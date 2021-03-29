package talk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Client extends JFrame implements ActionListener {
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JTextArea a1;

	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;

	Boolean typing;

	Client() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0, 9, 84));
		p1.setBounds(0, 0, 450, 70);
		add(p1);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("talk/pics/3.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(5, 17, 30, 30);
		p1.add(l1);

		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("talk/pics/smiley1.png"));
		Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l2.setBounds(40, 5, 60, 60);
		p1.add(l2);

		JLabel l3 = new JLabel("TAVNEET");
		l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
		l3.setForeground(Color.WHITE);
		l3.setBounds(110, 15, 100, 18);
		p1.add(l3);

		JLabel l4 = new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
		l4.setForeground(Color.WHITE);
		l4.setBounds(110, 35, 100, 20);
		p1.add(l4);

		Timer t = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (!typing) {
					l4.setText("Active Now");
				}
			}
		});

		t.setInitialDelay(2000);

		a1 = new JTextArea();
		a1.setBounds(5, 75, 440, 570);
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		add(a1);

		t1 = new JTextField();
		t1.setBounds(5, 655, 310, 40);
		t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		add(t1);

		t1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				l4.setText("typing...");
				try {
					if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
						// System.out.println("Hello");
						String out = t1.getText();
						a1.setText(a1.getText() + "\n\t\t\t" + out);
						dout.writeUTF(out);
						t1.setText("");
					}
				} catch (Exception e) {
				}

				t.stop();

				typing = true;
			}

			public void keyReleased(KeyEvent ke) {
				typing = false;

				if (!t.isRunning()) {
					t.start();
				}
			}
		});

		b1 = new JButton("Send");
		b1.setBounds(320, 655, 123, 40);
		b1.setBackground(new Color(0, 9, 84));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		b1.addActionListener(this);
		add(b1);

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setSize(450, 700);
		setLocation(100, 100);
		setUndecorated(true);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		try {
			String out = t1.getText();
			a1.setText(a1.getText() + "\n\t\t\t" + out);
			dout.writeUTF(out);
			t1.setText("");
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		new Client().setVisible(true);

		try {

			s = new Socket("192.168.1.207", 6003);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			String msginput = "";

			while (true) {
				msginput = din.readUTF();
				a1.setText(a1.getText() + "\n" + msginput);
			}

		} catch (Exception e) {
		}
	}
}
package talk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Client extends JFrame implements ActionListener {
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JTextArea a1;

	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;

	Boolean typing;

	Client() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0, 9, 84));
		p1.setBounds(0, 0, 450, 70);
		add(p1);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("talk/pics/3.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(5, 17, 30, 30);
		p1.add(l1);

		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("talk/pics/smiley1.png"));
		Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l2.setBounds(40, 5, 60, 60);
		p1.add(l2);

		JLabel l3 = new JLabel("TAVNEET");
		l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
		l3.setForeground(Color.WHITE);
		l3.setBounds(110, 15, 100, 18);
		p1.add(l3);

		JLabel l4 = new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
		l4.setForeground(Color.WHITE);
		l4.setBounds(110, 35, 100, 20);
		p1.add(l4);

		Timer t = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (!typing) {
					l4.setText("Active Now");
				}
			}
		});

		t.setInitialDelay(2000);

		a1 = new JTextArea();
		a1.setBounds(5, 75, 440, 570);
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		add(a1);

		t1 = new JTextField();
		t1.setBounds(5, 655, 310, 40);
		t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		add(t1);

		t1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				l4.setText("typing...");
				try {
					if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
						// System.out.println("Hello");
						String out = t1.getText();
						a1.setText(a1.getText() + "\n\t\t\t" + out);
						dout.writeUTF(out);
						t1.setText("");
					}
				} catch (Exception e) {
				}

				t.stop();

				typing = true;
			}

			public void keyReleased(KeyEvent ke) {
				typing = false;

				if (!t.isRunning()) {
					t.start();
				}
			}
		});

		b1 = new JButton("Send");
		b1.setBounds(320, 655, 123, 40);
		b1.setBackground(new Color(0, 9, 84));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		b1.addActionListener(this);
		add(b1);

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setSize(450, 700);
		setLocation(100, 100);
		setUndecorated(true);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		try {
			String out = t1.getText();
			a1.setText(a1.getText() + "\n\t\t\t" + out);
			dout.writeUTF(out);
			t1.setText("");
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		new Client().setVisible(true);

		try {

			s = new Socket("192.168.1.207", 6003);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			String msginput = "";

			while (true) {
				msginput = din.readUTF();
				a1.setText(a1.getText() + "\n" + msginput);
			}

		} catch (Exception e) {
		}
	}
}
