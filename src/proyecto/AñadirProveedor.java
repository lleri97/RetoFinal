package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Proveedor;
import control.Manager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AñadirProveedor extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodProv;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JTextField textDescripcion;
	private JButton btnAñadir;
	private JButton btnVolver;

	
	public AñadirProveedor(boolean modal) {
		this.setModal(modal);
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
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(79, 224, 89, 23);
		contentPanel.add(btnVolver);
		btnVolver.addActionListener(this);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(this);
		btnAñadir.setBounds(250, 224, 89, 23);
		contentPanel.add(btnAñadir);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnVolver)) {
			volverAñadir();
		}
		if(e.getSource().equals(btnAñadir)) {
			Manager manager=new Manager();
			Proveedor pro = new Proveedor();
			pro.setCodProv(textCodProv.getText());
			pro.setNombre(textNombre.getText());
			pro.setTlf(Integer.valueOf(textTelefono.getText()));
			pro.setDir(textDireccion.getText());
			pro.setDesc(textDescripcion.getText());
									
			try {
				manager.AñadirProveedor(pro);
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(btnVolver, "Datos añadidos");
			
			textCodProv.setText("");
			textNombre.setText("");
			textTelefono.setText("");
			textDireccion.setText("");
			textDescripcion.setText("");
		}
		
		
	}
	protected void volverAñadir() {
		this.dispose();
		
	}
}