import javax.swing.*;
import java.awt.*;

public class TicTacToe {

	public static void main(String[] args) {
	
		JFrame f = new JFrame();
		f.setSize(999,999+40);
		f.setContentPane(new Program());
		f.setTitle("Tic-Tac-Toe v1");
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	}
	
}