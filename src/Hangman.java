import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	ArrayList<String> words = new ArrayList<String>();
	Stack<String> s = new Stack<String>();
	String wordtosolve;
	String mysteryword;
	JFrame frame;
	JPanel panel;
	JLabel label;
int lives = 6;
	public static void main(String[] args) throws FileNotFoundException {
		Hangman h = new Hangman();
		h.getwords();
		h.pushtostack();
		h.makelines();
		h.changelines();
	}

	public void getwords() throws FileNotFoundException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));

			String userAnswernumber = JOptionPane.showInputDialog("Give me a number!");
			int userAnswer = Integer.parseInt(userAnswernumber);
			for (int i = 0; i < userAnswer; i++) {
				br = new BufferedReader(new FileReader("dictionary.txt"));
				Random number = new Random();
				int numberint = number.nextInt(2999);

				for (int j = 0; j < numberint; j++) {
					br.readLine();
				}
				String line = br.readLine();

				words.add(line);
				br.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pushtostack() {

		for (int i = 0; i < words.size(); i++) {
			s.push(words.get(i));
		}
	}

	public void makelines() {
		wordtosolve = (String) s.pop();
		System.out.println(wordtosolve);
		mysteryword = "";
		for (int i = 0; i < wordtosolve.length(); i++) {
			mysteryword += "_ ";
		}
		frame = new JFrame("Hangman!!! PRESS ENTER WHEN YOU HAVE GUESSED ALL OF THE LETTERS!");
		panel = new JPanel();
		label = new JLabel(mysteryword);
		label.setFont(new Font("Serif", Font.PLAIN, 50));
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();

	}

	public void changelines() {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == 0) {

			wordtosolve = s.pop();
			mysteryword = "";
			lives = 6;
			for (int i = 0; i < wordtosolve.length(); i++) {
				mysteryword += "_ ";
			}
			label.setText(mysteryword);
			// TODO Auto-generated method stub
		}
		// TODO Auto-generated method stub
		String tempString = "";

		// TODO Auto-generated method stub
		for (int i = 0; i < wordtosolve.length(); i++) {
			if (e.getKeyChar() == (wordtosolve.charAt(i))) {
				tempString += wordtosolve.charAt(i) + " ";

			} else {
				tempString += mysteryword.charAt(i * 2) + " ";
lives = lives-1;
if(lives == 0) {
	JOptionPane.showMessageDialog(null, "YOU SUCKKKKKKKK! You lost");
}
			}
		}
		mysteryword = tempString;
		label.setText(tempString);
		


	}

}
