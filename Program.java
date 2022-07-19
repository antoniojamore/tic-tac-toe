import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Program extends JPanel implements MouseListener, ActionListener {

	JButton resetBtn;
	JLabel noticeMsg;

	String box00 = "";
	String box01 = "";
	String box02 = "";
	String box10 = "";
	String box11 = "";
	String box12 = "";
	String box20 = "";
	String box21 = "";
	String box22 = "";

	int turn = 3;

	Random r = new Random();

	public Program() {

		addMouseListener(this);
		setFocusable(true);

		noticeMsg = new JLabel("Welcome to Tic-Tac-Toe!");
		noticeMsg.setFont(new Font("Verdana", Font.BOLD, 18));
		add(noticeMsg);

		resetBtn = new JButton("Reset Game");
		add(resetBtn);
		resetBtn.addActionListener(this);

		if(turn == 3) {
			turn = r.nextInt(2);
			System.out.println("[start] New turn = " + turn);

			if(turn == 0) { // human
				noticeMsg.setText("It is your (X) turn!");
			} else if(turn == 1) { // computer
				noticeMsg.setText("It is the computer's (O) turn.");
			} else {
				noticeMsg.setText("Error. Uh oh!");
			}
		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// board layout

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));

		g.drawLine(333, 0, 333, 999);
		g.drawLine(666, 0, 666, 999);

		g.drawLine(0, 333, 999, 333);
		g.drawLine(0, 666, 999, 666);

		// turn

		if(turn == 3) {
			turn = r.nextInt(2);
			System.out.println("[draw] New turn = " + turn);
		}

		if(turn == 0) { // human
			noticeMsg.setText("It is your (X) turn!");
		} else if(turn == 1) { // computer
			noticeMsg.setText("It is the computer's (O) turn.");
		} else {
			noticeMsg.setText("Error. Uh oh!");
		}

		if (!box00.equals("") && !box01.equals("") &&  !box02.equals("") &&  !box10.equals("") &&  !box11.equals("") &&  !box12.equals("") &&  !box20.equals("") &&  !box21.equals("") &&  !box22.equals("")) {
			turn = 6;
		}
		//computer

		while(turn == 1) { // computer move

			/*- if computer can win
			- take winning square 84% of the time

			- if computer can block 
			- 73% of the time
			*/

			int chances = r.nextInt(100) + 1;
			System.out.println("CHANCES = " + chances);

			if(chances <= 84) { // win
				System.out.println("ATTEMPTING WIN!");

				if(box00.equals("o") && box01.equals("o") && box02.equals("")) {
					box02 = "o";
					turn--;
				} else if(box00.equals("o") && box01.equals("") && box02.equals("o")) {
					box01 = "o";
					turn--;
				} else if(box00.equals("") && box01.equals("o") && box02.equals("o")) {
					box00 = "o";
					turn--;
				} else if(box10.equals("o") && box11.equals("o") && box12.equals("")) {
					box12 = "o";
					turn--;
				} else if(box10.equals("o") && box11.equals("") && box12.equals("o")) {
					box11 = "o";
					turn--;
				} else if(box10.equals("") && box11.equals("o") && box12.equals("o")) {
					box10 = "o";
					turn--;
				} else if(box20.equals("o") && box21.equals("o") && box22.equals("")) {
					box22 = "o";
					turn--;
				} else if(box20.equals("o") && box21.equals("") && box22.equals("o")) {
					box21 = "o";
					turn--;
				} else if(box20.equals("") && box21.equals("o") && box22.equals("o")) {
					box20 = "o";
					turn--;
				} else if(box00.equals("o") && box10.equals("o") && box20.equals("")) {
					box20 = "o";
					turn--;
				} else if(box00.equals("o") && box10.equals("") && box20.equals("o")) {
					box10 = "o";
					turn--;
				} else if(box00.equals("") && box10.equals("o") && box20.equals("o")) {
					box00 = "o";
					turn--;
				} else if(box01.equals("o") && box11.equals("o") && box21.equals("")) {
					box21 = "o";
					turn--;
				} else if(box01.equals("o") && box11.equals("") && box21.equals("o")) {
					box11 = "o";
					turn--;
				} else if(box01.equals("") && box11.equals("o") && box21.equals("o")) {
					box01 = "o";
					turn--;
				} else if(box02.equals("o") && box12.equals("o") && box22.equals("")) {
					box22 = "o";
					turn--;
				} else if(box02.equals("o") && box12.equals("") && box22.equals("o")) {
					box12 = "o";
					turn--;
				} else if(box02.equals("") && box12.equals("o") && box22.equals("o")) {
					box02 = "o";
					turn--;
				} else if(box00.equals("o") && box11.equals("o") && box22.equals("")) {
					box22 = "o";
					turn--;
				} else if(box00.equals("o") && box11.equals("") && box22.equals("o")) {
					box11 = "o";
					turn--;
				} else if(box00.equals("") && box11.equals("o") && box22.equals("o")) {
					box00 = "o";
					turn--;
				} else if(box02.equals("o") && box11.equals("o") && box20.equals("")) {
					box20 = "o";
					turn--;
				} else if(box02.equals("o") && box11.equals("") && box20.equals("o")) {
					box11 = "o";
					turn--;
				} else if(box02.equals("") && box11.equals("o") && box20.equals("o")) {
					box02 = "o";
					turn--;
				}

				if(turn == 0) {
					System.out.println("won!");
				}

			}
			if (turn == 1) {
				if(chances <= 73) { // block 
					System.out.println("ATTEMTPING BLOCK!");

					if(box00.equals("x") && box01.equals("x") && box02.equals("")) {
						box02 = "o";
						turn--;
					} else if(box00.equals("x") && box01.equals("") && box02.equals("x")) {
						box01 = "o";
						turn--;
					} else if(box00.equals("") && box01.equals("x") && box02.equals("x")) {
						box00 = "o";
						turn--;
					} else if(box10.equals("x") && box11.equals("x") && box12.equals("")) {
						box12 = "o";
						turn--;
					} else if(box10.equals("x") && box11.equals("") && box12.equals("x")) {
						box11 = "o";
						turn--;
					} else if(box10.equals("") && box11.equals("x") && box12.equals("x")) {
						box10 = "o";
						turn--;
					} else if(box20.equals("x") && box21.equals("x") && box22.equals("")) {
						box22 = "o";
						turn--;
					} else if(box20.equals("x") && box21.equals("") && box22.equals("x")) {
						box21 = "o";
						turn--;
					} else if(box20.equals("") && box21.equals("x") && box22.equals("x")) {
						box20 = "o";
						turn--;
					} else if(box00.equals("x") && box10.equals("x") && box20.equals("")) {
						box20 = "o";
						turn--;
					} else if(box00.equals("x") && box10.equals("") && box20.equals("x")) {
						box10 = "o";
						turn--;
					} else if(box00.equals("") && box10.equals("x") && box20.equals("x")) {
						box00 = "o";
						turn--;
					} else if(box01.equals("x") && box11.equals("x") && box21.equals("")) {
						box21 = "o";
						turn--;
					} else if(box01.equals("x") && box11.equals("") && box21.equals("x")) {
						box11 = "o";
						turn--;
					} else if(box01.equals("") && box11.equals("x") && box21.equals("x")) {
						box01 = "o";
						turn--;
					} else if(box02.equals("x") && box12.equals("x") && box22.equals("")) {
						box22 = "o";
						turn--;
					} else if(box02.equals("x") && box12.equals("") && box22.equals("x")) {
						box12 = "o";
						turn--;
					} else if(box02.equals("") && box12.equals("x") && box22.equals("x")) {
						box02 = "o";
						turn--;
					} else if(box00.equals("x") && box11.equals("x") && box22.equals("")) {
						box22 = "o";
						turn--;
					} else if(box00.equals("x") && box11.equals("") && box22.equals("x")) {
						box11 = "o";
						turn--;
					} else if(box00.equals("") && box11.equals("x") && box22.equals("x")) {
						box00 = "o";
						turn--;
					} else if(box02.equals("x") && box11.equals("x") && box20.equals("")) {
						box20 = "o";
						turn--;
					} else if(box02.equals("x") && box11.equals("") && box20.equals("x")) {
						box11 = "o";
						turn--;
					} else if(box02.equals("") && box11.equals("x") && box20.equals("x")) {
						box02 = "o";
						turn--;
					}

					if(turn == 0) {
						System.out.println("blocked!");
					}

				}
			}

			if (turn == 1) { // go random!!
				System.out.println("NOT BLOCKED OR WON!");
				int ranBox = r.nextInt(9);

				System.out.println("computer move box = " + ranBox);
				if(ranBox == 0) { //box00
					if(box00 == "") {
						box00 = "o";
						turn--;
					}
				} else if(ranBox == 1) { //box01
					if(box01 == "") {
						box01 = "o";
						turn--;
					}
				} else if(ranBox == 2) { //box02
					if(box02 == "") {
						box02 = "o";
						turn--;
					}
				} else if(ranBox == 3) { //box10
					if(box10 == "") {
						box10 = "o";
						turn--;
					}
				} else if(ranBox == 4) { //box11
					if(box11 == "") {
						box11 = "o";
						turn--;
					}
				} else if(ranBox == 5) { //box12
					if(box12 == "") {
						box12 = "o";
						turn--;
					}
				} else if(ranBox == 6) { //box20
					if(box20 == "") {
						box20 = "o";
						turn--;
					}
				} else if(ranBox == 7) { //box21
					if(box21 == "") {
						box21 = "o";
						turn--;
					}
				} else if(ranBox == 8) { //box22
					if(box22 == "") {
						box22 = "o";
						turn--;
					}
				}
			}

			System.out.println("[o-move] New turn = " + turn);
		}

		// wins 
		g2.setStroke(new BasicStroke(10));

		if(box00.equals("x") && box01.equals("x") && box02.equals("x")) { //accross 0
			g.drawLine(0, 166, 999, 166);
			turn = 4;
		} else if(box10.equals("x") && box11.equals("x") && box12.equals("x")) { //accross 1
			g.drawLine(0, 166+333, 999, 166+333);
			turn = 4;
		} else if(box20.equals("x") && box21.equals("x") && box22.equals("x")) { //accross 2
			g.drawLine(0, 166+333+333, 999, 166+333+333);
			turn = 4;
		} else if(box00.equals("x") && box10.equals("x") && box20.equals("x")) { //up 0
			g.drawLine(166, 0, 166, 999);
			turn = 4;
		} else if(box01.equals("x") && box11.equals("x") && box21.equals("x")) { //up 1
			g.drawLine(166+333, 0, 166+333, 999);
			turn = 4;
		} else if(box02.equals("x") && box12.equals("x") && box22.equals("x")) { //up 2
			g.drawLine(166+333+333, 0, 166+333+333, 999);
			turn = 4;
		} else if(box00.equals("x") && box11.equals("x") && box22.equals("x")) { //across left to right
			g.drawLine(0, 0, 999, 999);
			turn = 4;
		} else if(box02.equals("x") && box11.equals("x") && box20.equals("x")) { //acros right to left
			g.drawLine(999, 0, 0, 999);
			turn = 4;
		} else if(box00.equals("o") && box01.equals("o") && box02.equals("o")) { //accross 0
			g.drawLine(0, 166, 999, 166);
			turn = 5;
		} else if(box10.equals("o") && box11.equals("o") && box12.equals("o")) { //accross 1
			g.drawLine(0, 166+333, 999, 166+333);
			turn = 5;
		} else if(box20.equals("o") && box21.equals("o") && box22.equals("o")) { //accross 2
			g.drawLine(0, 166+333+333, 999, 166+333+333);
			turn = 5;
		} else if(box00.equals("o") && box10.equals("o") && box20.equals("o")) { //up 0
			g.drawLine(166, 0, 166, 999);
			turn = 5;
		} else if(box01.equals("o") && box11.equals("o") && box21.equals("o")) { //up 1
			g.drawLine(166+333, 0, 166+333, 999);
			turn = 5;
		} else if(box02.equals("o") && box12.equals("o") && box22.equals("o")) { //up 2
			g.drawLine(166+333+333, 0, 166+333+333, 999);
			turn = 5;
		} else if(box00.equals("o") && box11.equals("o") && box22.equals("o")) { //across left to right
			g.drawLine(0, 0, 999, 999);
			turn = 5;
		} else if(box02.equals("o") && box11.equals("o") && box20.equals("o")) { //acros right to left
			g.drawLine(999, 0, 0, 999);
			turn = 5;
		} else if (!box00.equals("") && !box01.equals("") &&  !box02.equals("") &&  !box10.equals("") &&  !box11.equals("") &&  !box12.equals("") &&  !box20.equals("") &&  !box21.equals("") &&  !box22.equals("")) {
			turn = 6;
		}

		if(turn == 4) {
			noticeMsg.setText("Celebrate! You won! Would you like to play again?");
			noticeMsg.setForeground(Color.GREEN);
			resetBtn.setText("Play again?");
		} else if (turn == 5) {
			noticeMsg.setText("BAHAHAHA! YOU LOST! Would you like to play again?");
			noticeMsg.setForeground(Color.RED);
			resetBtn.setText("Play again?");
		} else if (turn == 6) {
			noticeMsg.setText("It's a tie. Would you like to play again?");
			noticeMsg.setForeground(Color.BLACK);
			resetBtn.setText("Play again?");
		}

		// moves
		g2.setStroke(new BasicStroke(5));

		if (box00.equals("x")) {
			g2.setPaint(Color.MAGENTA);
			g.drawLine(33, 33, 300, 300);
			g.drawLine(300, 33, 33, 300);
		} else if (box00.equals("o")) {
			g2.setPaint(Color.ORANGE);
			g.drawOval(33, 33, 266, 266);
		}

		if (box01.equals("x")) {
			g2.setPaint(Color.MAGENTA);
			g.drawLine(33+333, 33, 300+333, 300);
			g.drawLine(300+333, 33, 33+333, 300);
		} else if (box01.equals("o")) {
			g2.setPaint(Color.ORANGE);
			g.drawOval(33+333, 33, 266, 266);
		}

		if (box02.equals("x")) {
			g2.setPaint(Color.MAGENTA);
			g.drawLine(33+333+333, 33, 300+333+333, 300);
			g.drawLine(300+333+333, 33, 33+333+333, 300);
		} else if (box02.equals("o")) {
			g2.setPaint(Color.ORANGE);
			g.drawOval(33+333+333, 33, 266, 266);
		}

		if (box10.equals("x")) {
			g2.setPaint(Color.MAGENTA);
			g.drawLine(33, 33+333, 300, 300+333);
			g.drawLine(300, 33+333, 33, 300+333);
		} else if (box10.equals("o")) {
			g2.setPaint(Color.ORANGE);
			g.drawOval(33, 33+333, 266, 266);
		}

		if (box11.equals("x")) {
			g2.setPaint(Color.MAGENTA);
			g.drawLine(33+333, 33+333, 300+333, 300+333);
			g.drawLine(300+333, 33+333, 33+333, 300+333);
		} else if (box11.equals("o")) {
			g2.setPaint(Color.ORANGE);
			g.drawOval(33+333, 33+333, 266, 266);
		}

		if (box12.equals("x")) {
			g2.setPaint(Color.MAGENTA);
			g.drawLine(33+333+333, 33+333, 300+333+333, 300+333);
			g.drawLine(300+333+333, 33+333, 33+333+333, 300+333);
		} else if (box12.equals("o")) {
			g2.setPaint(Color.ORANGE);
			g.drawOval(33+333+333, 33+333, 266, 266);
		}

		if (box20.equals("x")) {
			g2.setPaint(Color.MAGENTA);
			g.drawLine(33, 33+333+333, 300, 300+333+333);
			g.drawLine(300, 33+333+333, 33, 300+333+333);
		} else if (box20.equals("o")) {
			g2.setPaint(Color.ORANGE);
			g.drawOval(33, 33+333+333, 266, 266);
		}

		if (box21.equals("x")) {
			g2.setPaint(Color.MAGENTA);
			g.drawLine(33+333, 33+333+333, 300+333, 300+333+333);
			g.drawLine(300+333, 33+333+333, 33+333, 300+333+333);
		} else if (box21.equals("o")) {
			g2.setPaint(Color.ORANGE);
			g.drawOval(33+333, 33+333+333, 266, 266);
		}

		if (box22.equals("x")) {
			g2.setPaint(Color.MAGENTA);
			g.drawLine(33+333+333, 33+333+333, 300+333+333, 300+333+333);
			g.drawLine(300+333+333, 33+333+333, 33+333+333, 300+333+333);
		} else if (box22.equals("o")) {
			g2.setPaint(Color.ORANGE);
			g.drawOval(33+333+333, 33+333+333, 266, 266);
		}

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == resetBtn) {
			box00 = "";
			box01 = "";
			box02 = "";
			box10 = "";
			box11 = "";
			box12 = "";
			box20 = "";
			box21 = "";
			box22 = "";
			noticeMsg.setForeground(Color.BLACK);
			noticeMsg.setText("Resetting...");
			resetBtn.setText("Reset Game");
			turn = 3;

		}

		repaint();

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
			
		int x = e.getX();
		int y = e.getY();

		if(turn == 0){
			if(x < 333 && y < 333) { //box00
				if (box00.equals("")) {
					box00 = "x";
					turn++;
				}
			} else if(x < 666 && y < 333) { //box01
				if (box01.equals("")) {
					box01 = "x";
					turn++;
				}
			} else if(x < 999 && y < 333) { //box02
				if (box02.equals("")) {
					box02 = "x";
					turn++;
				}
			} else if(x < 333 && y < 666) { //box10
				if (box10.equals("")) {
					box10 = "x";
					turn++;
				}
			} else if(x < 666 && y < 666) { //box11
				if (box11.equals("")) {
					box11 = "x";
					turn++;
				}
			} else if(x < 999 && y < 666) { //box12
				if (box12.equals("")) {
					box12 = "x";
					turn++;
				}
			} else if(x < 333 && y < 999) { //box20
				if (box20.equals("")) {
					box20 = "x";
					turn++;
				}
			} else if(x < 666 && y < 999) { //box21
				if (box21.equals("")) {
					box21 = "x";
					turn++;
				}
			} else if(x < 999 && y < 999) { //box22
				if (box22.equals("")) {
					box22 = "x";
					turn++;
				}
			}
			System.out.println("[x-move] New turn = " + turn);
		}

		repaint();

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

}