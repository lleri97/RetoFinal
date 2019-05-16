package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class Login extends JFrame implements ActionListener{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private JPanel panBack;
	private JTextField textUser;
	private JPasswordField passwordField;
	private JButton btnClose;
	private JButton btnMin;
	private JPanel panLogin;
	private JLabel lblNewLabel;
	private JLabel lblUsuario;
	private JLabel lblPass;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/src/img/2411053_0.jpg")));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int wsize=450;
		int hsize=300;
		int w = (int) ((screenSize.getWidth()/2)-(wsize/2));
		int h = (int) ((screenSize.getHeight()/2)-(hsize/2));
		
		setUndecorated(true);
		setTitle("Zoologico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 294);
		panBack = new JPanel();
		panBack.setOpaque(false);
		setBackground(new Color(0, 0, 0,0));
		panBack.setBounds(84, 0, 271, 177);
		setContentPane(panBack);
		panBack.setLayout(null);
		
		panLogin = new JPanel();
		panLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panLogin.setBounds(210, 67, 180, 140);
		panBack.add(panLogin);
		panLogin.setLayout(null);
		
		textUser = new JTextField();
		textUser.setBounds(28, 38, 123, 20);
		panLogin.add(textUser);
		textUser.setColumns(10);
		
		btnMin = new JButton("");
		btnMin.setBounds(128, 2, 25, 25);
		panLogin.add(btnMin);
		btnMin.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/web/skin/DrawHorizontalLine_16x16_JFX.png")));
		btnMin.setActionCommand("");
		
		btnClose = new JButton("");
		btnClose.setBounds(153, 2, 25, 25);
		panLogin.add(btnClose);
		btnClose.setIcon(new ImageIcon(Login.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		btnClose.setActionCommand("");
		
		btnLogin = new JButton("LogIn");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\LogInIcon.png"));
		btnLogin.setActionCommand("");
		btnLogin.setBounds(28, 98, 123, 37);
		panLogin.add(btnLogin);
		btnLogin.addActionListener(this);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(38, 23, 76, 14);
		panLogin.add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(28, 75, 123, 20);
		panLogin.add(passwordField);
		
		lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(38, 60, 87, 14);
		panLogin.add(lblPass);
		btnClose.addActionListener(this);
		btnMin.addActionListener(this);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/src/img/Login.png")));
		lblNewLabel.setBounds(0, 0, 601, 294);
		panBack.add(lblNewLabel);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnClose)) {
			this.dispose();
		}
		if (e.getSource().equals(btnMin)) {
			this.setState(Frame.ICONIFIED);
		}
		if (e.getSource().equals(btnLogin)) {
			
			//TODO DB Control of Users
			
			
			//Prueba
			
			
			//Hasta aqui
			
			Inicio ini = new Inicio();
			this.dispose();
			ini.setVisible(true);
		}
	}
}
