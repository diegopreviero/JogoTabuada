package previero.jogo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import previero.recursos.Tabuada;

import java.awt.Font;

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
				confere(btR1.getText());
			}
		});
		btR1.setBounds(44, 127, 89, 23);
		frmJogoDaTabuada.getContentPane().add(btR1);

		btR2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confere(btR2.getText());
			}
		});
		btR2.setBounds(177, 127, 89, 23);
		frmJogoDaTabuada.getContentPane().add(btR2);

		btR3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confere(btR3.getText());
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

	//****************************************************************

	Tabuada t = new Tabuada();
	JLabel lblConta = new JLabel();
	JButton btR1 = new JButton();
	JButton btR2 = new JButton();
	JButton btR3 = new JButton();
	String resultado;

	int qtdeQuestoes = 30;
	int acertos = 0;
	int erros = 0;

	public void reset(){
		//Tabuada t = new Tabuada(3, 5, 3, 0);
		
		
		t.nivel();
		
		resultado = Integer.toString(t.getProduto());
		lblConta.setText(t.toString());
		btR1.setText(Integer.toString(t.getResultados()[0]));
		btR2.setText(Integer.toString(t.getResultados()[1]));
		btR3.setText(Integer.toString(t.getResultados()[2]));		
	}

	public void confere(String valor){

		t.setQuestao();
		if ((acertos+erros) < qtdeQuestoes) {

			if (resultado.equals(valor)) {
				acertos++;
			}else{
				erros++;
			}
		}

		if ((acertos+erros) >= qtdeQuestoes) {
			JOptionPane.showMessageDialog(null,  "   R E S U L T A D O\n\n************************\n\nAcertos: " + acertos	+"\nErros: " + erros +	"\n\n************************\n************************\n");
			System.exit(0);
		}

		reset();
		System.out.println("qtde: "+acertos+erros);

	}
}