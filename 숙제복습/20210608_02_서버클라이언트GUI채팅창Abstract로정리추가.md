# 프레임

```JAVA
package com.day34;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame implements KeyListener, ActionListener, WindowListener {
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JTextArea textArea;
	public SimpleDateFormat sdf = new SimpleDateFormat("  (yyyy-MM-dd HH:mm:ss)");

	Frame(String name) {
		super(name);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(setCenterPanel(), BorderLayout.CENTER);
		panel.add(setSouthPanel(), BorderLayout.SOUTH);

		add(panel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		text.requestFocus();
	}

	public Component setCenterPanel() {
		JPanel panel = new JPanel();
		if (textArea == null) {
			textArea = new JTextArea();
		}

		textArea.setPreferredSize(new Dimension(500, 750));
		textArea.setEditable(false);
		panel.add(textArea);

		return panel;
	}

	public Component setSouthPanel() {
		JPanel panel = new JPanel();
		if (text == null) {
			text = new JTextField();
		}
		if (button == null) {
			button = new JButton("모두 삭제");
		}

		text.setPreferredSize(new Dimension(400, 30));
		button.setPreferredSize(new Dimension(100, 30));
		button.addActionListener(this);
		text.addKeyListener(this);

		panel.setLayout(new BorderLayout());
		panel.add(text, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);

		return panel;

	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public JTextField getText() {
		return text;
	}

	public void setText(JTextField text) {
		this.text = text;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea TextArea) {
		this.textArea = TextArea;
	}

	public void setEnterText() {
		String formatDate = sdf.format(System.currentTimeMillis());
		String timeText = "본인 : " + text.getText() + formatDate;
		StringBuilder sb = new StringBuilder();
		sb.append(textArea.getText()).append(timeText).append("\n");
		textArea.setText(sb.toString());
		text.setText(null);
	}

	public void setEditTextArea(String message) {
		StringBuilder sb = new StringBuilder(textArea.getText());
		sb.append(message + "\n");
		textArea.setText(sb.toString());
	}

	public String getTextLine() {
		return text.getText();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.setText(null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_ENTER:
			setEnterText();
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		new Frame("프레임 창");
	}

}

```



# 서버&클라이언트 공통 정리(Abstract)

```java
package com.day34;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Abstract extends Frame implements Runnable {
	protected ServerSocket serverSocket;
	protected Socket socket;
	protected BufferedWriter bw;
	protected BufferedReader br;

	public abstract void setSocket() throws IOException;

	Abstract(String frameName) {
		super(frameName);
		try {

			setSocket();
			super.addKeyListener(this);

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			Thread thread = new Thread(this);
			thread.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		String message;
		String formatDate;
		try {
			while ((message = br.readLine()) != null) {
				formatDate = sdf.format(System.currentTimeMillis());
				setEditTextArea("상대방 : " + message + formatDate);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_ENTER:
			try {
				bw.write(getTextLine() + "\r\n");
				bw.flush();

				setEnterText();

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

}

```





# 서버

```java
package com.day34;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Abstract {

	@Override
	public void setSocket() throws IOException {
		serverSocket = new ServerSocket(50000);
		setEditTextArea("서버 생성 완료! 클라이언트를 기다리는 중..");
		socket = serverSocket.accept();
		setEditTextArea("클라이언트 연결 완료! 클라이언트 IP : " + socket.getInetAddress());
	}

	Server() {
		super("서버 채팅창");
		super.addWindowListener(this);

	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			if (serverSocket != null)
				serverSocket.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}

}


```



# 클라이언트

```java
package com.day34;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;

public class Client extends Abstract {

	@Override
	public void setSocket() throws IOException {
		socket = new Socket("127.0.0.1", 50000);
		setEditTextArea("서버 연결완료!");
	}

	Client() {
		super("클라이언트 채팅창");
		super.addWindowListener(this);

	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			if (socket != null)
				socket.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();
	}

}

```

