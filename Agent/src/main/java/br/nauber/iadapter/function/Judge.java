package br.nauber.iadapter.function;

import org.jgap.IChromosome;

public class Judge extends Thread {

	private static Game game;

	public static boolean executando;

	public static long requestGameAtaque(IChromosome a_subject,
			boolean atackPlayer) {

		long max = 0;

		synchronized (Judge.class) {

			Judge.executando = true;

			for (Object defensor : Game.defendPopulation.getChromosomes()) {

				for (IRunner runner : Game.getRunnersDefend()) {
					try {
						runner.run((IChromosome) defensor);
					} catch (Exception e) {
						System.out.println("Erro no defensor");
						e.printStackTrace();
					}
				}

				for (IRunner runner : Game.getRunnersAtack()) {

					long timeInit = System.currentTimeMillis();

					try {

						runner.run(a_subject);

					} catch (Exception e) {
						System.out.println("Erro no atacante");
						e.printStackTrace();
					}

					long timeEnd = System.currentTimeMillis();

					long value = timeEnd - timeInit;

					if (value > max) {
						max = value;
					}

				}

				for (IRunner runner : Game.getRunnersDefend()) {
					try {
						runner.stop((IChromosome) defensor);
					} catch (Exception e) {
						System.out.println("Erro no defensor");
						e.printStackTrace();
					}
				}

				for (IRunner runner : Game.getRunnersAtack()) {
					runner.stop(a_subject);
				}
			}

		}

		return max;

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

		

			for (Object chromossome : Game.atackPopulation.getChromosomes()) {
				for (IRunner runner : Game.getRunnersDefend()) {
					try {
						runner.run((IChromosome) a_subject);
					} catch (Exception e) {
						System.out.println("Erro no defensor");
						e.printStackTrace();
					}
				}
				
				
				for (IRunner runner : Game.getRunnersAtack()) {

					long timeInit = System.currentTimeMillis();

					try {

						runner.run( (IChromosome) chromossome);

					} catch (Exception e) {
						System.out.println("Erro no atacante");
						e.printStackTrace();
					}

					long timeEnd = System.currentTimeMillis();

					long value = timeEnd - timeInit;

					if (value > max) {
						max = value;
					}
					runner.stop((IChromosome) chromossome);
					

				}
				for (IRunner runner : Game.getRunnersDefend()) {
					try {
						runner.stop((IChromosome) a_subject);
					} catch (Exception e) {
						System.out.println("Erro no defensor");
						e.printStackTrace();
					}
				}
			}

			

		}

		return max;
	}
}
