package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DataDireccion;

public record DataActualizarMedico(

    @NotNull(message = "El valor del id esta siendo nulo oe ptm") Long id,

    String nombre, 

    String documento, 

    DataDireccion direccion


) {

}
