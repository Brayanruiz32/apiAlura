package med.voll.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;

public record DataDireccion(

    @NotBlank
    String calle, 
    @NotBlank
    String numero, 
    @NotBlank
    String complemento, 
    @NotBlank
    String ciudad,
    @NotBlank
    String distrito

) {

}
