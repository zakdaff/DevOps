package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.ActivitySectorImpl;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActivitySectorMockTest {

    @Mock
    private ActivitySectorRepository activitySectorRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private ActivitySectorImpl activitySectorService;

    @Test
    void testAddActivitySector() {
        // Arrange
        Long supplierId = 1L;
        Supplier supplier = new Supplier();
        ActivitySector activitySector = new ActivitySector();

        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));
        when(activitySectorRepository.save(any())).thenReturn(activitySector);

        // Act
        ActivitySector result = activitySectorService.addActiviySector(activitySector, supplierId);

        // Assert
        assertEquals(activitySector, result);
        verify(supplierRepository, times(1)).findById(supplierId);
        verify(activitySectorRepository, times(1)).save(activitySector);
    }

    @Test
    void testRetrieveActivitySector() {
        // Arrange
        Long activitySectorId = 1L;
        ActivitySector activitySector = new ActivitySector();

        when(activitySectorRepository.findById(activitySectorId)).thenReturn(Optional.of(activitySector));

        // Act
        ActivitySector result = activitySectorService.retrieveActivitySector(activitySectorId);

        // Assert
        assertEquals(activitySector, result);
        verify(activitySectorRepository, times(1)).findById(activitySectorId);
    }

    @Test
    void testRetrieveAllActivitySectors() {
        // Arrange
        List<ActivitySector> activitySectorList = new ArrayList<>();
        when(activitySectorRepository.findAll()).thenReturn(activitySectorList);

        // Act
        List<ActivitySector> result = activitySectorService.retrieveAllActivitySectors();

        // Assert
        assertEquals(activitySectorList, result);
        verify(activitySectorRepository, times(1)).findAll();
    }
}


