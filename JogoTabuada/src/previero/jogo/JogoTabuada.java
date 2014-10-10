package previero.jogo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import previero.recursos.Tabuada;

public class JogoTabuada {

	private JFrame frmJogoDaTabuada;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoTabuada window = new JogoTabuada();
					window.frmJogoDaTabuada.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JogoTabuada() {
		initialize();
	}

	private void initialize() {
		frmJogoDaTabuada = new JFrame();
		frmJogoDaTabuada.setTitle("Jogo da Tabuada");
		frmJogoDaTabuada.setResizable(false);
		frmJogoDaTabuada.setBounds(100, 100, 450, 300);
		frmJogoDaTabuada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDaTabuada.getContentPane().setLayout(null);
		frmJogoDaTabuada.setLocationRelativeTo(null);

		btR1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.confere(btR1.getText());
				reset();
			}
		});
		btR1.setBounds(44, 127, 89, 23);
		frmJogoDaTabuada.getContentPane().add(btR1);

		btR2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.confere(btR2.getText());
				reset();
			}
		});
		btR2.setBounds(177, 127, 89, 23);
		frmJogoDaTabuada.getContentPane().add(btR2);

		btR3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.confere(btR3.getText());
				reset();
			}
		});
		btR3.setBounds(310, 127, 89, 23);
		frmJogoDaTabuada.getContentPane().add(btR3);

		lblConta.setFont(new Font("Consolas", Font.BOLD, 40));
		lblConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConta.setBounds(44, 47, 355, 58);
		frmJogoDaTabuada.getContentPane().add(lblConta);

		reset();
	}

	Tabuada t = new Tabuada();
	JLabel lblConta = new JLabel();
	JButton btR1 = new JButton();
	JButton btR2 = new JButton();
	JButton btR3 = new JButton();

	public void reset(){

		t.nivel();
		lblConta.setText(t.toString());

		btR1.setText(Integer.toString(t.getResultados()[0]));
		btR2.setText(Integer.toString(t.getResultados()[1]));
		btR3.setText(Integer.toString(t.getResultados()[2]));	

		System.out.println("Questão   :  " + t.getQuestao());
		System.out.println("Level     :  " + t.getLevel() + "\n");

	}

}