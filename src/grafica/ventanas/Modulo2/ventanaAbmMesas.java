package grafica.ventanas.Modulo2;


import java.sql.SQLException;
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

import grafica.controladores.Modulo2.controladorAbmMesas;
import logica.Modulo2.excepciones.ExcMesa;
import logica.Modulo2.vo.voMesa;
import java.awt.Rectangle;

public class ventanaAbmMesas   {

	private JFrame jFrameLisMes = null;  //  @jve:decl-index=0:visual-constraint="135,23"
	private JPanel jContentPaneLisMes = null;
	private JList jListLisMes = new JList();
	private JLabel jLabelLisMes = null;
	//private JButton jButtonLisMesModificar = null;
	private JButton jButtonLisMesQuitar = null;
	private JButton jButtonLisMesNueva = null;
	private controladorAbmMesas	controlMesa;
	private DefaultListModel modelo;/*declaramos el Modelo*/
	private JScrollPane scrollLista;  //  @jve:decl-index=0:visual-constraint="609,41"
	private ArrayList<voMesa> mesas = null;
	private int idx=0;
	private int auxLisNom;
	
	public ventanaAbmMesas () throws Exception{
		controlMesa = new controladorAbmMesas(this);
		mesas = controlMesa.listarMesas();
		jFrameLisMes = getjFrameLisMes();
		jFrameLisMes.setVisible(true);
		jFrameLisMes.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jFrameLisMes	
	 * 	
	 * @return javax.swing.JFrame	
	 * @throws Exception 
	 */
	private JFrame getjFrameLisMes() throws Exception {
		if (jFrameLisMes == null) {
			jFrameLisMes = new JFrame();
			jFrameLisMes.setSize(464,275);
			jFrameLisMes.setTitle("Configuracion Mesas");
			jFrameLisMes.setContentPane(getjContentPaneLisMes());
			jFrameLisMes.setResizable(false);
		}
		return jFrameLisMes;
	}

	/**
	 * This method initializes jContentPaneLisMes	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws Exception 
	 */
	private JPanel getjContentPaneLisMes() throws Exception {
		if (jContentPaneLisMes == null) {
			jContentPaneLisMes = new JPanel();
			jContentPaneLisMes.setLayout(null);
			
			jContentPaneLisMes.add(getJLabelMesTitulo(), null);
			jContentPaneLisMes.add(getJScrollLisMes(), java.awt.BorderLayout.NORTH);
			//jContentPaneLisMes.add(getjButtonLisMesModificar(), null);
			jContentPaneLisMes.add(getjButtonLisMesQuitar(), null);
			jContentPaneLisMes.add(getjButtonLisMesNueva(), null);
		}
		return jContentPaneLisMes;
	}
	
	private JLabel getJLabelMesTitulo() {
		if (jLabelLisMes == null) {
			jLabelLisMes = new JLabel();
			jLabelLisMes.setBounds(new java.awt.Rectangle(15,12,230,23));
			jLabelLisMes.setFont(new java.awt.Font("Goudy Old Style", java.awt.Font.BOLD, 20));
			jLabelLisMes.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
			jLabelLisMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabelLisMes.setText("Mesas");	
		}
		return jLabelLisMes;
	}
	
	private JScrollPane getJScrollLisMes() throws Exception {
		
		if (scrollLista == null) {
			scrollLista = new JScrollPane();
			scrollLista.setViewportView(getJListLisMes());
			scrollLista.setBounds(new java.awt.Rectangle(7,40,240,190));
		}
		return scrollLista;
	}
	
	/**
	 * This method initializes jListLisMes	
	 * 	
	 * @return javax.swing.JList	
	 * @throws Exception 
	 */
	private JList getJListLisMes() throws Exception {
			//jListLisMes = new JList();
			jListLisMes.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			jListLisMes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
			actualizar();
			//Lo dejo siempre escuchando.
			jListLisMes.addListSelectionListener(new ListSelectionListener() {
			      public void valueChanged(ListSelectionEvent le) {
			        idx = jListLisMes.getSelectedIndex();
			        System.out.println("Variable idx: "+ idx);
			        if(idx>=0) {
			        	auxLisNom = (Integer) jListLisMes.getSelectedValue();	
			        	System.out.println("Variable auxLisNom: "+auxLisNom);
			        }	
			      }
			      
			 });
		return jListLisMes;
	}

	/**
	 * This method initializes jButtonLisMes	
	 * @return javax.swing.JButton	
	 */
	/*private JButton getjButtonLisMesModificar() {
		if (jButtonLisMesModificar == null) {
			jButtonLisMesModificar = new JButton();
			jButtonLisMesModificar.setBounds(new Rectangle(257, 122, 175, 30));
			jButtonLisMesModificar.setText("Modificar");
			jButtonLisMesModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("aux"+auxLisNom);
					//controlMesa.ventModMesa(auxLisNom);
				}
			});
		}
		return jButtonLisMesModificar;
	}*/

	/**
	 * This method initializes jButtonLisMesQuitar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getjButtonLisMesQuitar() {
		if (jButtonLisMesQuitar == null) {
			jButtonLisMesQuitar = new JButton();
			jButtonLisMesQuitar.setBounds(new Rectangle(257, 81, 175, 30));
			jButtonLisMesQuitar.setText("Quitar");
			
			jButtonLisMesQuitar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("poner como seleccionar de la list y borrar");
					System.out.println("Current selection: " + idx);
					System.out.println("aux"+auxLisNom);
					if (auxLisNom >= 0){
						if(mesas.size() > 0  ){
							Iterator<voMesa> it = mesas.iterator();
							while(it.hasNext() ){
								voMesa mes = it.next();
								if(mes.getIdMesa()==auxLisNom){
									int ax = JOptionPane.showConfirmDialog(null, "Seguro que desea borrar la mesa "+mes.getIdMesa());
							        if(ax == JOptionPane.YES_OPTION)
							        	controlMesa.borrarMesa(mes);
							        actualizar();
								}
							}
						}	
					}else{
						JOptionPane.showMessageDialog(null, (new ExcMesa(ExcMesa.ERROR_SELECT_ITEM_MESA)), "Error al quitar la Mesa", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return jButtonLisMesQuitar;
	}

	/**
	 * This method initializes jButtonLisMesNueva	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getjButtonLisMesNueva() {
		if (jButtonLisMesNueva == null) {
			jButtonLisMesNueva = new JButton();
			jButtonLisMesNueva.setBounds(new Rectangle(257, 40, 175, 30));
			jButtonLisMesNueva.setText("Nueva Mesa");
			jButtonLisMesNueva.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String ax = JOptionPane.showInputDialog("Numero de la Mesa?");
					System.out.println("AX: "+ax);
					if(ax!=null)
						try {
							controlMesa.crearMesa(Integer.parseInt(ax));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						};
						actualizar();
				}
			});
			
		
		}
		return jButtonLisMesNueva;
	}
	
	public void actualizar() {
			try {
				mesas = controlMesa.listarMesas();
				if(modelo==null){
					System.out.println("Entro");
					modelo= new DefaultListModel<Integer>();
				}
			
				modelo.removeAllElements();
				jListLisMes.removeAll();
				if(mesas.size() > 0  ){
					jListLisMes.setListData(mesas.toArray());
					Iterator<voMesa> it = mesas.iterator();
					while(it.hasNext()){
						voMesa mes = it.next();
						modelo.addElement(mes.getIdMesa());
						jListLisMes.setModel(modelo);
					}	
					System.out.println("finalizo");	
				}
				
				jListLisMes.updateUI();
				scrollLista.updateUI();
				
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				System.out.println(e.getCause());
				try {
					throw new Exception((new ExcMesa(ExcMesa.ERROR_AL_LISTAR_MESA)));
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
