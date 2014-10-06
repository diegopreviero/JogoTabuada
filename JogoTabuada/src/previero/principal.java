package previero;

public class principal {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			Tabuada t = new Tabuada(3,5,3,0);
			System.out.println(t.getResultados()[1]);
		}
		
	}
}