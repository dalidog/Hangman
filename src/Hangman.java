import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Hangman implements ActionListener{
	ArrayList<String> words = new ArrayList<String>();
	Stack s = new Stack();
String wordtosolve;
String mysteryword;
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
		for (int i = 0; i < ((String) s.pop()).length(); i++) {
			mysteryword += "_ ";
		}
		JFrame frame = new JFrame("HaNgMaN");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(mysteryword);
		label.setFont(new Font("Serif", Font.PLAIN, 50));
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.pack();
		
		
	}

	public void changelines() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tempString = "";
		// TODO Auto-generated method stub
		for (int i = 0; i < wordtosolve.length(); i++) {
			if(e.getSource().toString().equals(wordtosolve.charAt(i)+"")) {
				tempString+=wordtosolve.charAt(i)+" ";
			}
			else {
				tempString+=mysteryword.charAt(i*2)+" ";
			}
		}
		mysteryword=tempString;
		}
		
}
