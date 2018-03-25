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

public class Hangman {
	ArrayList<String> words = new ArrayList<String>();
	Stack s = new Stack();

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
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);

		String wordtosolve = (String) s.pop();
		String mysteryword = "";
		for (int i = 0; i < ((String) s.pop()).length(); i++) {
			mysteryword += "_";
		}
	}

	public void changelines() {

	}
}
