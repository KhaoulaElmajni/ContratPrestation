package me.elmajni.contratprestation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroContrat;
    private String zone;
    private String nom;

    @OneToMany(mappedBy = "contrat",fetch = FetchType.EAGER)
    private List<Prestation> prestations=new ArrayList<>();
}
