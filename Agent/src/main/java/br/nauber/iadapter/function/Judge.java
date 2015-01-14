package br.nauber.iadapter.function;

import java.util.ArrayList;
import java.util.List;

import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;

public class Judge extends Thread {

	public static void verifyWinner(int numberOfGames, int counter)
			throws InvalidConfigurationException {
		if (counter <= numberOfGames) {
			if (Game.getAtackPoint() > Game.getDefenderPoint()) {
				System.out.println("===================");
				System.out.println("Ataque ganhou");
				System.out.println("===================");
				System.out.println("===================");
				System.out.println(Game.atackPoint);
				System.out.println("===================");
				System.out.println(Game.defenderPoint);
				System.out.println("===================");

				Game.atackPoint = 0;
				Game.defenderPoint = 0;

				Game.defendGenotype = Game.getBestFit(Game.defendGenotype,
						Game.defenderConfiguration);

				Game.showCromossomes(Game.defendGenotype, "Apos selecao",
						"Defender");

				Game.crossOverOperation(Game.defendGenotype,
						Game.defenderConfiguration);

				Game.showCromossomes(Game.defendGenotype, "Apos cross over",
						"Defender");

				Game.defendGenotype.evolve();

				verifyWinner(numberOfGames, ++counter);

			} else {

				System.out.println("===================");
				System.out.println("Defesa ganhou");
				System.out.println("===================");
				System.out.println(Game.atackPoint);
				System.out.println("===================");
				System.out.println(Game.defenderPoint);
				System.out.println("===================");

				Game.atackPoint = 0;
				Game.defenderPoint = 0;

				Game.atackGenotype = Game.getBestFit(Game.atackGenotype,
						Game.atackConfiguration);

				Game.showCromossomes(Game.atackGenotype, "Apos selecao",
						"Atack");

				Game.crossOverOperation(Game.atackGenotype,
						Game.atackConfiguration);

				Game.showCromossomes(Game.getAtackGenotype(),
						"Apos cross over", "Atack");

				verifyWinner(numberOfGames, ++counter);

			}
		}
	}

	private static Game game;

	public static boolean executando;

	public static long requestGameAtaque(IChromosome a_subject,
			boolean atackPlayer) {

		long max = 0;

		synchronized (Judge.class) {

			Judge.executando = true;

			for (Object defensor : Game.defendGenotype.getChromosomes()) {

				for (IRunner runner : Game.getRunnersDefend()) {
					try {
						System.out.println("===================");
						System.out
								.println("Start runner defend -request atack ");
						System.out.println("===================");
						runner.run((IChromosome) defensor);
					} catch (Exception e) {
						System.out.println("Erro no defensor -request atack ");
						e.printStackTrace();
					}
				}

				for (IRunner runner : Game.getRunnersAtack()) {

					if (runner instanceof SeleniumRunner) {

						max = (long) runner.run(a_subject);
					}

					else {

						long timeInit = System.currentTimeMillis();

						try {
							System.out.println("===================");
							System.out
									.println("Start runner atack -request atack  ");
							System.out.println("===================");

							runner.run(a_subject);

						} catch (Exception e) {
							System.out
									.println("Erro no atacante -request atack ");
							e.printStackTrace();
						}

						long timeEnd = System.currentTimeMillis();

						long value = timeEnd - timeInit;

						if (value > max) {
							max = value;
						}
					}

				}

				for (IRunner runner : Game.getRunnersDefend()) {
					try {
						System.out.println("===================");
						System.out
								.println("Stop runner defend -request atack  ");
						System.out.println("===================");
						runner.stop((IChromosome) defensor);
					} catch (Exception e) {
						System.out.println("===================");
						System.out.println("Erro no defensor -request atack ");
						System.out.println("===================");
						e.printStackTrace();
					}
				}

				for (IRunner runner : Game.getRunnersAtack()) {
					runner.stop(a_subject);
				}
			}

			if (max > 0) {
				if (max > Game.getGoalValue()) {
					Game.setAtackPoint(Game.getAtackPoint() + 1);
					System.out.println("===================");
					System.out.println("Ponto pro ataque time:" + max
							+ " goal:" + Game.getGoalValue());
					System.out.println("===================");
				} else {
					Game.setDefenderPoint(Game.getDefenderPoint() + 1);
					System.out.println("===================");
					System.out.println("Ponto pra defesa time:" + max
							+ " goal:" + Game.getGoalValue());
					System.out.println("===================");
				}
			} else {

				System.out.println("===================");
				System.out
						.println("Erro execucao desconsiderada -request atack "
								+ max);
				System.out.println("===================");
				return 0;

			}

			return max;
		}

	}

