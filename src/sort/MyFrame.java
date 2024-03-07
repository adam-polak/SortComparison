package sort;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;

import sort.Number.Node;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = -8849683656483583890L;
	
	private class BPanel extends JPanel {
		
		private boolean[] mark = new boolean[100];
		
		BPanel() {
			setSize(new Dimension(200, 200));
			setPreferredSize(new Dimension(200, 200));
		}
		
		public void paint(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(Color.darkGray);
			int baseLine = 200;
			int center = 80;
			int count = 0;
			for(int i = heights.length - 1; i >= 0; i--) {
				g2D.drawLine(count + center, heights[i], count + center, baseLine);
				count++;
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
		this.setSize(280,200);
		this.setResizable(false);
		this.setVisible(true);
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
			height = num / 10;
			heights[i] = height;
			num = instance.getNextNum();
		}
	}
	
	public void mark(Node x) {
		if(x.next == null) {
			bars.mark[99] = true;
		} else {
			for(int i = 0; i < heights.length - 1; i++) {
				if(heights[i] == x.num && heights[i + 1] == x.next.num) {
					bars.mark[i] = true;
				}
			}
		}
	}
	
	private void randomizeButtonActionPerformed(ActionEvent e) {
		instance.randomGen();
		setHeights();
		changeLayout();
	}
	
	private void sortButtonActionPerformed(ActionEvent e) {
		Node x = instance.getFirst();
		while(x != null) {
			x = instance.insert(x);
		}
		instance.showList();
		setHeights();
		changeLayout();
	}
	
	
}
