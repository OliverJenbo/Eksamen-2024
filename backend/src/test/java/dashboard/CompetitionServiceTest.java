package dashboard;

import dashboard.dto.AthleteDTO;
import dashboard.model.Athlete;
import dashboard.model.Competition;
import dashboard.repository.CompetitionRepository;
import dashboard.service.CompetitionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompetitionServiceTest {
    @Mock
    private CompetitionRepository competitionRepository;
    @InjectMocks
    private CompetitionService competitionService;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testGetAcceptedAthletes_CompetitionExists() {
        int competitionId = 1;
        Competition competition = new Competition();
        Athlete acceptedAthlete = new Athlete();
        acceptedAthlete.setId(1);
        acceptedAthlete.setAccepted(true);
        Set<Athlete> athleteSet = new HashSet<>(List.of(acceptedAthlete));
        competition.setAthletes(athleteSet);
        when(competitionRepository.findById(competitionId)).thenReturn(Optional.of(competition));
        List<AthleteDTO> result = competitionService.getAcceptedAthletes(competitionId);
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(competitionRepository, times(1)).findById(competitionId);
    }
    @Test
    void testGetAcceptedAthletes_CompetitionDoesNotExist() {
        int competitionId = 1;
        when(competitionRepository.findById(competitionId)).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            competitionService.getAcceptedAthletes(competitionId);
        });
        assertEquals("Competition not found", exception.getMessage());
        verify(competitionRepository, times(1)).findById(competitionId);
    }
    @Test
    void testGetAcceptedAthletes_NoAcceptedAthletes() {
        int competitionId = 1;
        Competition competition = new Competition();
        Athlete notAcceptedAthlete = new Athlete();
        notAcceptedAthlete.setId(2);
        notAcceptedAthlete.setAccepted(false);
        Set<Athlete> athleteSet = new HashSet<>(List.of(notAcceptedAthlete));
        competition.setAthletes(athleteSet);
        when(competitionRepository.findById(competitionId)).thenReturn(Optional.of(competition));
        List<AthleteDTO> result = competitionService.getAcceptedAthletes(competitionId);
        assertNotNull(result);
        assertEquals(0, result.size());
        verify(competitionRepository, times(1)).findById(competitionId);
    }
}
