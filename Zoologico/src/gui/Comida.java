package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Comida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textAlimentacion;
	private JTextField textStock;
	private JTextField textCodProv;
	private JTextField textCodComida;

	/**
	 * Create the dialog.
	 */
	public Comida(boolean modal) {
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
		
		textCodProv = new JTextField();
		textCodProv.setBounds(310, 158, 114, 20);
		contentPanel.add(textCodProv);
		textCodProv.setColumns(10);
		
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
		
		JButton btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(269, 210, 105, 23);
		contentPanel.add(btnAñadir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnVolver)) {
					cerrarCom();
				}
			}
		});
		btnVolver.setBounds(53, 210, 96, 23);
		contentPanel.add(btnVolver);
		
		textCodComida = new JTextField();
		textCodComida.setBounds(106, 35, 86, 20);
		contentPanel.add(textCodComida);
		textCodComida.setColumns(10);
	}

	protected void cerrarCom() {
		this.dispose();
		
	}
}
