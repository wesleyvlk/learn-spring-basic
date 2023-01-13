package edu.dio.beansautowireddispring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class JsonConverter {

    @Autowired
    public Gson gson;

    public CepResponse convert(String json) {
        CepResponse response = gson.fromJson(json, CepResponse.class);
        return response;
    }
}
