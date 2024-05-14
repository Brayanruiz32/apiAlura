package med.voll.api.medico;

import com.fasterxml.jackson.annotation.JsonAlias;

import med.voll.api.direccion.DataDireccion;

public record DataMedico(

    String nombre, 

    Especialidad especialidad, 

    int documento, 

    String email, 

    int telefono, 

    DataDireccion direccion


) {
}
