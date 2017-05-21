package grafica.ventanas.Modulo1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import grafica.controladores.Modulo1.controladorAbmProveedor;
import logica.excepciones.ExcProveedores;
import logica.excepciones.ExcepcionesGeneral;
import logica.vo.voProveedor;

public class ventanaAbmProveedor {

	private JFrame jFrameAbmProv = null;  //  @jve:decl-index=0:visual-constraint="48,16"
	private JPanel jContentPaneAbmProv = null;
	private JSplitPane jSplitPaneabmProv = null;
	private JPanel jPanelAbmProvTop = null;
	private JPanel JPanelAbmProvBot = null;
	private JPanel jPanelTableContainer = null;
	private JScrollPane JScroolTabAbmProv = null; 
	private JTable table= null ;
	private JButton JButtonAbmProvRefresh = null;
	private JButton jButtonAbmProvModificar = null;
	private JButton jButtonAbmProvQuitar = null;
	private JButton jButtonAbmProvNueva = null;
	private JButton jButtonAbmProvCancelar = null;
 	private JButton JButtonAbmProvDetalle = null;
	private ListSelectionModel listSelectionModel;
 	private controladorAbmProveedor controlProveedor;
	private ArrayList<voProveedor> proveedores = null;
 	private ListSelectionModel lsm = null;
 	private String auxLisNom="";
 	private String auxLisRut="";
 	private int contProvAux = 0;
	
    public  ventanaAbmProveedor() throws Exception{
		controlProveedor = new controladorAbmProveedor(this);
		proveedores = controlProveedor.listarProveedores();
		contProvAux = proveedores.size();
		jFrameAbmProv = getJFrameAbmProv();
		jFrameAbmProv.setVisible(true);
		jFrameAbmProv.setLocationRelativeTo(null);
	}
 	
