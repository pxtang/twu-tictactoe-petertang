import java.io.PrintStream;
import java.util.List;

/**
 * Created by ptang on 8/6/15.
 */
public class BoardDrawer {
    private static final int NUM_COLUMNS = 3;
    private static final int NUM_ROWS = 3;
    private final String BOARD_ROW = " %s | %s | %s\n";
    private final String BOARD_LINE = "-----------\n";
    private final int MAX_BOARD_ROWS = 5;

    private List<String> moveGrid; // I know I could have used a normal array, but got too far before realizing it :(
    private PrintStream printStream;

    public BoardDrawer(List<String> moveGrid, PrintStream printStream) {

        this.moveGrid = moveGrid;
        this.printStream = printStream;
    }

    public void draw() {
        printStream.print(produceBoard());
    }

    private String produceBoard() {
        String board = "";
        for (int i = 0; i < MAX_BOARD_ROWS; i++) {
            if (i % 2 == 0) {
                board += produceRow(i);
            } else {
                board += BOARD_LINE;
            }
        }

        return board;
    }

    private String produceRow(int rowNumber) {
        rowNumber /= 2;
        return String.format(BOARD_ROW,
                moveGrid.get(rowNumber* NUM_COLUMNS),
                moveGrid.get(rowNumber* NUM_COLUMNS + 1),
                moveGrid.get(rowNumber* NUM_COLUMNS + 2));
    }
}
