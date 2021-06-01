package com.day29;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Study01 extends JFrame implements ActionListener {
	JButton startButton;
	JLabel timerLabel;

	Timer timer;
	int i;
	boolean running;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (running) {
			return;
		}

		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timerLabel.setText(++i + "초");
				running = true;

				// 5초일때 멈추게!
				if (i == 5) {
					timer.stop();
					running = false;
				}
			}
		});
		timer.start();
	}

	Study01() {
		super("타이머");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		timerLabel = new JLabel("0초", SwingConstants.CENTER);
		timerLabel.setPreferredSize(new Dimension(400, 400));
		timerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));

		startButton = new JButton("START");
		startButton.setPreferredSize(new Dimension(200, 100));
		startButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		startButton.addActionListener(this);

		setLayout(new BorderLayout());
		add(timerLabel, BorderLayout.CENTER);
		add(startButton, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Study01();

	}

}
