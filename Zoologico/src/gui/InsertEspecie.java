package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class InsertEspecie extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodEspecie;
	private JTextField textNameEspecie;
	private JComboBox comboBoxAlimentacion; 
	private JButton btnAadirEspecie; 
	private JButton cancelButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertEspecie dialog = new InsertEspecie();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertEspecie() {
		setBounds(100, 100, 245, 273);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textCodEspecie = new JTextField();
		textCodEspecie.setEditable(false);
		textCodEspecie.setBounds(124, 27, 86, 20);
		contentPanel.add(textCodEspecie);
		textCodEspecie.setColumns(10);
		
		JLabel lblCodigoAnimal = new JLabel("Codigo especie:");
		lblCodigoAnimal.setBounds(9, 30, 86, 14);
		contentPanel.add(lblCodigoAnimal);
		
		JLabel lblCodigoEspecie = new JLabel("Nombre especie:");
		lblCodigoEspecie.setBounds(9, 76, 87, 14);
		contentPanel.add(lblCodigoEspecie);
		
		JLabel lblDescripcin = new JLabel("Alimentianci\u00F3n:");
		lblDescripcin.setBounds(9, 122, 75, 14);
		contentPanel.add(lblDescripcin);
		
		textNameEspecie = new JTextField();
		textNameEspecie.setColumns(10);
		textNameEspecie.setBounds(124, 73, 86, 20);
		contentPanel.add(textNameEspecie);
		
		comboBoxAlimentacion = new JComboBox();
		comboBoxAlimentacion.setBounds(124, 119, 86, 20);
		contentPanel.add(comboBoxAlimentacion);
		
		btnAadirEspecie = new JButton("A\u00F1adir especie");
		btnAadirEspecie.setBounds(9, 166, 201, 23);
		contentPanel.add(btnAadirEspecie);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelButton) {
			this.dispose();
		}
		
	}
}
