package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Empleado;
import clases.Proveedor;
import proyecto.ProveedorVentana;
import control.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ProveedorVentana extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textDescripcion;
	private JComboBox <String> pro;
	private JButton btnVolver;
	private JButton btnModificar ;
	private JButton btnAñadir;
	Manager manager = new Manager();
	private JComboBox cbProv;
	private JButton btnEliminar;
	private JButton btnGuardar;

	/**
	 * Create the dialog.
	 */
	public ProveedorVentana(boolean modal) {
		this.setModal(modal);
		setTitle("Proveedores");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCodProv = new JLabel("Codigo Proveedor:");
			lblCodProv.setBounds(32, 37, 123, 14);
			contentPanel.add(lblCodProv);
		}
		{
			try {
				
				ArrayList <String> proveedores = manager.getCodProv();
				
				for(int i=0;i<proveedores.size();i++){
					cbProv.addItem(proveedores.get(i));
				}
				cbProv.setSelectedIndex(-1);
			} catch(Exception e) {
				//String mensaje = "Ha ocurrido un error";
				//JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
				//System.out.println(e.getMessage());
				
			}		

			cbProv = new JComboBox <String> ();
			cbProv.addActionListener(this); 
						
		}
				
				
	
	
		{
			btnModificar = new JButton("Modificar");
			btnModificar.setBounds(230, 33, 89, 23);
			contentPanel.add(btnModificar);
			btnModificar.addActionListener(this);
		}
		{
			btnAñadir = new JButton("A\u00F1adir proveedor");
			btnAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(btnAñadir)) {
						viajeAadir();
					}
				}
			});
			btnAñadir.setBounds(272, 80, 137, 23);
			contentPanel.add(btnAñadir);
		}
		{
			textNombre = new JTextField();
			textNombre.setEditable(false);
			textNombre.setBounds(82, 104, 130, 20);
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		}
		{
			textDireccion = new JTextField();
			textDireccion.setEditable(false);
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
			textTelefono.setEditable(false);
			textTelefono.setBounds(82, 153, 130, 20);
			contentPanel.add(textTelefono);
			textTelefono.setColumns(10);
		}
		{
			textDescripcion = new JTextField();
			textDescripcion.setEditable(false);
			textDescripcion.setBounds(304, 129, 120, 45);
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
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setBounds(320, 214, 89, 23);
			contentPanel.add(btnVolver);
		}
		{
			cbProv = new JComboBox();
			cbProv.setBounds(130, 34, 82, 20);
			contentPanel.add(cbProv);
			getCodPro();
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(320, 33, 89, 23);
			contentPanel.add(btnEliminar);
			btnEliminar.addActionListener(this);
		}
		
			btnGuardar = new JButton("Guardar");
			btnGuardar.setEnabled(false);
			btnGuardar.setBounds(230, 33, 89, 23);
			contentPanel.add(btnGuardar);
			btnGuardar.addActionListener(this);
		}
		private void getCodPro() {
			ArrayList <String> pro=new ArrayList <String>();
			pro=Manager.getCodPro();
			for(int i=0;i<pro.size();i++) {
				cbProv.addItem(pro.get(i));
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnVolver)){
				cerrarProv();
			}
			
			if(e.getSource().equals(btnModificar)) {//Modificar oficio 
				
				btnModificar.setVisible(false);
				btnGuardar.setEnabled(true);
				textNombre.setEditable(true);
				textDireccion.setEditable(true);
				textTelefono.setEditable(true);
				textDescripcion.setEditable(true);
			}
			if(e.getSource().equals(btnGuardar)) {//Modificar oficio 
				String auxProv;
				auxProv=cbProv.getSelectedItem().toString();
					System.out.println("KKKJK");
					Manager manager = new Manager();
					try {
						Proveedor prov= new Proveedor();
						prov.setCodProv(auxProv);
						prov.setNombre(textNombre.getText());
						prov.setDir(textDireccion.getText());
						prov.setTlf(Integer.parseInt(textTelefono.getText()));
						prov.setDesc(textDescripcion.getText());
						manager.ModificarProv(prov);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					textNombre.setText("");
					textDireccion.setText("");
					textTelefono.setText("");
					textDescripcion.setText("");
					btnGuardar.setEnabled(false);
					btnModificar.setVisible(true);
				}else {
					System.out.println("No se guardaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					//JOptionPane.showMessageDialog( this, "No se ha podido guardar", "ERROR", ERROR, null);
		
				}
			
			
		
			if(e.getSource().equals(btnEliminar)) {//Borrar Proveedor
				String auxProv;
				boolean esta=true;
				auxProv=cbProv.getSelectedItem().toString();
				try {
					esta=EsBorrable(auxProv);
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(esta==false) {
					System.out.println("KKKJK");
					Manager manager = new Manager();
					try {
						manager.borrarProv(auxProv);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					textNombre.setText("");
					textDireccion.setText("");
					textTelefono.setText("");
					textDescripcion.setText("");
				}else {
					JOptionPane.showMessageDialog( this, "No ha podido borrarse", "ERROR", ERROR, null);
				}
			}
		}


	private boolean EsBorrable(String auxProv) throws ClassNotFoundException, SQLException {
		boolean esta = false;
		int cont=0;
		Manager manager = new Manager();
		cont = manager.hayProvs(cont, auxProv);
		if(cont==0) {
			esta=false;
		}else {
			esta=true;
		}
		return esta;
	}


	protected void viajeAadir() {
		AñadirProveedor AadirProv = new AñadirProveedor(true);
		AadirProv.setVisible(true);
		
	}

	protected void cerrarProv() {
		this.dispose();
		
	}
	private void getDatosProveedor( String auxProv) throws Exception {//Datos Proveedor
		Manager manager = new Manager();
		Proveedor pro = manager.getDatosProv(auxProv);
		textNombre.setText(pro.getNombre());
		Integer.valueOf(pro.getTlf());
		textDireccion.setText(pro.getDir());
		textDescripcion.setText(pro.getDesc());
	}
	private void cargarProveedores() throws ClassNotFoundException, IOException, SQLException {		//cargar oficios

			Manager manager = new Manager();
			
			
			ArrayList <String> pro = manager.getNombreProv();
			for(int i=0;i<pro.size();i++) {
				cbProv.addItem(pro.get(i));
			}
			cbProv.setSelectedIndex(-1);
	
	cbProv.setModel(new DefaultComboBoxModel(new String[] {}));
	cbProv.setBounds(159, 34, 135, 20);
	contentPanel.add(cbProv);
	}
}
