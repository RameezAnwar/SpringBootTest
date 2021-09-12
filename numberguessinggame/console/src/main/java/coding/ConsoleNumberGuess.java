package coding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {

    //constants
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //fields
    private final Game game;

    private final MessageGenerator messageGenerator;


    //constructor
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start --> Container ready for use");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again yes or no??");

                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("yes")) {
                    break;
                }
                game.reset();
            }

        }


    }







}
