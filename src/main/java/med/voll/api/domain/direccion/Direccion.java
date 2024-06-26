package med.voll.api.domain.direccion;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    public Direccion(DataDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
        this.ciudad = direccion.ciudad();
        this.distrito = direccion.distrito();
    }

    private String calle;

    private String numero;

    private String complemento;

    private String ciudad;

    private String distrito;

    public Direccion actualizarDatos(DataDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
        this.ciudad = direccion.ciudad();
        this.distrito = direccion.distrito();
        return this;
    }

}
