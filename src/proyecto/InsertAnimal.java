package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Animal;
import control.Manager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class InsertAnimal extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodAnimal;
	private JTextField textDesc;
	private JButton cancelButton; 
	private JButton btnAadirAnimal;
	private JComboBox comboBoxEstado; 
	private JComboBox comboBoxCodEspecie;
	private JLabel lblEdad;
	private JTextField textEdad;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxRecinto;
	private JComboBox comboBoxComida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertAnimal dialog = new InsertAnimal(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param modal 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public InsertAnimal(boolean modal) throws ClassNotFoundException, IOException, SQLException {
		setBounds(100, 100, 268, 376);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setModal(modal);
		
		
		textCodAnimal = new JTextField();
		textCodAnimal.setEditable(false);
		textCodAnimal.setBounds(124, 65, 86, 20);
		contentPanel.add(textCodAnimal);
		textCodAnimal.setColumns(10);
		
		JLabel lblCodigoAnimal = new JLabel("Codigo animal:");
		lblCodigoAnimal.setBounds(9, 68, 75, 14);
		contentPanel.add(lblCodigoAnimal);
		
		JLabel lblCodigoEspecie = new JLabel("Codigo especie:");
		lblCodigoEspecie.setBounds(9, 34, 76, 14);
		contentPanel.add(lblCodigoEspecie);
		
		comboBoxCodEspecie = new JComboBox();
		comboBoxCodEspecie.setBounds(124, 34, 86, 20);
		contentPanel.add(comboBoxCodEspecie);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(9, 121, 75, 14);
		contentPanel.add(lblDescripcin);
		
		textDesc = new JTextField();
		textDesc.setColumns(10);
		textDesc.setBounds(94, 121, 115, 60);
		contentPanel.add(textDesc);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(9, 195, 46, 14);
		contentPanel.add(lblEstado);
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(94, 192, 115, 20);
		contentPanel.add(comboBoxEstado);
		
		btnAadirAnimal = new JButton("A\u00F1adir animal");
		btnAadirAnimal.setBounds(10, 271, 200, 23);
		contentPanel.add(btnAadirAnimal);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(9, 96, 46, 14);
		contentPanel.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setBounds(124, 93, 86, 20);
		contentPanel.add(textEdad);
		textEdad.setColumns(10);
		
		lblNewLabel = new JLabel("Codigo recinto:");
		lblNewLabel.setBounds(9, 220, 75, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Codigo comida:");
		lblNewLabel_1.setBounds(9, 245, 75, 14);
		contentPanel.add(lblNewLabel_1);
		
		comboBoxRecinto = new JComboBox();
		comboBoxRecinto.setBounds(94, 217, 116, 20);
		contentPanel.add(comboBoxRecinto);
		
		comboBoxComida = new JComboBox();
		comboBoxComida.setBounds(94, 242, 116, 20);
		contentPanel.add(comboBoxComida);
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
		CargarDatos();
	}
	public void CargarDatos() throws ClassNotFoundException, IOException, SQLException {
		Manager manager = new Manager();
		
		//Carga de Especies
		ArrayList <String> CodsEspecie = manager.getCodEsp();
		for(int i=0;i<CodsEspecie.size();i++) {
			comboBoxCodEspecie.addItem(CodsEspecie.get(i));
		}
		comboBoxCodEspecie.setSelectedItem(-1);
		//Creacion del codigo Animal
		textCodAnimal.setText(comboBoxCodEspecie.getToolTipText().toString().substring(1, 3)+"-"+manager.getTamaño(comboBoxCodEspecie.getToolTipText().toString())+1);
		//Carga de Estados
		ArrayList<String> Estados = new ArrayList<String>();
		comboBoxEstado.addItem(Estados.set(1, "Sano"));
		comboBoxEstado.addItem(Estados.set(2, "Enfermo"));
		comboBoxEstado.addItem(Estados.set(3, "Embarazada"));
		comboBoxEstado.setSelectedItem(-1);
		//Carga de Recintos
		ArrayList<String> Recintos = manager.getCodRecinto();
		for(int i=0;i<Recintos.size();i++) {
			comboBoxRecinto.addItem(Recintos.get(i));
		}
		comboBoxRecinto.setSelectedItem(-1);
		//Carga de comida
		ArrayList<String> Comidas= manager.getCodComida();
		for(int i=0;i<Comidas.size();i++) {
			comboBoxComida.addItem(Comidas.get(i));
		}
		comboBoxComida.setSelectedItem(-1);
	}
	
	public void anadirAnimal() throws ClassNotFoundException, IOException, SQLException {
		Manager manager=new Manager();
		Animal ani= new Animal();
		ani.setCodAni(textCodAnimal.getText());
		ani.setCodCom(comboBoxComida.getToolTipText().toString());
		ani.setCodEsp(comboBoxCodEspecie.getToolTipText().toString());
		ani.setCodRec(comboBoxEstado.getToolTipText().toString());
		ani.setDesc(textDesc.getText());
		ani.setEdad(textEdad.getColumns());
		ani.setEstado(comboBoxEstado.getToolTipText().toString());
		manager.AñadirAnimal(ani);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelButton ) {
			this.dispose();
		}
		if(e.getSource() == btnAadirAnimal) {
			try {
				ConfirmarAnadido confir= new ConfirmarAnadido();
				anadirAnimal();
				confir.setVisible(true);
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
