package tn.esprit.devops_project.services.Iservices;

import tn.esprit.devops_project.entities.ActivitySector;

import java.util.List;

public interface IActivitySector {
    List<ActivitySector> retrieveAllActivitySectors();

    ActivitySector addActiviySector(ActivitySector activitySector, Long idSupplier);

    void deleteActivitySector(Long id);

    ActivitySector updateActivitySector(ActivitySector activitySector);

    ActivitySector retrieveActivitySector(Long id);

    List<ActivitySector> retreiveActivitySupplier(Long id);
}