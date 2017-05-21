package test.descontinuados;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.dnd.Autoscroll;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controladores.Modulo1.Modulo1.Modulo1.Modulo1.controladorAbmProveedor;
import logica.excepciones.ExcProveedores;
import logica.vo.voProveedor;
import javax.swing.JTable;


public class ventanaListarProveedor   {

	private JFrame jFrameLisProv = null;  //  @jve:decl-index=0:visual-constraint="63,23"
	private JPanel jContentPaneLisProv= null;
	private JList jListLisProv= new JList();
	private JLabel jLabelLisProv= null;
	private JButton jButtonLisProvModificar = null;
	private JButton jButtonLisProvQuitar = null;
	private JButton jButtonLisProvNueva = null;
	private JButton jButtonLisProvCancelar = null;
	private controladorAbmProveedor controlProveedor;
	private DefaultListModel modelo;/*declaramos el Modelo*/
	private JScrollPane scrollLista;  //  @jve:decl-index=0:visual-constraint="609,41"
	private ArrayList<voProveedor> proveedores = null;
	private JButton jButtonRefresh = null;
	private int idx;
	private String auxLisNom;
	private JScrollPane jScrollPaneGrilla = null;
	private JTable jTableGrilla = null;
	private ListSelectionModel listSelectionModel;
	private int firstIndex;
	
