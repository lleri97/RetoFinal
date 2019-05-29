package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Usuario;
import control.Manager;

public class InsertUsuario extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JTextField textCodEmple;
	private JTextField textNombreEmple;
	private JTextField textContrasenaEmple;
	private JButton btnCancelar;
	private JButton btnAadir;

	
	public static void main(String[] args) {
		try {
			InsertUsuario dialog = new InsertUsuario(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public InsertUsuario(boolean modal) {
		setBounds(100,100,268,376);
		getContentPane().setLayout(null);
		this.setModal(modal);
		
		JLabel lblCodEmpleado = new JLabel("Cod empleado");
		lblCodEmpleado.setBounds(26, 32, 68, 14);
		getContentPane().add(lblCodEmpleado);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 73, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(26, 126, 68, 14);
		getContentPane().add(lblContrasea);
		
		textCodEmple = new JTextField();
		textCodEmple.setEditable(false);
		textCodEmple.setBounds(138, 29, 86, 20);
		getContentPane().add(textCodEmple);
		textCodEmple.setColumns(10);
		
		textNombreEmple = new JTextField();
		textNombreEmple.setBounds(138, 70, 86, 20);
		getContentPane().add(textNombreEmple);
		textNombreEmple.setColumns(10);
		
		textContrasenaEmple = new JTextField();
		textContrasenaEmple.setBounds(138, 123, 86, 20);
		getContentPane().add(textContrasenaEmple);
		textContrasenaEmple.setColumns(10);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(this);
		btnAadir.setBounds(26, 227, 89, 23);
		getContentPane().add(btnAadir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
			
		btnCancelar.setBounds(26, 273, 89, 23);
		getContentPane().add(btnCancelar);
	}
	public void anadirUsuario() throws ClassNotFoundException, SQLException, IOException {
		Manager manager=new Manager();
		Usuario usu=new Usuario();
		usu.setCodEmp(textCodEmple.getText());
		usu.setNomUser(textNombreEmple.getText());
		usu.setPassUser(textContrasenaEmple.getText());
		manager.AnadirUsuario(usu);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnCancelar){
			this.dispose();
		}
		if (e.getSource()==btnAadir) {
			try {
				anadirUsuario();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		
	}
}

