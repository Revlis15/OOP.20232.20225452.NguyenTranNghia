package hust.soict.dsai.GUI_project.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SwingAccumulator extends JFrame{
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum = 0;

	public SwingAccumulator(){
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2,2));

		cp.add(new JLabel("Enter an Interger: "));

		tfInput = new JTextField(10);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());

		cp.add(new JLabel("The Accumulated Sum is: "));

		tfOutput = new JTextField(10);	
		tfOutput.setEditable(false);
		cp.add(tfOutput);

		setTitle("Swing Accumulator");
		setSize(350, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NumberGrid();
	}

	private class TFInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
}
