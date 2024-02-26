package sort;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = -8849683656483583890L;
	
	private JButton randomize;
	private JButton sort;
	private Number instance;
	private JPanel[] bar;
	private int[] heights;
	
	public MyFrame() {
		bar = new JPanel[100];
		heights = new int[100];
		instance = new Number();
		setHeights();
		initBars();
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
		
		this.setSize(1000,1000);
		this.setResizable(true);
		this.setVisible(true);
		
	}
	
	private void changeLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
		this.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		GroupLayout.ParallelGroup hBars = setBarsH(layout);
		
		hGroup.addGroup(hBars
	            .addComponent(sort, 120, 120, 120));
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(randomize, 120, 120, 120));
		layout.setHorizontalGroup(hGroup);
		
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		GroupLayout.ParallelGroup vBars = setBarsV(layout);
		
		vGroup.addGroup(vBars);
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(sort).addComponent(randomize));
		layout.setVerticalGroup(vGroup);
	}
	
	private void initBars() {
		JPanel bar;
		bar = new JPanel();
		bar.setBackground(Color.red);
		bar.setSize(new Dimension(5, heights[0]));
		bar.setPreferredSize(getSize());
		this.bar[0] = bar;
//		boolean everyOther = true;
//		for(int i = 0; i < this.bar.length; i++) {
//			bar = new JPanel();
//			if(everyOther) {
//				bar.setBackground(Color.red);
//				everyOther = false;
//			} else {
//				bar.setBackground(Color.blue);
//				everyOther = true;
//			}
//			this.bar[i] = bar;
//		}
	}
	
	private void setHeights() {
		int num = instance.getNextNum();
		int height = 0;
		
		for(int i = 0; i < this.heights.length; i++) {
			height = (num / 2) + 10;
			heights[i] = height;
			num = instance.getNextNum();
		}
	}
	
	private ParallelGroup setBarsH(GroupLayout layout) {
		GroupLayout.ParallelGroup bars = layout.createParallelGroup();
		setHeights();
		bars.addComponent(bar[0], 10, 10, heights[0]);
//		for(int i = 0; i < heights.length; i++) {
//			bars.addComponent(bar[i], 10, 10, heights[i]);
//		}
		return bars;
	}
	
	private ParallelGroup setBarsV(GroupLayout layout) {
		GroupLayout.ParallelGroup bars = layout.createParallelGroup(Alignment.BASELINE);
		setHeights();
		bars.addComponent(bar[0], 10, 10, heights[0]);
//		for(int i = 0; i < heights.length; i++) {
//			bars.addComponent(bar[i], 10, 10, heights[i]);
//		}
		return bars;
	}
	
	private void randomizeButtonActionPerformed(ActionEvent e) {
		setHeights();
		changeLayout();
		instance.randomGen();
	}
	
	private void sortButtonActionPerformed(ActionEvent e) {
		setHeights();
		changeLayout();
		instance.insertionSort();
	}
	
	
}
