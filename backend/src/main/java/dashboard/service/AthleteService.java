package dashboard.service;

import dashboard.dto.AthleteDTO;
import dashboard.model.Athlete;
import dashboard.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    public List<AthleteDTO> getAllAthletes() {
        List<Athlete> athletes = athleteRepository.findAll();
        return athletes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AthleteDTO convertToDTO(Athlete athlete) {
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
