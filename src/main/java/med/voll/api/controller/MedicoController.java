package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import med.voll.api.dto.DataMedico;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/medico")
public class MedicoController {


    @PostMapping
    public void subirMedico(@RequestBody DataMedico datos){


        System.out.println(datos.toString());


        // ObjectMapper objectMapper = new ObjectMapper();
        // DataMedico medico = null;
        // try {
        //     medico = objectMapper.readValue(datos, DataMedico.class);
        // } catch (JsonProcessingException e) {
        //     throw new RuntimeException(e);
        // }

        // System.out.println(medico.nombre());
        //return "Se ingreso correctamente el usuario";
    } 
    


}
