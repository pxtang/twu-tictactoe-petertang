import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by ptang on 8/6/15.
 */
public class DirectWinAITest {

    private List<String> moveGrid;
    private PrintStream printStream;

    @Test
    public void shouldPlacePieceToWinWhenFindsWinOpportunity() throws Exception {
        DirectWinAI directWinAI = new DirectWinAI(moveGrid, printStream,1);

    }
}
