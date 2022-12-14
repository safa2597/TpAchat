package tn.esprit.spring.services;

import tn.esprit.spring.entities.Facture;

import java.util.Date;
import java.util.List;

public interface IFactureService {
    List<Facture> retrieveAllFactures();

    Facture addFacture(Facture f);

    void cancelFacture(Long id);

    Facture retrieveFacture(Long id);

    //float pourcentageRecouvrement(Date startDate, Date endDate);

}
