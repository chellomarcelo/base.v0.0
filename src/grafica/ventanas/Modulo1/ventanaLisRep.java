package grafica.ventanas.Modulo1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import grafica.controladores.Modulo1.controladorCrearFamilia;
import grafica.controladores.Modulo1.controladorLisRep;

import java.awt.BorderLayout;
import javax.swing.JButton;

import logica.vo.voFamilia;

public class ventanaLisRep {

	private JFrame jFrameLisRep = null;  //  @jve:decl-index=0:visual-constraint="129,15"
	private JPanel jContentPaneLisRep = null;
	private JButton jButtonLisRep = null;
	private controladorLisRep controlador;
	private String nombreReporte = new String ("Proveedor");
	
	public ventanaLisRep  () throws Exception{
		controlador = new controladorLisRep(this);
		jFrameLisRep = getjFrmaeLisRep();
		jFrameLisRep.setVisible(true);
		jFrameLisRep.setLocationRelativeTo(null);
	}
	

	/**
	 * This method initializes jFrmaeLisRep	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getjFrmaeLisRep() {
		if (jFrameLisRep == null) {
			jFrameLisRep = new JFrame();
			jFrameLisRep.setSize(new java.awt.Dimension(542,265));
			jFrameLisRep.setContentPane(getjContentPaneLisRep());
		}
		return jFrameLisRep;
	}

	/**
	 * This method initializes LisRepjContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getjContentPaneLisRep() {
		if (jContentPaneLisRep == null) {
			jContentPaneLisRep = new JPanel();
			jContentPaneLisRep.setLayout(null);
			jContentPaneLisRep.add(getjButtonLisRep(), null);
		}
		return jContentPaneLisRep;
	}

	/**
	 * This method initializes LisRepjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getjButtonLisRep() {
		if (jButtonLisRep == null) {
			jButtonLisRep = new JButton();
			jButtonLisRep.setBounds(new java.awt.Rectangle(31,30,184,46));
			jButtonLisRep.setText("Listado Proveedores");
			jButtonLisRep.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					controlador.crearReportePrueba(nombreReporte);
				}
			});
		}
		return jButtonLisRep;
	}

}
