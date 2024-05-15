package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.Direccion;

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
