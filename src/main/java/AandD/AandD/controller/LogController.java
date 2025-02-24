package AandD.AandD.controller;

import AandD.AandD.service.SimulationLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LogController {
    private final SimulationLogService logService;

    public LogController(SimulationLogService logService) {
        this.logService = logService;
    }

    @GetMapping("/market/logs")
    @ResponseBody
    public List<String> getLogs() {
        return logService.getLogs();
    }
}
