package med.voll.api.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DataDireccion;
import med.voll.api.direccion.Direccion;
import med.voll.api.medico.Especialidad;
import med.voll.api.medico.Medico;

public record DataMostrarActualizacion(
        Long id,

        String nombre,

        Especialidad especialidad,

        String documento,

        String email,

        String telefono,

        Direccion direccion) {


            public DataMostrarActualizacion(Medico m){
                this(m.getId(), m.getNombre(), m.getEspecialidad(), m.getDocumento(), m.getEmail(), m.getTelefono(), m.getDireccion());
            }

}
