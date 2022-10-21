package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.DetailFacture;

@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture, Long> {

}
