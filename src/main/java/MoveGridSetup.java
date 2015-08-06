import java.util.List;

/**
 * Created by ptang on 8/6/15.
 */
public class MoveGridSetup {
    public static void prepare(List<String> moveGrid) {
        for (int i = 0; i < 9; i++) {
            moveGrid.add(" ");
        }
    }
}
