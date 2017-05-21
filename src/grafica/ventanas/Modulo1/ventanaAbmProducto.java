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
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import grafica.controladores.Modulo1.controladorAbmProducto;
import logica.excepciones.ExcProveedores;
import logica.excepciones.ExcepcionesGeneral;
import logica.vo.voProducto;

public class ventanaAbmProducto {

	private JFrame jFrameAbmProd = null;  //  @jve:decl-index=0:visual-constraint="48,16"
	private JPanel jContentPaneAbmProd = null;
	private JSplitPane jSplitPaneabmProd = null;
	private JPanel jPanelabmProdTop = null;
	private JPanel JPanelabmProdBot = null;
	private JPanel jPanelTableContainer = null;
	private JScrollPane JScroolTababmProd = null; 
	private JTable table= null ;
	private JButton jButtonabmProdModificar = null;
	private JButton jButtonabmProdQuitar = null;
	private JButton jButtonabmProdNueva = null;
	private JButton jButtonabmProdCancelar = null;
 	private JButton JButtonabmProdDetalle = null;
	private ListSelectionModel listSelectionModel;
 	private controladorAbmProducto controlProducto;
	private ArrayList<voProducto> productos = null;
 	private ListSelectionModel lsm = null;
 	private String auxLisNom="";
 	private String auxNomProd="";
 	private int contProvAux = 0;
	
    public  ventanaAbmProducto() throws Exception{
		controlProducto = new controladorAbmProducto(this);
		productos = controlProducto.listarProductos();
		contProvAux = productos.size();
		jFrameAbmProd = getJFrameabmProd();
		jFrameAbmProd.setVisible(true);
		jFrameAbmProd.setLocationRelativeTo(null);
	}
 	
