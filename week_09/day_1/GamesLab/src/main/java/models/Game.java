package models;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    public static String getGame() {

        ArrayList<String> games = new ArrayList<>();
        games.add("Doom");
        games.add("Duke Nukem 3D");
        games.add("Theme Park");
        games.add("Half-Life");
        Collections.shuffle(games);
        String result = games.get(0);

        return result;

    }

}
