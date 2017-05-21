package grafica.ventanas.Modulo1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import grafica.controladores.Modulo1.controladorCrearFamilia;
import grafica.controladores.Modulo1.controladorTipoProveedor;

import javax.swing.JButton;

import logica.vo.voFamilia;
import logica.vo.voTipoProveedor;

public class ventanaCrearTipoProveedor {

	private JFrame jFrameTipoProv = null;  //  @jve:decl-index=0:visual-constraint="148,40"
	private JPanel jContentPaneTipoProv = null;
	private JLabel jLabelTipoProvNombre = null;
	private JTextField jTextFieldTipoProvNombre = null;
	private JButton jButtonTipoProvAceptar = null;
	private JButton jButtonTipoProvCancelar = null;
	private controladorTipoProveedor controlTipoProveedor;

	public ventanaCrearTipoProveedor() {
		controlTipoProveedor = new controladorTipoProveedor(this);
		jFrameTipoProv = getJFrameTipoProv();
		jFrameTipoProv.setVisible(true);
		jFrameTipoProv.setLocationRelativeTo(null);	
	}
	
	/**
	 * This method initializes jFrameTipoProv	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameTipoProv() {
		if (jFrameTipoProv == null) {
			jFrameTipoProv = new JFrame();
			jFrameTipoProv.setSize(new java.awt.Dimension(531,159));
			jFrameTipoProv.setTitle("Crear Tipo Proveedor");
			jFrameTipoProv.setContentPane(getJContentPaneTipoProv());
		}
		return jFrameTipoProv;
	}

	/**
	 * This method initializes jContentPaneTipoProv	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneTipoProv() {
		if (jContentPaneTipoProv == null) {
			jLabelTipoProvNombre = new JLabel();
			jLabelTipoProvNombre.setBounds(new java.awt.Rectangle(31,14,159,28));
			jLabelTipoProvNombre.setText("Ingresar Tipo Proveedor");
			jContentPaneTipoProv = new JPanel();
			jContentPaneTipoProv.setLayout(null);
			jContentPaneTipoProv.add(jLabelTipoProvNombre, null);
			jContentPaneTipoProv.add(getJTextFieldTipoProvNombre(), null);
			jContentPaneTipoProv.add(getJButtonTipoProvAceptar(), null);
			jContentPaneTipoProv.add(getJButtonTipoProvCancelar(), null);
		}
		return jContentPaneTipoProv;
	}

	/**
	 * This method initializes jTextFieldTipoProvNombre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTipoProvNombre() {
		if (jTextFieldTipoProvNombre == null) {
			jTextFieldTipoProvNombre = new JTextField();
			jTextFieldTipoProvNombre.setBounds(new java.awt.Rectangle(225,14,263,25));
		}
		return jTextFieldTipoProvNombre;
	}

	/**
	 * This method initializes jButtonAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonTipoProvAceptar() {
		if (jButtonTipoProvAceptar == null) {
			jButtonTipoProvAceptar = new JButton();
			jButtonTipoProvAceptar.setBounds(new java.awt.Rectangle(76,72,138,29));
			jButtonTipoProvAceptar.setText("Aceptar");
			jButtonTipoProvAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Rellenar validando todo");
					voTipoProveedor voData = new voTipoProveedor(jTextFieldTipoProvNombre.getText().toString());
						try {
							controlTipoProveedor.crearTipoProveedor(voData);
							//jFrameTipoProv.dispose();
						} catch (Exception e2){
							//Ver este punto
							JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					try {
						ventanaCrearProveedor2 aux = new ventanaCrearProveedor2();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					getJFrameTipoProv().dispose();	
				}
			});
		}
		
		return jButtonTipoProvAceptar;
	}

	/**
	 * This method initializes jButtonTipoProvCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonTipoProvCancelar() {
		if (jButtonTipoProvCancelar == null) {
			jButtonTipoProvCancelar = new JButton();			
			jButtonTipoProvCancelar.setBounds(new java.awt.Rectangle(275,70,141,29));
			jButtonTipoProvCancelar.setText("Cancelar");
			jButtonTipoProvCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaCrearTipoProveedor.this.jFrameTipoProv.dispose();
				}
			});
		}
		return jButtonTipoProvCancelar;
	}

}
