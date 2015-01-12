package br.nauber.iadapter.function;

import java.util.ArrayList;
import java.util.List;

import org.jgap.Gene;
import org.jgap.IChromosome;

public class Game {
	
	private static List<IRunner> runnersAtack=new ArrayList();
	
	private static List<IRunner> runnersDefend=new ArrayList();

	private static int numberMaxPlayers;

	public static List<IRunner> getRunnersAtack() {
		return runnersAtack;
	}

	public static void setRunnersAtack(List<IRunner> runnersAtack) {
		Game.runnersAtack = runnersAtack;
	}

	public static List<IRunner> getRunnersDefend() {
		return runnersDefend;
	}

	public void setRunnersDefend(List<IRunner> runnersDefend) {
		Game.runnersDefend = runnersDefend;
	}

	public List<IChromosome> getAtacantes() {
		return atacantes;
	}

	public void setAtacantes(List<IChromosome> atacantes) {
		this.atacantes = atacantes;
	}

	public static int getNumberMaxPlayers() {
		return numberMaxPlayers;
	}

	public static void setNumberMaxPlayers(int numberMaxPlayers) {
		Game.numberMaxPlayers = numberMaxPlayers;
	}

	public List<IChromosome> getDefensores() {
		return defensores;
	}

	public void setDefensores(List<IChromosome> defensores) {
		this.defensores = defensores;
	}

	private int numberOfPlayers;

	private List<IChromosome> atacantes = new ArrayList<IChromosome>();
	private List<IChromosome> defensores = new ArrayList<IChromosome>();;

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public static void main(String[] args) {

		
		
		Game.getRunnersAtack().add(new SeleniumRunner());
		Game.getRunnersDefend().add(new TomCatRunner());

		Game.setNumberMaxPlayers(2);

		ScriptPopulation script = new ScriptPopulation();
		script.start();

		TomCatPopulation population = new TomCatPopulation();
		population.start();

		// Set the fitness function we want to use, which is our
		// MinimizingMakeChangeFitnessFunction that we created earlier.
		// We construct it with the target amount of change provided
		// by the user.
		// ------------------------------------------------------------

	}

}
