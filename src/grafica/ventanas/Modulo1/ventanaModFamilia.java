package grafica.ventanas.Modulo1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import grafica.controladores.Modulo1.controladorModificarFamilia;

import javax.swing.JButton;

import logica.excepciones.ExcepcionesGeneral;
import logica.vo.voFamilia;

public class ventanaModFamilia {

	private JFrame jFrameModFam = null;  //  @jve:decl-index=0:visual-constraint="152,15"
	private JPanel jContentPaneModFam = null;
	private JLabel jLabelModFam1 = null;
	private JLabel jLabelModFam2 = null;
	private JTextField jTextFieldModFam1 = null;
	private JTextField jTextFieldModFam2 = null;
	private JButton jButtonModFamAceptar = null;
	private JButton jButtonModFamCancelar = null;
	private controladorModificarFamilia controlModFam;
	private String nombreActual; 
	
	/*****
	 * Constructor - Se le pasa el Nombre de la familia actual en base
	 * @param _nombreActual
	 */
	public ventanaModFamilia (String _nombreActual){
		controlModFam = new controladorModificarFamilia(this);
		nombreActual = _nombreActual;
		jFrameModFam = getJFrameModFam();
		jFrameModFam.setVisible(true);
		jFrameModFam.setLocationRelativeTo(null);
	}
	
	/**
	 * This method initializes jFrameModFam	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameModFam() {
		if (jFrameModFam == null) {
			jFrameModFam = new JFrame();
			jFrameModFam.setSize(new java.awt.Dimension(518,180));
			jFrameModFam.setTitle("Modificar Familia");
			jFrameModFam.setContentPane(getJContentPaneModFam());
		}
		return jFrameModFam;
	}

	/**
	 * This method initializes jContentPaneModFam	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneModFam() {
		if (jContentPaneModFam == null) {
			jContentPaneModFam = new JPanel();
			jContentPaneModFam.setLayout(null);
			jContentPaneModFam.add(getJLabelModFam1(), null);
			jContentPaneModFam.add(getJLabelModFam2(), null);
			jContentPaneModFam.add(getJTextFieldModFam1(), null);
			jContentPaneModFam.add(getJTextFieldModFam2(), null);
			jContentPaneModFam.add(getJButtonModFamAceptar(), null);
			jContentPaneModFam.add(getJButtonModFamCancelar(), null);
		}
		return jContentPaneModFam;
	}
	
	public JLabel getJLabelModFam1(){
		if(jLabelModFam1 == null){
			jLabelModFam1 = new JLabel();
			jLabelModFam1.setBounds(new java.awt.Rectangle(16,15,115,30));
			jLabelModFam1.setText("Nombre Actual:");
		}
		return jLabelModFam1;
	}
	
	public JLabel getJLabelModFam2(){
		if(jLabelModFam2 == null){
			jLabelModFam2 = new JLabel();
			jLabelModFam2.setBounds(new java.awt.Rectangle(16,50,115,30));
			jLabelModFam2.setText("Nombre Nuevo:");
		}
		return jLabelModFam2;
	}

	/**
	 * This method initializes jTextFieldModFam1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldModFam1() {
		if (jTextFieldModFam1 == null) {
			jTextFieldModFam1 = new JTextField();
			jTextFieldModFam1.setBounds(new java.awt.Rectangle(154,15,330,30));
			jTextFieldModFam1.setText(nombreActual);
			jTextFieldModFam1.setEditable(false);
		}
		return jTextFieldModFam1;
	}

	/**
	 * This method initializes jTextFieldModFam2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldModFam2() {
		if (jTextFieldModFam2 == null) {
			jTextFieldModFam2 = new JTextField();
			jTextFieldModFam2.setBounds(new java.awt.Rectangle(154,50,330,30));
		}
		return jTextFieldModFam2;
	}

	/**
	 * This method initializes jButtonModFamAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModFamAceptar() {
		if (jButtonModFamAceptar == null) {
			jButtonModFamAceptar = new JButton();
			jButtonModFamAceptar.setBounds(new java.awt.Rectangle(95,90,130,35));
			jButtonModFamAceptar.setText("Aceptar");
			jButtonModFamAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Rellenar validando todo");
					voFamilia voData1 = new voFamilia(0, jTextFieldModFam1.getText());
					voFamilia voData2 = new voFamilia(0, jTextFieldModFam2.getText());
						try {
							if((voData1.getNombreFamilia().isEmpty()) || (voData2.getNombreFamilia().isEmpty())){
								JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_ESPACIOS_BLANCOS)), "Error al modificar Familia",JOptionPane.ERROR_MESSAGE);
								//JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral(ExcepcionesGeneral.ERROR_CAMPOS_VACIO)).toString(), "Error al modificar Familia", JOptionPane.ERROR_MESSAGE);
							}else{
								controlModFam.modificarFamilia(voData1, voData2);
								jFrameModFam.dispose();
							}
						} catch (Exception e2){
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						
						}
				}
			});
		}
		return jButtonModFamAceptar;
	}

	/**
	 * This method initializes jButtonModFamCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModFamCancelar() {
		if (jButtonModFamCancelar == null) {
			jButtonModFamCancelar = new JButton();
			jButtonModFamCancelar.setBounds(new java.awt.Rectangle(300,90,130,35));
			jButtonModFamCancelar.setText("Cancelar");
			jButtonModFamCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaModFamilia.this.jFrameModFam.dispose();
				}
			});
		}
		return jButtonModFamCancelar;
	}
	

}
