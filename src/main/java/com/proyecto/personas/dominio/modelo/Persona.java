package com.proyecto.personas.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String tipoDocumento;
    private String numeroDocumento;
    private String numeroCelular;
    private String email;
    
}
