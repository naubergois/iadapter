package br.nauber.iadapter.function;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleState;
import org.jgap.IChromosome;

public class TomCatRunner implements IRunner {

	TomCatServer tomcat = new TomCatServer();

	@Override
	public double run(IChromosome chromosome) {

		// tomcat = new TomCatServer();

		int porta = (Integer) chromosome.getGenes()[0].getAllele();

		System.out.println(porta);
		tomcat.setPorta(8080);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		try {
			if (tomcat.getTomcat().getServer().getState()==LifecycleState.STARTED) {
				tomcat.getTomcat().getServer().stop();
				tomcat.ctx.setSessionTimeout((Integer) chromosome.getGenes()[1].getAllele());
				tomcat.getTomcat().getServer().start();
			} else {
				
				tomcat.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Judge.setPorta(8080);

		return 0;
	}

	@Override
	public double stop(IChromosome chromosome) {
		try {

			tomcat.stopp();

		} catch (LifecycleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
