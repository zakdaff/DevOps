package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.entities.tdo.ActivitySectorDTO;
import tn.esprit.devops_project.services.Iservices.IActivitySector;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ActivitySectorController {

    private final IActivitySector activitySectorService;
    private final ModelMapper modelMapper = new ModelMapper();
    @GetMapping("/activitySector")
    List<ActivitySector> retrieveAllActivitySectors(){
        return activitySectorService.retrieveAllActivitySectors();
    }

    @PostMapping("/activitysector/{idSupplier}")
    ActivitySector addActivitySector(@RequestBody ActivitySectorDTO activitySectorDTO, @PathVariable Long idSupplier){
        ActivitySector activitySector = this.modelMapper.map(activitySectorDTO, ActivitySector.class);
        return activitySectorService.addActiviySector(activitySector, idSupplier);
    }



    @DeleteMapping("/activitySector/{id}")
    void deleteActivitySector(@PathVariable Long id){
        activitySectorService.deleteActivitySector(id);
    }

    @PutMapping("/activitySector")
    ActivitySector updateActivitySector(@RequestBody ActivitySector activitySector){
        return activitySectorService.updateActivitySector(activitySector);
    }

    @GetMapping("/activitySector/{id}")
    ActivitySector retrieveActivitySector(@PathVariable Long id){
        return activitySectorService.retrieveActivitySector(id);
    }
}