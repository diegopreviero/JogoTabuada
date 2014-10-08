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
	private Integer[] resultados;//array com todas as respostas usado para preencher os botoes

	private int level = 1;
	private int questao;

	private List<Integer> l = new ArrayList<Integer>();//multiplicando

	//********************************************************************************************************************************************	


	public void nivel(){

		System.out.println("questao: " + questao);

		if (questao < 5) {
			

			if (level == 1) {
				setMultiplicador(fase[0][0]);
				setMultiplicando();
			}else
				if (level == 2) {
					setMultiplicador(fase[0][1]);
					setMultiplicando();
				}else
					if (level == 3) {
						setMultiplicador(fase[0][2]);
						setMultiplicando();
					}
			

		}else{
			resetaMultiplicandos();
			level++;
		}

	}




	public void resetaMultiplicandos(){

		questao = 0;
		l.removeAll(l);
		System.out.println("tamanho: " + l.size());

		for (int i = 0; i < 11; i++) {//preenche a lista de multiplicandos
			l.add(i);
		}

	}

	public void initialize(){

		resetaMultiplicandos();
		setQuestao();
		nivel();

		setProduto(multiplicador, multiplicando);
		
		System.out.println(toString()+"  "+getProduto());

		int resp = getProduto();
		for (int i = 0; rand.size() < qtdeBotoes; i++) {//quantidade de botoes para escolha
			rand.add(resp);//na primeira execução adiciona o produto e nas seguintes as respostas alternativas
			resp = valoresAleatorios[r.nextInt(valoresAleatorios.length)] + getProduto();//soma o valor do produto a um valor aleatorio
			System.out.println("resp: "+resp);
		}

		resultados = rand.toArray(new Integer[0]);//transforma o SET em array para facilitar iteracao

		/*for (int i = 0; i < rand.size(); i++) {
			//System.out.println("i= " + i + " - " + resultados[i]);
		}
		System.out.println("\n\n");*/

	}

	//********************************************************************************************************************************************





























	//****************************************************************

	public Tabuada() {

		super();
		initialize();

	}

	public Tabuada(int multiplicador, int multiplicando, int qtdeBotoes, int limiteTabuada) {

		super();
		this.multiplicador = multiplicador;
		this.multiplicando = multiplicando;
		this.qtdeBotoes    = qtdeBotoes;
		this.limiteTabuada = limiteTabuada;

		initialize();

	}

	//****************************************************************



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
		return multiplicador + " x " + multiplicando + " = ?";
	}

	//****************************************************************


}