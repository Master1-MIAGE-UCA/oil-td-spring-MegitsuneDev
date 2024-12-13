package miage.dice;

import miage.dice.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Dice API", description = "API pour gérer les lancers de dés")
public class DiceController {

    @Autowired
    private DiceService diceService;

    @Operation(summary = "Lancer un seul dé")
    @GetMapping("/rollDice")
    public List<Integer> rollSingleDice() {
        return diceService.rollDice(1);
    }

    @Operation(summary = "Lancer plusieurs dés", description = "Lance un nombre spécifié de dés.")
    @GetMapping("/rollDices/{count}")
    public List<Integer> rollMultipleDices(@PathVariable int count) {
        return diceService.rollDice(count);
    }

    @Operation(summary = "Obtenir l'historique des lancers", description = "Récupère tous les historiques des lancers de dés.")
    @GetMapping("/diceLogs")
    public List<DiceRollLog> getDiceLogs() {
        return diceService.getDiceRollLogs();
    }
}
