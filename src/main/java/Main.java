import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * The main method of the program.
     * @param args input args.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

        Game game = new Game(reader);
        game.begin();

        reader.close();
    }
}
