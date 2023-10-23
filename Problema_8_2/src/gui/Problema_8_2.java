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

public class Problema_8_2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JButton btnAdicionarDistintoYordenar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema_8_2 frame = new Problema_8_2();
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
	public Problema_8_2() {
		setTitle("Problema_8_2");
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

		btnAdicionarDistintoYordenar = new JButton("Adicionar distinto y ordenar");
		btnAdicionarDistintoYordenar.addActionListener(this);
		btnAdicionarDistintoYordenar.setBounds(380, 48, 145+50, 23);
		contentPane.add(btnAdicionarDistintoYordenar);
		
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
		if (arg0.getSource() == btnAdicionarDistintoYordenar) {
			actionPerformedBtnAdicionaDistintoYordenar(arg0);
		}
		limpieza();
	}
	protected void actionPerformedBtnAdicionaDistintoYordenar(ActionEvent arg0) {
		try {
			a.adicionarDistintoYordenar(leerNumero());
			listar();
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}
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