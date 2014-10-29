package previero.testes;

public class Contador extends Thread{

	public void run(){
		
		int quant = 40;
		//int valorProgress = Janela.progressBar.getMaximum()/quant;
		Janela.progressBar.setValue(0);
		//System.out.println(valorProgress);
		
		for (int i = quant; i > 0; i--) {

			if (Janela.getZerar() == true) {
				i = quant;
				Janela.setZerar(false);
				Janela.progressBar.setValue(0);
			}
			
			try {

				Thread.sleep(250);

			} catch (Exception e) {}
			
			Janela.setLblNewLabel(Double.toString(i));
			
			Janela.progressBar.setValue(Janela.progressBar.getValue() + i);
			

		}
		
	}

}