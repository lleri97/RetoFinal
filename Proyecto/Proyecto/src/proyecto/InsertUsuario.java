package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InsertUsuario extends JDialog implements ActionListener{
	public InsertUsuario() {
		getContentPane().setLayout(null);
		
		JLabel lblCodEmpleado = new JLabel("Cod empleado");
		lblCodEmpleado.setBounds(26, 32, 68, 14);
		getContentPane().add(lblCodEmpleado);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 73, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(26, 126, 68, 14);
		getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(138, 29, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 70, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 123, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(26, 227, 89, 23);
		getContentPane().add(btnAadir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(315, 227, 89, 23);
		getContentPane().add(btnCancelar);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertAnimal dialog = new InsertAnimal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}

