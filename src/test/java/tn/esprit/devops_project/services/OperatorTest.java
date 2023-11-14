package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OperatorTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllOperators() {
        List<Operator> operators = new ArrayList<>();
        when(operatorRepository.findAll()).thenReturn(operators);
        List<Operator> result = operatorService.retrieveAllOperators();
        assertEquals(operators, result);
    }

    @Test
    void testAddOperator() {
        Operator operator = new Operator();
        when(operatorRepository.save(operator)).thenReturn(operator);
        Operator result = operatorService.addOperator(operator);
        assertEquals(operator, result);
    }

    @Test
    void testDeleteOperator() {
        Long operatorId = 1L;
        operatorService.deleteOperator(operatorId);
        verify(operatorRepository, times(1)).deleteById(operatorId);
    }

    @Test
    void testUpdateOperator() {
        Operator operator = new Operator();
        when(operatorRepository.save(operator)).thenReturn(operator);
        Operator result = operatorService.updateOperator(operator);
        assertEquals(operator, result);
    }

    @Test
    void testRetrieveOperator_existingId() {
        Long operatorId = 1L;
        Operator operator = new Operator();
        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(operator));
        Operator result = operatorService.retrieveOperator(operatorId);
    }
}

