package proyecto;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class LogComida extends JPanel {

	/**
	 * Create the panel.
	 */
	public LogComida() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 290, 60);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNomComida = new JLabel("Cod Com");
		lblNomComida.setBounds(10, 9, 46, 14);
		panel.add(lblNomComida);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(66, 0, 2, 60);
		panel.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(78, 9, 91, 14);
		panel.add(lblNombre);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 30, 290, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		lblNewLabel.setBounds(202, 9, 78, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alimentacion");
		lblNewLabel_1.setBounds(202, 37, 78, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblCodProv = new JLabel("Cod Prov");
		lblCodProv.setBounds(10, 37, 46, 14);
		panel.add(lblCodProv);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(78, 37, 91, 14);
		panel.add(lblTelefono);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(179, 0, 2, 60);
		panel.add(separator_2);
		
	}
}
