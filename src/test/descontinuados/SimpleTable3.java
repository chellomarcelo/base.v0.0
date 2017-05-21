package test.descontinuados;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import logica.fachada;
import logica.excepciones.ExcProveedores;
import logica.vo.voProveedor;

public class SimpleTable3 extends JFrame {
	
	private fachada fac;
	
	public ArrayList<voProveedor> listarProveedores() throws Exception{
		try {
			if (fac==null){
				fac = new fachada();
			}
			return fac.listarNombreProveedores();
		} catch (ExcProveedores e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_NO_HAY_PROVEEDORES)), "Error al crear Proveedor", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(null, (e.getMessage()), "Error al crear proveedor", JOptionPane.ERROR_MESSAGE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public SimpleTable3() throws Exception {
		super("Ejemplo 3");
		//creamos el arreglo de objetos que contendra el
		//contenido de las columnas
		ArrayList<voProveedor> _voProveedor = listarProveedores();
		Object[] data = new Object[2];
		// creamos el modelo de Tabla}
		DefaultTableModel dtm= new DefaultTableModel();
		// se crea la Tabla con el modelo DefaultTableModel
		final JTable table = new JTable(dtm);
		
		// insertamos las columnas
		//for(int column = 0; column < 2; column++){}
		dtm.addColumn("RUT");
		dtm.addColumn("Nombre");
		// insertamos el contenido de las columnas
		for(int row = 0; row < _voProveedor.size(); row++) {
					data[0] = _voProveedor.get(row).getIdProveedor();//"Celda " + row + "," + column;
					data[1] = _voProveedor.get(row).getNombreProveedor();
					dtm.addRow(data);
		}
		//se define el tamaño
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		//manejamos la salida
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		System.exit(0);
		}
		});
		}
		public static void main(String[] args) {
		SimpleTable3 frame;
		try {
			frame = new SimpleTable3();
			frame.pack();
			frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}