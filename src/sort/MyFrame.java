package sort;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

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
		
		GroupLayout layout = new GroupLayout(getContentPane());
		this.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		GroupLayout.SequentialGroup xGroup  = layout.createSequentialGroup();
		xGroup.addGroup(layout.createParallelGroup())
			.addComponent(sort);
		xGroup.addGroup(layout.createParallelGroup())
			.addComponent(randomize);
		layout.setHorizontalGroup(xGroup);
		
		GroupLayout.SequentialGroup yGroup = layout.createSequentialGroup();
		yGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE))
			.addComponent(sort);
		yGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE))
			.addComponent(randomize);
		layout.setVerticalGroup(yGroup);
		
		this.setSize(300,300);
		this.setResizable(true);
		this.setVisible(true);
		
	}
	
	private void randomizeButtonActionPerformed(ActionEvent e) {
		instance.randomGen();
	}
	
	private void sortButtonActionPerformed(ActionEvent e) {
		instance.insertionSort();
	}
	
	
}
