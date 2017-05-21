package test.Menu;

import grafica.ventanas.Modulo1.ventanaAbmFamilia;
import grafica.ventanas.Modulo1.ventanaAbmProveedor;
import grafica.ventanas.Modulo1.ventanaCrearFamilia;
import grafica.ventanas.Modulo1.ventanaCrearProducto;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import logica.Config;
import logica.excepciones.MessageError;


public class VentanaPrincipal extends JFrame{

	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu2 = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenu jMenu3 = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem3 = null;
	private VentanaPrincipalController controller = null;
	private JMenuItem jMenuItem4 = null;
	public VentanaPrincipal(){
		super();
		controller = new VentanaPrincipalController();
		initialize();
	}
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private void initialize() {
		setSize(new java.awt.Dimension(247,258));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Certament Mascotas");
		setJMenuBar(getJJMenuBar());
		setContentPane(getJContentPane());
		setLocation(new java.awt.Point(400,200));
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			try {
				JLabel jLabel;
				jLabel = new JLabel(new ImageIcon(getClass().getResource(Config.getInstance().getProperty("background"))));
				jLabel.setBounds(new java.awt.Rectangle(0,0,238,208));
				jContentPane.add(jLabel, null);
			} catch (Exception e) {
			}
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu2());
			jJMenuBar.add(getJMenu3());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu2	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText("Dueños");
			jMenu2.add(getJMenuItem4());
			jMenu2.add(getJMenuItem1());
			jMenu2.add(getJMenuItem2());
		}
		return jMenu2;
	}

	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaCrearProducto vListarRepuesto; 
					try {
						vListarRepuesto= new ventanaCrearProducto();
						vListarRepuesto.setVisible(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getContentPane(), e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			jMenuItem1.setText("Listar");
		}
		return jMenuItem1;
	}

	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String s = (String) JOptionPane.showInputDialog(
		                    jContentPane,
		                    "Ingrese la cedula del dueño a borrar",
		                    "Borrar dueño",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    null,
		                    null);
					if (s != null) { 
						if(s.matches("^[0-9]{6,7}$")) {
							try {
								//controller.BorrarDueno(new Integer(s));
								JOptionPane.showMessageDialog(getContentPane(), (new MessageError()).getMessage(MessageError.M_DELETE_OK), "Éxito", JOptionPane.INFORMATION_MESSAGE);
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(getContentPane(), e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(getJContentPane(),(new MessageError()).getMessage(MessageError.E_CEDULA_INVALIDA), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			jMenuItem2.setText("Borrar");
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes jMenu3	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu3() {
		if (jMenu3 == null) {
			jMenu3 = new JMenu();
			jMenu3.setText("Mascotas");
			jMenu3.add(getJMenuItem());
			jMenu3.add(getJMenuItem3());
		}
		return jMenu3;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						ventanaAbmProveedor vabmprov = new ventanaAbmProveedor();
						//vabmprov.setVisible(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getContentPane(), e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			jMenuItem.setText("Agregar");
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Listar");
			jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String s = (String) JOptionPane.showInputDialog( jContentPane, "Ingrese la cedula del dueño de las mascotas","Listar Mascotas",JOptionPane.PLAIN_MESSAGE, null, null, null);
					if (s != null) { 
						if(s.matches("^[0-9]{6,7}$")) {
							try {
								new ventanaAbmFamilia();
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(getContentPane(), e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(getJContentPane(),(new MessageError()).getMessage(MessageError.E_CEDULA_INVALIDA), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		return jMenuItem3;
	}
	/**
	 * This method initializes jMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new JMenuItem();
			jMenuItem4.setText("Agregar");
			jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						ventanaCrearFamilia vendueno = new ventanaCrearFamilia();
						//vendueno.setVisible(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getContentPane(), e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return jMenuItem4;
	}

}  //  @jve:decl-index=0:visual-constraint="390,24"
