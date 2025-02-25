package AandD.AandD.controller;

import AandD.AandD.service.SimulationLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/logs")
public class LogController {
    private final SimulationLogService logService;

    public LogController(SimulationLogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<String> getLogs() {
        return logService.getLogs();
    }
}
