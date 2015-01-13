package br.nauber.iadapter.function;

public class ScriptSeleniumThread extends Thread {

	private IScriptSelenium script;

	private long time;

	public ScriptSeleniumThread(IScriptSelenium script) {
		this.script = script;
	}

	@Override
	public void run() {
		
		long max=0;
		super.run();
		
		long timeInit = System.currentTimeMillis();

		try {
			System.out.println("===================");
			System.out.println("Start runner atack ");
			System.out.println("===================");


		
		script.run();
		

		} catch (Exception e) {
			System.out.println("Erro no atacante");
			e.printStackTrace();
		}

		long timeEnd = System.currentTimeMillis();

		long value = timeEnd - timeInit;

		if (value > max) {
			max = value;
		}
		
		this.time=max;
		
		
	}

	public IScriptSelenium getScript() {
		return script;
	}

	public void setScript(IScriptSelenium script) {
		this.script = script;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
