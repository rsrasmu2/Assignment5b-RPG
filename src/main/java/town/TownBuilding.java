package town;

import characters.Player;

import java.io.BufferedReader;
import java.io.IOException;

public interface TownBuilding {
    void enter(Player player, BufferedReader reader) throws IOException;
}
