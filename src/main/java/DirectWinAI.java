import java.io.PrintStream;
import java.util.List;

/**
 * Created by ptang on 8/6/15.
 */
public class DirectWinAI extends CountingAI {
    private final int DIMENSION_MAX = 3;
    private String opponentToken;

    public DirectWinAI(List<String> moveGrid, PrintStream printStream, Integer number) {
        super(moveGrid, printStream, number);
        opponentToken = moveToken.equals("X") ? "O" : "X";
    }

    @Override
    public int inputMove() {
        // Find winning columns
        for (int column = 0; column < DIMENSION_MAX; column++) {
            int columnScore = 0;
            int moveIndex = 0;
            for (int row = 0; row < DIMENSION_MAX; row++) {
                int index = column + row*DIMENSION_MAX;
                if (moveGrid.get(index).equals(opponentToken)) {
                    break;
                } else if (moveGrid.get(index).equals(moveToken)) {
                    columnScore++;
                } else {
                    moveIndex = index;
                }
            }

            if (columnScore == 2) {
                return moveIndex;
            }
        }

        // Find winning rows
        for (int row = 0; row < DIMENSION_MAX; row++) {
            int rowScore = 0;
            int moveIndex = 0;
            for (int column = 0; column < DIMENSION_MAX; column++) {
                int index = column + row*DIMENSION_MAX;
                if (moveGrid.get(index).equals(opponentToken)) {
                    break;
                } else if (moveGrid.get(index).equals(moveToken)) {
                    rowScore++;
                } else {
                    moveIndex = index;
                }
            }

            if (rowScore == 2) {
                return moveIndex;
            }
        }

        return super.inputMove();
    }
}