 	/***
 	 *	Diseño
 	 *	Jframe
 	 *		->  jContentPaneabmProd    								controlPane
 	 *				->	jSplitPaneabmProd
 	 *						-> jPanelabmProdTop
 	 *							->jPanelTableContainer
 	 *								->JScroolTababmProd
 	 *									-> 	table	
 	 *						-> jPanelabmProdTop
 	 *							-> Jpanel	
 	 *
 	 */
 		
 	
	/**
	 * This method initializes jFrameabmProd	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrameabmProd() {
		if (jFrameAbmProd == null) {
			jFrameAbmProd = new JFrame();
			jFrameAbmProd.setSize(new Dimension(jFrameAbmProd.getToolkit().getScreenSize()));
			jFrameAbmProd.setContentPane(getJContentPaneabmProd());
			jFrameAbmProd.setTitle("Alta, Baja y Modificación de Productos");
			jFrameAbmProd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		return jFrameAbmProd;
	}

	/**
	 * This method initializes jContentPaneabmProd	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneabmProd() {
		if (jContentPaneAbmProd == null) {
			jContentPaneAbmProd = new JPanel();
			jContentPaneAbmProd.setLayout(new BoxLayout(getJContentPaneabmProd(), BoxLayout.X_AXIS));
			jContentPaneAbmProd.add(getJSplitPaneabmProd(), BorderLayout.CENTER);
			
		}
		return jContentPaneAbmProd;
	}

	/**
	 * This method initializes jSplitPaneabmProd	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPaneabmProd() {
		if (jSplitPaneabmProd == null) {
			jSplitPaneabmProd = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			jSplitPaneabmProd.add(getJPanelabmProdTop());
			jSplitPaneabmProd.add(getJPanelabmProdBot());
		}
		return jSplitPaneabmProd;
	}

	/**
	 * This method initializes jPanelabmProdTop	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelabmProdTop() {
		if (jPanelabmProdTop == null) {
			jPanelabmProdTop = new JPanel();
			jPanelabmProdTop.setLayout(new BoxLayout(jPanelabmProdTop, BoxLayout.LINE_AXIS));
			jPanelabmProdTop.setBorder(BorderFactory.createEmptyBorder(5,5,0,5));
			jPanelabmProdTop.setMinimumSize(new Dimension(800, 600));
			jPanelabmProdTop.setPreferredSize(new Dimension(800, 600));
			jPanelabmProdTop.add(getJPanelTableContainer());
		}
		return jPanelabmProdTop;
	}
	
	//JPanel bottom
	private JPanel getJPanelabmProdBot() {
		if (JPanelabmProdBot == null) {
			JPanelabmProdBot = new JPanel();
			JPanelabmProdBot.setLayout(new GridLayout(1,5));
			JPanelabmProdBot.setBorder(BorderFactory.createEmptyBorder(5,5,0,5));
			JPanelabmProdBot.setMaximumSize(new Dimension(100, 100));
			JPanelabmProdBot.setPreferredSize(new Dimension(100, 100));
			JPanelabmProdBot.add(getJButtonabmProdNueva());
			JPanelabmProdBot.add(getJButtonabmProdModificar());
			JPanelabmProdBot.add(getJButtonabmProdQuitar());
			JPanelabmProdBot.add(getJButtonabmProdDetalle());
			JPanelabmProdBot.add(getJButtonabmProdCancelar());
			
		}
		return JPanelabmProdBot;
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
			jPanelTableContainer.add(getJScrollPaneabmProd());
		}
		return jPanelTableContainer;
	}
	
	private JScrollPane getJScrollPaneabmProd(){
		if(JScroolTababmProd == null){
			JScroolTababmProd = new JScrollPane(getJTableabmProd());

			/*System.out.println(	" \n --------------Frame---------------------\n"+
								"H: " + jFrameabmProd.getHeight()+
								" W: " + jFrameabmProd.getWidth()+
								" Size:" + jFrameabmProd.getPreferredSize()+
								" Bound W" + jFrameabmProd.getBounds().getWidth()+
								" Bound H" + jFrameabmProd.getBounds().getHeight()+
								" \n --------------JPanel 1---------------------\n"+
								"H: " +jContentPaneabmProd.getHeight() +
								" W: " + jContentPaneabmProd.getWidth()+
								" Size:" + jContentPaneabmProd.getPreferredSize()+
								" \n -------------jSplitPaneabmProd-------------\n"+
								" Divider: " +jSplitPaneabmProd.getDividerSize()+
								" H: " + jSplitPaneabmProd.getHeight()+
								" W: " + jSplitPaneabmProd.getWidth()+
								" Resize" + jSplitPaneabmProd.getResizeWeight()+
								" \n -------------jPanelabmProdTop-------------\n"+
								"H:" +jPanelabmProdTop.getHeight()+ 
								" W:"+ jPanelabmProdTop.getWidth()+ 
								" Min: "+ jPanelabmProdTop.getMinimumSize()+ 
								" Max:" + jPanelabmProdTop.getMaximumSize()+
								" \n --------------Scroll---------------------\n"+
								"V: " + JScroolTababmProd.getViewport().getViewSize()+
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
		return JScroolTababmProd;
	}
	
	private JTable getJTableabmProd(){
		if (table == null){
				table = new JTable(controlProducto.CargarModelo());
				listSelectionModel = table.getSelectionModel();
		        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
				table.setSelectionModel(listSelectionModel);
				table.setRowHeight(80);
				 DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
			     modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
			     for (int i=0;i<table.getColumnCount()-1;i++)
			    	 table.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
		}
		
		return table;
	}
	
	private JButton getJButtonabmProdModificar (){
		if(jButtonabmProdModificar == null){
			jButtonabmProdModificar = new JButton();
			jButtonabmProdModificar.setText("Modificar");
			jButtonabmProdModificar.setBounds(435, 169, 141, 46);
			jButtonabmProdModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("aux"+auxNomProd);
					if(lsm==null){
						JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.MODIFICACIONES)), "Modificación Proveedor", JOptionPane.INFORMATION_MESSAGE);
					}else{						
						auxNomProd = productos.get(lsm.getAnchorSelectionIndex()).getNombreProducto();
						contProvAux = productos.size();
						if(!auxNomProd.isEmpty()){
							controlProducto.ventModProducto(auxNomProd);
							getJFrameabmProd().dispose();
						}
					}	
				}
			});
		}
		
		return jButtonabmProdModificar;
	}
	
	private JButton getJButtonabmProdQuitar(){
		if(jButtonabmProdQuitar == null){
			jButtonabmProdQuitar = new JButton();
			jButtonabmProdQuitar.setText("Quitar");
			jButtonabmProdQuitar.setBounds(435, 169, 141, 46);
			jButtonabmProdQuitar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Verifico si no hay nada seleccionado
					if(lsm == null){
						JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_SELECT_ITEM)), "Error al quitar Proveedor", JOptionPane.ERROR_MESSAGE);
					}else{
						auxLisNom = productos.get(lsm.getAnchorSelectionIndex()).getNombreProducto();
						contProvAux = productos.size();
						if(productos.size() > 0  ){
							Iterator<voProducto> it = productos.iterator();
							while(it.hasNext() ){
								voProducto prov = it.next();
								if(prov.getNombreProducto().equalsIgnoreCase(auxLisNom) ){
									//System.out.println("nom:" + fam.getNombreFamilia().toString());
									int ax = JOptionPane.showConfirmDialog(null, "Seguro que desea borrar la "+ prov.getNombreProducto());
									if(ax == JOptionPane.YES_OPTION){
										controlProducto.borrarProducto(prov);
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
		return jButtonabmProdQuitar;
	}
	
	private JButton getJButtonabmProdNueva(){
		if(jButtonabmProdNueva == null){
			jButtonabmProdNueva = new JButton();
			jButtonabmProdNueva.setText("Nuevo");
			jButtonabmProdNueva.setBounds(435, 169, 141, 46);
			jButtonabmProdNueva.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					controlProducto.ventCrearProducto();
					getJFrameabmProd().dispose();

				}
			});
		}
		return jButtonabmProdNueva;
	}
	
	private JButton getJButtonabmProdDetalle(){
		if(JButtonabmProdDetalle == null){
			JButtonabmProdDetalle= new JButton();
			JButtonabmProdDetalle.setText("Detalle");
			JButtonabmProdDetalle.setBounds(435, 169, 141, 46);
			JButtonabmProdDetalle.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					auxLisNom = productos.get(lsm.getAnchorSelectionIndex()).getNombreProducto();
					contProvAux = productos.size();
					if(productos.size() > 0  ){
						Iterator<voProducto> it = productos.iterator();
						while(it.hasNext() ){
							voProducto prov = it.next();
							
							if(prov.getNombreProducto().equalsIgnoreCase(auxLisNom) ){
								System.out.println("nom:" + prov.getIdProveedor());
									controlProducto.ventCrearProductoDet(4,prov.getNombreProducto());
									getJFrameabmProd().dispose();
							}
						}	
					}else{
						JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_SELECT_ITEM)), "Error al desplegar la pantalla de Detalles", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return JButtonabmProdDetalle;
	}
	
	private JButton getJButtonabmProdCancelar(){
		if(jButtonabmProdCancelar == null){
			jButtonabmProdCancelar = new JButton();
			jButtonabmProdCancelar.setText("Cancelar");
			jButtonabmProdCancelar.setBounds(435, 169, 141, 46);
			jButtonabmProdCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaAbmProducto.this.jFrameAbmProd.dispose();
				}
			});
		}
		return jButtonabmProdCancelar;
	}
	
	private void actualizar(){
		try {
			//proveedores = controlProveedor.listarProveedores();
			productos = controlProducto.listarProductos();
			if(contProvAux-1 == productos.size()){
				new ventanaAbmProducto();
				jFrameAbmProd.dispose();
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
            	System.out.println("Valor: " + productos.get(lsm.getAnchorSelectionIndex()).getNombreProducto() +" i: "+lsm.getAnchorSelectionIndex());
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
