package com.day29;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RemindHomework01 extends JFrame implements KeyListener {
	private JPanel panel;
	private JPanel[][] panels;
	private int row = 0;
	private int col = 0;

	private static final int ROAD = 0;
	private static final int WALL = 1;
	private static final int START = 2;
	private static final int END = 3;
	private static final int CURRENT = 4;

	private static final int ROW = 8;
	private static final int COL = 8;

	private static final Color[] COLOR = { new Color(250, 237, 239), // ROAD 의 색상
			new Color(33, 32, 32), // WALL 의 색상
			new Color(235, 52, 82), // START 의 색상
			new Color(74, 52, 237), // END 의 색상
			new Color(207, 52, 235) // CURRENT 의 색상
	};

	private static final int[][] MAP = { { START, ROAD, WALL, WALL, WALL, ROAD, WALL, ROAD },
			{ ROAD, ROAD, ROAD, ROAD, WALL, ROAD, WALL, ROAD }, { WALL, WALL, WALL, ROAD, ROAD, ROAD, ROAD, ROAD },
			{ WALL, ROAD, ROAD, ROAD, WALL, ROAD, WALL, ROAD }, { WALL, WALL, WALL, ROAD, WALL, WALL, WALL, ROAD },
			{ ROAD, ROAD, ROAD, ROAD, ROAD, ROAD, WALL, END }, { ROAD, WALL, WALL, WALL, WALL, WALL, WALL, ROAD },
			{ ROAD, ROAD, ROAD, ROAD, ROAD, ROAD, ROAD, ROAD }, };

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		panels[row][col].setBackground(COLOR[MAP[row][col]]);

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (row > 0 && MAP[row - 1][col] != WALL) {
				--row;
				panels[row][col].setBackground(COLOR[CURRENT]);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (row < ROW - 1 && MAP[row + 1][col] != WALL) {
				++row;
				panels[row][col].setBackground(COLOR[CURRENT]);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (col > 0 && MAP[row][col - 1] != WALL) {
				--col;
				panels[row][col].setBackground(COLOR[CURRENT]);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (col < COL - 1 && MAP[row][col + 1] != WALL) {
				++col;
				panels[row][col].setBackground(COLOR[CURRENT]);
			}
			break;

		}

		panels[row][col].setBackground(COLOR[CURRENT]);
		if (MAP[row][col] == END) {
			JOptionPane.showMessageDialog(panel, "WIN!");
			dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	RemindHomework01() {
		super("길찾기");
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(new GridLayout(ROW, COL));

		panels = new JPanel[ROW][COL];
		for (int i = 0; i < ROW; ++i) {
			for (int j = 0; j < COL; ++j) {
				panels[i][j] = new JPanel();
				panels[i][j].setBackground(COLOR[MAP[i][j]]);
				panel.add(panels[i][j]);
			}
		}

		add(panel);
		addKeyListener(this);

		setVisible(true);
	}

	public static void main(String[] args) {
		new RemindHomework01();
	}
}
