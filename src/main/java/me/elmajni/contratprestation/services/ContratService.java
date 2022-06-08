package me.elmajni.contratprestation.services;

import me.elmajni.contratprestation.entities.Contrat;
import me.elmajni.contratprestation.entities.Prestation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContratService {
    //Contrat service
    Contrat addNewContrat(Contrat contrat);
    Contrat getContratById(Long id);
    Contrat getContratByName(String name);
    void addPrestationToContrat(String nomContrat, String nomPrestation);
    List<Contrat> getAllContrats();


    //Prestation service
    Prestation addNewPrestation(Prestation prestation);
    Prestation getPrestationById(Long id);
    Prestation getPrestationByName(String name);
    List<Prestation> getAllPrestations();
}
