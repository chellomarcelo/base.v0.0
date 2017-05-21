package grafica.ventanas.Modulo2;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import grafica.controladores.Modulo2.controladorCrearMesa;

import javax.swing.JButton;

import logica.Modulo2.vo.voMesa;
import logica.vo.voProducto;

public class ventanaCrearMesa {

	private JFrame jFrameCrearMes = null;  //  @jve:decl-index=0:visual-constraint="114,27"
	private JPanel jContentPaneCrearMes = null;
	private JLabel jLabelCrearMes = null;
	private JTextField jTextFieldCrearMes = null;
	private JButton jButtonCrearMesAceptar = null;
	private JButton jButtonCrearMesCancelar = null;
	private controladorCrearMesa controlMesa;
	
	public ventanaCrearMesa  () throws Exception{
		controlMesa = new controladorCrearMesa(this);
		jFrameCrearMes = getJFrameMes();
		jFrameCrearMes.setVisible(true);
		jFrameCrearMes.setLocationRelativeTo(null);
	}
	
	/**
	 * This method initializes jFrameCrearMes	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameMes() throws Exception {
		jFrameCrearMes = new JFrame();
		jFrameCrearMes.setContentPane(getjContentPaneCrearMes());
		jFrameCrearMes.setSize(new java.awt.Dimension(478,169));
		jFrameCrearMes.setResizable(false);
		jFrameCrearMes.setTitle("Crear Mesa");
		jFrameCrearMes.setLocationRelativeTo(null);
		
		return jFrameCrearMes;
	}

	/**
	 * This method initializes jContentPaneCrearMes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getjContentPaneCrearMes() {
		if (jContentPaneCrearMes == null) {
			jContentPaneCrearMes = new JPanel();
			jContentPaneCrearMes.setLayout(null);
			jContentPaneCrearMes.add(getJLabelMes(), null);
			jContentPaneCrearMes.add(getjTextFieldCrearMes(), null);
			jContentPaneCrearMes.add(getjButtonCrearMesAceptar(), null);
			jContentPaneCrearMes.add(getjButtonCrearMesCancelar(), null);
		}
		return jContentPaneCrearMes;
	}

	private JLabel getJLabelMes(){
		if(jLabelCrearMes == null){
			jLabelCrearMes = new JLabel();
			jLabelCrearMes.setBounds(new java.awt.Rectangle(18,18,128,27));
			jLabelCrearMes.setText("Numero de la Mesa");
		}
	
	return jLabelCrearMes;
	}
	/**
	 * This method initializes jTextFieldCrearMes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getjTextFieldCrearMes() {
		if (jTextFieldCrearMes == null) {
			jTextFieldCrearMes = new JTextField();
			jTextFieldCrearMes.setBounds(new java.awt.Rectangle(169,17,268,27));
		}
		return jTextFieldCrearMes;
	}

	/**
	 * This method initializes jButtonCrearMes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getjButtonCrearMesAceptar() {
		if (jButtonCrearMesAceptar == null) {
			jButtonCrearMesAceptar = new JButton();
			jButtonCrearMesAceptar.setBounds(new java.awt.Rectangle(60,87,150,30));
			jButtonCrearMesAceptar.setText("Aceptar");
			jButtonCrearMesAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					voMesa voData = new voMesa(Integer.parseInt(jTextFieldCrearMes.getText()),0);
						try {
							controlMesa.crearMesa(voData);
							jFrameCrearMes.dispose();
						} catch (Exception e2){
							JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
				}
			});
		}
		return jButtonCrearMesAceptar;
	}

	/**
	 * This method initializes jButtonCrearMesCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getjButtonCrearMesCancelar() {
		if (jButtonCrearMesCancelar == null) {
			jButtonCrearMesCancelar = new JButton();
			jButtonCrearMesCancelar.setBounds(new java.awt.Rectangle(270,87,150,30));
			jButtonCrearMesCancelar.setText("Cancela");
			jButtonCrearMesCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaCrearMesa.this.jFrameCrearMes.dispose();
				}
			});
		}
		return jButtonCrearMesCancelar;
	}

}
