package grafica.ventanas.Modulo1;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import grafica.controladores.Modulo1.controladorCrearFamilia;

import javax.swing.JButton;

import logica.vo.voFamilia;
import logica.vo.voProducto;

public class ventanaCrearFamilia {

	private JFrame jFrameCrearFam = null;  //  @jve:decl-index=0:visual-constraint="114,27"
	private JPanel jContentPaneCrearFam = null;
	private JLabel jLabelCrearFam = null;
	private JTextField jTextFieldCrearFam = null;
	private JButton jButtonCrearFamAceptar = null;
	private JButton jButtonCrearFamCancelar = null;
	private controladorCrearFamilia controlFamilia;
	
	public ventanaCrearFamilia  () throws Exception{
		controlFamilia = new controladorCrearFamilia(this);
		jFrameCrearFam = getJFrameFam();
		jFrameCrearFam.setVisible(true);
		jFrameCrearFam.setLocationRelativeTo(null);
	}
	
	/**
	 * This method initializes jFrameCrearFam	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameFam() throws Exception {
		jFrameCrearFam = new JFrame();
		jFrameCrearFam.setContentPane(getJContentPaneCrearFam());
		jFrameCrearFam.setSize(new java.awt.Dimension(478,169));
		jFrameCrearFam.setResizable(false);
		jFrameCrearFam.setTitle("Crear Familia");
		jFrameCrearFam.setLocationRelativeTo(null);
		
		return jFrameCrearFam;
	}

	/**
	 * This method initializes jContentPaneCrearFam	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneCrearFam() {
		if (jContentPaneCrearFam == null) {
			jContentPaneCrearFam = new JPanel();
			jContentPaneCrearFam.setLayout(null);
			jContentPaneCrearFam.add(getJLabelFam(), null);
			jContentPaneCrearFam.add(getJTextFieldCrearFam(), null);
			jContentPaneCrearFam.add(getJButtonCrearFamAceptar(), null);
			jContentPaneCrearFam.add(getJButtonCrearFamCancelar(), null);
		}
		return jContentPaneCrearFam;
	}

	private JLabel getJLabelFam(){
		if(jLabelCrearFam == null){
			jLabelCrearFam = new JLabel();
			jLabelCrearFam.setBounds(new java.awt.Rectangle(18,18,128,27));
			jLabelCrearFam.setText("Nombre de la Familia");
		}
	
	return jLabelCrearFam;
	}
	/**
	 * This method initializes jTextFieldCrearFam	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCrearFam() {
		if (jTextFieldCrearFam == null) {
			jTextFieldCrearFam = new JTextField();
			jTextFieldCrearFam.setBounds(new java.awt.Rectangle(169,17,268,27));
		}
		return jTextFieldCrearFam;
	}

	/**
	 * This method initializes jButtonCrearFam	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCrearFamAceptar() {
		if (jButtonCrearFamAceptar == null) {
			jButtonCrearFamAceptar = new JButton();
			jButtonCrearFamAceptar.setBounds(new java.awt.Rectangle(60,87,150,30));
			jButtonCrearFamAceptar.setText("Aceptar");
			jButtonCrearFamAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Rellenar validando todo");
					voFamilia voData = new voFamilia(0, jTextFieldCrearFam.getText());
						try {
							controlFamilia.crearFamilia(voData);
							jFrameCrearFam.dispose();
						} catch (Exception e2){
							JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
				}
			});
		}
		return jButtonCrearFamAceptar;
	}

	/**
	 * This method initializes jButtonCrearFamCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCrearFamCancelar() {
		if (jButtonCrearFamCancelar == null) {
			jButtonCrearFamCancelar = new JButton();
			jButtonCrearFamCancelar.setBounds(new java.awt.Rectangle(270,87,150,30));
			jButtonCrearFamCancelar.setText("Cancela");
			jButtonCrearFamCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaCrearFamilia.this.jFrameCrearFam.dispose();
				}
			});
		}
		return jButtonCrearFamCancelar;
	}

}
