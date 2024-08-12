package com.example.surveys.service;

import com.example.surveys.model.Participation;
import com.example.surveys.model.Survey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SurveyServiceTest {

    @InjectMocks
    private SurveyService surveyService;

    @Mock
    private CSVReaderService csvReaderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMemberPoints() {
        // Mock data
        List<Survey> surveys = Arrays.asList(
                new Survey("1", "Survey 1", 100, 10, 5),
                new Survey("2", "Survey 2", 200, 20, 10),
                new Survey("3", "Survey 3", 150, 15, 7)
        );

        List<Participation> participations = Arrays.asList(
                new Participation("1", "1", 4, 30),
                new Participation("2", "1", 3, 20),
                new Participation("3", "2", 2, 15),
                new Participation("1", "3", 4, 25)
        );

        when(csvReaderService.getSurveys()).thenReturn(surveys);
        when(csvReaderService.getParticipations()).thenReturn(participations);

        // Test method
        List<Participation> result = surveyService.getMemberPoints("1");

        // Verify results
        assertEquals(2, result.size());

        Participation p1 = result.get(0);
        assertEquals("1", p1.getMemberId());
        assertEquals("1", p1.getSurveyId());
        assertEquals(4, p1.getStatusId());
        assertEquals(30, p1.getLength());
        assertEquals(10, p1.getPoints());

        Participation p2 = result.get(1);
        assertEquals("1", p2.getMemberId());
        assertEquals("3", p2.getSurveyId());
        assertEquals(4, p2.getStatusId());
        assertEquals(25, p2.getLength());
        assertEquals(15, p2.getPoints());
    }
}
