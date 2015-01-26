package br.nauber.iadapter.function;

import java.util.ArrayList;
import java.util.List;

import org.jgap.IChromosome;

public class JMeterRunner implements IRunner {

	public JMeterRunner(List<String> scripts, String resultFileName,
			int columnNumber) {
		this.scripts = scripts;
		this.resultFileName = resultFileName;
		this.columnNumber = columnNumber;
	}

	private List<String> scripts = new ArrayList<String>();

	private String resultFileName;

	private int columnNumber;

	public int getColumnNumber() {
		return columnNumber;
	}

	public List<String> getScripts() {
		return scripts;
	}

	public void setScripts(List<String> scripts) {
		this.scripts = scripts;
	}

	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}

	private static List<String> jmeterScript = new ArrayList<String>();

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

				for (int j = 0; j < user; j++) {

					System.out.println("===================");
					System.out.println("User " + user);
					System.out.println("===================");

					String scriptString = scripts.get(script);

					JMeterThread thread = new JMeterThread(scriptString,user);

					thread.start();
					threads.add(thread);

				}

				int counter = 0;
				while (counter <= threads.size() - 1) {
					counter = 0;
					for (JMeterThread thread : threads) {

						if (!(thread.isAlive())) {

							counter++;
						}

					}
				}

				ReadJMeterFile jmeterFile = new ReadJMeterFile();
				jmeterFile.getMaxFile(resultFileName, columnNumber);

			}

			// TODO Auto-generated method stub
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String getResultFileName() {
		return resultFileName;
	}

	public void setResultFileName(String resultFileName) {
		this.resultFileName = resultFileName;
	}

	@Override
	public double stop(IChromosome chromosome) {
		// TODO Auto-generated method stub
		return 0;
	}

}
