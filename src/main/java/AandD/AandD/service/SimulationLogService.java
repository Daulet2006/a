package AandD.AandD.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulationLogService {
    private final   List<String> logs = new ArrayList<>();

    public void addLog(String message) {
        logs.add(message);
    }

    public void addLogs(List<String> messages) {
        logs.addAll(messages);
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs); // Возвращаем копию списка
    }

    public void clearLogs() {
        logs.clear();
    }
}
