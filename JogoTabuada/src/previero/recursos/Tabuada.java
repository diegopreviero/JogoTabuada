package previero.recursos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Tabuada {

	//****************************************************************

	private Random r = new Random();
	private Set<Integer> rand = new TreeSet<Integer>();//TreeSet usado para ordenar os valores e nao permitir valores repetidos -- alimenta o array 'resultados'
	private int valoresAleatorios[] = {-1,-2,-3,-4,1,2,3,4};
	private int fase[][] = { {1,2,3}, {3,4,5}, {5,6,7}, {7,8,9} };

	private int multiplicador;
	private int multiplicando;
	private int produto;

	private int qtdeBotoes = 3;//remover depois *************
	private int limiteTabuada;	
	private Integer[] resultados = null;//array com todas as respostas usado para preencher os botoes

	int array = 0;
	private int level = 1;

	private int questao = 0;

	private List<Integer> l = new ArrayList<Integer>();//multiplicando

	int numeroDaQuestao = 0;
	int certo;
	int errado;
	int qtdeQuestoes = 40;
	int qtdeQuestoesPorFase = Math.round(qtdeQuestoes/4);
	int percentualAcerto;

	//*******************************************************************	

	public void confere(String resposta){

		int valor = Integer.parseInt(resposta);
		if ((certo+errado) < qtdeQuestoes) {

			if (getProduto() ==valor) {
				certo++;
			}else{
				errado++;
			}
		}

		if ((certo+errado) >= qtdeQuestoes) {
			JOptionPane.showMessageDialog(null,  "   R E S U L T A D O\n\n************************\n\nAcertos: " + certo	+"\nErros: " + errado +	"\n\n************************\n************************\n");
			System.exit(0);
		}

		percentualAcerto = certo*qtdeQuestoesPorFase;
		System.out.println("Percentual de Acerto: " + percentualAcerto);

	}

	public void nivel(){

		setQuestao();

		switch (array) {
		case 0:
			subNivel(array);
			break
			;
		case 1:
			subNivel(array);
			break;
		case 2:
			subNivel(array);
			break;
		case 3:
			subNivel(array);
			break;

		default:
			break;
		}

		if (numeroDaQuestao == qtdeQuestoesPorFase+1) {

			if (certo >= Math.round((90*qtdeQuestoesPorFase)/100)) {
				array++;
				level = 1;
				numeroDaQuestao = 0;
				percentualAcerto = 0;
				certo = 0;
				errado = 0;
				nivel();
			}else{
				if (array<0) {
					array--;
				}
				level = 1;
				numeroDaQuestao = 0;
				percentualAcerto = 0;
				certo = 0;
				errado = 0;
				//nivel();
			}

		}

	}

	public void subNivel(int a){

		if (getQuestao() <= 5) {

			switch (level) {
			case 1:
				setRespostas(a, 0);
				break;
			case 2:
				setRespostas(a, 1);
				break;
			case 3:
				setRespostas(a, 2);
				break;

			default:
				break;
			}

			numeroDaQuestao++;
			System.out.println("Nro Questão: "+numeroDaQuestao);

		}else{

			resetaMultiplicandos();
			questao = 0;
			level++;
			nivel();
		}

	}

	public void resetaMultiplicandos(){

		l.removeAll(l);

		for (int i = 0; i < 11; i++) {//preenche a lista de multiplicandos
			l.add(i);
		}

	}

	public void setRespostas(int a, int b){

		setMultiplicador(fase[a][b]);
		setMultiplicando();
		setProduto(getMultiplicador(), getMultiplicando());

		rand.removeAll(rand);
		int resp = getProduto();
		for (int i = 0; rand.size() < qtdeBotoes; i++) {//quantidade de botoes para escolha
			rand.add(resp);//na primeira execução adiciona o produto e nas seguintes as respostas alternativas
			resp = valoresAleatorios[r.nextInt(valoresAleatorios.length)] + getProduto();//soma o valor do produto a um valor aleatorio
			if (resp < 0) {//transforma os numeros negativos em positivos
				resp = resp*-1;
			}
		}

		resultados = rand.toArray(new Integer[0]);//transforma o SET em array para facilitar iteracao

	}

	public Tabuada() {

		super();
		resetaMultiplicandos();

	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getProduto() {
		return produto;
	}

	public int getQuestao() {
		return questao;
	}

	public void setQuestao() {
		this.questao++;
	}

	public void setProduto(int multiplicador, int multiplicando) {
		this.produto = multiplicador * multiplicando;
	}

	public Integer[] getResultados() {
		return resultados;
	}

	public void setResultados(Integer[] resultados) {
		this.resultados = resultados;
	}

	public int getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}

	public int getMultiplicando() {
		return multiplicando;
	}

	public void setMultiplicando() {
		Collections.shuffle(l);
		this.multiplicando = l.get(0);
		l.remove(0);
	}

	public int getQtdeBotoes() {
		return qtdeBotoes;
	}

	public void setQtdeBotoes(int qtdeBotoes) {
		this.qtdeBotoes = qtdeBotoes;
	}

	public int getLimiteTabuada() {
		return limiteTabuada;
	}

	public void setLimiteTabuada(int limiteTabuada) {
		this.limiteTabuada = limiteTabuada;
	}

	public String toString(){
		return getMultiplicador() + "x" + getMultiplicando() + " = ?";
	}

}