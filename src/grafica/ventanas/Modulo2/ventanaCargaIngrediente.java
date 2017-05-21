package grafica.ventanas.Modulo2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import grafica.controladores.Modulo2.controladorCargaIngrediente;
import logica.Modulo2.excepciones.ExcIngrediente;
import logica.Modulo2.vo.voIngrediente;
import logica.Modulo2.vo.voRelIngProd;
import logica.excepciones.ExcFamilia;
import logica.vo.voFamilia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ventanaCargaIngrediente {

	private JFrame frmCargaIngrediente;
	private JTextField textFieldIng;
	private String nombreProducto;
	private int idProducto;
	private ArrayList<voIngrediente> listIngredientes;
	private ArrayList<voRelIngProd> listProdIng;
	private ArrayList<String> listFilIng;
	private controladorCargaIngrediente controlCarIng;
	private DefaultListModel modeloProdIng;/*declaramos el Modelo*/
	private DefaultListModel modeloListIng;
	private JList JlistProd = new JList();
	private JList JlistIng = new JList();
	private int idx=-1 ,idIng=0;
	private String auxLisNom, auxLisIng;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaCargaIngrediente window = new ventanaCargaIngrediente(1, "Prueba");
					window.frmCargaIngrediente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaCargaIngrediente(int _idProcuto, String _nombreProducto) {
		this.nombreProducto = _nombreProducto;
		this.idProducto = _idProcuto;
		this.controlCarIng = new controladorCargaIngrediente(this);
		this.listIngredientes = controlCarIng.listarIngrediente();
		this.listProdIng = controlCarIng.listIngProducto(_idProcuto);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCargaIngrediente = new JFrame();
		frmCargaIngrediente.setTitle("Carga de Ingredientes");
		frmCargaIngrediente.setBounds(100, 100, 1030, 616);
		frmCargaIngrediente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCargaIngrediente.getContentPane().setLayout(null);
		
		JLabel lblCargaIngrediente = new JLabel("Producto");
		lblCargaIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCargaIngrediente.setBounds(10, 21, 77, 38);
		frmCargaIngrediente.getContentPane().add(lblCargaIngrediente);
		
		textFieldIng = new JTextField();
		textFieldIng.setBounds(739, 23, 262, 38);
		frmCargaIngrediente.getContentPane().add(textFieldIng);
		textFieldIng.setColumns(10);
		setJTexFieldChanged(textFieldIng);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(169, 487, 140, 40);
		frmCargaIngrediente.getContentPane().add(btnGuardar);
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("bt guardar oha!");
				int ax = JOptionPane.showConfirmDialog(null, "Antes de guardar verifique la lista de ingredientes del producto si es correcta");
				if(ax == JOptionPane.YES_OPTION){
					controlCarIng.guardarlistaProd(modeloProdIng, idProducto, listIngredientes);
					listIngredientes = controlCarIng.listarIngrediente();
				}
			}
		});
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(679, 487, 140, 40);
		frmCargaIngrediente.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCargaIngrediente.dispose();
			}
		});
		
		JLabel lblFiltroIng = new JLabel("Filtro de Ingrediente");
		lblFiltroIng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFiltroIng.setBounds(571, 21, 158, 38);
		frmCargaIngrediente.getContentPane().add(lblFiltroIng);
		
		JScrollPane scrollPaneIng = new JScrollPane();
		scrollPaneIng.setBounds(571, 72, 430, 386);
		frmCargaIngrediente.getContentPane().add(scrollPaneIng);
		
		//JList listIng = new JList();
		scrollPaneIng.setViewportView(JlistIng);
		JlistIng.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
		JlistIng.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		
		JLabel lblNombreProd = new JLabel("");
		lblNombreProd.setBackground(new Color(255, 250, 240));
		lblNombreProd.setForeground(new Color(0, 0, 0));
		lblNombreProd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreProd.setBounds(95, 21, 345, 38);
		lblNombreProd.setText(nombreProducto);
		frmCargaIngrediente.getContentPane().add(lblNombreProd);
		
		JScrollPane scrollPaneProd = new JScrollPane();
		scrollPaneProd.setBounds(10, 70, 430, 388);
		frmCargaIngrediente.getContentPane().add(scrollPaneProd);
		
		//listProd = new JList();
		scrollPaneProd.setViewportView(JlistProd);
		JlistProd.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
		JlistProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		
		JButton btnIzq = new JButton("Agregar");
		btnIzq.setBounds(465, 150, 80, 60);
		frmCargaIngrediente.getContentPane().add(btnIzq);
		
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!controlCarIng.repetido(modeloProdIng, auxLisIng))
					modeloProdIng.addElement(auxLisIng);
			}
		});
		
		JButton btnDer = new JButton("Quitar");
		btnDer.setBounds(465, 293, 80, 60);
		frmCargaIngrediente.getContentPane().add(btnDer);
		
		JButton btnNuevoIng = new JButton("Nuevo Ingrediente");
		btnNuevoIng.setBounds(335, 487, 140, 40);
		frmCargaIngrediente.getContentPane().add(btnNuevoIng);
		
		JButton btnRecListIng = new JButton("Recarga Ingredientes");
		btnRecListIng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listIngredientes=controlCarIng.listarIngrediente();
				actualizarListaIngredientes();
			}
		});
		btnRecListIng.setBounds(507, 487, 140, 40);
		frmCargaIngrediente.getContentPane().add(btnRecListIng);
		
		btnNuevoIng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			ventanaIngrediente _vent = new ventanaIngrediente();
			_vent.setVisible();
			actualizarListaIngredientes();
		}
		});
		
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(idx);
				if(idx!=-1)
					modeloProdIng.removeElementAt(idx);
			}
		});
		
		actualizarListaIngredientes();
		actualizarProdIng();
	
		}
	
	
	
	   private void setJTexFieldChanged(JTextField txt) {
	        DocumentListener documentListener = new DocumentListener() {
	 
	        @Override
	        public void changedUpdate(DocumentEvent documentEvent) {
	            printIt(documentEvent);
	        }
	 
	        @Override
	        public void insertUpdate(DocumentEvent documentEvent) {
	            printIt(documentEvent);
	        }
	 
	        @Override
	        public void removeUpdate(DocumentEvent documentEvent) {
	            printIt(documentEvent);
	        }};
	        
	        txt.getDocument().addDocumentListener(documentListener);
	 
	    }
	 
	    private void printIt(DocumentEvent documentEvent) {
	        DocumentEvent.EventType type = documentEvent.getType();
	 
	        if (type.equals(DocumentEvent.EventType.CHANGE)){
	 
	        }
	        else if (type.equals(DocumentEvent.EventType.INSERT))
	        {
	            txtEjemploJTextFieldChanged();
	        }
	        else if (type.equals(DocumentEvent.EventType.REMOVE))
	        {
	            txtEjemploJTextFieldChanged();
	        }
	    }
	 
	    private void txtEjemploJTextFieldChanged() {
	        //Copiar el contenido del jtextfield al jlabel
	    	//textFieldIng.setText(textFieldIng.getText());
	    	//Aca debo de ingresar la logica del filtro para que vaya agregando a medida que ingreso algo
	    	if(!textFieldIng.getText().isEmpty())
	    		listFilIng = controlCarIng.filtro(listIngredientes, textFieldIng.getText().toString());
	    		actualizarListaIngredientes();
	    }
	
	
	
	public void actualizarProdIng() {
		try {
			if(modeloProdIng==null){
				modeloProdIng= new DefaultListModel();
			}
			
			System.out.println("cantidad "+listProdIng.size());
			if(listProdIng.size()==0){
				modeloProdIng.addElement("No se ingresaron ingredientes para este producto");
				JlistProd.setModel(modeloProdIng);
			}else{
				
				modeloProdIng.removeAllElements();
				JlistProd.removeAll();
				if(listProdIng.size() > 0  ){
					JlistProd.setListData(listProdIng.toArray());
					Iterator<voRelIngProd> it = listProdIng.iterator();
					while(it.hasNext()){
						voRelIngProd ing = it.next();
						modeloProdIng.addElement(ing.getDescripcionIngrediente());
						JlistProd.setModel(modeloProdIng);
					}	
					System.out.println("finalizo");	
				}
			}
			
			JlistProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			//Lo dejo siempre escuchando.
			JlistProd.addListSelectionListener(new ListSelectionListener() {
			      public void valueChanged(ListSelectionEvent le) {
			        idx = JlistProd.getSelectedIndex();
			        auxLisNom = (String) JlistProd.getSelectedValue();	
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
				throw new Exception((new ExcIngrediente(ExcIngrediente.ERROR_AL_LISTAR_INGREDIENTE)));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Error en la excepción");
				e1.printStackTrace();
			}
		}
	}
	

	public void actualizarListaIngredientes() {
		try {
			if(modeloListIng==null){
				modeloListIng= new DefaultListModel();
			}
			
			if(textFieldIng.getText().isEmpty()){
				modeloListIng.removeAllElements();
				JlistIng.removeAll();
				if(listIngredientes.size() > 0  ){
					JlistIng.setListData(listIngredientes.toArray());
					Iterator<voIngrediente> it = listIngredientes.iterator();
					while(it.hasNext()){
						voIngrediente ing = it.next();
						modeloListIng.addElement(ing.getNombreIngrediente());
						JlistIng.setModel(modeloListIng);
					}	
					System.out.println("finalizo");	
				}
			}else{
				modeloListIng.removeAllElements();
				JlistIng.removeAll();
				if(listFilIng.size()>0){
					JlistIng.setListData(listFilIng.toArray());
					Iterator<String> it = listFilIng.iterator();
					while(it.hasNext()){
						String ing = it.next();
						modeloListIng.addElement(ing);
						JlistIng.setModel(modeloListIng);
					}	
					System.out.println("finalizo");
					
				}
			}
			
			JlistIng.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			//Lo dejo siempre escuchando.
			JlistIng.addListSelectionListener(new ListSelectionListener() {
			      public void valueChanged(ListSelectionEvent le) {
			        idIng = JlistIng.getSelectedIndex();
			        auxLisIng = (String) JlistIng.getSelectedValue();	
			        //Eso es para ver si toma correctamente el indice
			        if (idIng != -1){
			        	System.out.println("Current selection: " + idIng);
			        	System.out.println(auxLisIng + "     aca");
			        }else
			          System.out.println("Please choose a language.");
			        
			      }
			});
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			try {
				throw new Exception((new ExcIngrediente(ExcIngrediente.ERROR_AL_LISTAR_INGREDIENTE)));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Error en la excepción");
				e1.printStackTrace();
			}
		}
	}
}
