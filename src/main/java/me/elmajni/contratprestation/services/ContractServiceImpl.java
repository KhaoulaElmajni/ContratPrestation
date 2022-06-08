package me.elmajni.contratprestation.services;

import lombok.AllArgsConstructor;
import me.elmajni.contratprestation.entities.Contrat;
import me.elmajni.contratprestation.entities.Prestation;
import me.elmajni.contratprestation.repositories.ContratRepository;
import me.elmajni.contratprestation.repositories.PrestationRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ContractServiceImpl implements ContratService {
    private ContratRepository contratRepository;
    private PrestationRepository prestationRepository;

    @Override
    public Contrat addNewContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat getContratById(Long id) {
        Contrat contrat = contratRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Contrat not found"));
        return contrat;
    }

    @Override
    public Contrat getContratByName(String name) {
        Contrat contrat = contratRepository.findByNom(name);
        return contrat;
    }

    @Override
    public void addPrestationToContrat(String nomContrat, String nomPrestation) {
        Contrat contrat = getContratByName(nomContrat);
        Prestation prestation = getPrestationByName(nomPrestation);
        if (contrat.getPrestations() != null){
            contrat.getPrestations().add(prestation);
            prestation.setContrat(contrat);
        }

    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Prestation addNewPrestation(Prestation prestation) {
        return prestationRepository.save(prestation);
    }

    @Override
    public Prestation getPrestationById(Long id) {
        Prestation prestation = prestationRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Prestation not found"));
        return prestation;
    }

    @Override
    public Prestation getPrestationByName(String name) {
        Prestation prestation = prestationRepository.findByNom(name);
        return prestation;
    }

    @Override
    public List<Prestation> getAllPrestations() {
        return prestationRepository.findAll();
    }
}