 	/***
 	 *	Diseño
 	 *	Jframe
 	 *		->  jContentPaneAbmProv    								controlPane
 	 *				->	jSplitPaneabmProv
 	 *						-> jPanelAbmProvTop
 	 *							->jPanelTableContainer
 	 *								->JScroolTabAbmProv
 	 *									-> 	table	
 	 *						-> jPanelAbmProvTop
 	 *							-> Jpanel	
 	 *
 	 */
 		
 	
	/**
	 * This method initializes jFrameAbmProv	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameAbmProv() {
		if (jFrameAbmProv == null) {
			jFrameAbmProv = new JFrame();
			jFrameAbmProv.setSize(new java.awt.Dimension(931,445));
			jFrameAbmProv.setContentPane(getJContentPaneAbmProv());
			jFrameAbmProv.setTitle("Modificación de Proveedor");
			jFrameAbmProv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		return jFrameAbmProv;
	}

	/**
	 * This method initializes jContentPaneAbmProv	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneAbmProv() {
		if (jContentPaneAbmProv == null) {
			jContentPaneAbmProv = new JPanel();
			jContentPaneAbmProv.setLayout(new BoxLayout(getJContentPaneAbmProv(), BoxLayout.X_AXIS));
			jContentPaneAbmProv.add(getJSplitPaneabmProv(), BorderLayout.CENTER);
			
		}
		return jContentPaneAbmProv;
	}

	/**
	 * This method initializes jSplitPaneabmProv	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPaneabmProv() {
		if (jSplitPaneabmProv == null) {
			jSplitPaneabmProv = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			jSplitPaneabmProv.add(getJPanelAbmProvTop());
			jSplitPaneabmProv.add(getJPanelAbmProvBot());
		}
		return jSplitPaneabmProv;
	}

	/**
	 * This method initializes jPanelAbmProvTop	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelAbmProvTop() {
		if (jPanelAbmProvTop == null) {
			jPanelAbmProvTop = new JPanel();
			jPanelAbmProvTop.setLayout(new BoxLayout(jPanelAbmProvTop, BoxLayout.LINE_AXIS));
			jPanelAbmProvTop.setBorder(BorderFactory.createEmptyBorder(5,5,0,5));
			jPanelAbmProvTop.setMinimumSize(new Dimension(300, 350));
			jPanelAbmProvTop.setPreferredSize(new Dimension(300, 350));
			jPanelAbmProvTop.add(getJPanelTableContainer());
		}
		return jPanelAbmProvTop;
	}
	
	//JPanel bottom
	private JPanel getJPanelAbmProvBot() {
		if (JPanelAbmProvBot == null) {
			JPanelAbmProvBot = new JPanel();
			JPanelAbmProvBot.setLayout(new GridLayout(1,5));
			JPanelAbmProvBot.setBorder(BorderFactory.createEmptyBorder(5,5,0,5));
			JPanelAbmProvBot.setMinimumSize(new Dimension(300, 50));
			JPanelAbmProvBot.setPreferredSize(new Dimension(300, 50));
			JPanelAbmProvBot.add(getJButtonAbmProvNueva());
			JPanelAbmProvBot.add(getJButtonAbmProvModificar());
			JPanelAbmProvBot.add(getJButtonAbmProvQuitar());
			JPanelAbmProvBot.add(getJButtonAbmProvDetalle());
			JPanelAbmProvBot.add(getJButtonAbmProvCancelar());
			
		}
		return JPanelAbmProvBot;
	}
	
	/**
	 * This method initializes jPanelTableContainer	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelTableContainer() {
		if (jPanelTableContainer == null) {
			jPanelTableContainer = new JPanel(new GridLayout(1,1));
			jPanelTableContainer.setBorder(BorderFactory.createTitledBorder("Table"));
			jPanelTableContainer.add(getJScrollPaneAbmProv());
		}
		return jPanelTableContainer;
	}
	
	private JScrollPane getJScrollPaneAbmProv(){
		if(JScroolTabAbmProv == null){
			JScroolTabAbmProv = new JScrollPane(getJTableAbmProv());

			/*System.out.println(	" \n --------------Frame---------------------\n"+
								"H: " + jFrameAbmProv.getHeight()+
								" W: " + jFrameAbmProv.getWidth()+
								" Size:" + jFrameAbmProv.getPreferredSize()+
								" Bound W" + jFrameAbmProv.getBounds().getWidth()+
								" Bound H" + jFrameAbmProv.getBounds().getHeight()+
								" \n --------------JPanel 1---------------------\n"+
								"H: " +jContentPaneAbmProv.getHeight() +
								" W: " + jContentPaneAbmProv.getWidth()+
								" Size:" + jContentPaneAbmProv.getPreferredSize()+
								" \n -------------jSplitPaneabmProv-------------\n"+
								" Divider: " +jSplitPaneabmProv.getDividerSize()+
								" H: " + jSplitPaneabmProv.getHeight()+
								" W: " + jSplitPaneabmProv.getWidth()+
								" Resize" + jSplitPaneabmProv.getResizeWeight()+
								" \n -------------jPanelAbmProvTop-------------\n"+
								"H:" +jPanelAbmProvTop.getHeight()+ 
								" W:"+ jPanelAbmProvTop.getWidth()+ 
								" Min: "+ jPanelAbmProvTop.getMinimumSize()+ 
								" Max:" + jPanelAbmProvTop.getMaximumSize()+
								" \n --------------Scroll---------------------\n"+
								"V: " + JScroolTabAbmProv.getViewport().getViewSize()+
								" \n --------------jPanelTableContainer---------\n"+
								"H: " + jPanelTableContainer.getHeight()+
								" W: " + jPanelTableContainer.getWidth()+
								" Size:" + jPanelTableContainer.getPreferredSize()+
								" Bound W" + jPanelTableContainer.getBounds().getWidth()+
								" Bound H" + jPanelTableContainer.getBounds().getHeight()+
								" Min: "+ jPanelTableContainer.getMinimumSize()+ 
								" Max:" + jPanelTableContainer.getMaximumSize()
								 
			);*/
			
		}
		return JScroolTabAbmProv;
	}
	
	private JTable getJTableAbmProv(){
		if (table == null){
				table = new JTable(controlProveedor.CargarModelo());
				listSelectionModel = table.getSelectionModel();
		        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
				table.setSelectionModel(listSelectionModel);
		}
		
		return table;
	}
	
	private JButton getJButtonAbmProvModificar (){
		if(jButtonAbmProvModificar == null){
			jButtonAbmProvModificar = new JButton();
			jButtonAbmProvModificar.setText("Modificar");
			jButtonAbmProvModificar.setBounds(435, 169, 141, 46);
			jButtonAbmProvModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("aux"+auxLisRut);
					if(lsm==null){
						JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.MODIFICACIONES)), "Modificación Proveedor", JOptionPane.INFORMATION_MESSAGE);
					}else{						
						auxLisRut = proveedores.get(lsm.getAnchorSelectionIndex()).getIdProveedor();
						contProvAux = proveedores.size();
						if(!auxLisRut.isEmpty()){
							controlProveedor.ventModProveedor(auxLisRut);
							getJFrameAbmProv().dispose();
						}
					}	
				}
			});
		}
		
		return jButtonAbmProvModificar;
	}
	
	private JButton getJButtonAbmProvQuitar(){
		if(jButtonAbmProvQuitar == null){
			jButtonAbmProvQuitar = new JButton();
			jButtonAbmProvQuitar.setText("Quitar");
			jButtonAbmProvQuitar.setBounds(435, 169, 141, 46);
			jButtonAbmProvQuitar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Verifico si no hay nada seleccionado
					if(lsm == null){
						JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_SELECT_ITEM)), "Error al quitar Proveedor", JOptionPane.ERROR_MESSAGE);
					}else{
						auxLisNom = proveedores.get(lsm.getAnchorSelectionIndex()).getNombreProveedor();
						contProvAux = proveedores.size();
						if(proveedores.size() > 0  ){
							Iterator<voProveedor> it = proveedores.iterator();
							while(it.hasNext() ){
								voProveedor prov = it.next();
								if(prov.getNombreProveedor().equalsIgnoreCase(auxLisNom) ){
									//System.out.println("nom:" + fam.getNombreFamilia().toString());
									int ax = JOptionPane.showConfirmDialog(null, "Seguro que desea borrar la "+ prov.getNombreProveedor());
									if(ax == JOptionPane.YES_OPTION){
										controlProveedor.borrarProveedor(prov);
										actualizar();
									}		
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_SELECT_ITEM)), "Error al quitar Proveedor", JOptionPane.ERROR_MESSAGE);
						}
					}	
				}	
			});	
		}
		return jButtonAbmProvQuitar;
	}
	
	private JButton getJButtonAbmProvNueva(){
		if(jButtonAbmProvNueva == null){
			jButtonAbmProvNueva = new JButton();
			jButtonAbmProvNueva.setText("Nuevo");
			jButtonAbmProvNueva.setBounds(435, 169, 141, 46);
			jButtonAbmProvNueva.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					controlProveedor.ventCrearProveedor();
				}
			});
		}
		return jButtonAbmProvNueva;
	}
	
	private JButton getJButtonAbmProvDetalle(){
		if(JButtonAbmProvDetalle == null){
			JButtonAbmProvDetalle= new JButton();
			JButtonAbmProvDetalle.setText("Detalle");
			JButtonAbmProvDetalle.setBounds(435, 169, 141, 46);
			JButtonAbmProvDetalle.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					auxLisNom = proveedores.get(lsm.getAnchorSelectionIndex()).getNombreProveedor();
					contProvAux = proveedores.size();
					if(proveedores.size() > 0  ){
						Iterator<voProveedor> it = proveedores.iterator();
						while(it.hasNext() ){
							voProveedor prov = it.next();
							if(prov.getNombreProveedor().equalsIgnoreCase(auxLisNom) ){
								System.out.println("nom:" + prov.getIdProveedor());
									controlProveedor.ventCrearProveedorDet(4,prov.getIdProveedor());
									getJFrameAbmProv().dispose();
							}
						}	
					}else{
						JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_SELECT_ITEM)), "Error al desplegar la pantalla de Detalles", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return JButtonAbmProvDetalle;
	}
	
	private JButton getJButtonAbmProvCancelar(){
		if(jButtonAbmProvCancelar == null){
			jButtonAbmProvCancelar = new JButton();
			jButtonAbmProvCancelar.setText("Cancelar");
			jButtonAbmProvCancelar.setBounds(435, 169, 141, 46);
			jButtonAbmProvCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaAbmProveedor.this.jFrameAbmProv.dispose();
				}
			});
		}
		return jButtonAbmProvCancelar;
	}
	
	private void actualizar(){
		try {
			proveedores = controlProveedor.listarProveedores();
			if(contProvAux-1 == proveedores.size()){
				new ventanaAbmProveedor();
				jFrameAbmProv.dispose();
			}	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) { 
            if (lsm==null){
            	lsm = (ListSelectionModel)e.getSource();
            	System.out.println("Valor: " + proveedores.get(lsm.getAnchorSelectionIndex()).getNombreProveedor() +" i: "+lsm.getAnchorSelectionIndex());
            }
            /* Utilizado para ver los indices.
            int firstIndex = e.getFirstIndex();
            int lastIndex = e.getLastIndex();
            boolean isAdjusting = e.getValueIsAdjusting(); 
            System.out.println("Event for indexes " + firstIndex + " - " + lastIndex + "; isAdjusting is " + isAdjusting + "; selected indexes:");
            System.out.println("LSM: " +lsm.getAnchorSelectionIndex());
            */
        }
    }

}
