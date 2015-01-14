package br.nauber.iadapter.function;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.jgap.IChromosome;

public class JMeterRunner implements IRunner {
	
	private static List<String> jmeterScript=new ArrayList<String>();

	public static List<String> getJmeterScript() {
		return jmeterScript;
	}

	public static void setJmeterScript(List<String> jmeterScript) {
		JMeterRunner.jmeterScript = jmeterScript;
	}

	@Override
	public double run(IChromosome chromosome) {

		try {
			
			List<JMeterThread> threads = new ArrayList<JMeterThread>();

			for (int i = 0; i <= chromosome.size() - 2; i = i + 2) {
				int script = (Integer) chromosome.getGenes()[i].getAllele();
				int user = (Integer) chromosome.getGenes()[i + 1].getAllele();

				System.out.println("===================");
				System.out.println("Script " + script);
				System.out.println("===================");

				

				String scriptJMeter = JMeterRunner
						.getJmeterScript().get(script);
				
				
				for (int j = 0; j < user; j++) {

					System.out.println("===================");
					System.out.println("User " + user);
					System.out.println("===================");
					
					JMeterThread  thread = new JMeterThread(
							scriptJMeter);

					thread.start();
					threads.add(thread);

				}
				
				/*int counter = 0;
				while (counter <= threads.size() - 1) {
					counter = 0;
					for (JMeterThread thread : threads) {

						if (!(thread.isAlive())) {
							value = thread.getTime();
							if (value > max) {
								max = value;
							}
							counter++;
						}

					}
				}*/

			}

			// TODO Auto-generated method stub
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public double stop(IChromosome chromosome) {
		// TODO Auto-generated method stub
		return 0;
	}

}
