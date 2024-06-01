package dashboard.service;

import dashboard.dto.AthleteDTO;
import dashboard.dto.CompetitionDTO;
import dashboard.model.Athlete;
import dashboard.model.Competition;
import dashboard.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    public List<CompetitionDTO> getAllCompetitions() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AthleteDTO> getAcceptedAthletes(Long competitionId) {
        Competition competition = competitionRepository.findById(competitionId).orElseThrow(() -> new RuntimeException("Competition not found"));
        return competition.getAthletes().stream()
                .filter(Athlete::isAccepted)
                .map(this::convertToAthleteDTO)
                .collect(Collectors.toList());
    }

    public List<AthleteDTO> getInvitedAthletes(Long competitionId) {
        Competition competition = competitionRepository.findById(competitionId).orElseThrow(() -> new RuntimeException("Competition not found"));
        return competition.getAthletes().stream()
                .filter(Athlete::isInvited)
                .map(this::convertToAthleteDTO)
                .collect(Collectors.toList());
    }

    public List<AthleteDTO> getCheckedInAthletes(Long competitionId) {
        Competition competition = competitionRepository.findById(competitionId).orElseThrow(() -> new RuntimeException("Competition not found"));
        return competition.getAthletes().stream()
                .filter(Athlete::isCheckedIn)
                .map(this::convertToAthleteDTO)
                .collect(Collectors.toList());
    }

    private CompetitionDTO convertToDTO(Competition competition) {
        return new CompetitionDTO(competition.getId(), competition.getName(), competition.getDate().toString());
    }

    private AthleteDTO convertToAthleteDTO(Athlete athlete) {
        return new AthleteDTO(
                athlete.getId(),
                athlete.getName(),
                athlete.getEmail(),
                athlete.isInvited(),
                athlete.isAccepted(),
                athlete.isCheckedIn(),
                athlete.getStatus()
        );
    }
}
