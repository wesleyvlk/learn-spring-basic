package edu.dio.beansautowireddispring.app;

import lombok.Data;

@Data
public class CepResponse {
    private String cep;
    private String address;
    private String locality;
}
