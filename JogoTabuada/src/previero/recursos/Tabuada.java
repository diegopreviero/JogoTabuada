package previero.recursos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

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

	private int level = 1;
	private int questao = 0;

	private List<Integer> l = new ArrayList<Integer>();//multiplicando

	//*******************************************************************	

	int corretas = 0;
	int array = 0;

	public void nivel(){

		setQuestao();

		switch (array) {
		case 0:
			teste(array);
			break
			;
		case 1:
			teste(array);
			break;
		case 2:
			teste(array);
			break;
		case 3:
			teste(array);
			break;

		default:
			break;
		}

		if (corretas == 8) {
			array++;
			corretas = 0;
			nivel();
		}


	}


	/*
	 * ELABORAR:
	 * TRAZER A CONTAGEM DE ACERTOS E ERROS PARA ESTA CLASSE (QTDE DE QUESTOES)
	 * 
	 * 
	 */
	


	public void teste(int a){
		/*******************************/
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

			corretas++;
			System.out.println("corretas: "+corretas);

		}else{

			resetaMultiplicandos();
			questao = 0;
			level++;
			nivel();
		}
		/*******************************/
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

		/*for (int i = 0; i < rand.size(); i++) {
			System.out.println("i= " + i + " - " + resultados[i]);
		}
		System.out.println("\n\n");*/

	}


	//********************************************************************************************************************************************

	public Tabuada() {

		super();
		resetaMultiplicandos();

	}

	//****************************************************************

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