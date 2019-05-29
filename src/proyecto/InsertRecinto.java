package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Recinto;
import control.Manager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class InsertRecinto extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField TextCodRecinto;
	private JTextField textDesc;
	private JButton btnAadirRecinto;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertRecinto dialog = new InsertRecinto(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param modal 
	 */
	public InsertRecinto(boolean modal) {
		setBounds(100, 100, 245, 354);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setModal(modal);
		
		
		TextCodRecinto = new JTextField();
		TextCodRecinto.setBounds(124, 43, 86, 20);
		contentPanel.add(TextCodRecinto);
		TextCodRecinto.setColumns(10);
		
		JLabel lblCodigoAnimal = new JLabel("Codigo recintos:");
		lblCodigoAnimal.setBounds(10, 46, 86, 14);
		contentPanel.add(lblCodigoAnimal);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 115, 75, 14);
		contentPanel.add(lblDescripcin);
		
		textDesc = new JTextField();
		textDesc.setColumns(10);
		textDesc.setBounds(10, 140, 200, 98);
		contentPanel.add(textDesc);
		
		btnAadirRecinto = new JButton("A\u00F1adir recinto");
		btnAadirRecinto.setBounds(10, 249, 200, 23);
		contentPanel.add(btnAadirRecinto);
		btnAadirRecinto.addActionListener(this);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
		
	}
	

	public void AñadirRecinto() throws ClassNotFoundException, SQLException, IOException {
		Manager manager=new Manager();
		Recinto recin= new Recinto();
		recin.setCodRec(TextCodRecinto.getText());
		recin.setDesc(textDesc.getText());
		manager.AñadirRecinto(recin);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelButton) {
			this.dispose();
		}
		if(e.getSource() == btnAadirRecinto) {
			
				ConfirmarAnadido confir= new ConfirmarAnadido();
				try {
					AñadirRecinto();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				confir.setVisible(true);
			
		}
		
	}
}
