package AandD.AandD.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulationLogService {
    private final List<String> logs = new ArrayList<>();

    public void addLog(String message) {
        logs.add(message);
    }

    public List<String> getLogs() {
        return logs;
    }

    public void clearLogs() {
        logs.clear();
    }
}
