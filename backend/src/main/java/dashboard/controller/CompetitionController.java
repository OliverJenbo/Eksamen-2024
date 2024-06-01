package dashboard.controller;

import dashboard.dto.AthleteDTO;
import dashboard.dto.CompetitionDTO;
import dashboard.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public List<CompetitionDTO> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }

    @GetMapping("/{competitionId}/athletes/accepted")
    public List<AthleteDTO> getAcceptedAthletes(@PathVariable Long competitionId) {
        return competitionService.getAcceptedAthletes(competitionId);
    }

    @GetMapping("/{competitionId}/athletes/invited")
    public List<AthleteDTO> getInvitedAthletes(@PathVariable Long competitionId) {
        return competitionService.getInvitedAthletes(competitionId);
    }

    @GetMapping("/{competitionId}/athletes/checked-in")
    public List<AthleteDTO> getCheckedInAthletes(@PathVariable Long competitionId) {
        return competitionService.getCheckedInAthletes(competitionId);
    }
}
