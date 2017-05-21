package grafica.ventanas.Modulo1;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import grafica.controladores.Modulo1.controladorAbmProveedor;
import grafica.controladores.Modulo1.controladorCrearProveedor;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

import logica.excepciones.ExcProveedores;
import logica.excepciones.ExcProducto;
import logica.excepciones.ExcepcionesGeneral;
import logica.vo.voProveedor;
import logica.vo.voTipoProveedor;

public class ventanaCrearProveedor2 {

	private JFrame jFrameCrearProv = null;  //  @jve:decl-index=0:visual-constraint="41,25"
	private JPanel jContentPaneProv = null;
	private JLabel jLabelRutProv = null;
	private JTextField jTextFieldRutProv = null;
	private JLabel jLabelNomProv = null;
	private JTextField jTextFieldNomProv = null;
	private JLabel jLabelNomFanProv = null;
	private JTextField jTextFieldNomFanProv = null;
	private JLabel jLabelNomAuxProv = null;
	private JTextField jTextFieldNomAuxProv = null;
	private JLabel jLabelTipoProv = null;
	private JComboBox jComboBoxTipoProv = null;
	private JTextField jTextFieldTipProv = null;
	private JLabel jLabelDir1Prov = null;
	private JTextField jTextFieldDir1Prov = null;
	private JLabel jLabelDir2Prov = null;
	private JTextField jTextFieldDir2Prov = null;
	private JLabel jLabelDir3Prov = null;
	private JTextField jTextFieldDir3Prov = null;
	private JLabel jLabelTel1Prov = null;
	private JTextField jTextFieldTel1Prov = null;
	private JLabel jLabelTel2Prov = null;
	private JTextField jTextFieldTel2Prov = null;
	private JLabel jLabelTel3Prov = null;
	private JTextField jTextFieldTel3Prov = null;
	private JLabel jLabelCel1Prov = null;
	private JTextField jTextFieldCel1Prov = null;
	private JLabel jLabelCel2Prov = null;
	private JTextField jTextFieldCel2Prov = null;
	private JLabel jLabelCel3Prov = null;
	private JTextField jTextFieldCel3Prov = null;
	private JLabel jLabelCon1Prov = null;
	private JTextField jTextFieldCon1Prov = null;
	private JLabel jLabelCon2Prov = null;
	private JTextField jTextFieldCon2Prov = null;
	private JLabel jLabelCon3Prov = null;
	private JTextField jTextFieldCon3Prov = null;
	private JLabel jLabelHoraProv = null;
	private JTextField jTextFieldHoraProv = null;
	private JTextArea jTextAreaComProv = null;
	private JLabel jLabelComProv = null;
	private JButton jButtonAceptarProv = null;
	private JButton jButtonCanelarProv = null;
	private JButton jButtonAgrTipoProv = null;
	private ArrayList<voTipoProveedor> Tipoproveedor = null;
	private String selcombo2;
	private controladorCrearProveedor controlador;
	private JLabel jLabelCorr1Prov = null;
	private JTextField jTextFieldCorr1Prov = null;
	private JLabel jLabelCorr2Prov = null;
	private JTextField jTextFieldCorr2Prov = null;
	private JLabel jLabelCorr3Prov = null;
	private JTextField jTextFieldCorr3Prov = null;
	private int estado=1;
	private String rut = "0";
	private voProveedor voProv=null;
	
	public ventanaCrearProveedor2 () throws Exception{
		controlador = new controladorCrearProveedor(this);
		Tipoproveedor = controlador.listarTipoProveedor();
		jFrameCrearProv = getJFrameCrearProv();
		jFrameCrearProv.setVisible(true);
	}
	// estado (1=Alta, 2=Baja, 3=Modificación, 4=Detalle)
	public ventanaCrearProveedor2 (int _estado, String _rut) throws Exception{
		controlador = new controladorCrearProveedor(this);
		Tipoproveedor = controlador.listarTipoProveedor();
		voProv = controlador.getProvUni(_rut);
		estado = _estado;
		rut = _rut;
		jFrameCrearProv = getJFrameCrearProv();
		jFrameCrearProv.setVisible(true);
		System.out.println("Estado: "+estado);
	
	}
	
