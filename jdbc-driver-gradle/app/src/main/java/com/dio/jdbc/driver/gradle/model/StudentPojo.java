package com.dio.jdbc.driver.gradle.model;

import lombok.Data;

@Data
public class StudentPojo {
    private Integer studentId;
    private String name;
    private Integer age;
    private String stateCode;

    public StudentPojo(Integer studentId, String name, Integer age, String stateCode) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.stateCode = stateCode;
    }

    public StudentPojo(String name, Integer age, String stateCode) {
        this.name = name;
        this.age = age;
        this.stateCode = stateCode;
    }

    public StudentPojo() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return "student(" +
                "student_id= " + studentId +
                ", name= '" + name + '\'' +
                ", age= " + age +
                ", state_code= '" + stateCode + '\'' +
                ')';
    }
}
