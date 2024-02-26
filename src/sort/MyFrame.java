package sort;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = -8849683656483583890L;
	
	private class BPanel extends JPanel {
		
		BPanel() {
			this.setPreferredSize(new Dimension(200, 200));
		}
		
		public void paint(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(Color.darkGray);
			for(int i = 0; i < heights.length; i++) {
				g2D.fillRect(i + 70, 0, 1, heights[i]);
			}
		}
	}
	
	private JButton randomize;
	private JButton sort;
	private Number instance;
	private JPanel frame;
	private JPanel buttons;
	private BPanel bars;
	private int[] heights;
	
	public MyFrame() {
		frame = new JPanel();
		buttons = new JPanel();
		heights = new int[100];
		instance = new Number();
		setHeights();
		bars = new BPanel();
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sorting Algorithms");
		
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
		
		changeLayout();
		
		this.setSize(300,600);
		this.setResizable(true);
		this.setVisible(true);
		
	}
	
	private void changeLayout() {
		
		//Button Frame Layout
		GroupLayout buttonLayout = new GroupLayout(buttons);
		buttons.setLayout(buttonLayout);
		
		buttonLayout.setAutoCreateGaps(true);
		buttonLayout.setAutoCreateContainerGaps(true);
		
		GroupLayout.SequentialGroup hGroup = buttonLayout.createSequentialGroup();
		hGroup.addGroup(buttonLayout.createParallelGroup()
	            .addComponent(sort, 120, 120, 120));
		hGroup.addGroup(buttonLayout.createParallelGroup()
				.addComponent(randomize, 120, 120, 120));
		buttonLayout.setHorizontalGroup(hGroup);
		
		GroupLayout.SequentialGroup vGroup = buttonLayout.createSequentialGroup();
		vGroup.addGroup(buttonLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(sort).addComponent(randomize));
		buttonLayout.setVerticalGroup(vGroup);
		
		//Root Frame Layout
		GroupLayout rootLayout = new GroupLayout(frame);
		frame.setLayout(rootLayout);
		
		rootLayout.setAutoCreateGaps(true);
		rootLayout.setAutoCreateContainerGaps(true);
		
		hGroup = rootLayout.createSequentialGroup();
		hGroup.addGroup(rootLayout.createParallelGroup()
				.addComponent(bars)
				.addComponent(buttons));
		rootLayout.setHorizontalGroup(hGroup);
		
		vGroup = rootLayout.createSequentialGroup();
		vGroup.addGroup(rootLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(bars));
		vGroup.addGroup(rootLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(buttons));
		rootLayout.setVerticalGroup(vGroup);
		
		this.add(frame);
		
	}
	
	private void setHeights() {
		int num = instance.getNextNum();
		int height = 0;
		
		for(int i = 0; i < this.heights.length; i++) {
			height = num / 2;
			heights[i] = height;
			num = instance.getNextNum();
		}
	}
	
	private void randomizeButtonActionPerformed(ActionEvent e) {
		instance.randomGen();
		setHeights();
		changeLayout();
	}
	
	private void sortButtonActionPerformed(ActionEvent e) {
		instance.insertionSort();
		setHeights();
		changeLayout();
	}
	
	
}
