package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Empleado;
import control.Manager;



import javax.swing.JButton;

public class NuevoEmpleado extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTLF;
	private JTextField textDir;
	private JTextField textCodOfi;
	private JTextField textFech;
	private JTextField textCodRec;
	private JButton btnAadir;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoEmpleado dialog = new NuevoEmpleado(true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public NuevoEmpleado(boolean modal) {
		setTitle("A\u00F1adir empleado");
		setBounds(100, 100, 532, 329);
		getContentPane().setLayout(null);
		
		this.setModal(modal);
		
		JLabel label = new JLabel("Nombre:");
		label.setBounds(28, 26, 74, 14);
		getContentPane().add(label);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(155, 23, 86, 20);
		getContentPane().add(textNombre);
		
		JLabel label_1 = new JLabel("Apellido:");
		label_1.setBounds(28, 79, 74, 14);
		getContentPane().add(label_1);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(155, 76, 86, 20);
		getContentPane().add(textApellido);
		
		JLabel label_2 = new JLabel("Telefono:");
		label_2.setBounds(287, 26, 93, 14);
		getContentPane().add(label_2);
		
		textTLF = new JTextField();
		textTLF.setColumns(10);
		textTLF.setBounds(390, 23, 86, 20);
		getContentPane().add(textTLF);
		
		JLabel label_3 = new JLabel("Direcci\u00F3n:");
		label_3.setBounds(287, 79, 93, 14);
		getContentPane().add(label_3);
		
		textDir = new JTextField();
		textDir.setColumns(10);
		textDir.setBounds(390, 76, 86, 20);
		getContentPane().add(textDir);
		
		JLabel label_4 = new JLabel("Codigo oficio: ");
		label_4.setBounds(278, 128, 102, 14);
		getContentPane().add(label_4);
		
		textCodOfi = new JTextField();
		textCodOfi.setColumns(10);
		textCodOfi.setBounds(390, 125, 86, 20);
		getContentPane().add(textCodOfi);
		
		JLabel label_5 = new JLabel("Fecha de nacimiento:");
		label_5.setBounds(28, 128, 139, 14);
		getContentPane().add(label_5);
		
		textFech = new JTextField();
		textFech.setColumns(10);
		textFech.setBounds(155, 125, 86, 20);
		getContentPane().add(textFech);
		
		JLabel label_6 = new JLabel("Codigo recinto:");
		label_6.setBounds(28, 174, 102, 14);
		getContentPane().add(label_6);
		
		textCodRec = new JTextField();
		textCodRec.setColumns(10);
		textCodRec.setBounds(155, 171, 86, 20);
		getContentPane().add(textCodRec);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(155, 229, 89, 23);
		getContentPane().add(btnAadir);
		btnAadir.addActionListener(this);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(275, 229, 89, 23);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAadir)) {
			try {
				anadirEmpleado();
				
			} catch (ClassNotFoundException | SQLException | IOException e1) {
			
				e1.printStackTrace();
			}
		}if(e.getSource().equals(btnVolver)) {
			volverEmple();
		}

		
	}
	public void anadirEmpleado() throws ClassNotFoundException, SQLException, IOException {
		boolean error=false;
		String fechaAux=null;
		LocalDate fechaNac=null;
		
		Manager manager = new Manager();
		
		Empleado emp = new Empleado();
		
		emp.setNombre(textNombre.getText());
		emp.setApellido(textApellido.getText());
		DateTimeFormatter formateador=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		do{
		  error=false;
		  fechaAux=textFech.getText();
		  try{		
		   	fechaNac=LocalDate.parse(fechaAux, formateador);
		  } catch(DateTimeParseException e){
		   	error=true;  
			System.out.println("Error,Introduce fecha con formato dd/mm/aaaa: ");
		  }
		}while (error);
		
		
		emp.setFechanac(fechaNac);
		emp.setDir(textDir.getText());
		emp.setTlf(textTLF.getText());
		emp.setCodOfi(textCodOfi.getText());
		emp.setCodRec(textCodRec.getText());
		manager.AñadirEmpleado(emp);
	}
	private void volverEmple() {
		this.dispose();
		
	}



}
