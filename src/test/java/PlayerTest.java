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
        setUpMoveGridForTest();
    }

    private void setUpPlayer1() {
        player1 = new Player(moveGrid,printStream,inputStream, 1);
    }

    private void setUpPlayer2() {
        player2 = new Player(moveGrid,printStream,inputStream, 2);
    }

    private void setUpMoveGridForTest() {
        moveGrid = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            moveGrid.add(new String(" "));
        }
    }


    @Test
    public void shouldPromptPlayer1MoveWhenPlayer1Turn() {
        setUpPlayer1();
        player1.prompt();
        verify(printStream).print("Player 1, please enter a number between 1 and 9 to move.");
    }

    @Test
    public void shouldStorePlayer1MoveInGridIndex0WhenPlayer1InputsMoveOf1() throws IOException {
        setUpPlayer1();
        when(inputStream.readLine()).thenReturn("1");
        player1.move();

        assertThat(moveGrid.get(0), is("X"));

    }

    @Test
    public void shouldStorePlayer1MoveInGridIndex1WhenPlayer1InputsMoveOf2() throws IOException {
        setUpPlayer1();
        when(inputStream.readLine()).thenReturn("2");
        player1.move();

        assertThat(moveGrid.get(1), is("X"));

    }

    @Test
    public void shouldStorePlayer2MoveInGridIndex4WhenPlayer2InputsMoveOf5() throws IOException {
        setUpPlayer2();
        when(inputStream.readLine()).thenReturn("5");
        player2.move();

        assertThat(moveGrid.get(4), is("O"));

    }
}
