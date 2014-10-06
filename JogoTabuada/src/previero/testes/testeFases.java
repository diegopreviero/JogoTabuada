package previero.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class testeFases {

	public static void main(String[] args) {
		testeFases t = new testeFases();

		for (int i = 0; i < 11; i++) {
			t.l.add(i);
		}

		for (int i = 0; i < 11; i++) {
			t.escolheMultiplicando();
			System.out.println(t.multiplicando);
		}

		t.excluir();

	}


	//****************************************************************
	//****************************************************************
	//LEVAR PARA OUTRA CLASSE

	Random r = new Random();
	int multiplicador;
	int multiplicando = 2;
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

			System.out.println("Q: "+questao);
			//System.out.println("A: "+multiplicador);
			System.out.println("B: "+multiplicando + "\n");
		}

		questao++;
	}

	public void escolheMultiplicando() {
		Collections.shuffle(l);
		multiplicando = l.get(0);
		l.remove(0);
	}

	public void excluir(){
		l.removeAll(l);
		System.out.println("tamanho: " + l.size());
	}

}

/*
 * ELABORAR:
 * --dificuldade (quantas questoes de cada fase)
 * 
 * 
 * --REGRAS:
 * acertar 70% de cada fase
 * reiniciar fase caso não alcance esse percentual 
 */

//****************************************************************
//****************************************************************