	public ventanaListarProveedor () throws Exception{
		//REalice el cambio por el abm
		controlProveedor = new controladorAbmProveedor(this);
		proveedores = controlProveedor.listarProveedores();
		jFrameLisProv = getJFrameLisProv();
		jFrameLisProv.setVisible(true);
		jFrameLisProv.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jFrameLisFam	
	 * 	
	 * @return javax.swing.JFrame	
	 * @throws Exception 
	 */
	private JFrame getJFrameLisProv() throws Exception {
		if (jFrameLisProv== null) {
			jFrameLisProv= new JFrame();
			jFrameLisProv.setSize(980, 293);
			jFrameLisProv.setTitle("Listar Proveedores");
			jFrameLisProv.setContentPane(getJContentPaneLisProv());
			jFrameLisProv.setResizable(false);
					
		}
		return jFrameLisProv;
	}

	/**
	 * This method initializes jContentPaneLisFam	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws Exception 
	 */
	private JPanel getJContentPaneLisProv() throws Exception {
		if (jContentPaneLisProv == null) {
			jContentPaneLisProv = new JPanel();
			jContentPaneLisProv.setLayout(null);
			
			jContentPaneLisProv.add(getJLabelProvTitulo(), null);
			//jContentPaneLisProv.add(getJScrollLisProv(), java.awt.BorderLayout.NORTH);
			jContentPaneLisProv.add(getJButtonLisProvModificar(), null);
			jContentPaneLisProv.add(getJButtonLisProvQuitar(), null);
			jContentPaneLisProv.add(getJButtonLisProvNueva(), null);
			jContentPaneLisProv.add(getJButtonLisProvCancelar(), null);
			jContentPaneLisProv.add(getJButtonRefresh(), null);
			jContentPaneLisProv.add(getJScrollPaneGrilla(), null);
		}
		return jContentPaneLisProv;
	}
	
	private JLabel getJLabelProvTitulo() {
		if (jLabelLisProv== null) {
			jLabelLisProv= new JLabel();
			jLabelLisProv.setBounds(new java.awt.Rectangle(15,12,230,23));
			jLabelLisProv.setFont(new java.awt.Font("Goudy Old Style", java.awt.Font.BOLD, 20));
			jLabelLisProv.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
			jLabelLisProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabelLisProv.setText("Proveedores");	
		}
		return jLabelLisProv;
	}
	/*
	private JScrollPane getJScrollLisProv() throws Exception {
		
		if (scrollLista == null) {
			scrollLista = new JScrollPane();
			scrollLista.setViewportView(getJListLisProv());
			scrollLista.setBounds(new java.awt.Rectangle(7,40,240,190));
		}
		return scrollLista;
	}*/
	
	/**
	 * This method initializes jListLisProv
	 * 	
	 * @return javax.swing.JList	
	 * @throws Exception 
	 */
	private JList getJListLisProv() throws Exception {
			//jListLisFam = new JList();
			jListLisProv.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			jListLisProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
			actualizar();
		return jListLisProv;
	}

	/**
	 * This method initializes jButtonLisProv
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLisProvModificar() {
		if (jButtonLisProvModificar == null) {
			jButtonLisProvModificar = new JButton();
			jButtonLisProvModificar.setBounds(new java.awt.Rectangle(767,113,175,30));
			jButtonLisProvModificar.setText("Modificar");
			jButtonLisProvModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("aux"+auxLisNom);
					controlProveedor.ventModProveedor(auxLisNom);
				}
			});
		}
		return jButtonLisProvModificar;
	}

	/**
	 * This method initializes jButtonLisFamQuitar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLisProvQuitar() {
		if (jButtonLisProvQuitar == null) {
			jButtonLisProvQuitar = new JButton();
			jButtonLisProvQuitar.setBounds(new java.awt.Rectangle(767,153,175,30));
			jButtonLisProvQuitar.setText("Quitar");
			jButtonLisProvQuitar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					auxLisNom = proveedores.get(firstIndex).getNombreProveedor();
					System.out.println("aux"+auxLisNom);
					if (auxLisNom!= null){
						if(proveedores.size() > 0  ){
							Iterator<voProveedor> it = proveedores.iterator();
							while(it.hasNext() ){
								voProveedor prov = it.next();
								if(prov.getNombreProveedor().equalsIgnoreCase(auxLisNom) ){
									//System.out.println("nom:" + fam.getNombreFamilia().toString());
									int ax = JOptionPane.showConfirmDialog(null, "Seguro que desea borrar la "+ prov.getNombreProveedor());
							        if(ax == JOptionPane.YES_OPTION)
							        	controlProveedor.borrarProveedor(prov);
								}
							}
						}	
					}else{
						JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_SELECT_ITEM)), "Error al quitar Proveedor", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return jButtonLisProvQuitar;
	}

	/**
	 * This method initializes jButtonLisProvNueva	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLisProvNueva() {
		if (jButtonLisProvNueva == null) {
			jButtonLisProvNueva = new JButton();
			jButtonLisProvNueva.setBounds(new java.awt.Rectangle(767,73,175,30));
			jButtonLisProvNueva.setText("Nuevo Proveedor");
			jButtonLisProvNueva.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					controlProveedor.ventCrearProveedor();
				}
			});
		
		}
		return jButtonLisProvNueva;
	}

	/**
	 * This method initializes jButtonLisProvCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLisProvCancelar() {
		if (jButtonLisProvCancelar == null) {
			jButtonLisProvCancelar = new JButton();
			jButtonLisProvCancelar.setBounds(new java.awt.Rectangle(767,193,175,30));
			jButtonLisProvCancelar.setText("Cancelar");
			jButtonLisProvCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaListarProveedor.this.jFrameLisProv.dispose();
				}
			});
		}
		return jButtonLisProvCancelar;
	}

	/**
	 * This method initializes jButtonRefresh	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRefresh() {
		if (jButtonRefresh == null) {
			jButtonRefresh = new JButton();
			jButtonRefresh.setBounds(new java.awt.Rectangle(767,35,175,30));
			jButtonRefresh.setText("Actualizar Pantalla");
			jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						actualizar();
						jFrameLisProv = getJFrameLisProv();
						jFrameLisProv.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					System.out.println("Tam proveedores:" +proveedores.size());
				}
			});
		}
		return jButtonRefresh;
	}
	
	public void actualizar() {
			try {
				proveedores = controlProveedor.listarProveedores();
				if(modelo==null){
					modelo= new DefaultListModel();
				}
			
				modelo.removeAllElements();
				jListLisProv.removeAll();
				if(proveedores.size() > 0  ){
					jListLisProv.setListData(proveedores.toArray());
					Iterator<voProveedor> it = proveedores.iterator();
					while(it.hasNext()){
						voProveedor prov = it.next();
						modelo.addElement(prov.getNombreProveedor());
						jListLisProv.setModel(modelo);
					}	
					System.out.println("finalizo");	
				}
				jListLisProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				//Lo dejo siempre escuchando.
				jListLisProv.addListSelectionListener(new ListSelectionListener() {
				      public void valueChanged(ListSelectionEvent le) {
				        idx = jListLisProv.getSelectedIndex();
				        auxLisNom = (String) jListLisProv.getSelectedValue();	
				        /*//Eso es para ver si toma correctamente el indice
				        if (idx != -1)
				          System.out.println("Current selection: " + idx);
				        else
				          System.out.println("Please choose a language.");
				        */
				      }
				      
				 });
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				System.out.println(e.getCause());
				JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_AL_LISTAR)), "Error al Listar", JOptionPane.ERROR_MESSAGE);
			}
		}

	/**
	 * This method initializes jScrollPaneGrilla	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneGrilla() {
		if (jScrollPaneGrilla == null) {
			jScrollPaneGrilla = new JScrollPane(getJTableGrilla());
			jScrollPaneGrilla.setBounds(new java.awt.Rectangle(20,38,455,198));
			jScrollPaneGrilla.setViewportView(getJTableGrilla());
		}
		return jScrollPaneGrilla;
	}

	/**
	 * This method initializes jTableGrilla	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableGrilla() {
		if (jTableGrilla == null) { 
			jTableGrilla = new JTable(controlProveedor.CargarModelo());
			jTableGrilla.getColumnModel().getColumn(0).setPreferredWidth(1);
			

			listSelectionModel = jTableGrilla.getSelectionModel();
	        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
	        jTableGrilla.setSelectionModel(listSelectionModel);
		}
		return jTableGrilla;
	}
	
	class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) { 
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();

            firstIndex = e.getFirstIndex();
            int lastIndex = e.getLastIndex();
            boolean isAdjusting = e.getValueIsAdjusting(); 
            System.out.println("Event for indexes " + firstIndex + " - " + lastIndex + "; isAdjusting is " + isAdjusting + "; selected indexes:");
            System.out.println("Valor " + proveedores.get(firstIndex).getNombreProveedor());
        
        }
    }
	
	
	
	
}  