	/**
	 * This method initializes jFrameCrearProv	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameCrearProv() {
		if (jFrameCrearProv == null) {
			jFrameCrearProv = new JFrame();
			jFrameCrearProv.setSize(new java.awt.Dimension(1089,529));
			jFrameCrearProv.setTitle("Crear Proveedor");
			jFrameCrearProv.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			jFrameCrearProv.setContentPane(getJContentPaneProv());
			jFrameCrearProv.setLocationRelativeTo(null);
			
		}
		return jFrameCrearProv;
	}

	/**
	 * This method initializes jContentPaneProv	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneProv() {
		if (jContentPaneProv == null) {
			jLabelCorr3Prov = new JLabel();
			jLabelCorr3Prov.setBounds(new java.awt.Rectangle(428,346,112,28));
			jLabelCorr3Prov.setText("Correo 3");
			jLabelCorr2Prov = new JLabel();
			jLabelCorr2Prov.setBounds(new java.awt.Rectangle(430,304,106,29));
			jLabelCorr2Prov.setText("Correo 2");
			jLabelCorr1Prov = new JLabel();
			jLabelCorr1Prov.setBounds(new java.awt.Rectangle(428,262,105,26));
			jLabelCorr1Prov.setText("Correo 1");
			jLabelComProv = new JLabel();
			jLabelComProv.setBounds(new java.awt.Rectangle(803,15,105,25));
			jLabelComProv.setText("Comentario");
			jLabelHoraProv = new JLabel();
			jLabelHoraProv.setBounds(new java.awt.Rectangle(430,225,105,25));
			jLabelHoraProv.setText("Horario Atención");
			jLabelCon3Prov = new JLabel();
			jLabelCon3Prov.setBounds(new java.awt.Rectangle(430,190,105,25));
			jLabelCon3Prov.setText("Contacto 3");
			jLabelCon2Prov = new JLabel();
			jLabelCon2Prov.setBounds(new java.awt.Rectangle(430,155,105,25));
			jLabelCon2Prov.setText("Contacto 2");
			jLabelCon1Prov = new JLabel();
			jLabelCon1Prov.setBounds(new java.awt.Rectangle(430,120,105,25));
			jLabelCon1Prov.setText("Contacto 1");
			jLabelCel3Prov = new JLabel();
			jLabelCel3Prov.setBounds(new java.awt.Rectangle(430,85,105,25));
			jLabelCel3Prov.setText("Celular 3");
			jLabelCel2Prov = new JLabel();
			jLabelCel2Prov.setBounds(new java.awt.Rectangle(430,50,105,25));
			jLabelCel2Prov.setText("Celular 2");
			jLabelCel1Prov = new JLabel();
			jLabelCel1Prov.setBounds(new java.awt.Rectangle(430,15,105,25));
			jLabelCel1Prov.setText("Celular 1");
			jLabelTel3Prov = new JLabel();
			jLabelTel3Prov.setBounds(new java.awt.Rectangle(25,365,105,25));
			jLabelTel3Prov.setText("Telefono 3");
			jLabelTel2Prov = new JLabel();
			jLabelTel2Prov.setBounds(new java.awt.Rectangle(25,330,105,25));
			jLabelTel2Prov.setText("Telefono 2");
			jLabelTel1Prov = new JLabel();
			jLabelTel1Prov.setBounds(new java.awt.Rectangle(25,295,105,25));
			jLabelTel1Prov.setText("Telefono 1");
			jLabelDir3Prov = new JLabel();
			jLabelDir3Prov.setBounds(new java.awt.Rectangle(25,260,105,25));
			jLabelDir3Prov.setText("Dirección 3");
			jLabelDir2Prov = new JLabel();
			jLabelDir2Prov.setBounds(new java.awt.Rectangle(25,225,105,25));
			jLabelDir2Prov.setText("Dirección 2");
			jLabelDir1Prov = new JLabel();
			jLabelDir1Prov.setBounds(new java.awt.Rectangle(25,190,105,25));
			jLabelDir1Prov.setText("Dirección 1");
			jLabelTipoProv = new JLabel();
			jLabelTipoProv.setBounds(new java.awt.Rectangle(25,155,105,25));
			jLabelTipoProv.setText("Tipo Proveedor");
			jLabelNomAuxProv = new JLabel();
			jLabelNomAuxProv.setBounds(new java.awt.Rectangle(25,120,105,25));
			jLabelNomAuxProv.setText("Nombre Auxiliar");
			jLabelNomFanProv = new JLabel();
			jLabelNomFanProv.setBounds(new java.awt.Rectangle(25,85,105,25));
			jLabelNomFanProv.setText("Nombre Fantasía");
			jLabelNomProv = new JLabel();
			jLabelNomProv.setBounds(new java.awt.Rectangle(25,50,105,25));
			jLabelNomProv.setText("Nombre");
			jLabelRutProv = new JLabel();
			jLabelRutProv.setBounds(new java.awt.Rectangle(25,15,105,25));
			jLabelRutProv.setText("Rut");
			jContentPaneProv = new JPanel();
			jContentPaneProv.setLayout(null);
			jContentPaneProv.add(jLabelRutProv, null);
			jContentPaneProv.add(getJTextFieldRutProv(), null);
			jContentPaneProv.add(jLabelNomProv, null);
			jContentPaneProv.add(getJTextFieldNomProv(), null);
			jContentPaneProv.add(jLabelNomFanProv, null);
			jContentPaneProv.add(getJTextFieldNomFanProv(), null);
			jContentPaneProv.add(jLabelNomAuxProv, null);
			jContentPaneProv.add(getJTextFieldNomAuxProv(), null);
			jContentPaneProv.add(jLabelTipoProv, null);
			jContentPaneProv.add(getJComboBoxTipoProv(), null);
			jContentPaneProv.add(jLabelDir1Prov, null);
			jContentPaneProv.add(getJTextFieldDir1Prov(), null);
			jContentPaneProv.add(jLabelDir2Prov, null);
			jContentPaneProv.add(getJTextFieldDir2Prov(), null);
			jContentPaneProv.add(jLabelDir3Prov, null);
			jContentPaneProv.add(getJTextFieldDir3Prov(), null);
			jContentPaneProv.add(jLabelTel1Prov, null);
			jContentPaneProv.add(getJTextFieldTel1Prov(), null);
			jContentPaneProv.add(jLabelTel2Prov, null);
			jContentPaneProv.add(getJTextFieldTel2Prov(), null);
			jContentPaneProv.add(jLabelTel3Prov, null);
			jContentPaneProv.add(getJTextFieldTel3Prov(), null);
			jContentPaneProv.add(jLabelCel1Prov, null);
			jContentPaneProv.add(getJTextFieldCel1Prov(), null);
			jContentPaneProv.add(jLabelCel2Prov, null);
			jContentPaneProv.add(getJTextFieldCel2Prov(), null);
			jContentPaneProv.add(jLabelCel3Prov, null);
			jContentPaneProv.add(getJTextFieldCel3Prov(), null);
			jContentPaneProv.add(jLabelCon1Prov, null);
			jContentPaneProv.add(getJTextFieldCon1Prov(), null);
			jContentPaneProv.add(jLabelCon2Prov, null);
			jContentPaneProv.add(getJTextFieldCon2Prov(), null);
			jContentPaneProv.add(jLabelCon3Prov, null);
			jContentPaneProv.add(getJTextFieldCon3Prov(), null);
			jContentPaneProv.add(jLabelHoraProv, null);
			jContentPaneProv.add(getJTextFieldHoraProv(), null);
			jContentPaneProv.add(getJTextAreaComProv(), null);
			jContentPaneProv.add(jLabelComProv, null);
			jContentPaneProv.add(getJButtonAceptarProv(), null);
			jContentPaneProv.add(getJButtonCanelarProv(), null);
			jContentPaneProv.add(getJButtonAgrTipoProv(), null);
			jContentPaneProv.add(jLabelCorr1Prov, null);
			jContentPaneProv.add(getJTextFieldCorr1Prov(), null);
			jContentPaneProv.add(jLabelCorr2Prov, null);
			jContentPaneProv.add(getJTextFieldCorr2Prov(), null);
			jContentPaneProv.add(jLabelCorr3Prov, null);
			jContentPaneProv.add(getJTextFieldCorr3Prov(), null);
		}
		return jContentPaneProv;
	}

	/**
	 * This method initializes jTextFieldRutProv	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRutProv() {
		if (jTextFieldRutProv == null) {
			jTextFieldRutProv = new JTextField();
			jTextFieldRutProv.setBounds(new java.awt.Rectangle(150,15,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldRutProv.setText(voProv.getIdProveedor()); 
			jTextFieldRutProv.disable();
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getIdProveedor().isEmpty())
				jTextFieldRutProv.setText(voProv.getIdProveedor());
			jTextFieldRutProv.disable();
			jTextFieldRutProv.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldRutProv;
	}

	/**
	 * This method initializes jTextFieldNomProv	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNomProv() {
		if (jTextFieldNomProv == null) {
			jTextFieldNomProv = new JTextField();
			jTextFieldNomProv.setBounds(new java.awt.Rectangle(150,50,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldNomProv.setText(voProv.getNombreProveedor()); 
			
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getNombreProveedor().isEmpty())
				jTextFieldNomProv.setText(voProv.getNombreProveedor());
			jTextFieldNomProv.disable();
			jTextFieldNomProv.setDisabledTextColor(Color.BLUE);
		}
		
		return jTextFieldNomProv;
	}

	/**
	 * This method initializes jTextFieldNomFanProv	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNomFanProv() {
		if (jTextFieldNomFanProv == null) {
			jTextFieldNomFanProv = new JTextField();
			jTextFieldNomFanProv.setBounds(new java.awt.Rectangle(150,85,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldNomFanProv.setText(voProv.getNombreFantasia()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getNombreFantasia().isEmpty())
				jTextFieldNomFanProv.setText(voProv.getNombreFantasia());
			jTextFieldNomFanProv.disable();
			jTextFieldNomFanProv.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldNomFanProv;
	}

	/**
	 * This method initializes jTextFieldNomAuxProv	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNomAuxProv() {
		if (jTextFieldNomAuxProv == null) {
			jTextFieldNomAuxProv = new JTextField();
			jTextFieldNomAuxProv.setBounds(new java.awt.Rectangle(150,120,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldNomAuxProv.setText(voProv.getNombreAuxiliar()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getNombreAuxiliar().isEmpty())
				jTextFieldNomAuxProv.setText(voProv.getNombreAuxiliar());
			jTextFieldNomAuxProv.disable();
			jTextFieldNomAuxProv.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldNomAuxProv;
	}

	/**
	 * This method initializes jComboBoxTipoProv	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxTipoProv() {
		if (jComboBoxTipoProv == null) {
			jComboBoxTipoProv = new JComboBox();
			jComboBoxTipoProv.setBounds(new java.awt.Rectangle(150,155,220,25));
		}
		//ALTA
		if(estado==1){
			Iterator<voTipoProveedor> it = Tipoproveedor.iterator();
			while(it.hasNext()){
				System.out.println("entro");
				voTipoProveedor prov = it.next();
				System.out.println(prov.getNombreTipoProveedor());
				jComboBoxTipoProv.addItem(prov.getNombreTipoProveedor());
			}	
			// Accion a realizar cuando el JComboBox cambia de item seleccionado.
			jComboBoxTipoProv.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selcombo2 = jComboBoxTipoProv.getSelectedItem().toString();
					System.out.println(selcombo2);
				}
			});
		}
		//MODIFICACIÓN
		if(estado==3){
			Iterator<voTipoProveedor> it = Tipoproveedor.iterator();
			jComboBoxTipoProv.addItem(voProv.getTipoProveedor());
			selcombo2 = voProv.getTipoProveedor();
			System.out.println(selcombo2);
			while(it.hasNext()){
				System.out.println("entro");
				voTipoProveedor prov = it.next();
				System.out.println(prov.getNombreTipoProveedor());
				if(!prov.getNombreTipoProveedor().equals(voProv.getTipoProveedor()))
					jComboBoxTipoProv.addItem(prov.getNombreTipoProveedor());
			}
			
			// Accion a realizar cuando el JComboBox cambia de item seleccionado.
			jComboBoxTipoProv.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selcombo2 = jComboBoxTipoProv.getSelectedItem().toString();
					System.out.println(selcombo2);
				}
			});
			//AGREGAR para la carga de la modifiación
		}	
		//DETALLE
		if(estado==4){
			if(!voProv.getTipoProveedor().isEmpty())
				jComboBoxTipoProv.addItem(voProv.getTipoProveedor());
			jComboBoxTipoProv.disable();
			jComboBoxTipoProv.setBackground(Color.BLACK);
		}
		return jComboBoxTipoProv;
	}

	/**
	 * This method initializes jTextFieldDir1Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDir1Prov() {
		if (jTextFieldDir1Prov == null) {
			jTextFieldDir1Prov = new JTextField();
			jTextFieldDir1Prov.setBounds(new java.awt.Rectangle(150,190,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldDir1Prov.setText(voProv.getDir1()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getDir1().isEmpty())
				jTextFieldDir1Prov.setText(voProv.getDir1());
			jTextFieldDir1Prov.disable();
			jTextFieldDir1Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldDir1Prov;
	}

	/**
	 * This method initializes jTextFieldDir2Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDir2Prov() {
		if (jTextFieldDir2Prov == null) {
			jTextFieldDir2Prov = new JTextField();
			jTextFieldDir2Prov.setBounds(new java.awt.Rectangle(150,225,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldDir2Prov.setText(voProv.getDir2()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getDir2().isEmpty())
				jTextFieldDir2Prov.setText(voProv.getDir2());
			jTextFieldDir2Prov.disable();
			jTextFieldDir2Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldDir2Prov;
	}

	/**
	 * This method initializes jTextFieldDir3Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDir3Prov() {
		if (jTextFieldDir3Prov == null) {
			jTextFieldDir3Prov = new JTextField();
			jTextFieldDir3Prov.setBounds(new java.awt.Rectangle(150,260,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldDir3Prov.setText(voProv.getDir3()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getDir3().isEmpty())
				jTextFieldDir3Prov.setText(voProv.getDir3());
			jTextFieldDir3Prov.disable();
			jTextFieldDir3Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldDir3Prov;
	}

	/**
	 * This method initializes jTextFieldTel1Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTel1Prov() {
		if (jTextFieldTel1Prov == null) {
			jTextFieldTel1Prov = new JTextField();
			jTextFieldTel1Prov.setBounds(new java.awt.Rectangle(150,295,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldTel1Prov.setText(voProv.getTel1()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getTel1().isEmpty())
				jTextFieldTel1Prov.setText(voProv.getTel1());
			jTextFieldTel1Prov.disable();
			jTextFieldTel1Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldTel1Prov;
	}

	/**
	 * This method initializes jTextFieldTel2Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTel2Prov() {
		if (jTextFieldTel2Prov == null) {
			jTextFieldTel2Prov = new JTextField();
			jTextFieldTel2Prov.setBounds(new java.awt.Rectangle(150,330,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldTel2Prov.setText(voProv.getTel2()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getTel2().isEmpty())
				jTextFieldTel2Prov.setText(voProv.getTel2());
			jTextFieldTel2Prov.disable();
			jTextFieldTel2Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldTel2Prov;
	}

	/**
	 * This method initializes jTextFieldTel3Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTel3Prov() {
		if (jTextFieldTel3Prov == null) {
			jTextFieldTel3Prov = new JTextField();
			jTextFieldTel3Prov.setBounds(new java.awt.Rectangle(150,365,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldTel3Prov.setText(voProv.getTel3()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getTel3().isEmpty())
				jTextFieldTel3Prov.setText(voProv.getTel3());
			jTextFieldTel3Prov.disable();
			jTextFieldTel3Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldTel3Prov;
	}

	/**
	 * This method initializes jTextFieldCel1Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCel1Prov() {
		if (jTextFieldCel1Prov == null) {
			jTextFieldCel1Prov = new JTextField();
			jTextFieldCel1Prov.setBounds(new java.awt.Rectangle(550,15,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldCel1Prov.setText(voProv.getCel1()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getCel1().isEmpty())
				jTextFieldCel1Prov.setText(voProv.getCel1());
			jTextFieldCel1Prov.disable();
			jTextFieldCel1Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldCel1Prov;
	}

	/**
	 * This method initializes jTextFieldCel2Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCel2Prov() {
		if (jTextFieldCel2Prov == null) {
			jTextFieldCel2Prov = new JTextField();
			jTextFieldCel2Prov.setBounds(new java.awt.Rectangle(550,50,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldCel2Prov.setText(voProv.getCel2()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getCel2().isEmpty())
				jTextFieldCel2Prov.setText(voProv.getCel2());
			jTextFieldCel2Prov.disable();
			jTextFieldCel2Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldCel2Prov;
	}

	/**
	 * This method initializes jTextFieldCel3Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCel3Prov() {
		if (jTextFieldCel3Prov == null) {
			jTextFieldCel3Prov = new JTextField();
			jTextFieldCel3Prov.setBounds(new java.awt.Rectangle(550,85,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldCel3Prov.setText(voProv.getCel3()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getCel3().isEmpty())
				jTextFieldCel3Prov.setText(voProv.getCel3());
			jTextFieldCel3Prov.disable();
			jTextFieldCel3Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldCel3Prov;
	}

	/**
	 * This method initializes jTextFieldCon1Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCon1Prov() {
		if (jTextFieldCon1Prov == null) {
			jTextFieldCon1Prov = new JTextField();
			jTextFieldCon1Prov.setBounds(new java.awt.Rectangle(550,120,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldCon1Prov.setText(voProv.getContacto1()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getContacto1().isEmpty())
				jTextFieldCon1Prov.setText(voProv.getContacto1());
			jTextFieldCon1Prov.disable();
			jTextFieldCon1Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldCon1Prov;
	}

	/**
	 * This method initializes jTextFieldCon2Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCon2Prov() {
		if (jTextFieldCon2Prov == null) {
			jTextFieldCon2Prov = new JTextField();
			jTextFieldCon2Prov.setBounds(new java.awt.Rectangle(550,155,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldCon2Prov.setText(voProv.getContacto2()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getContacto2().isEmpty())
				jTextFieldCon2Prov.setText(voProv.getContacto2());
			jTextFieldCon2Prov.disable();
			jTextFieldCon2Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldCon2Prov;
	}

	/**
	 * This method initializes jTextFieldCon3Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCon3Prov() {
		if (jTextFieldCon3Prov == null) {
			jTextFieldCon3Prov = new JTextField();
			jTextFieldCon3Prov.setBounds(new java.awt.Rectangle(550,190,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldCon3Prov.setText(voProv.getContacto3()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getContacto3().isEmpty())
				jTextFieldCon3Prov.setText(voProv.getContacto3());
			jTextFieldCon3Prov.disable();
			jTextFieldCon3Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldCon3Prov;
	}

	/**
	 * This method initializes jTextFieldHoraProv	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldHoraProv() {
		if (jTextFieldHoraProv == null) {
			jTextFieldHoraProv = new JTextField();
			jTextFieldHoraProv.setBounds(new java.awt.Rectangle(550,225,220,25));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldHoraProv.setText(voProv.getHorarioAtentcion()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getHorarioAtentcion().isEmpty())
				jTextFieldHoraProv.setText(voProv.getHorarioAtentcion());
			jTextFieldHoraProv.disable();
			jTextFieldHoraProv.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldHoraProv;
	}

	/**
	 * This method initializes jTextAreaComProv	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaComProv() {
		if (jTextAreaComProv == null) {
			jTextAreaComProv = new JTextArea();
			jTextAreaComProv.setBounds(new java.awt.Rectangle(802,48,255,199));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextAreaComProv.setText(voProv.getComentarios()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getComentarios().isEmpty())
				jTextAreaComProv.setText(voProv.getComentarios());
			jTextAreaComProv.disable();
			jTextAreaComProv.setDisabledTextColor(Color.BLUE);
		}
		return jTextAreaComProv;
	}
	
	/**
	 * This method initializes jTextFieldCorr1Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCorr1Prov() {
		if (jTextFieldCorr1Prov == null) {
			jTextFieldCorr1Prov = new JTextField();
			jTextFieldCorr1Prov.setBounds(new java.awt.Rectangle(554,264,215,28));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldCorr1Prov.setText(voProv.getCorreo1()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getCorreo1().isEmpty())
				jTextFieldCorr1Prov.setText(voProv.getCorreo1());
			jTextFieldCorr1Prov.disable();
			jTextFieldCorr1Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldCorr1Prov;
	}

	/**
	 * This method initializes jTextFieldCorr2Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCorr2Prov() {
		if (jTextFieldCorr2Prov == null) {
			jTextFieldCorr2Prov = new JTextField();
			jTextFieldCorr2Prov.setBounds(new java.awt.Rectangle(556,302,216,24));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldCorr2Prov.setText(voProv.getCorreo2()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getCorreo2().isEmpty())
				jTextFieldCorr2Prov.setText(voProv.getCorreo2());
			jTextFieldCorr2Prov.disable();
			jTextFieldCorr2Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldCorr2Prov;
	}

	/**
	 * This method initializes jTextFieldCorr3Prov	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCorr3Prov() {
		if (jTextFieldCorr3Prov == null) {
			jTextFieldCorr3Prov = new JTextField();
			jTextFieldCorr3Prov.setBounds(new java.awt.Rectangle(556,344,216,28));
		}
		//MODIFICACIÓN
		if(estado==3){
			jTextFieldCorr3Prov.setText(voProv.getCorreo3()); 
		}
		//DETALLE
		if(estado==4){
			if(!voProv.getCorreo3().isEmpty())
				jTextFieldCorr3Prov.setText(voProv.getCorreo3());
			jTextFieldCorr3Prov.disable();
			jTextFieldCorr3Prov.setDisabledTextColor(Color.BLUE);
		}
		return jTextFieldCorr3Prov;
	}

	/**
	 * This method initializes jButtonAceptarProv	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAceptarProv() {
		if (jButtonAceptarProv == null) {
			jButtonAceptarProv = new JButton();
			jButtonAceptarProv.setBounds(new java.awt.Rectangle(250,430,140,45));
			if (estado==4){
				jButtonAceptarProv.disable();
				jButtonAceptarProv.setVisible(false);
			}	
			jButtonAceptarProv.setText("Aceptar");
			jButtonAceptarProv.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Rellenar validando todo");
					//Todo esto para proveedor.
					System.out.println("Rut: "+jTextFieldRutProv.getText().toString());
					voProveedor voData =	new voProveedor(jTextFieldRutProv.getText().toString(), //idRut - Obligatorio 
											jTextFieldNomProv.getText().toString(), //nombreProveedor - Obligatorio
											jTextFieldNomFanProv.getText().toString(), //nombreFantasia, -- No 
											jTextFieldNomAuxProv.getText().toString(), // nombreAuxiliar, --No	
											selcombo2, //tipoProveedor, -- Obligatorio 
											jTextFieldDir1Prov.getText().toString(), // dir1 -- obli 
											jTextFieldDir2Prov.getText().toString(), // dir2 -- NO 
											jTextFieldDir3Prov.getText().toString(), // dir3 -- NO 
											jTextFieldTel1Prov.getText().toString(), // tel1 -- Obligatorio 
											jTextFieldTel2Prov.getText().toString(), // tel2 -- No
											jTextFieldTel3Prov.getText().toString(), // tel3 -- No
											jTextFieldCel1Prov.getText().toString(), // cel1 -- Obligatorio 
											jTextFieldCel2Prov.getText().toString(), // cel2 -- No 
											jTextFieldCel3Prov.getText().toString(), // cel3 -- No
											jTextFieldCorr1Prov.getText().toString(),//correo1 --No 
											jTextFieldCorr2Prov.getText().toString(),//correo2 --No 
											jTextFieldCorr3Prov.getText().toString(),//correo3 --No 
											jTextFieldCon1Prov.getText().toString(), //contacto1 -- Obligatorio 
											jTextFieldCon2Prov.getText().toString(), //contacto2 -- No, 
											jTextFieldCon3Prov.getText().toString(), //contacto3 -- No, 
											jTextAreaComProv.getText().toString(), //comentarios --No, 
											jTextFieldHoraProv.getText().toString()//Ver que hacemos con esto horarioAtentcion
											);
					if (estado == controladorAbmProveedor.ESTADO_A){
						try {
							controlador.crearProveedor(voData);
						} catch (Exception e2){
							JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						if(estado == controladorAbmProveedor.ESTADO_M){
							controlador.modProveedor(voProv, voData);
							getJFrameCrearProv().dispose();
							try {
								ventanaAbmProveedor vent = new ventanaAbmProveedor();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
		);
	}
		return jButtonAceptarProv;
	}

	/**
	 * This method initializes jButtonCanelarProv	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCanelarProv() {
		if (jButtonCanelarProv == null) {
			jButtonCanelarProv = new JButton();
			jButtonCanelarProv.setBounds(new java.awt.Rectangle(625,430,140,45));
			if (estado==4){
				jButtonCanelarProv.setText("Salir");
			}else{
				jButtonCanelarProv.setText("Cancelar");
			}
			jButtonCanelarProv.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						ventanaAbmProveedor vent = new ventanaAbmProveedor();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ventanaCrearProveedor2.this.jFrameCrearProv.dispose();
				}
			});
		}
		return jButtonCanelarProv;
	}

	/**
	 * This method initializes jButtonAgrTipoProv	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgrTipoProv() {
		
		if (jButtonAgrTipoProv == null) {
			jButtonAgrTipoProv = new JButton();
			if(estado==4){
				jButtonAgrTipoProv.disable();
				jButtonAgrTipoProv.setVisible(false);
			}else{
				jButtonAgrTipoProv.setBounds(new java.awt.Rectangle(420,430,175,45));
				jButtonAgrTipoProv.setText("Agregar Tipo Proveedor");
				jButtonAgrTipoProv.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						ventanaCrearTipoProveedor aux = new ventanaCrearTipoProveedor();
						getJFrameCrearProv().dispose();
					}
				});
			}	
		}
		return jButtonAgrTipoProv;
	}

	public void cerrarVentana(){
		this.jFrameCrearProv.dispose();
	}

}
