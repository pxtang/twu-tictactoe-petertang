import java.io.PrintStream;
import java.util.List;

/**
 * Created by ptang on 8/6/15.
 */
public class DirectWinAI extends CountingAI {
    public DirectWinAI(List<String> moveGrid, PrintStream printStream, Integer number) {
        super(moveGrid, printStream, number);
    }

    @Override
    public int inputMove() {
        // find a winning place
        return super.inputMove();
    }
}
