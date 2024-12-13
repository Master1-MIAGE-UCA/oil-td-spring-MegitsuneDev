package miage.dice;

import miage.dice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DiceService {

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    public List<Integer> rollDice(int diceCount) {
        List<Integer> results = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < diceCount; i++) {
            results.add(random.nextInt(6) + 1);
        }

        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(diceCount);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRollLogRepository.save(log);

        return results;
    }

    public List<DiceRollLog> getDiceRollLogs() {
        return diceRollLogRepository.findAll();
    }
}