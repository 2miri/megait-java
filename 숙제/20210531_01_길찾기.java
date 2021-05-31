package com.day28;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Homework01 extends JFrame implements KeyListener {
	private JButton[][] bt = new JButton[ROW][COL];

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
		// ￿ 왼쪽 / 37 ￿ 아래 / 40 ￿오른쪽 / 39 위￿ / 38
		if (e.getKeyCode() == 37) {
			setLeft();
		}
		if (e.getKeyCode() == 39) {
			setRight();
		}
		if (e.getKeyCode() == 38) {
			setUp();
		}
		if (e.getKeyCode() == 40) {
			setDown();
		}
	}

	public void setLeft() {
		try {
			--col;
			int i = Integer.parseInt(bt[row][col].getText());
			if (col >= 0 && col < bt[row].length) {
				switch (i) {
				case ROAD:
					bt[row][col].setText(String.valueOf(CURRENT));
					setBtColor(bt, row, col);

					if (bt[row][col + 1].getText().equals(String.valueOf(START))) {
						return;
					} else {
						bt[row][col + 1].setText(String.valueOf(ROAD));
						setBtColor(bt, row, col + 1);
					}
					break;
				case WALL:
					++col;
					break;
				case END:
					bt[row][col + 1].setText(String.valueOf(ROAD));
					setBtColor(bt, row, col + 1);
					JOptionPane.showMessageDialog(this, "성공!");
					this.dispose();
					break;
				case START:
					bt[row][col + 1].setText(String.valueOf(ROAD));
					setBtColor(bt, row, col + 1);
					break;

				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "지도를 벗어났습니다.");
			++col;
		}
	}

	public void setRight() {
		try {
			++col;
			int i = Integer.parseInt(bt[row][col].getText());
			if (col > 0 && col < bt[row].length) {
				switch (i) {
				case ROAD:
					bt[row][col].setText(String.valueOf(CURRENT));
					setBtColor(bt, row, col);

					if (bt[row][col - 1].getText().equals(String.valueOf(START))) {
						return;
					} else {
						bt[row][col - 1].setText(String.valueOf(ROAD));
						setBtColor(bt, row, col - 1);
					}
					break;
				case WALL:
					--col;
					break;
				case END:
					bt[row][col - 1].setText(String.valueOf(ROAD));
					setBtColor(bt, row, col - 1);
					JOptionPane.showMessageDialog(this, "성공!");
					this.dispose();
					break;
				}
			} else {
				--col;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "지도를 벗어났습니다.");
			--col;
		}
	}

	public void setUp() {
		try {
			--row;
			int i = Integer.parseInt(bt[row][col].getText());
			if (row >= 0 && row < bt.length) {
				switch (i) {
				case ROAD:
					bt[row][col].setText(String.valueOf(CURRENT));
					setBtColor(bt, row, col);

					if (bt[row + 1][col].getText().equals(String.valueOf(START))) {
						return;
					} else {
						bt[row + 1][col].setText(String.valueOf(ROAD));
						setBtColor(bt, row + 1, col);
					}
					break;
				case WALL:
					++row;
					break;
				case END:
					bt[row + 1][col].setText(String.valueOf(ROAD));
					setBtColor(bt, row + 1, col);
					JOptionPane.showMessageDialog(this, "성공!");
					this.dispose();
					break;
				}
			} else {
				++row;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "지도를 벗어났습니다.");
			++row;
		}
	}

	public void setDown() {
		try {
			++row;
			int i = Integer.parseInt(bt[row][col].getText());
			if (row > 0 && row < bt.length) {
				switch (i) {
				case ROAD:
					bt[row][col].setText(String.valueOf(CURRENT));
					setBtColor(bt, row, col);

					if (bt[row - 1][col].getText().equals(String.valueOf(START))) {
						return;
					} else {
						bt[row - 1][col].setText(String.valueOf(ROAD));
						setBtColor(bt, row - 1, col);
					}
					break;
				case WALL:
					--row;
					break;
				case END:
					bt[row - 1][col].setText(String.valueOf(ROAD));
					setBtColor(bt, row - 1, col);
					JOptionPane.showMessageDialog(this, "성공!");
					this.dispose();
					break;
				}
			} else {
				--row;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "지도를 벗어났습니다.");
			--row;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public void setJButton(JButton[][] bt, JFrame frame) {
		if (bt == null) {
			bt = new JButton[ROW][COL];
		}
		for (int i = 0; i < bt.length; ++i) {
			for (int j = 0; j < bt[i].length; ++j) {
				bt[i][j] = new JButton(String.valueOf(MAP[i][j]));
				int jbt = Integer.parseInt(bt[i][j].getText());

				switch (jbt) {
				case ROAD:
					bt[i][j].setForeground(COLOR[ROAD]);
					bt[i][j].setBackground(COLOR[ROAD]);
					break;
				case WALL:
					bt[i][j].setForeground(COLOR[WALL]);
					bt[i][j].setBackground(COLOR[WALL]);
					break;
				case START:
					bt[i][j].setForeground(COLOR[START]);
					bt[i][j].setBackground(COLOR[START]);
					break;
				case END:
					bt[i][j].setForeground(COLOR[END]);
					bt[i][j].setBackground(COLOR[END]);
					break;
				case CURRENT:
					bt[i][j].setForeground(COLOR[CURRENT]);
					bt[i][j].setBackground(COLOR[CURRENT]);
					break;

				}
				bt[i][j].addKeyListener(this);
				frame.add(bt[i][j]);
			}
		}
	}

	public void setBtColor(JButton[][] bt, int row, int col) {
		bt[row][col].getText();
		int i = Integer.parseInt(bt[row][col].getText());
		if (bt[row][col] == null) {
			return;
		}
		switch (i) {
		case ROAD:
			bt[row][col].setForeground(COLOR[ROAD]);
			bt[row][col].setBackground(COLOR[ROAD]);
			break;
		case WALL:
			bt[row][col].setForeground(COLOR[WALL]);
			bt[row][col].setBackground(COLOR[WALL]);
			break;
		case START:
			bt[row][col].setForeground(COLOR[START]);
			bt[row][col].setBackground(COLOR[START]);
			break;
		case END:
			bt[row][col].setForeground(COLOR[END]);
			bt[row][col].setBackground(COLOR[END]);
			break;
		case CURRENT:
			bt[row][col].setForeground(COLOR[CURRENT]);
			bt[row][col].setBackground(COLOR[CURRENT]);
			break;
		}
	}

	public void setJFrame(JFrame frame) {
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(ROW, COL));
	}

	Homework01() {

		super("길찾기!");

		setJFrame(this);

		setJButton(bt, this);

		setVisible(true);
		bt[row][col].requestFocus();
	}

	public static void main(String[] args) {
		new Homework01();
	}
}
