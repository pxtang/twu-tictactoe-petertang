import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ptang on 8/6/15.
 */
public class TicTacToeLauncher {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TicTacToe ticTacToe = new TicTacToe(System.out, bufferedReader);
        ticTacToe.start();
        ticTacToe.play();
    }
}
