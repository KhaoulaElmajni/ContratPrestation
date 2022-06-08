package me.elmajni.contratprestation;

import me.elmajni.contratprestation.entities.Contrat;
import me.elmajni.contratprestation.entities.Prestation;
import me.elmajni.contratprestation.services.ContratService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ContratPrestationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContratPrestationApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ContratService contratService){
        return args -> {
            Stream.of("Contrat1","Contrat2","Contrat3","Contrat4","Contrat5").forEach(name->{
                Contrat contrat = new Contrat();
                contrat.setNom(name);
                contrat.setNumeroContrat((int)Math.random()*10000);
                contrat.setZone(name);

                contratService.addNewContrat(contrat);
            });

            Stream.of("Prestation1","Prestation2","Prestation3","Prestation4","Prestation5",
                    "Prestation6","Prestation7","Prestation8","Prestation9","Prestation10").forEach(name->{
                Prestation prestation = new Prestation();
                prestation.setNom(name);
                prestation.setPrestateire("prestataire");
                //prestation.setContrat(contrat);
                contratService.addNewPrestation(prestation);
            });

            //contratService.addPrestationToContrat("user1","STUDENT");

            /*for (Contrat contrat:contratService.getAllContrats()) {
                int i=0;
                while (i<10){
                    contratService.addPrestationToContrat(contrat.getNom(),"Prestation"+(i+1));
                }
            }*/
        };
    }
}
