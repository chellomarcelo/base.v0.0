package grafica.ventanas.Modulo1;


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

import grafica.controladores.Modulo1.controladorAbmFamilia;
import logica.excepciones.ExcFamilia;
import logica.excepciones.ExcProducto;
import logica.vo.voFamilia;

public class ventanaAbmFamilia   {

	private JFrame jFrameLisFam = null;  //  @jve:decl-index=0:visual-constraint="135,23"
	private JPanel jContentPaneLisFam = null;
	private JList jListLisFam = new JList();
	private JLabel jLabelLisFam = null;
	private JButton jButtonLisFamModificar = null;
	private JButton jButtonLisFamQuitar = null;
	private JButton jButtonLisFamNueva = null;
	private JButton jButtonLisFamCancelar = null;
	private controladorAbmFamilia	controlFamilia;
	private DefaultListModel modelo;/*declaramos el Modelo*/
	private JScrollPane scrollLista;  //  @jve:decl-index=0:visual-constraint="609,41"
	private ArrayList<voFamilia> familias = null;
	private JButton jButtonRefresh = null;
	private int idx;
	private String auxLisNom;
	
	public ventanaAbmFamilia () throws Exception{
		controlFamilia = new controladorAbmFamilia(this);
		familias = controlFamilia.listarFamilias();
		jFrameLisFam = getJFrameLisFam();
		jFrameLisFam.setVisible(true);
		jFrameLisFam.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jFrameLisFam	
	 * 	
	 * @return javax.swing.JFrame	
	 * @throws Exception 
	 */
	private JFrame getJFrameLisFam() throws Exception {
		if (jFrameLisFam == null) {
			jFrameLisFam = new JFrame();
			jFrameLisFam.setSize(464,275);
			jFrameLisFam.setTitle("Listar Familias");
			jFrameLisFam.setContentPane(getJContentPaneLisFam());
			jFrameLisFam.setResizable(false);
		}
		return jFrameLisFam;
	}

	/**
	 * This method initializes jContentPaneLisFam	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws Exception 
	 */
	private JPanel getJContentPaneLisFam() throws Exception {
		if (jContentPaneLisFam == null) {
			jContentPaneLisFam = new JPanel();
			jContentPaneLisFam.setLayout(null);
			
			jContentPaneLisFam.add(getJLabelFamTitulo(), null);
			jContentPaneLisFam.add(getJScrollLisFam(), java.awt.BorderLayout.NORTH);
			jContentPaneLisFam.add(getJButtonLisFamModificar(), null);
			jContentPaneLisFam.add(getJButtonLisFamQuitar(), null);
			jContentPaneLisFam.add(getJButtonLisFamNueva(), null);
			jContentPaneLisFam.add(getJButtonLisFamCancelar(), null);
			jContentPaneLisFam.add(getJButtonRefresh(), null);
		}
		return jContentPaneLisFam;
	}
	
	private JLabel getJLabelFamTitulo() {
		if (jLabelLisFam == null) {
			jLabelLisFam = new JLabel();
			jLabelLisFam.setBounds(new java.awt.Rectangle(15,12,230,23));
			jLabelLisFam.setFont(new java.awt.Font("Goudy Old Style", java.awt.Font.BOLD, 20));
			jLabelLisFam.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
			jLabelLisFam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabelLisFam.setText("Familias");	
		}
		return jLabelLisFam;
	}
	
	private JScrollPane getJScrollLisFam() throws Exception {
		
		if (scrollLista == null) {
			scrollLista = new JScrollPane();
			scrollLista.setViewportView(getJListLisFam());
			scrollLista.setBounds(new java.awt.Rectangle(7,40,240,190));
		}
		return scrollLista;
	}
	
	/**
	 * This method initializes jListLisFam	
	 * 	
	 * @return javax.swing.JList	
	 * @throws Exception 
	 */
	private JList getJListLisFam() throws Exception {
			//jListLisFam = new JList();
			jListLisFam.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			jListLisFam.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
			actualizar();
		return jListLisFam;
	}

	/**
	 * This method initializes jButtonLisFam	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLisFamModificar() {
		if (jButtonLisFamModificar == null) {
			jButtonLisFamModificar = new JButton();
			jButtonLisFamModificar.setBounds(new java.awt.Rectangle(258,118,175,30));
			jButtonLisFamModificar.setText("Modificar");
			jButtonLisFamModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("aux"+auxLisNom);
					controlFamilia.ventModFamilia(auxLisNom);
				}
			});
		}
		return jButtonLisFamModificar;
	}

	/**
	 * This method initializes jButtonLisFamQuitar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLisFamQuitar() {
		if (jButtonLisFamQuitar == null) {
			jButtonLisFamQuitar = new JButton();
			jButtonLisFamQuitar.setBounds(new java.awt.Rectangle(258,158,175,30));
			jButtonLisFamQuitar.setText("Quitar");
			jButtonLisFamQuitar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("poner como seleccionar de la list y borrar");
					System.out.println("Current selection: " + idx);
					System.out.println("aux"+auxLisNom);
					if (auxLisNom!= null){
						if(familias.size() > 0  ){
							Iterator<voFamilia> it = familias.iterator();
							while(it.hasNext() ){
								voFamilia fam = it.next();
								if(fam.getNombreFamilia().equalsIgnoreCase(auxLisNom) ){
									//System.out.println("nom:" + fam.getNombreFamilia().toString());
									int ax = JOptionPane.showConfirmDialog(null, "Seguro que desea borrar la "+fam.getNombreFamilia());
							        if(ax == JOptionPane.YES_OPTION)
							        	controlFamilia.borrarFamilia(fam);
								}
							}
						}	
					}else{
						JOptionPane.showMessageDialog(null, (new ExcFamilia(ExcFamilia.ERROR_SELECT_ITEM)), "Error al quitar Familia", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return jButtonLisFamQuitar;
	}

	/**
	 * This method initializes jButtonLisFamNueva	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLisFamNueva() {
		if (jButtonLisFamNueva == null) {
			jButtonLisFamNueva = new JButton();
			jButtonLisFamNueva.setBounds(new java.awt.Rectangle(258,78,175,30));
			jButtonLisFamNueva.setText("Nueva Familia");
			jButtonLisFamNueva.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					controlFamilia.ventCrearFamilia();
				}
			});
		
		}
		return jButtonLisFamNueva;
	}

	/**
	 * This method initializes jButtonLisFamCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLisFamCancelar() {
		if (jButtonLisFamCancelar == null) {
			jButtonLisFamCancelar = new JButton();
			jButtonLisFamCancelar.setBounds(new java.awt.Rectangle(258,198,175,30));
			jButtonLisFamCancelar.setText("Cancelar");
			jButtonLisFamCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ventanaAbmFamilia.this.jFrameLisFam.dispose();
				}
			});
		}
		return jButtonLisFamCancelar;
	}

	/**
	 * This method initializes jButtonRefresh	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRefresh() {
		if (jButtonRefresh == null) {
			jButtonRefresh = new JButton();
			jButtonRefresh.setBounds(new java.awt.Rectangle(258,40,175,30));
			jButtonRefresh.setText("Actualizar Pantalla");
			jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						actualizar();
						jFrameLisFam = getJFrameLisFam();
						jFrameLisFam.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					System.out.println("Tam familias:" +familias.size());
				}
			});
		}
		return jButtonRefresh;
	}
	
	public void actualizar() {
			try {
				familias = controlFamilia.listarFamilias();
				if(modelo==null){
					modelo= new DefaultListModel();
				}
			
				modelo.removeAllElements();
				jListLisFam.removeAll();
				if(familias.size() > 0  ){
					jListLisFam.setListData(familias.toArray());
					Iterator<voFamilia> it = familias.iterator();
					while(it.hasNext()){
						voFamilia fam = it.next();
						modelo.addElement(fam.getNombreFamilia());
						jListLisFam.setModel(modelo);
					}	
					System.out.println("finalizo");	
				}
				jListLisFam.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				//Lo dejo siempre escuchando.
				jListLisFam.addListSelectionListener(new ListSelectionListener() {
				      public void valueChanged(ListSelectionEvent le) {
				        idx = jListLisFam.getSelectedIndex();
				        auxLisNom = (String) jListLisFam.getSelectedValue();	
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
				try {
					throw new Exception((new ExcFamilia(ExcFamilia.ERROR_AL_LISTAR)));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Error en la excepción");
					e1.printStackTrace();
				}
			}
		}
	public void setVisible(boolean _estado){
		this.setVisible(_estado);	
	}
}  //  @jve:decl-index=0:visual-constraint="609,10"
