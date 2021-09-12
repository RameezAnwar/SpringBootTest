package coding;

import coding.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess The Number Game");
        //context
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(GameConfig.class);

        /*
        //get number bean
        NumberGenerator numberGenerator =
                context.getBean( NumberGenerator.class);

        //call method
        int number = numberGenerator.next();

        //log gen number
        log.info("number = {}", number);

        //get game bean
        //Game game = context.getBean(Game.class);

        //message bean
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getmainmessage {}", messageGenerator.getMainMessage());
        log.info("getresultmessage {}", messageGenerator.getResultMessage());
        */

        //close container
        context.close();

    }
}
