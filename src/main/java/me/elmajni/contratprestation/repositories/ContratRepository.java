package me.elmajni.contratprestation.repositories;

import me.elmajni.contratprestation.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
    public Contrat findByNom(String nom);
}
