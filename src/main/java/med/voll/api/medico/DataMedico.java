package med.voll.api.medico;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DataDireccion;


public record DataMedico(
    @NotBlank(message = "No puede ser vacio el nombre p ctm >:v")
    String nombre, 

    
    @NotNull
    Especialidad especialidad, 

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String documento, 

    @NotBlank
    @Email
    String email, 

    @NotNull
    String telefono,

    @NotNull
    @Valid
    DataDireccion direccion

) {
}
