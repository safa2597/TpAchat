package tn.esprit.spring.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

    @Query("SELECT sum(f.montantFacture) FROM Facture f where  f.dateCreationFacture between :startDate"
            + " and :endDate and f.archivee=false")
    float getTotalFacturesEntreDeuxDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Modifying
    @Query("update Facture f set f.archivee=true where f.idFacture=?1")
    void updateFacture(Long id);

}