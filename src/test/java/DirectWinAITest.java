import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

/**
 * Created by ptang on 8/6/15.
 */
public class DirectWinAITest {

    private List<String> moveGrid;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        moveGrid = new ArrayList<>();
        MoveGridSetup.prepare(moveGrid);
    }

    @Test
    public void shouldPlacePieceToWinWhenFindsWinOpportunityInCol() throws Exception {
        DirectWinAI directWinAI = new DirectWinAI(moveGrid, printStream,1);
        moveGrid.set(0,"X");
        moveGrid.set(3,"X");
        assertThat(directWinAI.inputMove(), is(6));

    }

    @Test
    public void shouldPlacePieceToWinWhenFindsWinOpportunityInRow() throws Exception {
        DirectWinAI directWinAI = new DirectWinAI(moveGrid, printStream,1);
        moveGrid.set(3,"X");
        moveGrid.set(4,"X");
        assertThat(directWinAI.inputMove(),is(5));

    }
}
