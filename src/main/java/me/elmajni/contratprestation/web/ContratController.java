package me.elmajni.contratprestation.web;

import me.elmajni.contratprestation.entities.Contrat;
import me.elmajni.contratprestation.entities.Prestation;
import me.elmajni.contratprestation.services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContratController {
    @Autowired
    private ContratService contratService;


    @GetMapping("/contrats")
    public List<Contrat> getAllContrats(){
        List<Contrat> contrats = contratService.getAllContrats();
        return contrats;
    }


    @GetMapping("/contrats/{name}")
    public Contrat getContratByName(@PathVariable String name){
        Contrat contrat = contratService.getContratByName(name);
        return contrat;
    }

    @GetMapping("/contrats/{id}")
    public Contrat getContratById(@PathVariable Long id){
        Contrat contrat = contratService.getContratById(id);
        return contrat;
    }

    @PostMapping("/contrats")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addNewContrat(contrat);
    }


    //

    @GetMapping("/prestations")
    public List<Prestation> prestations(){
        List<Prestation> prestations = contratService.getAllPrestations();
        return prestations;
    }


    @GetMapping("/prestations/{name}")
    public Prestation getPrestationByName(@PathVariable String name){
        Prestation prestation = contratService.getPrestationByName(name);
        return prestation;
    }

    @GetMapping("/prestations/{id}")
    public Prestation prestation(@PathVariable Long id){
        Prestation prestation = contratService.getPrestationById(id);
        return prestation;
    }

    @PostMapping("/prestations")
    public Prestation addPrestation(@RequestBody Prestation prestation) {
        return contratService.addNewPrestation(prestation);
    }
}
