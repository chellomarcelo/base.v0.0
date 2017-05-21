package test.descontinuados;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controladores.Modulo1.Modulo1.Modulo1.Modulo1.controladorAbmProveedor;
import logica.fachada;
import logica.excepciones.ExcProveedores;
import logica.vo.voProveedor;

public class ventanaPruebaGrilla extends JFrame {
	public ventanaPruebaGrilla() {
		 super("Ejemplo 1");
	final JTable table = new JTable(CargarModelo());
	table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	 //Creamos un JscrollPane y le agregamos la JTable
	 JScrollPane scrollPane = new JScrollPane(table);
	 //Agregamos el JScrollPane al contenedor
	 getContentPane().add(scrollPane, BorderLayout.CENTER);
	 addWindowListener(new WindowAdapter() {
		 public void windowClosing(WindowEvent e) {
		 System.exit(0);
		 }
		 });
		 }
	
	public static void main(String[] args) {
		 ventanaPruebaGrilla frame = new ventanaPruebaGrilla();
		 frame.pack();
		 frame.setVisible(true);
	} 
	
	public DefaultTableModel CargarModelo(){
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			ArrayList<voProveedor> _voProveedor = listarProveedores();
			Object [] data = new Object[2];
			//dtm.addColumn(nombreColumnas, data);
			
			// insertamos el contenido de las columnas
			dtm.addColumn("RUT");
			dtm.addColumn("Nombre");
			// insertamos el contenido de las columnas
			for(int row = 0; row < _voProveedor.size(); row++) {
						data[0] = _voProveedor.get(row).getIdProveedor();//"Celda " + row + "," + column;
						data[1] = _voProveedor.get(row).getNombreProveedor();
						dtm.addRow(data);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtm;
		
	}
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
}

