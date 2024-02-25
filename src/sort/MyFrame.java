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
		
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup()
	            .addComponent(sort, 120, 120, 120));
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(randomize, 120, 120, 120));
		layout.setHorizontalGroup(hGroup);
		
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(sort).addComponent(randomize));
		layout.setVerticalGroup(vGroup);
		
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
