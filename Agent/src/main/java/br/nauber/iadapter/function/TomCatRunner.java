package br.nauber.iadapter.function;

import org.jgap.IChromosome;

public class TomCatRunner implements IRunner {

	TomCatServer tomcat = new TomCatServer();
	@Override
	public double run(IChromosome chromosome) {
		

		int porta = (Integer) chromosome.getGenes()[0].getAllele();

		System.out.println(porta);
		tomcat.setPorta(8080);
		tomcat.setTimeout((Integer) chromosome.getGenes()[1].getAllele());

		tomcat.start();
		Judge.setPorta(8080);

		return 0;
	}

	@Override
	public double stop(IChromosome chromosome) {
		tomcat.stop();
		// TODO Auto-generated method stub
		return 0;
	}

}
