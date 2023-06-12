package com.proyecto.personas.infraestructura.excepciones;

import lombok.Data;

@Data
public class Error {
    
    private String code;
    private String message;
}
