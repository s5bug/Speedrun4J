import com.tsunderebug.speedrun4j.game.Game;
import com.tsunderebug.speedrun4j.game.run.Run;
import com.tsunderebug.speedrun4j.user.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {

        User user = User.fromID("lundylizard");

        Arrays.stream(user.getPBs().getData()).collect(Collectors.toList()).forEach(placedRun -> {

            System.out.println(placedRun.getPlace());
            Run run = placedRun.getRun();

            try {
                System.out.println(Game.fromID(run.getId()).getNames().get("international"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }

}
