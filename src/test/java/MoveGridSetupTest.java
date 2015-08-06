import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by ptang on 8/6/15.
 */
public class MoveGridSetupTest {
    @Test
    public void shouldSetArrayListToAllSpaceWhenPrepare() throws Exception {
        ArrayList<String> movesGrid = new ArrayList<>();
        MoveGridSetup.prepare(movesGrid);

        for (String s : movesGrid) {
            assert(s.equals(" "));
        }
    }
}
