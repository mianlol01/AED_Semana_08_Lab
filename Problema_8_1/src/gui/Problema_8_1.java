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
import javax.swing.UIManager;

public class Problema_8_1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JButton btnAdicionar;
	private JButton btnEliminarPares;
	private JButton btnEliminarImpares;
	private JButton btnEliminarRepetidos;
	private JButton btnPrimerParAlFinal;
	private JButton btnBarajar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Problema_8_1 frame = new Problema_8_1();
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
	public Problema_8_1() {
		setTitle("Problema_8_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
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
		btnAdicionar.setBounds(380, 48, 195, 23);
		contentPane.add(btnAdicionar);

		btnEliminarPares = new JButton("Eliminar n�meros pares");
		btnEliminarPares.addActionListener(this);
		btnEliminarPares.setBounds(380, 78, 195, 23);
		contentPane.add(btnEliminarPares);
		
		btnEliminarImpares = new JButton("Eliminar n�meros impares");
		btnEliminarImpares.addActionListener(this);
		btnEliminarImpares.setBounds(380, 108, 195, 23);
		contentPane.add(btnEliminarImpares);
		
		btnEliminarRepetidos = new JButton("Eliminar n�meros repetidos");
		btnEliminarRepetidos.addActionListener(this);
		btnEliminarRepetidos.setBounds(380, 138, 195, 23);
		contentPane.add(btnEliminarRepetidos);

		btnPrimerParAlFinal = new JButton("Primer n�mero par al final");
		btnPrimerParAlFinal.addActionListener(this);
		btnPrimerParAlFinal.setBounds(380, 168, 195, 23);
		contentPane.add(btnPrimerParAlFinal);

		btnBarajar = new JButton("Barajar los n�meros");
		btnBarajar.addActionListener(this);
		btnBarajar.setBounds(380, 198, 195, 23);
		contentPane.add(btnBarajar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 360, 400);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
		
	//  Declaraci�n global
	Arreglo a = new Arreglo();

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBarajar) {
			actionPerformedBtnBarajar(arg0);
		}
		if (arg0.getSource() == btnPrimerParAlFinal) {
			actionPerformedBtnPrimerParAlFinal(arg0);
		}
		if (arg0.getSource() == btnEliminarRepetidos) {
			actionPerformedBtnEliminarRepetidos(arg0);
		}
		if (arg0.getSource() == btnEliminarImpares) {
			actionPerformedBtnEliminarImpares(arg0);
		}
		if (arg0.getSource() == btnEliminarPares) {
			actionPerformedBtnEliminarPares(arg0);
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
	protected void actionPerformedBtnEliminarPares(ActionEvent arg0) {
		a.eliminarNumerosPares();
		listar();
	}
	protected void actionPerformedBtnEliminarImpares(ActionEvent arg0) {
		try {
			a.eliminarNumerosImpares();
			listar();	
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}
	}
	protected void actionPerformedBtnEliminarRepetidos(ActionEvent arg0) {
		a.eliminarNumerosRepetidos();
		listar();
	}
	protected void actionPerformedBtnPrimerParAlFinal(ActionEvent arg0) {
		a.primerNumeroParAlFinal();
		listar();
	}
	protected void actionPerformedBtnBarajar(ActionEvent arg0) {
		a.barajarNumeros();
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