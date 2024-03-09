package sort;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = -8849683656483583890L;
	
	private class BPanel extends JPanel {
		
		//private boolean[] mark = new boolean[100];
		
		BPanel() {
			setSize(new Dimension(200, 200));
			setPreferredSize(new Dimension(200, 200));
		}
		
		public void paint(Graphics g) {
			Number.Node val = list.getNext();
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(Color.darkGray);
			int baseLine = 200;
			int center = 80;
			int count = 99;
			int height = 0;
			while(val != null) {
				g2D.setColor(Color.red);
				g2D.drawLine(count + center, 0, count + center, baseLine);
				if(val.red) g2D.setColor(Color.red);
				else g2D.setColor(Color.darkGray);
				val.red = false;
				height = val.num / 10;
				g2D.drawLine(count + center, height, count + center, baseLine);
				count--;
				val = list.getNext();
			}
			MyFrame.this.changeLayout();
		}
	}
	
	private JButton randomize;
	private JButton sort;
	private JPanel frame;
	private JPanel buttons;
	private BPanel bars;
	private Number list;
	
	public MyFrame() {
		frame = new JPanel();
		buttons = new JPanel();
		list = new Number();
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
	
	private void randomizeButtonActionPerformed(ActionEvent e) {
		list.randomGen();
		//setHeights();
		changeLayout();
	}
	
	private void sortButtonActionPerformed(ActionEvent e) {
		list.insertionSort();
		//setHeights();
		changeLayout();
	}
	
	private class Number {
		
		public class Node {
			int num;
			Node next;
			boolean red = false;
			Node(int n, Node x) {
				num = n;
				next = x;
			}
		}
		
		private Node dummy = new Node(-1, null);
		private Node nextValue = dummy;
		private Node nextNode = dummy;
		
		/*
		 * Returns the value of the next node in the list.
		 */
		public int getNextNum() {
			if(nextValue != null && nextValue.next != null) {
				nextValue = nextValue.next;
				return nextValue.num;
			} else {
				nextValue = dummy;
				return -1;
			}
		}
		
		public Node getNext() {
			if(nextNode != null && nextNode.next != null) {
				nextNode = nextNode.next;
				return nextNode;
			} else {
				nextNode = dummy;
				return null;
			}
		}
		
		public Number() {
			randomGen();
		}
		
		public void showList() {
			System.out.println("-------------------------------------------------");
			Node check = dummy.next;
			while(check != null) {
				System.out.println(check.num);
				check = check.next;
			}
			System.out.println("-------------------------------------------------");
		}
		
		/*
		 * Creates a list of 100 random numbers between (0, 1,000]
		 */
		private void randomGen() {
			int random;
			dummy.next = null;
			Node prev = dummy.next;
			Node add;
			for(int i = 0; i < 100; i++) {
				random = (int)(Math.random() * 1000) + 1;
				add = new Node(random, prev);
				dummy.next = add;
				prev = add;
			}
			
			showList();
		}
		
		/*
		 * Uses insertion sort to sort the 1000 numbers;
		 */
		private void insertionSort() {
			Node lag = dummy.next;
			Node current = lag == null ? null : lag.next;
			Node temp = current;
			if(lag != null) lag.next = null;
			Node find;
			boolean found = false;
			int delay = 0;
			while(current != null) {
				temp = current;
				current = current.next;
				temp.next = null;
				
				find = dummy;
				found = false;
				temp.red = true;
				while(find.next != null) {
					find.red = true;
					if(temp.num <= find.next.num) {
						temp.next = find.next;
						find.next = temp;
						found = true;
						find.red = true;
						MyFrame.this.bars.paint(MyFrame.this.bars.getGraphics());
						while(delay < 100000) {
							System.out.println(delay);
							delay++;
						}
						break;
					}
					while(delay < 100) {
						System.out.println(delay);
						delay++;
					}
					delay = 0;
					MyFrame.this.bars.paint(MyFrame.this.bars.getGraphics());
					find = find.next;
				}
				MyFrame.this.bars.paint(MyFrame.this.bars.getGraphics());
				if(!found) find.next = temp;
			}
			
			showList();
		}
	}
	
	
}
