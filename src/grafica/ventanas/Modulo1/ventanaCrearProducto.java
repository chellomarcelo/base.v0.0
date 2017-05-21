package grafica.ventanas.Modulo1;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import logica.Config;
import logica.fecha;
import logica.excepciones.ExcFamilia;
import logica.excepciones.ExcProveedores;
import logica.excepciones.ExcProducto;
import logica.excepciones.ExcepcionesGeneral;
import logica.vo.voFamilia;
import logica.vo.voProveedor;
import logica.vo.voProducto;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.HTMLEditorKit.Parser;

import grafica.controladores.Modulo1.controladorCrearProducto;



//import logica.excepciones.MessageError;

public class ventanaCrearProducto extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrameCrearProducto = null;  //  @jve:decl-index=0:visual-constraint="100,12"
	private JPanel jContentPaneCrearProducto = null;
	private JLabel jLabelNombreProducto = null;
	private JLabel jLabelFamilia = null;
	private JLabel jLabelProveedor = null;
	private JLabel jLabelCantidad = null;
	private JLabel jLabelPrecio = null;
	private JLabel jLabelImagen = null;
	private JTextField jTextFieldNombreProducto = null;
	private JTextField jTextFieldCantidad = null;
	private JTextField jTextFieldPrecio = null;
	private JButton jButtonImagen = null;
	private JButton jButtonAceptar = null;
	private JButton jButtonCancelar = null;
	private JLabel jLabelFechIngreso = null;
	private JLabel jLabelFechVencimiento = null;
	private JTextField jTextFieldFechIngreso = null;
	private JTextField jTextFieldFechVencimiento = null;
	private JLabel jLabelLote = null;
	private JLabel jLabelCargoFoto = null;
	private JTextField jTextFieldLote = null;
	private JLabel jLabelCodBarr = null;
	private JTextField jTextFieldCodBarr = null;
	private JLabel jLabelDescripcion = null;
	private JTextArea jTextAreaDescripcion = null;
	private JComboBox jComboBox = null;
	private JCheckBox jCheckBoxIVA = null;
	private JComboBox jComboBoxProveedor = null;
	private JFileChooser fileChooser = new JFileChooser();
	private File fichero = null;
	private fecha f;
	private int resultado=0;
	private voProducto voProd=null;
	private controladorCrearProducto controlador;
	private ArrayList<voFamilia> familias = null;
	private ArrayList<voProveedor> proveedor = null;
	private String selcombo;
	private String selcombo2;
	private int estado= 1 ;
	
	public ventanaCrearProducto  () throws Exception{
		controlador = new controladorCrearProducto(this);
		familias = controlador.listarFamilias();
		proveedor = controlador.listarProveedores();
		jFrameCrearProducto = getJFrameCrearProducto();
		jFrameCrearProducto.setVisible(true);
		jFrameCrearProducto.setLocationRelativeTo(null);
	}
	
	// estado (1=Alta, 2=Baja, 3=Modificación, 4=Detalle)   ----2016/11/28
	public ventanaCrearProducto (int _estado, String _nombreProducto ) throws Exception{
		controlador = new controladorCrearProducto(this);
		voProd = controlador.getProdUni(_nombreProducto);
		familias = controlador.listarFamilias();
		proveedor = controlador.listarProveedores();
		estado = _estado;
		jFrameCrearProducto = getJFrameCrearProducto();
		jFrameCrearProducto.setVisible(true);
		System.out.println("Estado: "+estado);
		
	}
	
	private JFrame getJFrameCrearProducto() throws Exception {
		if(jFrameCrearProducto == null){
			jFrameCrearProducto = new JFrame();
			jFrameCrearProducto.setContentPane(getJContentPaneCrearProducto());
			jFrameCrearProducto.setSize(786, 552);
			jFrameCrearProducto.setTitle("Crear Producto");
			jFrameCrearProducto.setResizable(false);
			jFrameCrearProducto.setLocationRelativeTo(null);
		}
		return jFrameCrearProducto;
	}
	
	
	private JPanel getJContentPaneCrearProducto() throws Exception {
		if (jContentPaneCrearProducto == null) {
			jLabelCargoFoto = new JLabel();
			jLabelCargoFoto.setBounds(new java.awt.Rectangle(404,253,358,166));
			//jLabelCargoFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			//jLabelCargoFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			//jLabelCargoFoto.setFont(new java.awt.Font("DigifaceWide", java.awt.Font.BOLD, 24));
			//jLabelCargoFoto.setText("Foto");
			jLabelDescripcion = new JLabel();
			jLabelDescripcion.setBounds(new java.awt.Rectangle(403,16,360,30));
			jLabelDescripcion.setText("Descripción");
			jLabelCodBarr = new JLabel();
			jLabelCodBarr.setBounds(new java.awt.Rectangle(15,290,150,25));
			jLabelCodBarr.setText("Codigo de Barras");
			jLabelLote = new JLabel();
			jLabelLote.setBounds(new java.awt.Rectangle(15,251,151,33));
			jLabelLote.setText("Número de Lote");
			jLabelFechVencimiento = new JLabel();
			jLabelFechVencimiento.setBounds(new java.awt.Rectangle(15,209,155,25));
			jLabelFechVencimiento.setText("Fecha Vencimiento");
			jLabelFechIngreso = new JLabel();
			jLabelFechIngreso.setBounds(new java.awt.Rectangle(15,165,152,28));
			jLabelFechIngreso.setText("Fecha Ingreso");
			jContentPaneCrearProducto = new JPanel();
			jContentPaneCrearProducto.setLayout(null);
			jContentPaneCrearProducto.add(getJLabelNombreProducto(), null);
			jContentPaneCrearProducto.add(getJLabelFamilia(), null);
			jContentPaneCrearProducto.add(getJLabelProveedor(), null);
			jContentPaneCrearProducto.add(getJLabelCantidad(), null);
			jContentPaneCrearProducto.add(getJLabelPrecio(), null);
			jContentPaneCrearProducto.add(getJLabelImagen(), null);
			jContentPaneCrearProducto.add(getJTextFieldNombreProducto(), null);
			jContentPaneCrearProducto.add(getJTextFieldCantidad(), null);
			jContentPaneCrearProducto.add(getJTextFieldPrecio(), null);
			if(estado !=4)
				jContentPaneCrearProducto.add(getJButtonImagen(), null);
			jContentPaneCrearProducto.add(getJComboBox(), null);
			jContentPaneCrearProducto.add(getJCheckBoxIVA(), null);
			jContentPaneCrearProducto.add(getJComboBoxProveedor(), null);
			jContentPaneCrearProducto.add(jLabelFechIngreso, null);
			jContentPaneCrearProducto.add(jLabelFechVencimiento, null);
			jContentPaneCrearProducto.add(getJTextFieldFechIngreso(), null);
			jContentPaneCrearProducto.add(getJTextFieldFechVencimiento(), null);
			jContentPaneCrearProducto.add(jLabelLote, null);
			jContentPaneCrearProducto.add(getJTextFieldLote(), null);
			jContentPaneCrearProducto.add(jLabelCodBarr, null);
			jContentPaneCrearProducto.add(getJTextFieldCodBarr(), null);
			jContentPaneCrearProducto.add(jLabelDescripcion, null);
			jContentPaneCrearProducto.add(getJTextAreaDescripcion(), null);
			if(estado !=4)
				jContentPaneCrearProducto.add(getJButtonAceptar(), null);
			jContentPaneCrearProducto.add(getJButtonCancelar(), null);
			jContentPaneCrearProducto.add(jLabelCargoFoto, null);
			//Detalle
			if(estado==4 || estado==3){
				jLabelCargoFoto.setIcon(controlador.createImage(voProd.getNombreProducto(), voProd.getUrlFoto(),jLabelCargoFoto.getWidth(),jLabelCargoFoto.getHeight() ));
			}
		}
		return jContentPaneCrearProducto;
	}
	
	private JLabel getJLabelNombreProducto(){
		if(jLabelNombreProducto == null){
			jLabelNombreProducto = new JLabel();
			jLabelNombreProducto.setBounds(16,15,150,25);
			jLabelNombreProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
			jLabelNombreProducto.setHorizontalTextPosition(javax.swing.SwingConstants.TRAILING);
			jLabelNombreProducto.setText("Nombre del Producto");
		}
		return jLabelNombreProducto;
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
			jLabelPrecio.setBounds(12, 364, 150, 25);
			jLabelPrecio.setHorizontalTextPosition(SwingConstants.TRAILING);
			jLabelPrecio.setText("Precio");
			jLabelPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabelPrecio;
	}
	
	private JLabel getJLabelImagen(){
		if(jLabelImagen == null){
			jLabelImagen = new JLabel();
			jLabelImagen.setBounds(402, 212, 150, 25);
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
	private JTextField getJTextFieldNombreProducto() {
		if (jTextFieldNombreProducto == null) {
			jTextFieldNombreProducto = new JTextField();
			jTextFieldNombreProducto.setBounds(180,15,180,25);
		}
		
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldNombreProducto.setText(voProd.getNombreProducto());
			jTextFieldNombreProducto.disable();
			jTextFieldNombreProducto.setDisabledTextColor(Color.BLUE);
		}
		
		//DETALLE
		if(estado==4){
			if(!voProd.getNombreProducto().isEmpty())
				jTextFieldNombreProducto.setText(voProd.getNombreProducto());
			jTextFieldNombreProducto.disable();
			jTextFieldNombreProducto.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldNombreProducto;
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
			
			//MODIFICACIÓN
			if(estado==3){
				jTextFieldCantidad.setText(Integer.toString(voProd.getCantidadProducto()));
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
			//Detalle
			if(estado==4){
				if(!voProd.getNombreProducto().isEmpty())
					jTextFieldCantidad.setText(Integer.toString(voProd.getCantidadProducto()));
					jTextFieldCantidad.disable();
					jTextFieldCantidad.setDisabledTextColor(Color.BLUE);
			}
			
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
			jTextFieldPrecio.setBounds(178, 362, 180, 25);
			
			//ALTA 1
			if (estado == 1 ){
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
			//MODIFICACION 3 y DETALLE 4
			float aux=0;
			if (estado == 3 || estado == 4){
				if(voProd.getPrecioIva()!=0){
					aux = voProd.getPrecioIva() + voProd.getPrecioSIva();
					jTextFieldPrecio.setText(Float.toString(aux));
				}else{
					jTextFieldPrecio.setText(Float.toString(voProd.getPrecioSIva()));
				}
			}
			
			
			//DETALLE 4 
			if (estado == 4){
				jTextFieldPrecio.disable();
				jTextFieldPrecio.setDisabledTextColor(Color.BLUE);
			}
			
		}
		return jTextFieldPrecio;
	}

	/**
	 * This method initializes jButtonImagen	
	 * 	
	 * @return javax.swing.JButton	
	 */
	
	
	// Ver como hacer para que me traiga la imagen de one
	private JButton getJButtonImagen() {
		if (jButtonImagen == null) {
			jButtonImagen = new JButton();
			jButtonImagen.setBounds(582, 210, 180, 25);
			jButtonImagen.setText("Examinar");
			
			//AlTA o Modificación
			jButtonImagen.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						//FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG", "jpg");
						resultado = fileChooser.showOpenDialog(null);
						/*abrimos el archivo seleccionado*/
						fichero = fileChooser.getSelectedFile();
		 				ImageIcon icon = new ImageIcon (fichero.toString());
		 				System.out.println(fichero+"");
		 				Icon icono = new ImageIcon(icon.getImage().getScaledInstance(jLabelCargoFoto.getWidth(), jLabelCargoFoto.getHeight(), Image.SCALE_DEFAULT));
		 				jLabelCargoFoto.setText(null);
		 				jLabelCargoFoto.setIcon(icono);
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Error al cargar imagen "+ex);
					}
				}
			});
			
			
		}
		return jButtonImagen;
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
		
			if (estado==1){	
				Iterator<voFamilia> it = familias.iterator();
				while(it.hasNext()){
					//System.out.println("entro");
					voFamilia fam = it.next();
					//System.out.println(fam.getNombreFamilia());
					jComboBox.addItem(fam.getNombreFamilia());
				}	
				
			}	
			
			//MODIFICACIÓN
			if(estado==3){
				//Agrego a la cabecera el nombre de la familia que tiene cargado el producto
				String nomFamMod = controlador.buscarNombreFamilia(familias, voProd.getIdFamilia());
				selcombo = nomFamMod;
				jComboBox.addItem(nomFamMod); 
				Iterator<voFamilia> it = familias.iterator();
				while(it.hasNext()){
					System.out.println("entro al modificar familia");
					voFamilia fam = it.next();
					System.out.println(fam.getNombreFamilia());
					System.out.println(voProd.getIdFamilia());
					System.out.println(nomFamMod);
					if(!fam.getNombreFamilia().equals(nomFamMod))
						jComboBox.addItem(fam.getNombreFamilia());
				}
			
			}
			// Accion a realizar cuando el JComboBox cambia de item seleccionado.
			jComboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selcombo = jComboBox.getSelectedItem().toString();
					System.out.println(selcombo);
				}
			});
			//Detalle
			if(estado==4){
				jComboBox.addItem(controlador.buscarNombreFamilia(familias, voProd.getIdFamilia()));
				jComboBox.disable();
			}
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
			jCheckBoxIVA.setBounds(178, 396, 176, 25);
			jCheckBoxIVA.setText("Lleva? IVA");
		}
		
		//MODIFICACIÓN 3
		if(estado ==3 || estado == 4 ){
			System.out.println("precioSiva: "+voProd.getPrecioSIva());
			if(voProd.getPrecioSIva()!=0)
				jCheckBoxIVA.doClick();
		}	
		
		//DETALLE 4
		if (estado== 4){
			jCheckBoxIVA.disable();	
			jCheckBoxIVA.setEnabled(false);
		}
		
		return jCheckBoxIVA;
	}

	/**
	 * This method initializes jComboBoxProveedor	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxProveedor() {
		if (jComboBoxProveedor == null) {
			jComboBoxProveedor = new JComboBox();
			jComboBoxProveedor.setBounds(new java.awt.Rectangle(180,87,180,25));
		
			//ALTA
			if(estado==1){	
				Iterator<voProveedor> it = proveedor.iterator();
				while(it.hasNext()){
					//System.out.println("entro");
					voProveedor prov = it.next();
					//System.out.println(prov.getNombreProveedor());
					jComboBoxProveedor.addItem(prov.getNombreProveedor());
				}	
				
			}
			
			//MODIFICACIÓN
			if(estado==3){
				//Agregar nombre del proveedor
				String nomProvMod = controlador.buscarNombreProveedor(proveedor, voProd.getIdProveedor());
				selcombo2 = voProd.getIdProveedor();
				jComboBoxProveedor.addItem(nomProvMod); 
				Iterator<voProveedor> it = proveedor.iterator();
				while(it.hasNext()){
					//System.out.println("entro");
					voProveedor prov = it.next();
					System.out.println(prov.getNombreProveedor());
					System.out.println(voProd.getIdProveedor());
					System.out.println(nomProvMod);
					if(!prov.getNombreProveedor().equals(nomProvMod))
						jComboBoxProveedor.addItem(prov.getNombreProveedor());
					
				}
			
			}
			// Accion a realizar cuando el JComboBox cambia de item seleccionado.
			jComboBoxProveedor.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selcombo2 = jComboBoxProveedor.getSelectedItem().toString();
					System.out.println(selcombo2);
				}
			});
			//Detalle
			if(estado==4){
				jComboBoxProveedor.addItem(controlador.buscarNombreProveedor(proveedor, voProd.getIdProveedor()));
				jComboBoxProveedor.disable();
			}
		}	
		return jComboBoxProveedor;
	}

	/**
	 * This method initializes jTextFieldFechIngreso	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFechIngreso() {
		if (f==null){
			f = new fecha();
		}
		
		if (jTextFieldFechIngreso == null) {
			jTextFieldFechIngreso = new JTextField();
			jTextFieldFechIngreso.setBounds(new java.awt.Rectangle(180,164,180,25));
		}
		
		//ALTA 1 
		if (estado ==1 ){
			jTextFieldFechIngreso.setText(f.getAno()+"/"+f.getMes()+"/"+f.getDia());
			jTextFieldFechIngreso.setEditable(false);
		}
		
		//MODIFICACION 3
		if (estado == 3 ){
			System.out.println("Fecha ingreso: "+ voProd.getFechaIngreso());
			jTextFieldFechIngreso.setText(f.retornoFecha(voProd.getFechaIngreso()));
			//Controlar que no pueda ingresar una fecha mayor a la de hoy.
		}
		
		//DETALLE 4
		if (estado == 4 ){
			jTextFieldFechIngreso.setText(voProd.getFechaIngreso());
			jTextFieldFechIngreso.disable();
			jTextFieldFechIngreso.setDisabledTextColor(Color.BLUE);
		}
		
		return jTextFieldFechIngreso;
	}

	/**
	 * This method initializes jTextFieldFechVencimiento	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFechVencimiento() {
		if (jTextFieldFechVencimiento == null) {
			jTextFieldFechVencimiento = new JTextField();
			jTextFieldFechVencimiento.setBounds(new java.awt.Rectangle(180,211,180,25));
		}
		
		//ALTA 1 
		if (estado ==1 ){
			jTextFieldFechVencimiento.setText("AAAA/MM/DD");
		}
		
		//MODIFICACION 3
		if (estado == 3 ){
			System.out.println("Fecha Vencimiento: "+ voProd.getFechaVencimiento());
			jTextFieldFechVencimiento.setText(f.retornoFecha(voProd.getFechaVencimiento()));
			//Controlar que no pueda ingresar una fecha menor o igual a la de hoy.
		}
		
		//DETALLE 4
		if (estado == 4 ){
			jTextFieldFechVencimiento.setText(voProd.getFechaVencimiento());
			jTextFieldFechVencimiento.disable();
			jTextFieldFechVencimiento.setDisabledTextColor(Color.BLUE);
		}
		
		return jTextFieldFechVencimiento;
	}

	/**
	 * This method initializes jTextFieldLote	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLote() {
		if (jTextFieldLote == null) {
			jTextFieldLote = new JTextField();
			jTextFieldLote.setBounds(new java.awt.Rectangle(180,256,180,25));
		}
	
		//MODIFICACION 3
		if (estado == 3 || estado == 4){
			jTextFieldLote.setText(voProd.getLote());
		}
		
		//DETALLE 4
		if (estado == 4){
			jTextFieldLote.disable();	
			jTextFieldLote.setDisabledTextColor(Color.BLUE);
		}
		
		return jTextFieldLote;
	}
	/**
	 * This method initializes jTextFieldCodBarr	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCodBarr() {
		if (jTextFieldCodBarr == null) {
			jTextFieldCodBarr = new JTextField();
			jTextFieldCodBarr.setBounds(new java.awt.Rectangle(180,293,180,25));
		}
		
		//MODIFICACION 3
		if (estado == 3 || estado == 4){
			jTextFieldCodBarr.setText(voProd.getCodBar());
		}
		
		//DETALLE 4
		if (estado == 4){
			jTextFieldCodBarr.disable();
			jTextFieldCodBarr.setDisabledTextColor(Color.BLUE);
		}
		
		return jTextFieldCodBarr;
	}

	/**
	 * This method initializes jTextAreaDescripcion	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaDescripcion() {
		if (jTextAreaDescripcion == null) {
			jTextAreaDescripcion = new JTextArea();
			jTextAreaDescripcion.setBounds(new java.awt.Rectangle(403,63,360,138));
		}
		
		//MODIFICACION 3
		if (estado == 3 || estado == 4){
			jTextAreaDescripcion.setText(voProd.getDescripcion());
		}
		
		//DETALLE 4
		if (estado == 4){
			jTextAreaDescripcion.disable();
			jTextAreaDescripcion.setDisabledTextColor(Color.BLUE);
		}
		
		return jTextAreaDescripcion;
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
			jButtonAceptar.setBounds(177, 451, 141, 46);
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					boolean ok=true;
					int idFamilia = controlador.darFamiliaId(selcombo);
					String idProveedor = controlador.darProveedor(selcombo2);
					float precio = 0;
							
					int cantidad;
					if(jTextFieldCantidad.getText().isEmpty()){
						cantidad=0;
					}else{ 
						cantidad = Integer.parseInt(jTextFieldCantidad.getText().toString()); 
					}
					//PRECIOS
					
					float precioIva = 0;
					float precioAux = 0;
					if(jTextFieldPrecio.getText().isEmpty()){
						precioAux=0;
					}else{
						if(jTextFieldPrecio.getText().matches("[-+]?[0-9]*\\.?[0-9]*")){ //("\\d*")){
							precioAux = Float.parseFloat(jTextFieldPrecio.getText().toString());
							if(jCheckBoxIVA.isSelected())
								precioIva = 1;
						}else{
							JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage((ExcepcionesGeneral.ERROR_NUMEROS))), "Error Campo Precio", JOptionPane.ERROR_MESSAGE);
							ok=false;
						}
					}
					String urlFoto="";
					if(estado==3){
						urlFoto = voProd.getUrlFoto();
						//System.out.println(urlFoto);
					}
					
					if (fichero!=null)
						urlFoto= fichero.toString();
					
					
					int idProducto=1;
					if(estado==3)
						idProducto= voProd.getIdProducto();	
					voProducto voData=null;
					if(ok)
					voData = new voProducto(	idProducto	, 
												jTextFieldNombreProducto.getText().toString(), 
												idProveedor, 
												idFamilia, 
												urlFoto, 
												cantidad,
												precioAux,   
												precioIva, // Por ahora 1 lleva IVA  
												jTextFieldFechIngreso.getText().toString(),		
												jTextFieldFechVencimiento.getText().toString(),
												jTextFieldLote.getText().toString(),
												jTextFieldCodBarr.getText().toString(),
												jTextAreaDescripcion.getText().toString()
																);
							
							try {
								controlador.crearProducto(voData, estado);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							// TODO Auto-generated catch block
					}
				});
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
			jButtonCancelar.setBounds(453, 451, 141, 46);
			if (estado==4){
				jButtonCancelar.setText("Salir");
			}else{
				jButtonCancelar.setText("Cancelar");
			}
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						ventanaAbmProducto vent = new ventanaAbmProducto();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ventanaCrearProducto.this.jFrameCrearProducto.dispose();
				}
			});
		}
		return jButtonCancelar;
	}
	
	public void cerrarVentana() throws Exception{
		getJFrameCrearProducto().dispose();
	}

} 