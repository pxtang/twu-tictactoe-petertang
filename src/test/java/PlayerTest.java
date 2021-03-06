import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ptang on 8/6/15.
 */
public class PlayerTest {

    private PrintStream printStream;
    private Player player1, player2;
    private List<String> moveGrid;
    private BufferedReader inputStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        inputStream = mock(BufferedReader.class);
        moveGrid = new ArrayList<>();
        MoveGridSetup.prepare(moveGrid);
    }

    private void setUpPlayer1() {
        player1 = new Player(moveGrid,printStream,inputStream, 1);
    }

    private void setUpPlayer2() {
        player2 = new Player(moveGrid,printStream,inputStream, 2);
    }


    @Test
    public void shouldPromptPlayer1MoveWhenPlayer1Turn() {
        setUpPlayer1();
        player1.prompt();
        verify(printStream).printf("Player %d, please enter a number between 1 and 9 to move.\n", 1);
    }

    @Test
    public void shouldGetMoveIndex0WhenPlayerInput1() throws IOException {
        setUpPlayer1();
        when(inputStream.readLine()).thenReturn("2");

        assertThat(player1.inputMove(), is(1));

    }

    @Test
    public void shouldGetMoveIndex4WhenPlayerInput5() throws IOException {
        setUpPlayer1();
        when(inputStream.readLine()).thenReturn("5");

        assertThat(player1.inputMove(), is(4));

    }

    @Test
    public void shouldStorePlayer1MoveInGridIndex1WhenPlayer1InputsMoveOf2() throws IOException {
        setUpPlayer1();
        when(inputStream.readLine()).thenReturn("2");
        int moveIndex = player1.inputMove();
        player1.move(moveIndex);

        assertThat(moveGrid.get(1), is("X"));

    }


    @Test
    public void shouldSayInvalidLocationWhenPlayer1MovesInGrid2WhenGrid2Taken() throws Exception {
        setUpPlayer1();
        moveGrid.set(1, "X");
        when(inputStream.readLine()).thenReturn("2", "1");
        int moveIndex = player1.inputMove();
        player1.move(moveIndex);

        verify(printStream).println("Location already taken, try again");
    }
}
