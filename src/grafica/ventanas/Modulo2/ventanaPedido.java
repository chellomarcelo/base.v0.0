package grafica.ventanas.Modulo2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import grafica.controladores.Modulo1.controladorAbmFamilia;
import grafica.controladores.Modulo2.controladorModo1;
import logica.familia;
import logica.vo.voProducto;
import logica.Modulo2.vo.voMesa;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Rectangle;
import javax.swing.border.MatteBorder;

public class ventanaPedido {

	
	private JFrame frame;
	private controladorModo1 control;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JScrollPane scroll;
	private JButton btnCocina;
	private JButton btnPizzeria;
	private JButton btnBebida;
	private ArrayList<voProducto> voProd;
	private ArrayList<voMesa> voMesa;
	private ArrayList<voProducto> voProdAux;
	private float importe=0;
	private JLabel lblImporteD;
	private JLabel lblPagaD;
	private JLabel lblVueltoD;
	private JLabel auxLbl_1; // nombre producto
	private JLabel auxLbl_2; // precio
	private JLabel auxLbl_3; // cantidad
	private JLabel lblProducto;
	private JLabel lblImporte;
	private JLabel lblCantidad;
	private JLabel lblMesa ; 
	private JLabel lblPedido;
	private int on=0;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaModo1 window = new ventanaModo1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the application.
	 */
	public ventanaPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		voProdAux = new ArrayList<voProducto>();
		control = new controladorModo1(this);
		voMesa = control.ListarMesas();
		frame = new JFrame();
		frame.setBounds(100, 100, 1236, 983);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		JLabel lblMesas = new JLabel("Mesas");
		lblMesas.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblMesas.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_7 = new JPanel();
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMesas, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(104))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblMesas, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 902, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		//Agrego las mesas 
		botonesMesas();
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JButton btnInicio_1 = new JButton("Inicio");
		btnInicio_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btnInicio_1);
		
		panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setBounds(400, 400, 100, 100);
		
		JButton btnListo = new JButton("Listo");
		
		JButton btnCancelar = new JButton("Canclear");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	
			}
		});
		
		JLabel lblImp = new JLabel("Importe");
		lblImp.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		
		lblPedido = new JLabel("Pedido Calle");
		lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedido.setForeground(Color.BLACK);
		lblPedido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblPedido.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblPedido.setText("Pedido Calle ");
				lblPedido.setForeground(Color.BLACK);
				apagarMesas();
			}
		});
		
		JLabel lblPaga = new JLabel("Paga");
		lblPaga.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		
		JLabel lblVuelto = new JLabel("Vuelto");
		lblVuelto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		
		panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(192, 192, 192)));
		panel_6.setBackground( new Color(245, 245, 245) );
		
		lblImporteD = new JLabel("");
		lblImporteD.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImporteD.setForeground(Color.BLACK);
		lblImporteD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblPagaD = new JLabel("");
		lblPagaD.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPagaD.setForeground(Color.BLACK);
		lblPagaD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblVueltoD = new JLabel("");
		lblVueltoD.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVueltoD.setForeground(Color.BLACK);
		lblVueltoD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblImporte = new JLabel("Importe");
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProducto, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(35)
					.addComponent(lblImporte, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblCantidad, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addComponent(lblImp, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblImporteD, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addComponent(lblVuelto)
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addComponent(lblVueltoD, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addComponent(lblPaga, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addGap(54)
							.addComponent(lblPagaD, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPedido, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(7)
							.addComponent(btnListo, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
					.addGap(0))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnListo, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(lblPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProducto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblImporte, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblImp, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblImporteD, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblPaga, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(lblVuelto))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblPagaD, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblVueltoD, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		
		panel_5 = new JPanel();
		
		btnPizzeria = new JButton("Pizzeria");
		btnCocina = new JButton("Cocina");
		btnBebida = new JButton("Bebida");
		
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(65)
							.addComponent(btnPizzeria, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(btnCocina, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBebida, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(145, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPizzeria, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCocina, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnBebida, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(7)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
					.addGap(56))
		);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
		panel_5.setMinimumSize(new java.awt.Dimension(110, 300));
		panel_5.setPreferredSize(new java.awt.Dimension(110, 300));
		panel_4.setLayout(gl_panel_4);
		
		btnPizzeria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_5.removeAll();
				botonesDinamicos(familia.PIZZERIA);
				panel_5.updateUI();
			}
		});
	
		btnCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_5.removeAll();
				botonesDinamicos(familia.COCINA);
				panel_5.updateUI();
			}
		});
		
		btnBebida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_5.removeAll();
				botonesDinamicos(familia.BRBIDA);
				panel_5.updateUI();
			}
		});
	
	}
	
	public void visible(){
		this.frame.setVisible(true);
	}
	
	public void botonesDinamicos (int idBtn)	{
		Dimension preferredSize = new Dimension(85,85);
		voProd = control.ListarProductos(idBtn); //IdFamilia por ahora
		for(int i=0;i<voProd.size();i++){
			final JButton jbtn  	= new JButton("btn "+ voProd.get(i).getIdProducto());
			jbtn.setSize(preferredSize);
			jbtn.setText(null);
			Icon icono = control.createImage(voProd.get(i).getNombreProducto(), voProd.get(i).getUrlFoto());
			jbtn.setIcon( icono );
			 accionBotones(jbtn, voProd.get(i));
				
			JLabel  lbl		= new JLabel ("lbl "+voProd.get(i).getIdProducto());
			lbl.setText(voProd.get(i).getNombreProducto());
			panel_5.add(jbtn);
			panel_5.add(lbl);
		}
	}	
	
	
	
	public void accionBotones(final JButton jbtn, final voProducto voProdL){
		 panel_6.setLayout(new GridLayout(0, 3));
		 
		 jbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cant=0;
				auxLbl_1 = new JLabel (String.valueOf(voProdL.getIdProducto())+"p");
				auxLbl_2 = new JLabel (String.valueOf(voProdL.getIdProducto())+"p");
				auxLbl_1.setName(String.valueOf(voProdL.getIdProducto())+"p");
				auxLbl_2.setName(String.valueOf(voProdL.getIdProducto())+"p");
				auxLbl_3 = new JLabel (String.valueOf(voProdL.getIdProducto())+"p");
				auxLbl_3.setName(String.valueOf(voProdL.getIdProducto())+"p");
				
				System.out.println(jbtn.getName());
				auxLbl_1.setHorizontalAlignment(SwingConstants.LEFT);
				auxLbl_1.setForeground(Color.BLACK);
				auxLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
				auxLbl_1.setText(voProdL.getNombreProducto());
				System.out.println(voProdL.getNombreProducto());
				
				auxLbl_2.setHorizontalAlignment(SwingConstants.CENTER);
				auxLbl_2.setForeground(Color.BLACK);
				auxLbl_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
				auxLbl_2.setText(Float.toString(voProdL.getPrecioSIva()));
				
				String ax = JOptionPane.showInputDialog("Cuantas cantidades?");
				System.out.println("AX: "+ax);
				if(ax!=null) 
					cant = Integer.parseInt(ax);
				
				if(cant > 1 )	{ 
					auxLbl_3.setText(ax);
					importe = (float) (control.redondearDecimales(importe) + (control.redondearDecimales(voProdL.getPrecioSIva())*cant));
				}else{
					auxLbl_3.setText("1");
					importe = (float) (control.redondearDecimales(importe) + control.redondearDecimales(voProdL.getPrecioSIva()));
				}
				auxLbl_3.setHorizontalAlignment(SwingConstants.RIGHT);
				auxLbl_3.setForeground(Color.BLACK);
				auxLbl_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
				
				
				
				System.out.println(voProdL.getNombreProducto());
				
				auxLbl_1.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						System.out.println("Entro");
						boolean borre=false;
						int i=0;
						Component [] a = panel_6.getComponents();
						System.out.println("Largo: "+a.length);
						while (!borre && i <a.length-1){
							if(e.getComponent().getName().equals(a[i].getName())){
								int ax = JOptionPane.showConfirmDialog(null, "Seguro que desea borrar "+ a[i].getAccessibleContext().getAccessibleName());
								if(ax == JOptionPane.YES_OPTION){
									System.out.println("Borro: "+a[i+1].getAccessibleContext().getAccessibleName() + " i: "+i);
									System.out.println("antes importe: " + importe );
									System.out.println( importe + " - " + Float.parseFloat(a[i+1].getAccessibleContext().getAccessibleName()));
									System.out.println( importe + " - " + Float.parseFloat(a[i+2].getAccessibleContext().getAccessibleName()));
									importe = (float) (control.redondearDecimales (importe) - (control.redondearDecimales (Float.parseFloat(a[i+1].getAccessibleContext().getAccessibleName())))*Integer.parseInt(a[i+2].getAccessibleContext().getAccessibleName())) ;
									
									lblImporteD.setText(String.valueOf(importe));;
									panel_6.remove(a[i]);
									panel_6.remove(a[i+1]);
									panel_6.remove(a[i+2]);
								//	System.out.println(a[i]);
								//	System.out.println(a[i+1]);
								//	System.out.println(a[i+2]);
								}		
								borre = true;
							}
							i++;
							
							
						}
						
						panel_6.updateUI();
						
					}
				});
				
								
				voProdAux.add(voProdL);
				//System.out.println("Producto que meto en el arreglo: "+voProdL.getNombreProducto() );
				//System.err.println("largo arreglo aux: "+voProdAux.size());
				
				panel_6.add(auxLbl_1);
				panel_6.add(auxLbl_2);
				panel_6.add(auxLbl_3);
				lblImporteD.setText(String.valueOf(importe));
				
				System.out.println("Suma: "+importe);
				System.out.println(auxLbl_3.getText());
				panel_6.updateUI();
			}
			});
	}
	
	public void botonesMesas ()	{
		voMesa = control.ListarMesas(); //IdFamilia por ahora
		for(int i=0;i<voMesa.size();i++){
			final JLabel lblMesa = new JLabel ("lbl "+ voMesa.get(i).getIdMesa());
			lblMesa.setName("lbl "+ voMesa.get(i).getIdMesa());
			System.out.println(voMesa.get(i).getIdMesa());
		
			Icon icono = control.createImageMesa(0);
			lblMesa.setText(""+voMesa.get(i).getIdMesa());
			lblMesa.setIcon(icono);
			
			lblMesa.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					apagarMesas();
					System.out.println(lblMesa.getName());
					lblPedido.setText("Pedido Mesa "+lblMesa.getText());
					lblPedido.setForeground(Color.MAGENTA);
					lblMesa.setIcon(control.createImageMesa(1));
				}
			});
			
			panel_7.add(lblMesa);
		}
		
		
	}

	
	public void apagarMesas(){
			
		//lblMesa.setIcon(control.createImageMesa(0));
		System.out.println("Entro al apagar");
		int i=0;
		Component [] a = panel_7.getComponents();
		System.out.println("Largo: "+a.length);
		for(int u=0; u<a.length;u++){
			System.out.println(a[u].getName());
			JLabel aux = (JLabel) a[u];
			aux.setIcon(control.createImageMesa(0));
		}
		panel_7.updateUI();
				
	}
		
	
}
