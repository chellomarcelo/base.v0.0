package test.descontinuados;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controladores.Modulo1.Modulo1.Modulo1.Modulo1.controladorCrearProducto;

import javax.swing.JTextField;
import javax.swing.JButton;

import logica.Config;
import logica.excepciones.ExcFamilia;
import logica.excepciones.ExcProducto;
import logica.vo.voFamilia;
import logica.vo.voProducto;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;

//import logica.excepciones.MessageError;

public class respaldoRespt extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrameCrearRepuesto = null;  //  @jve:decl-index=0:visual-constraint="179,10"
	private JPanel jContentPaneCrearRepuesto = null;
	private JLabel jLabelNombreRepuesto = null;
	private JLabel jLabelFamilia = null;
	private JLabel jLabelProveedor = null;
	private JLabel jLabelCantidad = null;
	private JLabel jLabelPrecio = null;
	private JLabel jLabelImagen = null;
	private JTextField jTextFieldNombreRepuesto = null;
	private JTextField jTextFieldProveedor = null;
	private JTextField jTextFieldCantidad = null;
	private JTextField jTextFieldPrecio = null;
	private JButton jButtonImagen = null;
	private JButton jButtonAceptar = null;
	private JButton jButtonCancelar = null;
	private controladorCrearProducto controlador;
	private ArrayList<voFamilia> familias = null;
	private JComboBox jComboBox = null;
	private String selcombo;
	private JCheckBox jCheckBoxIVA = null;
	private Config config = Config.getInstance();
	private boolean punto=false;
	
	public respaldoRespt  () throws Exception{
	//	controlador = new controladorCrearRepuesto(this);
		familias = controlador.listarFamilias();
		jFrameCrearRepuesto = getJFrameCrearRepuesto();
		jFrameCrearRepuesto.setVisible(true);
	}
	
	private JFrame getJFrameCrearRepuesto() throws Exception {
		if(jFrameCrearRepuesto == null){
			jFrameCrearRepuesto = new JFrame();
			jFrameCrearRepuesto.setContentPane(getJContentPaneCrearRepuesto());
			jFrameCrearRepuesto.setSize(710, 263);
			jFrameCrearRepuesto.setTitle("Crear Repuesto");
			jFrameCrearRepuesto.setResizable(false);
			jFrameCrearRepuesto.setLocationRelativeTo(null);
		}
		return jFrameCrearRepuesto;
	}
	
	
	private JPanel getJContentPaneCrearRepuesto() throws Exception {
		if (jContentPaneCrearRepuesto == null) {
			jContentPaneCrearRepuesto = new JPanel();
			jContentPaneCrearRepuesto.setLayout(null);
			jContentPaneCrearRepuesto.add(getJLabelNombreRepuesto(), null);
			jContentPaneCrearRepuesto.add(getJLabelFamilia(), null);
			jContentPaneCrearRepuesto.add(getJLabelProveedor(), null);
			jContentPaneCrearRepuesto.add(getJLabelCantidad(), null);
			jContentPaneCrearRepuesto.add(getJLabelPrecio(), null);
			jContentPaneCrearRepuesto.add(getJLabelImagen(), null);
			jContentPaneCrearRepuesto.add(getJTextFieldNombreRepuesto(), null);
			jContentPaneCrearRepuesto.add(getJTextFieldProveedor(), null);
			jContentPaneCrearRepuesto.add(getJTextFieldCantidad(), null);
			jContentPaneCrearRepuesto.add(getJTextFieldPrecio(), null);
			jContentPaneCrearRepuesto.add(getJButtonImagen(), null);
			jContentPaneCrearRepuesto.add(getJButtonAceptar(), null);
			jContentPaneCrearRepuesto.add(getJButtonCancelar(), null);
			jContentPaneCrearRepuesto.add(getJComboBox(), null);
			jContentPaneCrearRepuesto.add(getJCheckBoxIVA(), null);
			
		}
		return jContentPaneCrearRepuesto;
	}
	
	private JLabel getJLabelNombreRepuesto(){
		if(jLabelNombreRepuesto == null){
			jLabelNombreRepuesto = new JLabel();
			jLabelNombreRepuesto.setBounds(16,15,150,25);
			jLabelNombreRepuesto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
			jLabelNombreRepuesto.setHorizontalTextPosition(javax.swing.SwingConstants.TRAILING);
			jLabelNombreRepuesto.setText("Nombre Repuesto");
		}
		return jLabelNombreRepuesto;
	}
	
	private JLabel getJLabelFamilia (){
		if(jLabelFamilia == null){
			jLabelFamilia = new JLabel();
			jLabelFamilia.setBounds(15,51,150,25);
			jLabelFamilia.setHorizontalTextPosition(javax.swing.SwingConstants.TRAILING);
			jLabelFamilia.setText("Familia");
			jLabelFamilia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		}
		return jLabelFamilia;
	}
	
	private JLabel getJLabelProveedor(){
		if(jLabelProveedor == null){
			jLabelProveedor = new JLabel();
			jLabelProveedor.setBounds(15,87,150,25);
			jLabelProveedor.setHorizontalTextPosition(SwingConstants.TRAILING);
			jLabelProveedor.setText("Proveedor");
			jLabelProveedor.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabelProveedor;
	}
	
	private JLabel getJLabelCantidad (){
		if(jLabelCantidad == null){
			jLabelCantidad = new JLabel();
			jLabelCantidad.setBounds(15,123,150,25);
			jLabelCantidad.setHorizontalTextPosition(SwingConstants.TRAILING);
			jLabelCantidad.setText("Cantidad");
			jLabelCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabelCantidad;
	}
	
	private JLabel getJLabelPrecio (){
		if(jLabelPrecio == null){
			jLabelPrecio = new JLabel();
			jLabelPrecio.setBounds(407,15,150,25);
			jLabelPrecio.setHorizontalTextPosition(SwingConstants.TRAILING);
			jLabelPrecio.setText("Precio");
			jLabelPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabelPrecio;
	}
	
	private JLabel getJLabelImagen(){
		if(jLabelImagen == null){
			jLabelImagen = new JLabel();
			jLabelImagen.setBounds(408,87,150,25);
			jLabelImagen.setHorizontalTextPosition(SwingConstants.TRAILING);
			jLabelImagen.setText("Imagen");
			jLabelImagen.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabelImagen;
	}
	
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNombreRepuesto() {
		if (jTextFieldNombreRepuesto == null) {
			jTextFieldNombreRepuesto = new JTextField();
			jTextFieldNombreRepuesto.setBounds(180,15,180,25);
		}
		return jTextFieldNombreRepuesto;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldProveedor() {
		if (jTextFieldProveedor == null) {
			jTextFieldProveedor = new JTextField();
			jTextFieldProveedor.setBounds(180,87,180,25);
		}
		return jTextFieldProveedor;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCantidad() {
		if (jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setBounds(180, 123, 180, 25);
			jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
				//Este evento verifica que solo consuma números y puntos
				public void keyTyped(java.awt.event.KeyEvent e) {
					char c= e.getKeyChar();
					if(!Character.isDigit(c)){
						e.consume();
					}
				}
			});
		}
		return jTextFieldCantidad;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPrecio() {
		if (jTextFieldPrecio == null) {
			jTextFieldPrecio = new JTextField();
			jTextFieldPrecio.setBounds(510,15,180,25);
			jTextFieldPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
				//Este evento verifica que solo consuma números y puntos
				public void keyTyped(java.awt.event.KeyEvent e) {
					char c= e.getKeyChar();
					if(!Character.isDigit(c)&& c!='.'){
						e.consume();
						//System.out.println("keyTyped()");
					}
					if(c=='.' && jTextFieldPrecio.getText().contains("."))
						e.consume();
				}
			});
			
		}
		return jTextFieldPrecio;
	}

	/**
	 * This method initializes jButtonImagen	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonImagen() {
		if (jButtonImagen == null) {
			jButtonImagen = new JButton();
			jButtonImagen.setBounds(510, 87, 180, 25);
			jButtonImagen.setText("Examinar");
			
		}
		return jButtonImagen;
	}

	/**
	 * This method initializes jButtonAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 * @throws Exception 
	 */
	private JButton getJButtonAceptar() throws Exception {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(159, 169, 141, 46);
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					System.out.println("Rellenar validando todo");
					int idFamilia = controlador.darFamiliaId(selcombo);
					float precio = 0;
					int cant=0;
					if (!jTextFieldCantidad.getText().toString().isEmpty()){
						cant=Integer.parseInt(jTextFieldCantidad.getText().toString());
					}else {
						JOptionPane.showMessageDialog(jContentPaneCrearRepuesto, new ExcProducto().ERROR_ESPACIOS_BLANCOS, "Error", JOptionPane.ERROR_MESSAGE);
					}
							
					if(!jTextFieldPrecio.getText().toString().isEmpty())
						precio=Float.parseFloat(jTextFieldPrecio.getText().toString());
					else{
						JOptionPane.showMessageDialog(jContentPaneCrearRepuesto, new ExcProducto().ERROR_ESPACIOS_BLANCOS, "Error", JOptionPane.ERROR_MESSAGE);
					}
					if(idFamilia == 0){
						JOptionPane.showMessageDialog(jContentPaneCrearRepuesto, new ExcFamilia(ExcFamilia.FAMILIA_NOT_EXISTS), "Error", JOptionPane.ERROR_MESSAGE);
					}else{
							float precioIva = 0;
							if(jCheckBoxIVA.isSelected())
								precioIva = (Float.parseFloat(config.getProperty(config.CONST_IVA))) * Float.parseFloat(jTextFieldPrecio.getText().toString());
					}
				}
			});
			//refresh();
		}
		return jButtonAceptar;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(435, 169, 141, 46);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respaldoRespt.this.jFrameCrearRepuesto.dispose();
					
				}
			});
		}
		return jButtonCancelar;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(180,51,180,25);
			
			Iterator<voFamilia> it = familias.iterator();
			while(it.hasNext()){
				System.out.println("entro");
				voFamilia fam = it.next();
				System.out.println(fam.getNombreFamilia());
				jComboBox.addItem(fam.getNombreFamilia());
			}	
			// Accion a realizar cuando el JComboBox cambia de item seleccionado.
			jComboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selcombo = jComboBox.getSelectedItem().toString();
					System.out.println(selcombo);
				}
			});
		}
		return jComboBox;
	}

	/**
	 * This method initializes jCheckBoxIVA	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxIVA() {
		if (jCheckBoxIVA == null) {
			jCheckBoxIVA = new JCheckBox();
			jCheckBoxIVA.setBounds(510, 51, 180, 25);
			jCheckBoxIVA.setText("Lleva? IVA");
		}
		return jCheckBoxIVA;
	}
	
	public void closeVent(){
		this.jFrameCrearRepuesto.dispose();
	}

} 