	private static long bilheteDefensor = -1;

	private static long bilheteAtacante;

	public static long getBilheteDefensor() {
		return bilheteDefensor;
	}

	public static void setBilheteDefensor(long bilheteDefensor) {
		Judge.bilheteDefensor = bilheteDefensor;
	}

	public static long getBilheteAtacante() {
		return bilheteAtacante;
	}

	public static void setBilheteAtacante(long bilheteAtacante) {
		Judge.bilheteAtacante = bilheteAtacante;
	}

	private static double porta;

	public static double getPorta() {
		return porta;
	}

	public static void setPorta(double porta) {
		Judge.porta = porta;
	}

	public static boolean waitPlayer;

	public static boolean gameFinish;

	public static boolean isGameFinish() {
		return gameFinish;
	}

	public static void setGameFinish(boolean gameFinish) {
		Judge.gameFinish = gameFinish;
	}

	public static boolean isWaitPlayer() {
		return waitPlayer;
	}

	public static void setWaitPlayer(boolean waitPlayer) {
		Judge.waitPlayer = waitPlayer;
	}

	private static double responseTime;

	public static double getResponseTime() {
		return responseTime;
	}

	public static void setResponseTime(double responseTime) {
		Judge.responseTime = responseTime;
	}

	public static double requestGameDefend(IChromosome a_subject) {
		long max = 0;

		synchronized (Judge.class) {

			Judge.executando = true;

			for (Object chromossome : Game.atackGenotype.getChromosomes()) {
				for (IRunner runner : Game.getRunnersDefend()) {
					try {
						System.out.println("===================");
						System.out
								.println("Start runner defend -request defend ");
						System.out.println("===================");
						runner.run((IChromosome) a_subject);
						System.out.println("===================");
						System.out
								.println("StartED runner defend -request defend ");
						System.out.println("===================");
					} catch (Exception e) {
						max = -1000;
						System.out.println("Erro no defensor -request defend");
						e.printStackTrace();
					}
				}

				for (IRunner runner : Game.getRunnersAtack()) {
					if (runner instanceof SeleniumRunner) {
						System.out.println("===================");
						System.out
								.println("Start runner atack -request defend ");
						System.out.println("===================");

						max = (long) runner.run((IChromosome) chromossome);

						System.out.println("===================");
						System.out.println("max " + max);
						System.out.println("===================");

					} else {

						long timeInit = System.currentTimeMillis();

						try {
							System.out.println("===================");
							System.out
									.println("Start runner atack -request defend ");
							System.out.println("===================");

							runner.run((IChromosome) chromossome);

						} catch (Exception e) {
							max = -1000;
							System.out.println("Erro no atacante ");
							e.printStackTrace();
						}

						long timeEnd = System.currentTimeMillis();

						long value = timeEnd - timeInit;

						if (value > max) {
							max = value;
						}
						runner.stop((IChromosome) chromossome);
					}

				}
				for (IRunner runner : Game.getRunnersDefend()) {
					try {
						System.out.println("===================");
						System.out
								.println("Stop runner defend -request defend ");
						System.out.println("===================");
						runner.stop((IChromosome) a_subject);
					} catch (Exception e) {
						System.out.println("Erro no defensor -request defend");
						e.printStackTrace();
					}
				}

				if (max > 0) {
					if (max > Game.getGoalValue()) {
						Game.setAtackPoint(Game.getAtackPoint() + 1);
						System.out.println("===================");
						System.out.println("Ponto pro ataque time:" + max
								+ " goal:" + Game.getGoalValue());
						System.out.println("===================");
					} else {
						Game.setDefenderPoint(Game.getDefenderPoint() + 1);
						System.out.println("===================");
						System.out.println("Ponto pra defesa time:" + max
								+ " goal:" + Game.getGoalValue());
						System.out.println("===================");
					}
				} else {
					System.out.println("===================");
					System.out.println("Erro execucao desconsiderada:" + max
							+ " goal:" + Game.getGoalValue());
					System.out.println("===================");
					return Double.MAX_VALUE;

				}
			}

		}

		return max;
	}
}
