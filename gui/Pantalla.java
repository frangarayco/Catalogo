package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BaseDatos.Bd;
import tpfinal.Catalogo;


public class Pantalla extends JFrame{
	
	

	private String [] desplegableMostrar = {"Elegir forma de muestra","Mostrar general", "Mostrar Cds", "Mostrar Dvds", "Mostrar disponibles", "Mostrar por Id"};
	private String [] desplegableOp = {"Elegir", "Verdadero", "Falso"};
	
	private JPanel contentPane = new JPanel();
	private JPanel panel1 = new JPanel();
	private JLabel texto2 = new JLabel("Agregar al catalogo");
	private JLabel titulo1 = new JLabel("Titulo");
	private JTextField txtTitulo1 = new JTextField();
	private JLabel genero1 = new JLabel("Genero");
	private JTextField txtGenero1 = new JTextField();
	private JLabel duracion1 = new JLabel("Duracion");
	private JTextField txtDuracion1 = new JTextField();
	private JLabel disponible1 = new JLabel("Disponible");
	private JLabel comentario1 = new JLabel("Comentario");
	private JTextField txtComentario1 = new JTextField();
	private JLabel id1 = new JLabel("Id");
	private JTextField txtId1 = new JTextField();
	private JLabel cantTemas1 = new JLabel("Cantidad de temas");
	private JTextField txtCantTemas1 = new JTextField();;
	private JButton btnAgregar1 = new JButton("Agregar");
	private JPanel panel2 = new JPanel();
	private JLabel texto4 = new JLabel("Mostrar el catalogo");
	private JLabel titulo2 = new JLabel("Titulo:");
	private JTextField txtEliminar = new JTextField();
	private JButton btnEliminar = new JButton("Eliminar");
	private JPanel panel3 = new JPanel();
	private JLabel texto3 = new JLabel("Eliminar del catalogo");
	private JComboBox comboBox2 = new JComboBox(desplegableMostrar);
	private JButton btnMostrar = new JButton("Mostrar");
	private JRadioButton rdbtnCd1 = new JRadioButton("Cds",false);
	private JRadioButton rdbtnDvds1 = new JRadioButton("Dvds",true);
	private JRadioButton rdbtnCd2 = new JRadioButton("Cds",false);
	private JRadioButton rdbtnDvds2 = new JRadioButton("Dvds",true);
	private JTextArea txtMostrar = new JTextArea();
	private ButtonGroup grupo1 = new ButtonGroup();
	private ButtonGroup grupo2 = new ButtonGroup();
	private JComboBox comboBox4 = new JComboBox(desplegableOp);
	private JButton btnLimpiar = new JButton("Limpiar");
	private JButton btnLimpiarCampos = new JButton("Limpiar campos");
	private Bd bd = new Bd();
	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null; 
	private PreparedStatement ps = null; 
	
	private void iniciarPanel() {
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panel1.setBounds(0, 0, 1199, 130);
		panel1.setLayout(null);
		
		panel2.setBounds(0, 128, 1199, 104);
		panel2.setLayout(null);
		
		panel3.setBounds(0, 230, 1199, 508);
		panel3.setLayout(null);
		
	}
	
	private void iniciarLabel(){
		
		texto2.setBounds(19, 22, 116, 14);
		panel1.add(texto2);
		
		titulo1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		titulo1.setBounds(162, 49, 34, 22);
		panel1.add(titulo1);
		
		genero1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		genero1.setBounds(251, 49, 41, 22);
		panel1.add(genero1);
		
		duracion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		duracion1.setBounds(347, 49, 63, 22);
		panel1.add(duracion1);
		
		disponible1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		disponible1.setBounds(444, 49, 63, 22);
		panel1.add(disponible1);
		
		comentario1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comentario1.setBounds(528, 49, 72, 22);
		panel1.add(comentario1);
		
		id1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		id1.setBounds(651, 49, 20, 22);
		panel1.add(id1);
		
		cantTemas1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cantTemas1.setBounds(715, 49, 116, 22);
		panel1.add(cantTemas1);
		
		titulo2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		titulo2.setBounds(223, 62, 56, 22);
		panel2.add(titulo2);
		
		texto3.setBounds(11, 11, 170, 14);
		panel2.add(texto3);
		
		
		texto4.setBounds(10, 31, 159, 14);
		panel3.add(texto4);
	}
	
	private void iniciarComboBox() {
		
		comboBox2.setBounds(321, 27, 165, 22);
		panel3.add(comboBox2);
		
		comboBox4.setBounds(426, 71, 90, 21);
		panel1.add(comboBox4);
		
	}
	
	private void iniciarRadioBtn() {

		rdbtnCd1.setBounds(19, 55, 109, 23);
		panel1.add(rdbtnCd1);
		
		rdbtnDvds1.setBounds(20, 81, 109, 23);
		panel1.add(rdbtnDvds1);
		grupo1.add(rdbtnCd1);
		grupo1.add(rdbtnDvds1);
		
		rdbtnCd2.setBounds(10, 48, 109, 23);
		panel2.add(rdbtnCd2);
	
		rdbtnDvds2.setBounds(11, 74, 109, 23);
		panel2.add(rdbtnDvds2);
		grupo2.add(rdbtnCd2);
		grupo2.add(rdbtnDvds2);
		
	}
	
