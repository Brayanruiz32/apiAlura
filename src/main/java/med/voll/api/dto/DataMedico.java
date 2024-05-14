package med.voll.api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DataMedico(

    String nombre, 

    Especialidad especialidad, 

    int documento, 

    String email, 

    int telefono, 

    DataDireccion direccion


) {
}
