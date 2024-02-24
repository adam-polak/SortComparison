package sort;

import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = -8849683656483583890L;
	
	private JButton randomize;
	private JButton sort;
	private Number instance;
	
	public MyFrame() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sorting Algorithms");
		
		instance = new Number();
		
		randomize = new JButton();
			randomize.setText("Randomize");
				randomize.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						randomizeButtonActionPerformed(e);
					}
				});
		sort = new JButton();
			sort.setText("Sort Numbers");
				sort.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sortButtonActionPerformed(e);
					}
				});
	}
	
	private void randomizeButtonActionPerformed(ActionEvent e) {
		instance.randomGen();
	}
	
	private void sortButtonActionPerformed(ActionEvent e) {
		instance.insertionSort();
	}
	
	
}
