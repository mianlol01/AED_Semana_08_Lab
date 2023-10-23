package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_08.Arreglo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Ejemplo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JButton btnAdicionar;
	private JButton btnBuscarRezagar;
	private JButton btnBuscarPriorizar;
	private JButton btnInvertirArreglo;
	private JButton btnOrdenarArreglo;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo frame = new Ejemplo();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo() {
		setTitle("Ejemplo - Semana_08");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumero = new JLabel("N�mero");
		lblNumero.setBounds(10, 11, 50, 23);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtNumero.setBounds(66, 11, 50, 23);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(380, 48, 145, 23);
		contentPane.add(btnAdicionar);

		btnBuscarRezagar = new JButton("Buscar / rezagar");
		btnBuscarRezagar.addActionListener(this);
		btnBuscarRezagar.setBounds(380, 78, 145, 23);
		contentPane.add(btnBuscarRezagar);
		
		btnBuscarPriorizar = new JButton("Buscar / priorizar");
		btnBuscarPriorizar.addActionListener(this);
		btnBuscarPriorizar.setBounds(380, 108, 145, 23);
		contentPane.add(btnBuscarPriorizar);
		
		btnInvertirArreglo = new JButton("Invertir arreglo");
		btnInvertirArreglo.addActionListener(this);
		btnInvertirArreglo.setBounds(380, 138, 145, 23);
		contentPane.add(btnInvertirArreglo);

		btnOrdenarArreglo = new JButton("Ordenar arreglo");
		btnOrdenarArreglo.addActionListener(this);
		btnOrdenarArreglo.setBounds(380, 168, 145, 23);
		contentPane.add(btnOrdenarArreglo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 360, 400);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
		
	//  Declaraci�n global
	Arreglo a = new Arreglo();

	/**
				.----.----.----.----.----.----.----.----.----.----.
		n  ==>  |    |    |    |    |    |    |    |    |    |    |   
				'----'----'----'----'----'----'----'----'----'----'
		  		   0    1    2    3    4    5    6    7    8    9
                indice
	 */

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOrdenarArreglo) {
			actionPerformedBtnOrdenarArreglo(arg0);
		}
		if (arg0.getSource() == btnInvertirArreglo) {
			actionPerformedBtnInvertirArreglo(arg0);
		}
		if (arg0.getSource() == btnBuscarPriorizar) {
			actionPerformedBtnBuscarPriorizar(arg0);
		}
		if (arg0.getSource() == btnBuscarRezagar) {
			actionPerformedBtnBuscarRezagar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		limpieza();
	}
	/**
	 *  Adiciona un n�mero en el arreglo
	 */	
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			a.adicionar(leerNumero());
			listar();
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}
	}
	/**
	 *  Busca un n�mero en el arreglo y si existe lo traslada al final
	 */
	protected void actionPerformedBtnBuscarRezagar(ActionEvent arg0) {
		try {
			a.buscarRezagar(leerNumero());
			listar();	
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}
	}
	/**
	 *  Busca un n�mero en el arreglo y si existe lo traslada al inicio
	 */	
	protected void actionPerformedBtnBuscarPriorizar(ActionEvent arg0) {
		try {
			a.buscarPriorizar(leerNumero());
			listar();	
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}
	}
	/**
	 *  Invierte el contenido del arreglo
	 */
	protected void actionPerformedBtnInvertirArreglo(ActionEvent arg0) {
		a.invertirArreglo();
		listar();
	}
	/**
	 *  Ordena de menor a mayor el contenido del arreglo
	 */
	protected void actionPerformedBtnOrdenarArreglo(ActionEvent arg0) {
		a.ordenarArreglo();
		listar();
	}
	//  M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}
	void limpieza() {
		txtNumero.setText("");
		txtNumero.requestFocus();
	}
	void listar() {
		txtS.setText("");
		for (int i=0; i<a.tamanio(); i++)
			imprimir("n[" + i + "] : " + a.obtener(i));
	}
	//  M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//  M�todos que retornan valor (sin par�metros)
	int leerNumero()  {
		return Integer.parseInt(txtNumero.getText().trim());
	}
	
}