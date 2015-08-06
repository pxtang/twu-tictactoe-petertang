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
 *
 * User story:
 * Computer Player
 * Replace one of the players with a computer player that chooses an empty location using whatever strategy to prefer.
 *
 */
public class CountingAITest {

    private List<String> moveGrid;
    private PrintStream printStream;
    private CountingAI countingAI;

    @Before
    public void setUp() {
        moveGrid = new ArrayList<>();
        MoveGridSetup.prepare(moveGrid);

        printStream = mock(PrintStream.class);
        countingAI = new CountingAI(moveGrid, printStream,1);
    }

    private void setUpMoveGridForTest() {
        for (int i = 0; i < 9; i++) {
            moveGrid.add(" ");
        }
    }

    @Test
    public void shouldPlayIndex0WhenAskedToMoveFirst() throws Exception {
        assertThat(countingAI.inputMove(), is(0));
    }

    @Test
    public void shouldPlayIndex5WhenIndices0To4AreOccupied() throws Exception {
        for (int i = 0; i < 5; i++) {
            moveGrid.set(i,"X");
        }

        assertThat(countingAI.inputMove(), is(5));

    }
}
