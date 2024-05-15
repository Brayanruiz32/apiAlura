package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import med.voll.api.medico.DataActualizarMedico;
import med.voll.api.medico.DataListMedico;
import med.voll.api.medico.DataMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repositorio;



    @PostMapping
    public void subirMedico(@RequestBody @Valid DataMedico datos){
      
        repositorio.save( new Medico(datos));
    
        System.out.println("llego correctamente la data que es la siguiente "+datos.toString());
    } 
    

    @GetMapping
    public Page<DataListMedico> listarMedicos(Pageable paginacion) {
         return repositorio.findAll(paginacion).map(DataListMedico::new);
    
    }
    
    //NOMBRE, DOCUMENTO, DIRECCION 

    // @PutMapping("/{id}")
    // public void actualizarMedico(@PathVariable String id, @RequestBody DataActualizarMedico entity) {


        
    // }


}
