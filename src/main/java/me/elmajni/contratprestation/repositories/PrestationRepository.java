package me.elmajni.contratprestation.repositories;

import me.elmajni.contratprestation.entities.Contrat;
import me.elmajni.contratprestation.entities.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestationRepository extends JpaRepository<Prestation,Long> {
    public Prestation findByNom(String nom);
}
