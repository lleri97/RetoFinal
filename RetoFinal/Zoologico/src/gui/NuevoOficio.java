package gui;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoOficio extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textCodOfi;
	private JTextField textNombreOfi;
	private JTextField textDescOfi;
	private JTextField textSueldoOfi;
	private JButton btnAadir;
	private JButton btnVolver;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoOficio dialog = new NuevoOficio();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public NuevoOficio() {
		setTitle("A\u00F1adir oficio");
		setBounds(100, 100, 277, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCodigoOficio = new JLabel("Codigo oficio:");
		lblCodigoOficio.setBounds(38, 45, 82, 14);
		getContentPane().add(lblCodigoOficio);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(38, 79, 69, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(38, 114, 82, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblSueldo = new JLabel("Sueldo: ");
		lblSueldo.setBounds(38, 149, 69, 14);
		getContentPane().add(lblSueldo);
		
		textCodOfi = new JTextField();
		textCodOfi.setEditable(false);
		textCodOfi.setBounds(148, 42, 86, 20);
		getContentPane().add(textCodOfi);
		textCodOfi.setColumns(10);
		
		textNombreOfi = new JTextField();
		textNombreOfi.setBounds(148, 76, 86, 20);
		getContentPane().add(textNombreOfi);
		textNombreOfi.setColumns(10);
		
		textDescOfi = new JTextField();
		textDescOfi.setBounds(148, 111, 86, 20);
		getContentPane().add(textDescOfi);
		textDescOfi.setColumns(10);
		
		textSueldoOfi = new JTextField();
		textSueldoOfi.setBounds(148, 146, 86, 20);
		getContentPane().add(textSueldoOfi);
		textSueldoOfi.setColumns(10);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(31, 204, 89, 23);
		getContentPane().add(btnAadir);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnVolver)) {
				volverOficio();
			}
		}
		});
		btnVolver.setBounds(148, 204, 89, 23);
		getContentPane().add(btnVolver);

	}

	protected void volverOficio() {
		this.dispose();
		
	}
	
}

