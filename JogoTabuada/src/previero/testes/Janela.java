package previero.testes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class Janela extends Thread {

	private JFrame frmContador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frmContador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Janela() {
		initialize();
	}

	private void initialize() {
		frmContador = new JFrame();
		frmContador.setTitle("Contador");
		frmContador.setBounds(100, 100, 290, 166);
		frmContador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmContador.getContentPane().setLayout(null);
		lblContador.setHorizontalAlignment(SwingConstants.CENTER);


		lblContador.setBounds(112, 11, 46, 14);
		frmContador.getContentPane().add(lblContador);

		JButton btnIniciar = new JButton("iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Contador().start();
				btnIniciar.setEnabled(false);
			}
		});
		btnIniciar.setBounds(29, 52, 89, 23);
		frmContador.getContentPane().add(btnIniciar);
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setZerar(true);
				
			}
		});
		btnReiniciar.setBounds(152, 52, 89, 23);

		frmContador.getContentPane().add(btnReiniciar);
		
		
		progressBar.setBounds(12, 100, 252, 14);
		frmContador.getContentPane().add(progressBar);
		progressBar.setMinimum(-40);
		progressBar.setMaximum(0);
		progressBar.setStringPainted(true);
	}

	
	static JProgressBar progressBar = new JProgressBar();
	
	//******************************************************************
	static JLabel lblContador = new JLabel("--");
	private final JButton btnReiniciar = new JButton("Reiniciar");

	public static void setLblNewLabel(String x) {
		lblContador.setText(x);
	}
	//******************************************************************

	
	//******************************************************************
	private static boolean zerar = false;

	public static boolean getZerar() {
		return zerar;
	}

	public static void setZerar(Boolean x) {
		zerar = x;
	}
}