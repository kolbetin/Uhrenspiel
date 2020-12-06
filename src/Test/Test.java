package Test;
import Test.Domain.Game;
import Test.Presentation.ClockSkin;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Crunchify.com
 *
 */

public class Test extends Application {
   private ClockSkin clockSkin;
   private Game game;
   public Node node;



   public Node Test(){
       game = new Game();
       game.nextQuestion();
       clockSkin = new ClockSkin(game.key);
       node = clockSkin.createClock();
       return node;
   }

    public void start(Stage primarystage) {}
    public static void main(String[] args) { launch(args);    }

}