package grafica.ventanas.Modulo2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import grafica.controladores.Modulo2.controladorIngrediente;
import logica.Modulo2.vo.voIngrediente;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaIngrediente {

	private JFrame frmIngredientes;
	private JTextField textFieldNombreIng;
	private JTextField textFieldCosto;
	private controladorIngrediente controlIng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaIngrediente window = new ventanaIngrediente();
					window.frmIngredientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaIngrediente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controlIng = new controladorIngrediente(this);
		frmIngredientes = new JFrame();
		frmIngredientes.setTitle("Ingreso de Ingredientes");
		frmIngredientes.setBounds(100, 100, 639, 356);
		frmIngredientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngredientes.getContentPane().setLayout(null);
		
		JLabel lblNombreDelIngrediente = new JLabel("Nombre del Ingrediente");
		lblNombreDelIngrediente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblNombreDelIngrediente.setBounds(25, 53, 197, 31);
		frmIngredientes.getContentPane().add(lblNombreDelIngrediente);
		
		/*
		JLabel lblTipoDeIngrediente = new JLabel("Tipo de Ingrediente");
		lblTipoDeIngrediente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblTipoDeIngrediente.setBounds(25, 95, 197, 31);
		frmIngredientes.getContentPane().add(lblTipoDeIngrediente);
		*/
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblCosto.setBounds(25, 137, 197, 31);
		frmIngredientes.getContentPane().add(lblCosto);
		
		textFieldNombreIng = new JTextField();
		textFieldNombreIng.setBounds(232, 53, 352, 26);
		frmIngredientes.getContentPane().add(textFieldNombreIng);
		textFieldNombreIng.setColumns(10);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(232, 143, 175, 26);
		frmIngredientes.getContentPane().add(textFieldCosto);
		/*
		JComboBox comboBoxTipoIng = new JComboBox();
		comboBoxTipoIng.setBounds(232, 101, 262, 20);
		frmIngredientes.getContentPane().add(comboBoxTipoIng);
		*/
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(115, 225, 107, 44);
		frmIngredientes.getContentPane().add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					voIngrediente _voIng = new voIngrediente(0, 1, textFieldNombreIng.getText(), Float.parseFloat(textFieldCosto.getText()));
					controlIng.ingresoIngrediente(_voIng);
			}
		});
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmIngredientes.dispose();
			}
		});
		btnCancelar.setBounds(387, 225, 107, 44);
		frmIngredientes.getContentPane().add(btnCancelar);
	}
	
	public void setVisible(){
		this.frmIngredientes.setVisible(true);;;
	}
	
}
