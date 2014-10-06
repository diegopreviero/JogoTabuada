package previero;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Tabuada {

	//****************************************************************

	Random r = new Random();
	Set<Integer> rand = new TreeSet<Integer>();//TreeSet usado para ordenar os valores e nao permitir valores repetidos -- alimenta o array 'resultados'
	int valoresAleatorios[] = {-1,-2,-3,-4,1,2,3,4};

	private int multiplicador;
	private int multiplicando;
	private int produto;

	private int qtdeBotoes;
	private int limiteTabuada;	
	private Integer[] resultados;//array com todas as respostas usado para preencher os botoes

	//****************************************************************

	public Tabuada(int multiplicador, int multiplicando, int qtdeBotoes, int limiteTabuada) {
		super();
		this.multiplicador = multiplicador;
		this.multiplicando = multiplicando;
		this.qtdeBotoes    = qtdeBotoes;
		this.limiteTabuada = limiteTabuada;

		setProduto(multiplicador, multiplicando);

		initialize();
	}

	//****************************************************************

	public int getProduto() {
		return produto;
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

	public void setMultiplicando(int multiplicando) {
		this.multiplicando = multiplicando;
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

	//****************************************************************

	public void initialize(){
		int resp = getProduto();
		for (int i = 0; rand.size() < qtdeBotoes; i++) {//quantidade de botoes para escolha
			rand.add(resp);//na primeira execução adiciona o produto e nas seguintes as respostas alternativas
			resp = valoresAleatorios[r.nextInt(valoresAleatorios.length)] + getProduto();//soma o valor do produto a um valor aleatorio
		}

		resultados = rand.toArray(new Integer[0]);//transforma o SET em array para facilitar iteracao

		/*for (int i = 0; i < rand.size(); i++) {
			//System.out.println("i= " + i + " - " + resultados[i]);
		}
		System.out.println("\n\n");*/

	}

	public String toString(){
		return multiplicador + " x " + multiplicando + " = ?";
	}

}