	private void iniciarTextField() {
		txtTitulo1.setBounds(134, 72, 86, 20);
		panel1.add(txtTitulo1);
		txtTitulo1.setColumns(10);
		
		txtGenero1.setColumns(10);
		txtGenero1.setBounds(230, 72, 86, 20);
		panel1.add(txtGenero1);
		
		txtDuracion1.setColumns(10);
		txtDuracion1.setBounds(330, 72, 86, 20);
		panel1.add(txtDuracion1);
		
		txtComentario1.setColumns(10);
		txtComentario1.setBounds(522, 72, 86, 20);
		panel1.add(txtComentario1);

		txtId1.setColumns(10);
		txtId1.setBounds(619, 72, 86, 20);
		panel1.add(txtId1);
		
		txtCantTemas1.setColumns(10);
		txtCantTemas1.setBounds(715, 72, 86, 20);
		txtCantTemas1.setEditable(false);
		txtCantTemas1.setEnabled(false);
		panel1.add(txtCantTemas1);
		
		txtEliminar.setColumns(10);
		txtEliminar.setBounds(269, 64, 177, 20);
		panel2.add(txtEliminar);
		
	}
	
	private void iniciarBtn() {
		
		
		btnAgregar1.setBounds(838, 89, 103, 30);
		panel1.add(btnAgregar1);
		
		
		btnLimpiarCampos.setBounds(973, 89, 126, 30);
		panel1.add(btnLimpiarCampos);
		
		btnEliminar.setBounds(551, 63, 103, 23);
		panel2.add(btnEliminar);

		btnMostrar.setBounds(675, 27, 103, 23);
		panel3.add(btnMostrar);

		btnLimpiar.setBounds(959, 27, 103, 23);
		panel3.add(btnLimpiar);

	}
	
	private void iniciarAreatext() {
		txtMostrar.setText("TITULO: \t\t\tGENERO: \t\tCANTIDAD DE TEMAS: \t\tPRODUCTO: \t\t  ID: \n");
		txtMostrar.setEditable(false);
		
		txtMostrar.setBounds(10, 56, 1179, 300);
		panel3.add(txtMostrar);

	}

	
	private void iniciarComponentes(){
		iniciarPanel();
		iniciarLabel();
		iniciarComboBox();
		iniciarRadioBtn();
		iniciarTextField();
		iniciarBtn();
		iniciarAreatext();

	}

	

