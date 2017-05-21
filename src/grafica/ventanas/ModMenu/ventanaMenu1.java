package grafica.ventanas.ModMenu;

import grafica.ventanas.Modulo1.ventanaAbmFamilia;
import grafica.ventanas.Modulo1.ventanaAbmProducto;
import grafica.ventanas.Modulo1.ventanaAbmProveedor;
import grafica.ventanas.Modulo1.ventanaCrearProducto;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ventanaMenu1  {

	private JFrame 		JFrameMenu1 = null; //  @jve:decl-index=0:visual-constraint="304,25"
	private JPanel 		jContentPaneMenu1 = null;
	private JButton 	JButtonMenFam = null;
	private JButton 	JButtonMenProv = null;
	private JButton 	JButtonMenProd = null;
	private JButton 	jButtonMenClientes = null;
	private JMenuBar 	JMenuBarMen;
	private JMenu 		JMenu1 = null;
	private JMenu 		JMenu2 = null;
	private JMenuItem 	JMenuItem1 = null;
	private JMenuItem 	JMenuItem2 = null;
	private JMenuItem 	JMenuItem3 = null;
	private JMenuItem 	JMenuItem4 = null;
	
	
	public ventanaMenu1(){
		JFrameMenu1 = getJFrameMenu1();
		JFrameMenu1.setVisible(true);
		JFrameMenu1.setLocationRelativeTo(null);
	}
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameMenu1() {
		if (JFrameMenu1 == null) {
			JFrameMenu1 = new JFrame();
			JFrameMenu1.setSize(new java.awt.Dimension(420,250));
			JFrameMenu1.setContentPane(getJContentPaneMenu1());
			JFrameMenu1.setTitle("Menu 1");
			JFrameMenu1.setVisible(true);
			JFrameMenu1.setJMenuBar(getJJMenuBar());
		}
		return JFrameMenu1;
	}
	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneMenu1() {
		if (jContentPaneMenu1 == null) {
			jContentPaneMenu1 = new JPanel();
			jContentPaneMenu1.setLayout(new GridLayout(3,4));
			jContentPaneMenu1.add(getJButtonMenFam());
			jContentPaneMenu1.add(getJButtonMenProv());
			jContentPaneMenu1.add(getJButtonMenProd());
			jContentPaneMenu1.add(getJButtonMenClientes());
			//jContentPaneMenu1.add(getJJMenuBar());
			
		}
		return jContentPaneMenu1;
	}
	
	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (JMenuBarMen == null) {
			JMenuBarMen = new JMenuBar();
			JMenuBarMen.add(getJMenu1());
			//JMenuBarMen.add(getJMenu2());
		}
		return JMenuBarMen;
	}

	/**
	 * This method initializes jMenu2	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu1() {
		if (JMenu1 == null) {
			JMenu1 = new JMenu();
			JMenu1.setText("Menu1");
			JMenu1.add(getJMenuItem1());
			//JMenu1.add(getJMenuItem2());
			//JMenu1.add(getJMenuItem3());
		}
		return JMenu1;
	}

	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (JMenuItem1 == null) {
			JMenuItem1 = new JMenuItem();
			JMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//ventanaCrearProducto vListarProducto = null; 
						ventanaAbmProducto vListarProducto = null;
					try {
						vListarProducto = new ventanaAbmProducto();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getJContentPaneMenu1(), e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			JMenuItem1.setText("Listar");
		}
		return JMenuItem1;
	}

	
	private JButton getJButtonMenFam(){
		
		if(JButtonMenFam == null)
			JButtonMenFam = new JButton();
			JButtonMenFam.setText("Familia");
			JButtonMenFam.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaAbmFamilia vAbmFam = null; 
					try {
						vAbmFam = new ventanaAbmFamilia();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getJContentPaneMenu1(), e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		return JButtonMenFam;
	}
	
	private JButton getJButtonMenProv(){
		if(JButtonMenProv== null)
			JButtonMenProv = new JButton();
			JButtonMenProv.setText("Proveedores");
			JButtonMenProv.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaAbmProveedor vAbmProv = null; 
					try {
						vAbmProv = new ventanaAbmProveedor();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getJContentPaneMenu1(), e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		return JButtonMenProv;
	}

	private JButton getJButtonMenProd(){
		if(JButtonMenProd== null)
			JButtonMenProd= new JButton();
			JButtonMenProd.setText("Productos");
			JButtonMenProd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaAbmProducto vAbmProd = null; 
					try {
						vAbmProd = new ventanaAbmProducto();
						//vAbmProd = new ventanaAbmProductos();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getJContentPaneMenu1(), e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		
		return JButtonMenProd;
	}
	
	private JButton getJButtonMenClientes(){
		if(jButtonMenClientes== null)
			jButtonMenClientes= new JButton();
			jButtonMenClientes.setText("Clientes");
		
		return jButtonMenClientes;
	}
	
	
}
