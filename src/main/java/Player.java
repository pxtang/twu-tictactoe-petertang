import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by ptang on 8/6/15.
 */
public class Player {
    private static List<String> moveGrid;
    private Integer number;
    private PrintStream printStream;
    private BufferedReader inputStream;


    public Player(List<String> moveGrid, PrintStream printStream, BufferedReader inputStream, Integer number) {
        this.number = number;
        this.moveGrid = moveGrid;

        this.printStream = printStream;
        this.inputStream = inputStream;
    }

    public void prompt() {
        printStream.print("Player 1, please enter a number between 1 and 9 to move.");
    }

    public void move() {
        String move = "";
        try {
            move = inputStream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int moveIndex = Integer.parseInt(move) - 1;

        moveGrid.set(moveIndex, number == 1 ? "X" : "O");
    }
}
