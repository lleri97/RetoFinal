package proyecto;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import clases.Animal;
import clases.Especie;
import clases.Oficio;
import clases.Recinto;
import clases.Usuario;
import control.Manager;


import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class Inicio extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textBusquedaAnimal;
	private JTextField TextBusquedaEspecie;
	private JTextField textBusquedaRecintos;
	private JTextField TextCodEspe;
	private JTextField textCodAnimal;
	private JTextField textDescAni;
	private JTextField textEstado;
	private JTextField textEdad;
	private JTextField textCodRecin;
	private JTextField textCodComida;
	private JTextField textCodEsp;
	private JTextField textNombreEsp;
	private JTextField textAlimentacion;
	private JTextField textDescripRecin;
	private JComboBox comboBoxRecintos;
	private JTable TablaLogs;
	private JButton BusquedaBoton;
	private JButton btnGuardarDatos;
	private JButton btnAadir;
	private JButton btnProveedores;
	private JButton BusquedaEspeciue;
	private JButton BusquedaRecinto; 
	private JButton button_5;
	private JList ListaOficios; 
	private JList ListaComida;
	private JList ListaAnimal; 
	private JList ListaAnimalDatos;
	private JList ListaEspecies;
	private JList ListaEspeciesDatos;
	private JList ListaRecintos; 
	private JList ListaRecintosDatos; 
	private JList ListaUsuarios; 
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JButton btnClose;
	private JButton btnMin;
	private JButton btnResetearPasswd;
	private JButton btnEliminar;
	private JButton cancelButton; 
//USUARIos
	private JButton BusquedaUsu;
	private JButton btnCambiarContraseña;
	private JButton NuevoUsu;
	private JButton btnEliminarUsu;
	private JTextField textBusqueda;
	private JTextField textMostrarNombre;
	private JTextField textUsuario;
	private JTextField textClave;
//Fin USUARIOS
//ESP	
	private JButton BtnNuevaEspecie;
	private JButton BusquedaEspecie;
	private JButton btnGuardarCambiosEsp;
	private JButton btnEditarEsp;
	private JButton btnEliminarEsp;
//FIN ESP
//ANIMAL
	private JButton btnEditarAnimal;
	private JButton btnBusquedaAnimal;
	private JButton btnNuevoAnimal;
	private JButton btnGuardarCambiosAni;
	private JButton btnEliminarAni;
//FIN ANIMAL
//RECINTOS
	private JButton btnNuevoRecinto;
	private JButton btnEditarRec;
	private JButton btnGuardarCambiosRecin; 
	private JButton btnEliminarRec;
//FIN RECINTOS
//EMPLE	
	private JButton btnNuevoEmp; 
	private JComboBox comboBoxOficios; 
//Fin emple
	
//oficio	
	private JButton btnEditar; 
	private JButton NewOficioBtn; 
//Comida
	private JButton btnGuardarCambios;
	private JButton btnEliminarComida;
	private JButton btnModificarComida;
	private JButton btnAñadirComida;
