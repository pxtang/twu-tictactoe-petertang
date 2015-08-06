import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ptang on 8/6/15.
 */
public class BoardDrawerTest {

    private List<String> moveGrid;
    private PrintStream printStream;
    private BoardDrawer boardDrawer;



    @Before
    public void setUp() throws Exception {
        moveGrid = new ArrayList<>();
        MoveGridSetup.prepare(moveGrid);
        printStream = mock(PrintStream.class);
        boardDrawer = new BoardDrawer(moveGrid, printStream);
    }

    @Test
    public void shouldProduceBoardWhenStart() throws Exception {
        boardDrawer.draw();

        verify(printStream).print(  "   |   |  \n" +
                                    "-----------\n" +
                                    "   |   |  \n" +
                                    "-----------\n" +
                                    "   |   |  \n");

    }


    @Test
    public void shouldDrawBoardWithXInSpot5IfGridIndex4FilledWithX() throws Exception {
        moveGrid.set(4, "X");

        boardDrawer.draw();

        verify(printStream).print(  "   |   |  \n" +
                                    "-----------\n" +
                                    "   | X |  \n" +
                                    "-----------\n" +
                                    "   |   |  \n");
    }

    @Test
    public void shouldDrawBoardWithXInSpot9IfGridIndex8FilledWithX() throws Exception {
        moveGrid.set(8, "X");
        boardDrawer.draw();

        verify(printStream).print(  "   |   |  \n" +
                                    "-----------\n" +
                                    "   |   |  \n" +
                                    "-----------\n" +
                                    "   |   | X\n");
    }

    @Test
    public void shouldDrawBoardWithOInSpot4IfIfGridIndex3FilledWithO() throws Exception {
        moveGrid.set(3, "O");
        boardDrawer.draw();

        verify(printStream).print(  "   |   |  \n" +
                                    "-----------\n" +
                                    " O |   |  \n" +
                                    "-----------\n" +
                                    "   |   |  \n");
    }

}
