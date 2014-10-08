/*
 * ELABORAR:
 * 
 * --dificuldade (quantas questoes de cada fase) 
 * 
 * --REGRAS:
 * ----acertar 70% de cada fase
 * ----reiniciar fase caso não alcance esse percentual 
 * 
 * --MULTIPLAYER
 * ----mesma tabuada para todos, o primeiro q responder ativa um cronometro para os outros jogadores
 * ----pontuacao proporcional ao ranquamento de respostas
 * ----nome do player
 */

package previero.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class testeFases {

	public static void main(String[] args) {
		testeFases t = new testeFases();

		t.iniciaLista();

		for (int i = 0; i < 11; i++) {
			t.escolheMultiplicando();
			System.out.println(t.multiplicando);
		}

	}

	Random r = new Random();
	int multiplicador;
	int multiplicando = 2;
	
	
	//daqui pra baixo copiado para Tabuada
	
	int level = 1;
	int questao = 1;

	int fase[][] = {
			/* 1 */ {1,2,3},
			/* 2 */ {3,4,5},
			/* 3 */ {5,6,7},
			/* 4 */ {7,8,9}
	};

	
	List<Integer> l = new ArrayList<Integer>();



	public void nivel(){

		if (level == 1 && questao < 6){

			multiplicador = fase[0][0];
			multiplicando = r.nextInt(11);
		}

		questao++;
	}

	
	
	public void escolheMultiplicando() {
		Collections.shuffle(l);
		multiplicando = l.get(0);
		l.remove(0);
	}
	

	public void iniciaLista(){
		
		l.removeAll(l);
		System.out.println("tamanho: " + l.size());
		
		for (int i = 0; i < 11; i++) {//preenche a lista de multiplicandos
			l.add(i);
		}

	}
	


}