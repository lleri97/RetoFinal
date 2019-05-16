package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AñadirProveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodProv;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JTextField textDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AñadirProveedor dialog = new AñadirProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AñadirProveedor() {
		setTitle("A\u00F1adir proveedor");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textCodProv = new JTextField();
		textCodProv.setBounds(128, 48, 80, 20);
		contentPanel.add(textCodProv);
		textCodProv.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(128, 113, 80, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(128, 177, 80, 20);
		contentPanel.add(textTelefono);
		textTelefono.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(314, 48, 89, 20);
		contentPanel.add(textDireccion);
		textDireccion.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(314, 113, 89, 20);
		contentPanel.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblCodProv = new JLabel("Codigo Proveedor:");
		lblCodProv.setBounds(20, 51, 124, 14);
		contentPanel.add(lblCodProv);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(76, 116, 52, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(73, 180, 74, 14);
		contentPanel.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(253, 51, 86, 14);
		contentPanel.add(lblDireccion);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(239, 116, 86, 14);
		contentPanel.add(lblDescripcion);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnVolver)) {
					volverAñadir();
				}
			}
		});
		btnVolver.setBounds(79, 224, 89, 23);
		contentPanel.add(btnVolver);
		
		JButton btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(250, 224, 89, 23);
		contentPanel.add(btnAñadir);
	}

	protected void volverAñadir() {
		this.dispose();
		
	}
}
