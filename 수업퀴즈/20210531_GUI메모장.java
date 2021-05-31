package com.day28;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//메모장 만들어보기
public class Study01 extends JPanel implements ActionListener, KeyListener {
	private JFrame frame;
	private JButton button;
	private JPanel smallPanel;
	private JPanel bigPanel;
	private TextField textField;
	private TextArea textArea;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String s = textField.getText();
			textArea.setText(textArea.getText() + s + "\n");
			textField.setText(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.setText(null);
	}

	Study01() {

		button = new JButton("삭제");
		button.addActionListener(this);

		textField = new TextField();
		textField.addKeyListener(this);

		textArea = new TextArea();
		textArea.setEditable(false);

		smallPanel = new JPanel();
		smallPanel.setLayout(new BorderLayout());
		smallPanel.add(textField, BorderLayout.CENTER);
		smallPanel.add(button, BorderLayout.EAST);

		bigPanel = new JPanel();
		bigPanel.setPreferredSize(new Dimension(400, 800));
		bigPanel.setLayout(new BorderLayout());
		bigPanel.add(textArea, BorderLayout.CENTER);
		bigPanel.add(smallPanel, BorderLayout.SOUTH);

		frame = new JFrame("나의 메모장");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(bigPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
		textField.requestFocus();
	}

	public static void main(String[] args) {
		new Study01();

	}
}
