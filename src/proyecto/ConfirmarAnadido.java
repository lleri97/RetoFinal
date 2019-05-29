package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmarAnadido extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnAceptar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmarAnadido frame = new ConfirmarAnadido();
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
	public ConfirmarAnadido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosEnviadosY = new JLabel("Datos enviados y a\u00F1adidos");
		lblDatosEnviadosY.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosEnviadosY.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDatosEnviadosY.setBounds(31, 27, 183, 41);
		contentPane.add(lblDatosEnviadosY);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(31, 83, 192, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()  == btnAceptar) {
			this.dispose();
		}
		
	}
}