	public Pantalla(Catalogo cata) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1225, 649);
		setTitle("Sistema de catalogos");
		getContentPane().setLayout(null);
		getContentPane().add(panel1);
		getContentPane().add(panel2);
		getContentPane().add(panel3);
		iniciarComponentes();
		
		btnLimpiarCampos.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtTitulo1.setText("");
				txtGenero1.setText("");
				txtDuracion1.setText("");
				txtComentario1.setText("");
				txtId1.setText("");
				txtCantTemas1.setText("");
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMostrar.setText("TITULO: \t\t\tGENERO: \t\tCANTIDAD DE TEMAS: \t\tPRODUCTO: \t\t  ID: \n");
			}			
		});
		
		
		comboBox4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opcion = comboBox4.getSelectedItem().toString();
				if(opcion.equals("Elegir")) {
					JOptionPane.showMessageDialog(contentPane, "Error debe elegir una opcion", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		comboBox2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opcion =comboBox2.getSelectedItem().toString();
				if(opcion.equals("Elegir un catalogo")) {
					JOptionPane.showMessageDialog(contentPane, "Error debe elegir una forma de muestra", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		btnMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipo;
				String opcion =comboBox2.getSelectedItem().toString();
				
				if (opcion == "Elegir forma de muestra") {
					JOptionPane.showMessageDialog(contentPane, "Error debe elegir una forma de muestra", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
				}else {
					if(opcion == "Mostrar general") {
						cata.mostrar(txtMostrar);
						}else {
							if(opcion == "Mostrar Cds") {
								cata.mostrarCd(txtMostrar);
							}else {
								if(opcion == "Mostrar Dvds") {
									cata.mostrarDVd(txtMostrar);
								}else {
									if(opcion == "Mostrar disponibles") {
										cata.mostrarDisponibles(txtMostrar);
									}else {
										if(opcion == "Mostrar por Id") {
											String nombre = JOptionPane.showInputDialog("Ingrese el nombre del artista que desea busacr");
											cata.mostrarId(nombre,txtMostrar);
								}
							}
						}
					}
				}
			}
		}	
	});
		rdbtnCd1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCantTemas1.setEditable(true);
				txtCantTemas1.setEnabled(true);
			}
		});

		
		rdbtnDvds1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCantTemas1.setEditable(false);
				txtCantTemas1.setEnabled(false);
			}
		});
		
		btnAgregar1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i = 0;
				int rta;
				String x;
				String titulo;
				String genero;
				String disponible;
				String comentario;
				int duracion;
				String id;
				int cantTemas;
				int produ; 
				String opcion2 = comboBox4.getSelectedItem().toString();
				if(rdbtnCd1.isSelected()==true) {
					titulo = txtTitulo1.getText();
					genero = txtGenero1.getText();
					comentario = txtComentario1.getText();
					if(opcion2.equals("Verdadero")) {
						disponible = "Verdadero";
					}else {
						disponible = "Falso"; 
					}
					duracion = Integer.parseInt(txtDuracion1.getText());
					id = txtId1.getText();
					cantTemas = Integer.parseInt(txtCantTemas1.getText());
					produ = 1;
					if(opcion2.equals("Elegir")) {
						JOptionPane.showMessageDialog(contentPane, "Se debe elegir una opcion", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
					}else {
						if (!verificarTitulo(titulo)) {
							cata.agregar(titulo,genero,duracion,disponible,comentario,id,cantTemas,produ);
							JOptionPane.showMessageDialog(contentPane, "Se agrego correctamente", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
						}else {
							rta = JOptionPane.showConfirmDialog(contentPane, "El titulo ya existe¿Desea cambiar el titulo?", "Mensaje de aviso", JOptionPane.YES_NO_OPTION);
							if(rta == JOptionPane.YES_OPTION) {
								String titulo2 = JOptionPane.showInputDialog("Ingrese el neuvo titulo");
								cata.agregar(titulo2,genero,duracion,disponible,comentario,id,cantTemas,produ);
								JOptionPane.showMessageDialog(contentPane, "Se agrego correctamente", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
							}else {
								if(rta == JOptionPane.NO_OPTION) {
									cata.agregar(titulo+1,genero,duracion,disponible,comentario,id,cantTemas,produ);
									JOptionPane.showMessageDialog(contentPane, "Se agrego correctamente", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					}
				}else {
					titulo = txtTitulo1.getText();
					genero = txtGenero1.getText();
					comentario = txtComentario1.getText();
					if(opcion2.equals("Verdadero")) {
						disponible = "Verdadero";
					}else {
						disponible = "Falso"; 
					}
					duracion = Integer.parseInt(txtDuracion1.getText());
					txtCantTemas1.setEditable(false);
					id = txtId1.getText();
					cantTemas = 0; 
					produ = 0;
					if(opcion2.equals("Elegir")) {
						JOptionPane.showMessageDialog(contentPane, "Se debe elegir una opcion", "Mensaje de confirmacion", JOptionPane.ERROR_MESSAGE);
					}else {
						if (!verificarTitulo(titulo)) {
							cata.agregar(titulo,genero,duracion,disponible,comentario,id,cantTemas,produ);
							JOptionPane.showMessageDialog(contentPane, "Se agrego correctamente", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
						}else {
							rta = JOptionPane.showConfirmDialog(contentPane, "El titulo ya existe¿Desea cambiar el titulo?", "Mensaje de aviso", JOptionPane.YES_NO_OPTION);
							if(rta == JOptionPane.YES_OPTION) {
								String titulo2 = JOptionPane.showInputDialog("Ingrese el neuvo titulo");
								cata.agregar(titulo2,genero,duracion,disponible,comentario,id,cantTemas,produ);
							}else {
								if(rta == JOptionPane.NO_OPTION) {
									cata.agregar(titulo+1,genero,duracion,disponible,comentario,id,cantTemas,produ);
									JOptionPane.showMessageDialog(contentPane, "Se agrego correctamente", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				}
			}
		}
	});
		
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtEliminar.getText();
				if(verificarTitulo(nombre)) {
					cata.eliminar(nombre);
					JOptionPane.showMessageDialog(contentPane, "Se elimino correctamente", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(contentPane, "No se encontro, nombre incorrecto", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
				}
					
			}
		});
		
		txtCantTemas1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnDvds1.isSelected()) {
					JOptionPane.showMessageDialog(contentPane, "Error en DVD no se puede agregar cantidad de temas", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(contentPane, "Debe ingresar unicamente numero", "Mensaje de informacion", JOptionPane.INFORMATION_MESSAGE);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {	}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}	
		});
	
		txtDuracion1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDuracion1.setText("");
				JOptionPane.showMessageDialog(contentPane,"Debe ingresar numero unicamente", "Mensaje de informacion", JOptionPane.INFORMATION_MESSAGE);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {	}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}	
		});

		txtCantTemas1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
		
		txtDuracion1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
	
	}

	private boolean verificarTitulo(String titulo) {
		boolean esta = false;
		
		try {
			con = bd.conectar();
			ps = con.prepareStatement("SELECT * FROM `discos` WHERE titulo = ?");
			ps.setString(1, titulo);
			rs = ps.executeQuery();
			if(rs.next()) {
				esta = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return esta;
	}
}

