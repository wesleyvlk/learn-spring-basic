package com.dio.jdbc.driver.gradle.service.implementation;

import com.dio.jdbc.driver.gradle.controller.JdbcConnectionController;
import com.dio.jdbc.driver.gradle.model.StudentPojo;
import com.dio.jdbc.driver.gradle.service.StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void createStudent(StudentPojo student) {
        try (Connection connection = JdbcConnectionController.getConnection()) {
            String sql = "INSERT INTO student(name, age, state_code) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getStateCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<StudentPojo> getAllStudents() {
        List<StudentPojo> students = new ArrayList<>();
        try (Connection connection = JdbcConnectionController.getConnection()) {
            String sql = "SELECT * FROM student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer studentId = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                String stateCode = resultSet.getString("state_code");

                students.add(new StudentPojo(studentId, name, age, stateCode));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public StudentPojo getStudentById(int studentId) {
        StudentPojo student = new StudentPojo();

        try (Connection connection = JdbcConnectionController.getConnection()) {
            String sql = "SELECT * FROM student WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student.setStudentId(resultSet.getInt("student_id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setStateCode(resultSet.getString("state_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void updateStudent(StudentPojo student) {
        try (Connection connection = JdbcConnectionController.getConnection()) {
            String sql = "UPDATE student SET name = ?, age = ?, state_code = ? WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getStateCode());
            preparedStatement.setInt(4, student.getStudentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        try (Connection connection = JdbcConnectionController.getConnection()) {
            String sql = "DELETE FROM student WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}