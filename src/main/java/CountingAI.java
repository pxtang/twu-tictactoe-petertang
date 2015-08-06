import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by ptang on 8/6/15.
 */
public class CountingAI extends Player {
    public CountingAI(List<String> moveGrid, PrintStream printStream, Integer number) {
        super(moveGrid, printStream, null, number);
    }

    @Override
    public void prompt() {
        printStream.println("Computer is thinking...");
    }

    @Override
    public int inputMove() {
        for (int i = 0; i < moveGrid.size(); i++) {
             if (moveGrid.get(i).equals(" ")) {
                 return i;
             }

        }

        return 0;
    }
}
