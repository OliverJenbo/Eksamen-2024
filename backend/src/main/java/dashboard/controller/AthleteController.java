package dashboard.controller;

import dashboard.dto.AthleteDTO;
import dashboard.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/athletes")
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    @GetMapping
    public List<AthleteDTO> getAllAthletes() {
        return athleteService.getAllAthletes();
    }
}
