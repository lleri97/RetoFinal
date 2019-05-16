package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Proveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textDescripcion;

	/**
	 * Create the dialog.
	 */
	public Proveedor(boolean modal) {
		this.setModal(modal);
		setTitle("Proveedores");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCodProv = new JLabel("Codigo Proveedor:");
			lblCodProv.setBounds(50, 37, 123, 14);
			contentPanel.add(lblCodProv);
		}
		{
			JComboBox cbProv = new JComboBox();
			cbProv.setBounds(159, 34, 135, 20);
			contentPanel.add(cbProv);
		}
		{
			JButton btnModificar = new JButton("Modificar");
			btnModificar.setBounds(320, 33, 89, 23);
			contentPanel.add(btnModificar);
		}
		{
			JButton btnAñadir = new JButton("A\u00F1adir proveedor");
			btnAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(btnAñadir)) {
						viajeAadir();
					}
				}
			});
			btnAñadir.setBounds(274, 80, 135, 23);
			contentPanel.add(btnAñadir);
		}
		{
			textNombre = new JTextField();
			textNombre.setBounds(82, 104, 130, 20);
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		}
		{
			textDireccion = new JTextField();
			textDireccion.setBounds(82, 199, 130, 20);
			contentPanel.add(textDireccion);
			textDireccion.setColumns(10);
		}
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setBounds(32, 107, 66, 14);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblDireccion = new JLabel("Direccion: ");
			lblDireccion.setBounds(23, 202, 79, 17);
			contentPanel.add(lblDireccion);
		}
		{
			textTelefono = new JTextField();
			textTelefono.setBounds(82, 153, 130, 20);
			contentPanel.add(textTelefono);
			textTelefono.setColumns(10);
		}
		{
			textDescripcion = new JTextField();
			textDescripcion.setBounds(304, 141, 120, 45);
			contentPanel.add(textDescripcion);
			textDescripcion.setColumns(10);
		}
		{
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(29, 155, 66, 17);
			contentPanel.add(lblTelefono);
		}
		{
			JLabel lblDescripcion = new JLabel("Descripcion:");
			lblDescripcion.setBounds(230, 144, 89, 14);
			contentPanel.add(lblDescripcion);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(btnVolver)){
						cerrarProv();
					}
						
				}
			});
			btnVolver.setBounds(320, 214, 89, 23);
			contentPanel.add(btnVolver);
		}
	}

	protected void viajeAadir() {
		AñadirProveedor AadirProv = new AñadirProveedor();
		AadirProv.setVisible(true);
		
		
	}

	protected void cerrarProv() {
		this.dispose();
		
	}

}