//Fin oficio
	
	//TODO quitar?
	/*public static void main(String[] args) {
		try {
			Inicio dialog = new Inicio();
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * Create the Frame.
	 */
	public Inicio() {
		setUndecorated(true);
		setBounds(100, 100, 679, 426);
		getContentPane().setLayout(null);
		
		JTabbedPane PestañasGeneral = new JTabbedPane(JTabbedPane.LEFT);
		PestañasGeneral.setBackground(Color.WHITE);
		PestañasGeneral.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		PestañasGeneral.setForeground(Color.BLACK);
		PestañasGeneral.setBounds(0, 33, 642, 359);
		getContentPane().add(PestañasGeneral);
		getContentPane().setBackground(Color.GRAY);
		
		JPanel InicioTab = new JPanel();
		PestañasGeneral.addTab("Inicio", null, InicioTab, null);
		PestañasGeneral.setBackgroundAt(0, Color.WHITE);
		InicioTab.setLayout(null);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\cooltext323822615239491.png"));
		label_1.setBounds(26, 101, 517, 126);
		InicioTab.add(label_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Cheetah-print-white-and-black-animal-skin-fur-texture-and-background-600x381.jpg"));
		lblNewLabel.setBounds(0, 0, 570, 354);
		InicioTab.add(lblNewLabel);
		//---------------------------------------------------------------------
		JPanel EmpleadosTab = new JPanel();
		PestañasGeneral.addTab("Empleados", null, EmpleadosTab, null);
		EmpleadosTab.setLayout(null);
		
		JTabbedPane PestañasEmple = new JTabbedPane(JTabbedPane.BOTTOM);
		PestañasEmple.setBounds(0, 0, 570, 354);
		EmpleadosTab.add(PestañasEmple);
		
		JPanel DatosTab = new JPanel();
		PestañasEmple.addTab("Datos", null, DatosTab, null);
		DatosTab.setLayout(null);
		
		cancelButton = new JButton("Desconectar");
		cancelButton.setBounds(527, 398, 115, 23);
		getContentPane().add(cancelButton);
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(this);
		
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
		btnGuardarDatos.setBounds(274, 255, 117, 23);
		DatosTab.add(btnGuardarDatos);
		
		btnNuevoEmp = new JButton("Nuevo emplado");
		btnNuevoEmp.addActionListener(this);
		btnNuevoEmp.setBounds(410, 255, 131, 23);
		DatosTab.add(btnNuevoEmp);
		//Fin empleados
		//Oficios
		JPanel OficiosTab = new JPanel();
		PestañasEmple.addTab("Oficios", null, OficiosTab, null);
		OficiosTab.setLayout(null);
		
		NewOficioBtn = new JButton("Nuevo oficio");
		NewOficioBtn.addActionListener(this);
		NewOficioBtn.setBounds(445, 279, 110, 36);
		OficiosTab.add(NewOficioBtn);
		
		JLabel CodOficioLabel = new JLabel("Codigo de oficio:");
		CodOficioLabel.setBounds(41, 134, 100, 14);
		OficiosTab.add(CodOficioLabel);
		
		JLabel NombreLabel_1 = new JLabel("Nombre:");
		NombreLabel_1.setBounds(51, 218, 71, 14);
		OficiosTab.add(NombreLabel_1);
		
		JLabel DescLabel = new JLabel("Descripci\u00F3n:");
		DescLabel.setBounds(291, 134, 76, 14);
		OficiosTab.add(DescLabel);
		
		JLabel SueldoLabel = new JLabel("Sueldo:");
		SueldoLabel.setBounds(291, 218, 63, 14);
		OficiosTab.add(SueldoLabel);
		
		CodText = new JTextField();
		CodText.setEditable(false);
		CodText.setBounds(151, 131, 110, 20);
		OficiosTab.add(CodText);
		CodText.setColumns(10);
		
		NombreText_1 = new JTextField();
		NombreText_1.setEditable(false);
		NombreText_1.setBounds(151, 215, 110, 20);
		OficiosTab.add(NombreText_1);
		NombreText_1.setColumns(10);
		
		DescText = new JTextField();
		DescText.setEditable(false);
		DescText.setBounds(366, 131, 166, 20);
		OficiosTab.add(DescText);
		DescText.setColumns(10);
		
		SueldoText = new JTextField();
		SueldoText.setEditable(false);
		SueldoText.setBounds(366, 215, 123, 20);
		OficiosTab.add(SueldoText);
		SueldoText.setColumns(10);
		
		comboBoxOficios = new JComboBox();
		comboBoxOficios.setBounds(41, 77, 169, 20);
		OficiosTab.add(comboBoxOficios);
		
		JLabel lblElijaElOficio = new JLabel("Elija el oficio ");
		lblElijaElOficio.setBounds(51, 55, 159, 14);
		OficiosTab.add(lblElijaElOficio);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(52, 286, 89, 23);
		OficiosTab.add(btnEditar);
		btnEditar.addActionListener(this);
		
		btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setEnabled(false);
		btnGuardarCambios.addActionListener(this);
		btnGuardarCambios.setBounds(151, 286, 89, 23);
		OficiosTab.add(btnGuardarCambios);
		btnGuardarCambios.addActionListener(this);
		try {
			cargarOficios();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Fin oficios
		//--------------------------------------------------------------------------------------------
		
		JPanel ComidaTab = new JPanel();
		PestañasGeneral.addTab("Comida", null, ComidaTab, null);
		ComidaTab.setLayout(null);
		
		ListaComida = new JList();
		ListaComida.setBounds(10, 28, 290, 294);
		ComidaTab.add(ListaComida);
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setBounds(356, 299, 133, 23);
		ComidaTab.add(btnProveedores);
		btnProveedores.addActionListener(this);
		
		btnAñadirComida = new JButton("A\u00F1adir Comida");
		btnAñadirComida.setBounds(356, 68, 133, 23);
		ComidaTab.add(btnAñadirComida);
		btnAñadirComida.addActionListener(this);
		
		btnEliminarComida = new JButton("Eliminar Comida");
		btnEliminarComida.setBounds(356, 129, 133, 23);
		ComidaTab.add(btnEliminarComida);
		btnEliminarComida.addActionListener(this);
		
		btnModificarComida = new JButton("Modificar Comida");
		btnModificarComida.setBounds(356, 98, 133, 23);
		ComidaTab.add(btnModificarComida);
		btnModificarComida.addActionListener(this);
		//---------------------------------------------------------
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
				btnNuevoAnimal.setBounds(442, 281, 113, 23);
				Animales.add(btnNuevoAnimal);
				btnNuevoAnimal.addActionListener(this);
				
				ListaAnimal =  new JList();
				ListaAnimal.setBounds(47, 81, 153, 223);
				Animales.add(ListaAnimal);
				
				JLabel lblCodigoAnimal = new JLabel("Codigo animal:");
				lblCodigoAnimal.setBounds(234, 118, 70, 14);
				Animales.add(lblCodigoAnimal);
				
				JLabel lblCodigoEspecie = new JLabel("Codigo especie:");
				lblCodigoEspecie.setBounds(234, 93, 81, 14);
				Animales.add(lblCodigoEspecie);
				
				JLabel lblDescripcion = new JLabel("Descripcion:");
				lblDescripcion.setBounds(234, 143, 63, 14);
				Animales.add(lblDescripcion);
				
				JLabel lblEstado = new JLabel("Estado:");
				lblEstado.setBounds(234, 168, 37, 14);
				Animales.add(lblEstado);
				
				JLabel lblEdad = new JLabel("Edad:");
				lblEdad.setBounds(234, 193, 37, 14);
				Animales.add(lblEdad);
				
				JLabel lblCodigoRecinto = new JLabel("Codigo recinto:");
				lblCodigoRecinto.setBounds(234, 218, 81, 14);
				Animales.add(lblCodigoRecinto);
				
				JLabel lblCodigoComida = new JLabel("Codigo comida");
				lblCodigoComida.setBounds(234, 243, 70, 14);
				Animales.add(lblCodigoComida);
				
				TextCodEspe = new JTextField();
				TextCodEspe.setEditable(false);
				TextCodEspe.setBounds(346, 90, 139, 20);
				Animales.add(TextCodEspe);
				TextCodEspe.setColumns(10);
				
				textCodAnimal = new JTextField();
				textCodAnimal.setEditable(false);
				textCodAnimal.setBounds(346, 115, 139, 20);
				Animales.add(textCodAnimal);
				textCodAnimal.setColumns(10);
				
				textDescAni = new JTextField();
				textDescAni.setEditable(false);
				textDescAni.setBounds(346, 140, 139, 20);
				Animales.add(textDescAni);
				textDescAni.setColumns(10);
				
				textEstado = new JTextField();
				textEstado.setEditable(false);
				textEstado.setBounds(346, 165, 139, 20);
				Animales.add(textEstado);
				textEstado.setColumns(10);
				
				textEdad = new JTextField();
				textEdad.setEditable(false);
				textEdad.setBounds(346, 190, 139, 20);
				Animales.add(textEdad);
				textEdad.setColumns(10);
				
				textCodRecin = new JTextField();
				textCodRecin.setEditable(false);
				textCodRecin.setBounds(346, 215, 139, 20);
				Animales.add(textCodRecin);
				textCodRecin.setColumns(10);
				
				textCodComida = new JTextField();
				textCodComida.setEditable(false);
				textCodComida.setBounds(346, 240, 139, 20);
				Animales.add(textCodComida);
				textCodComida.setColumns(10);
				
				btnEditarAnimal = new JButton("Editar");
				btnEditarAnimal.addActionListener(this);
				
				btnEditarAnimal.setBounds(355, 19, 89, 23);
				Animales.add(btnEditarAnimal);
				
				btnGuardarCambiosAni = new JButton("Guardar cambios");
				btnGuardarCambiosAni.setEnabled(false);
				btnGuardarCambiosAni.setBounds(406, 49, 113, 23);
				Animales.add(btnGuardarCambiosAni);
				
				btnEliminarAni = new JButton("Eliminar");
				btnEliminarAni.setEnabled(false);
				btnEliminarAni.setBounds(295, 49, 89, 23);
				Animales.add(btnEliminarAni);
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
				BtnNuevaEspecie.addActionListener(this);
				BtnNuevaEspecie.setBounds(425, 284, 113, 23);
				Especies.add(BtnNuevaEspecie);
				BtnNuevaEspecie.addActionListener(this);
				
				ListaEspecies = new JList();
				ListaEspecies.setBounds(40, 87, 153, 223);
				Especies.add(ListaEspecies);
				
				JLabel lblNewLabel = new JLabel("Codigo especie:");
				lblNewLabel.setBounds(219, 111, 81, 14);
				Especies.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Nombre especie:");
				lblNewLabel_1.setBounds(219, 161, 81, 14);
				Especies.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Alimentacion:");
				lblNewLabel_2.setBounds(219, 211, 65, 14);
				Especies.add(lblNewLabel_2);
				
				textCodEsp = new JTextField();
				textCodEsp.setEditable(false);
				textCodEsp.setBounds(322, 108, 153, 20);
				Especies.add(textCodEsp);
				textCodEsp.setColumns(10);
				
				textNombreEsp = new JTextField();
				textNombreEsp.setEditable(false);
				textNombreEsp.setBounds(322, 158, 153, 20);
				Especies.add(textNombreEsp);
				textNombreEsp.setColumns(10);
				
				textAlimentacion = new JTextField();
				textAlimentacion.setEditable(false);
				textAlimentacion.setBounds(322, 208, 153, 20);
				Especies.add(textAlimentacion);
				textAlimentacion.setColumns(10);
				
				btnEditarEsp = new JButton("Editar");
				btnEditarEsp.setBounds(338, 25, 89, 23);
				Especies.add(btnEditarEsp);
				
				btnGuardarCambiosEsp = new JButton("Guardar cambios");
				btnGuardarCambiosEsp.setEnabled(false);
				btnGuardarCambiosEsp.setBounds(393, 52, 126, 23);
				Especies.add(btnGuardarCambiosEsp);
				
				btnEliminarEsp = new JButton("Eliminar");
				btnEliminarEsp.setEnabled(false);
				btnEliminarEsp.setBounds(271, 52, 89, 23);
				Especies.add(btnEliminarEsp);
				//Fin Especies
				
				//Recintos
				JPanel Recintos = new JPanel();
				tabbedPane.addTab("Recintos", null, Recintos, null);
				Recintos.setLayout(null);
				
				JLabel label_2 = new JLabel("Busqueda de recintos ");
				label_2.setBounds(46, 34, 149, 14);
				Recintos.add(label_2);
				
				btnNuevoRecinto = new JButton("Nuevo recinto");
				btnNuevoRecinto.addActionListener(this);
				btnNuevoRecinto.setBounds(442, 284, 113, 23);
				Recintos.add(btnNuevoRecinto);
				
				JLabel lblNewLabel_3 = new JLabel("Descripcion: ");
				lblNewLabel_3.setBounds(235, 139, 78, 14);
				Recintos.add(lblNewLabel_3);
				
				textDescripRecin = new JTextField();
				textDescripRecin.setEditable(false);
				textDescripRecin.setBounds(235, 164, 296, 109);
				Recintos.add(textDescripRecin);
				textDescripRecin.setColumns(10);
				
				btnEditarRec = new JButton("Editar");
				btnEditarRec.setBounds(235, 58, 89, 23);
				Recintos.add(btnEditarRec);
				
				btnGuardarCambiosRecin = new JButton("Guardar cambios");
				btnGuardarCambiosRecin.setEnabled(false);
				btnGuardarCambiosRecin.setBounds(437, 58, 118, 23);
				Recintos.add(btnGuardarCambiosRecin);
				
				btnEliminarRec = new JButton("Eliminar");
				btnEliminarRec.setEnabled(false);
				btnEliminarRec.addActionListener(this);
				btnEliminarRec.setBounds(338, 58, 89, 23);
				Recintos.add(btnEliminarRec);
				
				comboBoxRecintos = new JComboBox();
				comboBoxRecintos.setBounds(30, 59, 149, 20);
				Recintos.add(comboBoxRecintos);		
//-------------------------------------------------------------
//USUARIOS
				JPanel UsuariosTab = new JPanel();
				PestañasGeneral.addTab("Usuarios", null, UsuariosTab, null);
				UsuariosTab.setLayout(null);
				
				textBusqueda = new JTextField();
				textBusqueda.setBounds(49, 48, 133, 20);
				UsuariosTab.add(textBusqueda);
				textBusqueda.setColumns(10);
				
				JLabel lblBuscarPorNombre = new JLabel("Buscar por nombre");
				lblBuscarPorNombre.setBounds(49, 23, 98, 14);
				UsuariosTab.add(lblBuscarPorNombre);
				
				BusquedaUsu = new JButton("New button");
				BusquedaUsu.addActionListener(this);
				BusquedaUsu.setBounds(180, 47, 40, 23);
				UsuariosTab.add(BusquedaUsu);
				
				textMostrarNombre = new JTextField();
				textMostrarNombre.setEditable(false);
				textMostrarNombre.setBounds(385, 76, 86, 20);
				UsuariosTab.add(textMostrarNombre);
				textMostrarNombre.setColumns(10);
				
				JLabel lblUsuario = new JLabel("Usuario");
				lblUsuario.setBounds(391, 107, 46, 14);
				UsuariosTab.add(lblUsuario);
				
				textUsuario = new JTextField();
				textUsuario.setBounds(385, 132, 86, 20);
				UsuariosTab.add(textUsuario);
				textUsuario.setColumns(10);
				
				JLabel lblClave = new JLabel("Clave");
				lblClave.setBounds(391, 169, 46, 14);
				UsuariosTab.add(lblClave);
				
				textClave = new JTextField();
				textClave.setBounds(385, 194, 86, 20);
				UsuariosTab.add(textClave);
				textClave.setColumns(10);
				
				btnCambiarContraseña = new JButton("Cambiar contrase\u00F1a");
				btnCambiarContraseña.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnCambiarContraseña.setBounds(357, 225, 143, 23);
				UsuariosTab.add(btnCambiarContraseña);
				
				btnEliminarUsu = new JButton("Eliminar");
				btnEliminarUsu.addActionListener(this);
				btnEliminarUsu.setBounds(385, 301, 89, 23);
				UsuariosTab.add(btnEliminarUsu);
				
				ListaUsuarios = new JList();
				ListaUsuarios.setBounds(49, 108, 166, 216);
				UsuariosTab.add(ListaUsuarios);
				
				NuevoUsu = new JButton("Anadir usuario");
				NuevoUsu.addActionListener(this);
				NuevoUsu.setBounds(367, 259, 115, 23);
				UsuariosTab.add(NuevoUsu);

//-------------------------------------------------------------------------------------------------
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
		
		btnClose = new JButton("");
		btnClose.setBounds(617, 5, 25, 25);
		getContentPane().add(btnClose);
		btnClose.setIcon(new ImageIcon(Login.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		btnClose.setActionCommand("");
		btnClose.addActionListener(this);
		
		btnMin = new JButton("");
		btnMin.setBounds(584, 5, 25, 25);
		getContentPane().add(btnMin);
		btnMin.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/web/skin/DrawHorizontalLine_16x16_JFX.png")));
		btnMin.setActionCommand("");
		btnMin.addActionListener(this);
		
		JLabel lblNUser = new JLabel("");
		lblNUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblNUser.setBackground(new Color(139, 69, 19));
		lblNUser.setForeground(new Color(238, 232, 170));
		lblNUser.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNUser.setBounds(404, 396, 113, 22);
		getContentPane().add(lblNUser);
		
		JLabel lblLogeado = new JLabel("Logeado c\u00F3mo:");
		lblLogeado.setForeground(new Color(238, 232, 170));
		lblLogeado.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLogeado.setBounds(248, 396, 146, 22);
		getContentPane().add(lblLogeado);
		
		
		
		JLabel lblImgFondo = new JLabel("");
		lblImgFondo.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\33cbabd9393782e76901358102f1f8a6.jpg"));
		lblImgFondo.setBounds(0, 0, 679, 426);
		getContentPane().add(lblImgFondo);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cancelButton)) {
			Login log = new Login();
			this.dispose();
			log.setVisible(true);
		}
		if (e.getSource().equals(btnMin)) {
			this.setState(Frame.ICONIFIED);
		}
		if (e.getSource().equals(btnClose)) {
			this.dispose();
		}
		if (e.getSource().equals(btnProveedores)) {
			ProveedorVentana vProv= new ProveedorVentana(true);
			vProv.setVisible(true);
		}
		if (e.getSource().equals(btnAñadirComida)) {
			AñadirComidaVentana vCom=new AñadirComidaVentana(true);
			vCom.setVisible(true);
		}
		if (e.getSource().equals(btnModificarComida)) {
			ModificarComidaVentana vCom=new ModificarComidaVentana(true);
			vCom.setVisible(true);
		}
		if (e.getSource().equals(btnEliminarComida)) {
			EliminarComidaVentana vCom=new EliminarComidaVentana(true);
			vCom.setVisible(true);
		}
//-------------------------------------------------------------------------------------------------------------------------------
//Gaizka
		if(e.getSource() == btnBusquedaAnimal) {
			Manager manager = new Manager();

			
				ArrayList<Animal> animales = new ArrayList <Animal>();
				DefaultListModel lista = new DefaultListModel<>();
				try {
					animales.add(manager.getAnimal(textBusquedaAnimal.getText()));
					
					for(int i=0;i<animales.size();i++) {	
						lista.addElement(i);
						}
				
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			ListaAnimal.setModel(lista);
		}
		if(e.getSource() == BusquedaEspecie) {
			Manager manager = new Manager();
			DefaultListModel lista = new DefaultListModel<>();
			ArrayList <Especie> especies = new ArrayList <Especie>();
			try {
				Especie ej=manager.getEspecie(TextBusquedaEspecie.getText());
				especies.add(manager.getEspecie(TextBusquedaEspecie.getText()));
				
				for(int i=0;i<especies.size();i++) {
					lista.addElement(i);
				}
				ListaEspecies.setModel(lista);
			}
			 catch (ClassNotFoundException | IOException | SQLException e1) {
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
				IntAni = new InsertAnimal(true);
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			IntAni.setVisible(true);
		}
		if(e.getSource()==btnNuevoRecinto) {
			InsertRecinto IntRec = new InsertRecinto(true);
			IntRec.setVisible(true);
		}if(e.getSource()==btnEditarAnimal) {
			btnGuardarCambiosAni.setEnabled(true);
			btnEliminarAni.setEnabled(true);
			if(e.getSource()==btnGuardarCambiosAni) {
				Manager manager= new Manager();
				
			}
			if(e.getSource()==btnEliminarAni) {
				Manager manager= new Manager();
				try {
					manager.EliminarAni(textBusquedaAnimal.getText());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}if(e.getSource()==btnEditarEsp) {
			btnGuardarCambiosEsp.setEnabled(true);
			btnEliminarEsp.setEnabled(true);
			if(e.getSource()==btnEliminarEsp) {
				Manager manager=new Manager();
				try {
					manager.EliminarEsp(TextBusquedaEspecie.getText());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}if(e.getSource()==btnEditarRec) {
			btnEliminarRec.setEnabled(true);
			btnGuardarCambiosRecin.setEnabled(true);
			if(e.getSource()==btnEliminarRec) {
				Manager manager=new Manager();
				try {
					manager.EliminarRec(TextBusquedaEspecie.getText());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}if(e.getSource() == cancelButton ){
			this.dispose();
		
		}
		
//---------------------------------------------------------------------------------------------------------------------------
//Andoni		
		if(e.getSource().equals(NewOficioBtn)) {	//nuevo oficio
			NuevoOficio nuevo = new NuevoOficio(true);
			nuevo.setVisible(true);
		}
		if(e.getSource().equals(btnNuevoEmp)) {		//nuevo empleado
			NuevoEmpleado newEmp = new NuevoEmpleado(true);
			newEmp.setVisible(true);
		}
		if(e.getSource().equals(btnEditar)) {		//editar oficio
			try {
				editarOficio();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
//------------------------------------------------------------------------------------------------------------------------------
//Yeray
		if(e.getSource()==NuevoUsu) {
			InsertUsuario InsUsu =new InsertUsuario(true);
			InsUsu.setVisible(true);
		}
		
		if(e.getSource()==btnEliminarUsu) {
			Manager manager =new Manager();
			Usuario usu=new Usuario();
			usu.setNomUser(textUsuario.getText());
			usu.setPassUser(textClave.getText());
			
			try {
				manager.EliminarUsuario(usu);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
//------------------------------------------------------------------------------------------------------------------------------			
	
	}

	private void guardarCambioOficio() throws IOException, ClassNotFoundException, SQLException {
		Manager manager = new Manager();
		Oficio ofi = new Oficio();
		ofi.setCodOfi(CodText.getText());
		ofi.setNombre(NombreText_1.getText());
		ofi.setDesc(DescText.getText());
		ofi.setSueldo(Float.parseFloat(SueldoText.getText()));
		manager.guardarCambioOficio(ofi);
		
	}

	private void editarOficio() throws Exception {		//editar oficio
		boolean esta;
		String auxOfi = null;
		esta=false;
		if(comboBoxOficios.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Seleccione un oficio");
			esta=false;
		}else {
			auxOfi = (String) comboBoxOficios.getSelectedItem();
			esta=true;
			CodText.setEditable(true);
			DescText.setEditable(true);
			SueldoText.setEditable(true);
			NombreText_1.setEditable(true);
			btnGuardarCambios.setEnabled(true);
			//cargarOficios();
		}
		if(esta==true) {
			Oficio ofi = new Oficio();
			getDatosOficio(auxOfi);
		}
		
		
	}
	private void getDatosOficio(String auxOfi) throws Exception {//Datos Oficio
		Manager manager = new Manager();
		Oficio ofi = manager.getDatosOficio(auxOfi);
		CodText.setText(ofi.getCodOfi());
		DescText.setText(ofi.getDesc());
		SueldoText.setText(String.valueOf(ofi.getSueldo()));
		NombreText_1.setText(ofi.getNombre());
	}	
	private void cargarOficios() throws ClassNotFoundException, IOException, SQLException {		//cargar oficios

		Manager manager = new Manager();
		
		
		ArrayList <String> ofi = manager.getNombreOficios();
		for(int i=0;i<ofi.size();i++) {
			comboBoxOficios.addItem(ofi.get(i));
		}
		comboBoxOficios.setSelectedIndex(-1);
		
	}
//----------------------------------------------------------------------------------------------------------------------------
	
}