package med.voll.api.domain.medico;

public record DataListMedico(
    Long id,

    String nombre,

    String especialidad,

    String documento,

    String email

) {


    public DataListMedico(Medico medico){
        this(medico.getId() ,medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }

}

