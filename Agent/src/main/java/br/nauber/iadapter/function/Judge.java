package br.nauber.iadapter.function;

import java.util.ArrayList;
import java.util.List;

import org.jgap.Chromosome;
import org.jgap.IChromosome;

public class Judge extends Thread {

	private static List runners = new ArrayList();
	private static List servers = new ArrayList();

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

			for (IChromosome atack : game.getAtacantes()) {
				for (IRunner runner : Game.getRunnersAtack()) {
					runner.stop(atack);
				}
			}
			for (IChromosome defensor : game.getDefensores()) {
				for (IRunner runner : Game.getRunnersDefend()) {
					runner.stop(defensor);
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

	public static double requestGameDefend(IChromosome a_subject, boolean b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
