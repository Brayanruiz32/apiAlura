package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DataActualizarMedico;
import med.voll.api.medico.DataListMedico;
import med.voll.api.medico.DataMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repositorio;

    @PostMapping
    public ResponseEntity<DataMostrarActualizacion> subirMedico(@RequestBody @Valid DataMedico datos) {
        Medico m = new Medico(datos);
        repositorio.save(m);
        DataMostrarActualizacion medicoMostrar = new DataMostrarActualizacion(m);
        URI url = UriComponentsBuilder.fromPath("/medicos/{id}").buildAndExpand(m.getId()).toUri();
        return ResponseEntity.created(url).body(medicoMostrar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataMostrarActualizacion> mostrarMedico(@PathVariable Long id){
        Optional<Medico> m = repositorio.findById(id);
        Medico medico= m.get();
        return ResponseEntity.ok(new DataMostrarActualizacion(medico));
    }



    @GetMapping
    public List<DataListMedico> listarMedicos(Pageable paginacion) {
        return repositorio.findByEstadoTrue(paginacion).stream().map(m -> new DataListMedico(m)).toList();

    }

    // NOMBRE, DOCUMENTO, DIRECCION

    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid DataActualizarMedico entity) {
        Optional<Medico> m = repositorio.findById(entity.id());
        m.get().actualizarDatos(entity);
        return ResponseEntity.ok(new DataMostrarActualizacion(m.get()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Optional<Medico> miMedico = repositorio.findById(id);
        miMedico.get().actualizarEstadoMedico();
        return ResponseEntity.noContent().build();

    }

}
