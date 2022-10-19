package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.DetailFournisseur;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.repositories.DetailFournisseurRepository;
import tn.esprit.spring.repositories.FournisseurRepository;

@Service
@Slf4j
public class FournisseurServiceImpl implements IFournisseurService {

    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    DetailFournisseurRepository detailFournisseurRepository;

    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();
        for (Fournisseur fournisseur : fournisseurs) {
            log.info(" fournisseur : " + fournisseur);
        }
        return fournisseurs;
    }


    public Fournisseur addFournisseur(Fournisseur f /*Master*/) {
        DetailFournisseur df= new DetailFournisseur();//Slave
        df.setDateDebutCollaboration(new Date()); //util
        //On affecte le "Slave" au "Master"
        fournisseurRepository.save(f);
        return f;
    }

    public Fournisseur updateFournisseur(Fournisseur f) {
        fournisseurRepository.save(f);
        return f;
    }

    @Override
    public void deleteFournisseur(Long fournisseurId) {
        fournisseurRepository.deleteById(fournisseurId);

    }

    @Override
    public Fournisseur retrieveFournisseur(Long fournisseurId) {

        Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).orElse(null);
        return fournisseur;
    }



}
