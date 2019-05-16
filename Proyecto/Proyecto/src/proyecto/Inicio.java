package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Animal;
import clases.Especie;
import clases.Recinto;
import control.Manager;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Component;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Inicio extends JFrame implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField BusquedaText;
	private JTextField NombreText;
	private JTextField ApellidoText;
	private JTextField FechaNacText;
	private JTextField CodRecText;
	private JTextField TlfText;
	private JTextField DirText;
	private JTextField CodOfiText;
	private JTextField CodText;
	private JTextField NombreText_1;
	private JTextField DescText;
	private JTextField SueldoText;
	private JTextField textField;
	private JTextField textMostrarNombre;
	private JTextField textUsuario;
	private JTextField textClave;
	private JTextField textBusquedaAnimal;
	private JTextField TextBusquedaEspecie;
	private JTextField textBusquedaRecintos;
	private JTable TablaLogs;
	private JButton BusquedaBoton;
	private JButton btnGuardarDatos;
	private JButton NewOficioBtn;
	private JButton btnAadir;
	private JButton btnProveedores;
	private JButton btnBusquedaAnimal;
	private JButton btnNuevoAnimal;
	private JButton BusquedaEspecie;
	private JButton BtnNuevaEspecie;
	private JButton BusquedaRecinto; 
	private JButton btnNuevoRecinto;
	private JButton BusquedaUsu;
	private JButton btnResetearPasswd;
	private JButton btnEliminar;
	private JButton cancelButton; 
	private JList ListaOficios; 
	private JList ListaComida;
	private JList ListaAnimal; 
	private JList ListaAnimalDatos;
	private JList ListaEspecies;
	private JList ListaEspeciesDatos;
	private JList ListaRecintos; 
	private JList ListaRecintosDatos; 
	private JList ListaUsuarios; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Inicio dialog = new Inicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Inicio() {
		setBounds(100, 100, 658, 426);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JTabbedPane PestañasGeneral = new JTabbedPane(JTabbedPane.LEFT);
		PestañasGeneral.setBounds(0, 0, 642, 351);
		PestañasGeneral.setBackground(Color.WHITE);
		PestañasGeneral.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		PestañasGeneral.setForeground(Color.BLACK);
		getContentPane().add(PestañasGeneral);
		
		//Inicio
		JPanel InicioTab = new JPanel();
		PestañasGeneral.addTab("Inicio", null, InicioTab, null);
		PestañasGeneral.setBackgroundAt(0, Color.WHITE);
		InicioTab.setLayout(null);
		// Fin Inicio
		// Empleados
		JPanel EmpleadosTab = new JPanel();
		PestañasGeneral.addTab("Empleados", null, EmpleadosTab, null);
		EmpleadosTab.setLayout(null);
		
		JTabbedPane PestañasEmple = new JTabbedPane(JTabbedPane.BOTTOM);
		PestañasEmple.setBounds(0, 0, 570, 354);
		EmpleadosTab.add(PestañasEmple);
		
		JPanel DatosTab = new JPanel();
		PestañasEmple.addTab("Datos", null, DatosTab, null);
		DatosTab.setLayout(null);
		
		BusquedaText = new JTextField();
		BusquedaText.setToolTipText("");
		BusquedaText.setBounds(10, 11, 112, 23);
		DatosTab.add(BusquedaText);
		BusquedaText.setColumns(10);
		
		BusquedaBoton = new JButton("");
		BusquedaBoton.setBounds(132, 11, 42, 23);
		DatosTab.add(BusquedaBoton);
		
		JLabel NombreLabel = new JLabel("Nombre:");
		NombreLabel.setBounds(20, 62, 74, 14);
		DatosTab.add(NombreLabel);
		
		JLabel ApellidoLabel = new JLabel("Apellido:");
		ApellidoLabel.setBounds(20, 115, 46, 14);
		DatosTab.add(ApellidoLabel);
		
		JLabel FechaNacLabel = new JLabel("Fecha de nacimiento:");
		FechaNacLabel.setBounds(20, 182, 112, 14);
		DatosTab.add(FechaNacLabel);
		
		JLabel CodRecintoLabel = new JLabel("Codigo recinto:");
		CodRecintoLabel.setBounds(20, 259, 74, 14);
		DatosTab.add(CodRecintoLabel);
		
		JLabel TelfLabel = new JLabel("Telefono:");
		TelfLabel.setBounds(307, 62, 46, 14);
		DatosTab.add(TelfLabel);
		
		JLabel DirLabel = new JLabel("Direcci\u00F3n:");
		DirLabel.setBounds(307, 115, 56, 14);
		DatosTab.add(DirLabel);
		
		JLabel CodOfiLabel = new JLabel("Codigo oficio: ");
		CodOfiLabel.setBounds(307, 182, 68, 14);
		DatosTab.add(CodOfiLabel);
		
		NombreText = new JTextField();
		NombreText.setEditable(false);
		NombreText.setBounds(135, 59, 86, 20);
		DatosTab.add(NombreText);
		NombreText.setColumns(10);
		
		ApellidoText = new JTextField();
		ApellidoText.setEditable(false);
		ApellidoText.setBounds(135, 112, 86, 20);
		DatosTab.add(ApellidoText);
		ApellidoText.setColumns(10);
		
		FechaNacText = new JTextField();
		FechaNacText.setEditable(false);
		FechaNacText.setBounds(135, 179, 86, 20);
		DatosTab.add(FechaNacText);
		FechaNacText.setColumns(10);
		
		CodRecText = new JTextField();
		CodRecText.setEditable(false);
		CodRecText.setBounds(135, 256, 86, 20);
		DatosTab.add(CodRecText);
		CodRecText.setColumns(10);
		
		TlfText = new JTextField();
		TlfText.setEditable(false);
		TlfText.setBounds(410, 59, 86, 20);
		DatosTab.add(TlfText);
		TlfText.setColumns(10);
		
		DirText = new JTextField();
		DirText.setEditable(false);
		DirText.setBounds(410, 112, 86, 20);
		DatosTab.add(DirText);
		DirText.setColumns(10);
		
		CodOfiText = new JTextField();
		CodOfiText.setEditable(false);
		CodOfiText.setBounds(410, 179, 86, 20);
		DatosTab.add(CodOfiText);
		CodOfiText.setColumns(10);
		
		btnGuardarDatos = new JButton("Guardar datos");
		btnGuardarDatos.setBounds(349, 255, 117, 23);
		DatosTab.add(btnGuardarDatos);
		//Fin Empleados
		//Oficios
		JPanel OficiosTab = new JPanel();
		PestañasEmple.addTab("Oficios", null, OficiosTab, null);
		OficiosTab.setLayout(null);
		
		ListaOficios = new JList();
		ListaOficios.setBounds(10, 11, 224, 304);
		OficiosTab.add(ListaOficios);
		
		NewOficioBtn = new JButton("Nuevo oficio");
		NewOficioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		NewOficioBtn.setBounds(324, 44, 110, 36);
		OficiosTab.add(NewOficioBtn);
		
		JLabel CodOficioLabel = new JLabel("Codigo de oficio:");
		CodOficioLabel.setBounds(257, 119, 80, 14);
		OficiosTab.add(CodOficioLabel);
		
		JLabel NombreLabel_1 = new JLabel("Nombre:");
		NombreLabel_1.setBounds(257, 167, 46, 14);
		OficiosTab.add(NombreLabel_1);
		
		JLabel DescLabel = new JLabel("Descripci\u00F3n:");
		DescLabel.setBounds(257, 216, 63, 14);
		OficiosTab.add(DescLabel);
		
		JLabel SueldoLabel = new JLabel("Sueldo:");
		SueldoLabel.setBounds(257, 260, 46, 14);
		OficiosTab.add(SueldoLabel);
		
		CodText = new JTextField();
		CodText.setBounds(363, 116, 86, 20);
		OficiosTab.add(CodText);
		CodText.setColumns(10);
		
		NombreText_1 = new JTextField();
		NombreText_1.setBounds(363, 164, 86, 20);
		OficiosTab.add(NombreText_1);
		NombreText_1.setColumns(10);
		
		DescText = new JTextField();
		DescText.setBounds(363, 213, 86, 20);
		OficiosTab.add(DescText);
		DescText.setColumns(10);
		
		SueldoText = new JTextField();
		SueldoText.setBounds(363, 257, 86, 20);
		OficiosTab.add(SueldoText);
		SueldoText.setColumns(10);
		//Fin Oficios
		
		//Comida
		JPanel ComidaTab = new JPanel();
		PestañasGeneral.addTab("Comida", null, ComidaTab, null);
		ComidaTab.setLayout(null);
		
		ListaComida = new JList();
		ListaComida.setBounds(10, 28, 290, 294);
		ComidaTab.add(ListaComida);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(356, 179, 133, 23);
		ComidaTab.add(btnAadir);
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setBounds(356, 114, 133, 23);
		ComidaTab.add(btnProveedores);
		//Fin Comida
		
		//Animales
		JPanel AnimalesTab = new JPanel();
		PestañasGeneral.addTab("Animales", null, AnimalesTab, null);
		AnimalesTab.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBounds(0, 0, 570, 346);
		AnimalesTab.add(tabbedPane);
		
		JPanel Animales = new JPanel();
		tabbedPane.addTab("Animales", null, Animales, null);
		Animales.setLayout(null);
		
		textBusquedaAnimal = new JTextField();
		textBusquedaAnimal.setBounds(47, 50, 153, 20);
		Animales.add(textBusquedaAnimal);
		textBusquedaAnimal.setColumns(10);
		
		btnBusquedaAnimal = new JButton("");
		btnBusquedaAnimal.setBounds(213, 49, 45, 23);
		Animales.add(btnBusquedaAnimal);
		
		JLabel lblBusquedaDeAnimal = new JLabel("Busqueda de animal");
		lblBusquedaDeAnimal.setBounds(65, 23, 149, 14);
		Animales.add(lblBusquedaDeAnimal);
		
		btnNuevoAnimal = new JButton("Nuevo animal");
		btnNuevoAnimal.setBounds(375, 49, 113, 23);
		Animales.add(btnNuevoAnimal);
		btnNuevoAnimal.addActionListener(this);
		
		ListaAnimal =  new JList();
		ListaAnimal.setBounds(47, 92, 153, 223);
		Animales.add(ListaAnimal);
		
		ListaAnimalDatos = new JList();
		ListaAnimalDatos.setBounds(359, 92, 153, 223);
		Animales.add(ListaAnimalDatos);
		//Fin Animal
		//Fin Recintos
		
		
		//Especies
		JPanel Especies = new JPanel();
		tabbedPane.addTab("Especies", null, Especies, null);
		Especies.setLayout(null);
		
		TextBusquedaEspecie = new JTextField();
		TextBusquedaEspecie.setColumns(10);
		TextBusquedaEspecie.setBounds(40, 53, 153, 20);
		Especies.add(TextBusquedaEspecie);
		
		BusquedaEspecie = new JButton("");
		BusquedaEspecie.setBounds(203, 53, 38, 23);
		Especies.add(BusquedaEspecie);
		
		JLabel label = new JLabel("Busqueda de especie");
		label.setBounds(59, 29, 149, 14);
		Especies.add(label);
		
		BtnNuevaEspecie = new JButton("Nueva especie");
		BtnNuevaEspecie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BtnNuevaEspecie.setBounds(354, 53, 113, 23);
		Especies.add(BtnNuevaEspecie);
		BtnNuevaEspecie.addActionListener(this);
		
		ListaEspecies = new JList();
		ListaEspecies.setBounds(40, 87, 153, 223);
		Especies.add(ListaEspecies);
		
		ListaEspeciesDatos = new JList();
		ListaEspeciesDatos.setBounds(354, 87, 153, 228);
		Especies.add(ListaEspeciesDatos);
		//Fin Especies
		
		//Recintos
		JPanel Recintos = new JPanel();
		tabbedPane.addTab("Recintos", null, Recintos, null);
		Recintos.setLayout(null);
		
		textBusquedaRecintos = new JTextField();
		textBusquedaRecintos.setColumns(10);
		textBusquedaRecintos.setBounds(45, 59, 153, 20);
		Recintos.add(textBusquedaRecintos);
		
		BusquedaRecinto = new JButton("");
		BusquedaRecinto.setBounds(208, 58, 38, 23);
		Recintos.add(BusquedaRecinto);
		
		JLabel label_2 = new JLabel("Busqueda de recintos ");
		label_2.setBounds(61, 34, 149, 14);
		Recintos.add(label_2);
		
		btnNuevoRecinto = new JButton("Nuevo recinto");
		btnNuevoRecinto.addActionListener(this);
		btnNuevoRecinto.setBounds(363, 58, 113, 23);
		Recintos.add(btnNuevoRecinto);
		
		ListaRecintos = new JList();
		ListaRecintos.setBounds(45, 98, 153, 223);
		Recintos.add(ListaRecintos);
		
		ListaRecintosDatos = new JList();
		ListaRecintosDatos.setBounds(363, 98, 153, 228);
		Recintos.add(ListaRecintosDatos);
		
		//Usuarios
		JPanel UsuariosTab = new JPanel();
		PestañasGeneral.addTab("Usuarios", null, UsuariosTab, null);
		UsuariosTab.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(49, 48, 133, 20);
		UsuariosTab.add(textField);
		textField.setColumns(10);
		
		JLabel lblBuscarPorNombre = new JLabel("Buscar por nombre");
		lblBuscarPorNombre.setBounds(49, 23, 98, 14);
		UsuariosTab.add(lblBuscarPorNombre);
		
		BusquedaUsu = new JButton("New button");
		BusquedaUsu.setBounds(180, 47, 40, 23);
		UsuariosTab.add(BusquedaUsu);
		
		textMostrarNombre = new JTextField();
		textMostrarNombre.setEditable(false);
		textMostrarNombre.setBounds(385, 106, 86, 20);
		UsuariosTab.add(textMostrarNombre);
		textMostrarNombre.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(391, 153, 46, 14);
		UsuariosTab.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(385, 178, 86, 20);
		UsuariosTab.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(391, 222, 46, 14);
		UsuariosTab.add(lblClave);
		
		textClave = new JTextField();
		textClave.setBounds(385, 247, 86, 20);
		UsuariosTab.add(textClave);
		textClave.setColumns(10);
		
		btnResetearPasswd = new JButton("Resetear passwd");
		btnResetearPasswd.setBounds(356, 278, 143, 23);
		UsuariosTab.add(btnResetearPasswd);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(382, 312, 89, 23);
		UsuariosTab.add(btnEliminar);
		
		ListaUsuarios = new JList();
		ListaUsuarios.setBounds(49, 108, 166, 216);
		UsuariosTab.add(ListaUsuarios);
		//Fin Usuarios
		
		//Logs
		JPanel LogTab = new JPanel();
		PestañasGeneral.addTab("Logs", null, LogTab, null);
		LogTab.setLayout(null);
		
		JLabel lblRegistroDeCambios = new JLabel("Registro de cambios");
		lblRegistroDeCambios.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeCambios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistroDeCambios.setBounds(183, 66, 161, 24);
		LogTab.add(lblRegistroDeCambios);
		
		TablaLogs = new JTable();
		TablaLogs.setBounds(10, 101, 550, 242);
		LogTab.add(TablaLogs);
		{
			cancelButton = new JButton("Desconectar");
			cancelButton.addActionListener(this);
			cancelButton.setBounds(521, 354, 111, 23);
			getContentPane().add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		//Fin Logs
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBusquedaAnimal) {
			Manager manager = new Manager();

			
				ArrayList<Animal> animales = new ArrayList <Animal>();
				try {
					animales.add(manager.getAnimal(textBusquedaAnimal.getText()));
					
					for(int i=0;i<animales.size();i++) {	
						ListaAnimal.setSelectedIndex(i);
						}
				
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
		if(e.getSource() == BusquedaEspecie) {
			Manager manager = new Manager();
			
			ArrayList <Especie> especies = new ArrayList <Especie>();
			
			try {
					especies.add(manager.getEspecie(TextBusquedaEspecie.getText()));
				
					for(int i=0;i<especies.size();i++) {
						ListaEspecies.setSelectedIndex(i);
					}
				
				} catch (ClassNotFoundException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource() == BusquedaRecinto) {
			Manager manager = new Manager();
			
			ArrayList <Recinto> recintos = new ArrayList <Recinto>();
			
			try {
					recintos.add(manager.getRecinto(textBusquedaRecintos.getText()));
				
					for(int i=0;i<recintos.size();i++) {
						ListaEspecies.setSelectedIndex(i);
					}
				
				} catch (ClassNotFoundException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
				}
		}
		if(e.getSource()==BtnNuevaEspecie) {
			InsertEspecie IntEsp = new InsertEspecie();
			IntEsp.setVisible(true);
		}
		if(e.getSource()==btnNuevoAnimal) {
			InsertAnimal IntAni=null;
			try {
				IntAni = new InsertAnimal();
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			IntAni.setVisible(true);
		}
		if(e.getSource()==btnNuevoRecinto) {
			InsertRecinto IntRec = new InsertRecinto();
			IntRec.setVisible(true);
		}if(e.getSource() == cancelButton ){
			this.dispose();
		}
		
		
		
	}
}
