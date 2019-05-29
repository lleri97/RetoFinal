package proyecto;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Comida;
import clases.Proveedor;
import control.Manager;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AñadirComidaVentana extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textAlimentacion;
	private JTextField textStock;
	private JTextField textCodComida;
	private JButton btnVolver;
	private JButton btnAñadir;
	private JComboBox cbAli;
	private JComboBox cbProv;
	
	/**
	 * Create the dialog.
	 */
	public AñadirComidaVentana(boolean modal) {
		this.setModal(modal);
		setTitle("A\u00F1adir comida");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodComida = new JLabel("Codigo Comida: ");
		lblCodComida.setBounds(13, 38, 97, 14);
		contentPanel.add(lblCodComida);
		
		textNombre = new JTextField();
		textNombre.setBounds(106, 98, 86, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(106, 158, 86, 20);
		contentPanel.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		textAlimentacion = new JTextField();
		textAlimentacion.setBounds(310, 38, 114, 20);
		contentPanel.add(textAlimentacion);
		textAlimentacion.setColumns(10);
		
		textStock = new JTextField();
		textStock.setBounds(310, 98, 114, 20);
		contentPanel.add(textStock);
		textStock.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(53, 101, 97, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(30, 161, 97, 14);
		contentPanel.add(lblDescripcion);
		
		JLabel lblAlimentacion = new JLabel("Alimentacion:");
		lblAlimentacion.setBounds(228, 38, 97, 14);
		contentPanel.add(lblAlimentacion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(269, 101, 84, 14);
		contentPanel.add(lblStock);
		
		JLabel lblCodProv = new JLabel("Codigo proveedor: ");
		lblCodProv.setBounds(202, 161, 114, 14);
		contentPanel.add(lblCodProv);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(319, 210, 105, 23);
		contentPanel.add(btnAñadir);
		btnAñadir.addActionListener(this);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(213, 210, 96, 23);
		contentPanel.add(btnVolver);
		
		textCodComida = new JTextField();
		textCodComida.setBounds(106, 35, 86, 20);
		contentPanel.add(textCodComida);
		textCodComida.setColumns(10);
		
		JLabel lblCodAlimentacion = new JLabel("Codigo ali:");
		lblCodAlimentacion.setBounds(41, 214, 86, 14);
		contentPanel.add(lblCodAlimentacion);
		
		cbAli = new JComboBox();
		cbAli.setBounds(106, 211, 86, 20);
		contentPanel.add(cbAli);
		getCodAli();
		
		cbProv = new JComboBox();
		cbProv.setBounds(310, 158, 114, 20);
		contentPanel.add(cbProv);
		getCodPro();
	}

	private void getCodPro() {
		ArrayList <String> pro=new ArrayList <String>();
		pro=Manager.getCodPro();
		for(int i=0;i<pro.size();i++) {
			cbProv.addItem(pro.get(i));
		}
		
		
	}
	private void getCodAli() {
		ArrayList <String> ali=new ArrayList <String>();
		ali=Manager.getCodAli();
		for(int i=0;i<ali.size();i++) {
			cbAli.addItem(ali.get(i));
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAñadir)) {
			Manager manager=new Manager();
			Comida com= new Comida();
			com.setCodCom(textCodComida.getText());
			com.setNombre(textNombre.getText());
			com.setDesc(textDescripcion.getText());
			com.setAlimentacion(textAlimentacion.getText());
			com.setStock(Integer.valueOf(textStock.getText()));
			com.setCodProv(cbAli.getSelectedItem().toString());
			com.setCodAli(cbProv.getSelectedItem().toString());
									
			try {
				manager.AñadirComida(com);
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(btnVolver, "Datos añadidos");
			
			textCodComida.setText("");
			textNombre.setText("");
			textDescripcion.setText("");
			textAlimentacion.setText("");
			textStock.setText("");
			cbAli.setSelectedIndex(-1);
			cbProv.setSelectedIndex(-1);
		}
		
	}
	protected void cerrarCom() {
		this.dispose();
		
	}
}