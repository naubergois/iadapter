package br.nauber.iadapter.function;

public class ScriptGene extends TestGene {
	
	public ScriptGene(int scriptNumber,int userNumber){
		this.scriptName=scriptNumber;
		this.userNumber=userNumber;
	}
	
	
	private int userNumber;
	
	private int scriptName;

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getScriptName() {
		return scriptName;
	}

	public void setScriptName(int scriptName) {
		this.scriptName = scriptName;
	}

}
