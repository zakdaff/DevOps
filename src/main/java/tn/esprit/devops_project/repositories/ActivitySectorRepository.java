package tn.esprit.devops_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devops_project.entities.ActivitySector;

import java.util.Optional;

public interface ActivitySectorRepository extends JpaRepository<ActivitySector, Long> {
    Optional<ActivitySector> findById(Long idSupplier);
}
