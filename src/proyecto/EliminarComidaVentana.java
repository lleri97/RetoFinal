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

public class EliminarComidaVentana extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JButton btnEliminar;
	private JComboBox cbComida;
	
	/**
	 * Create the dialog.
	 */
	public EliminarComidaVentana(boolean modal) {
		this.setModal(modal);
		setTitle("Eliminar comida");
		setBounds(100, 100, 250, 155);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodComida = new JLabel("Codigo Comida: ");
		lblCodComida.setBounds(14, 35, 97, 14);
		contentPanel.add(lblCodComida);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(117, 77, 105, 23);
		contentPanel.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(14, 77, 96, 23);
		contentPanel.add(btnVolver);
		btnVolver.addActionListener(this);
		
		cbComida = new JComboBox();
		cbComida.setBounds(106, 32, 116, 20);
		contentPanel.add(cbComida);
		getCodCom();
	}

	private void getCodCom() {
		ArrayList <String> com=new ArrayList <String>();
		com=Manager.getCodCom();
		for(int i=0;i<com.size();i++) {
			cbComida.addItem(com.get(i));
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnEliminar)) {//Borrar Comida
			String auxCom;
			auxCom=cbComida.getSelectedItem().toString();
			Manager manager = new Manager();
			try {
				manager.borrarCom(auxCom);
				getCodCom();
				JOptionPane.showMessageDialog(btnVolver, "Datos Eliminados");
				this.dispose();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(btnVolver)) {
			this.dispose();
		}
	}
	
}