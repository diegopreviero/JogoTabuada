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

	int qtdeQuestoes = 15;
	
	public int getQtdeQuestoes(){
		return this.qtdeQuestoes;
	}
	
	int acertos = 0;
	int erros = 0;

	public void reset(){

		t.nivel();

		resultado = Integer.toString(t.getProduto());
		lblConta.setText(t.toString());

		btR1.setText(Integer.toString(t.getResultados()[0]));
		btR2.setText(Integer.toString(t.getResultados()[1]));
		btR3.setText(Integer.toString(t.getResultados()[2]));	

		System.out.println("toString  :  " + t.toString());
		System.out.println("Conta     :  " + t.getMultiplicador() + " x " + t.getMultiplicando() + " = " + t.getProduto());
		System.out.println("Respostas :  " + t.getResultados()[0] + " , " +  t.getResultados()[1] + " , " + t.getResultados()[2]);
		System.out.println("Questão   :  " + t.getQuestao());
		System.out.println("Level     :  " + t.getLevel() + "\n");

	}

	public void confere(String valor){

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

	}
}