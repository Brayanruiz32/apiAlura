package med.voll.api.domain.medico;

import javax.xml.crypto.Data;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
public class Medico {

    public Medico(DataMedico datos) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.documento = datos.documento();
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.direccion());
        this.telefono = datos.telefono();
        this.estado = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    private String documento;

    private boolean estado;

    private String telefono;

    private String email;

    @Embedded
    private Direccion direccion;

    public void actualizarDatos(DataActualizarMedico datos) {
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
        if (datos.documento() != null) {
            this.documento = datos.documento();
        }

        if (datos.direccion() != null) { 
            this.direccion = direccion.actualizarDatos(datos.direccion());
        }

    }

    public void actualizarEstadoMedico() {
        this.estado = false;
    }

}
