package br.nauber.iadapter.function;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class TomCatServer extends Thread{
	
	private int timeout;
	private int porta;
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			System.out.println("Working Directory = "
					+ System.getProperty("user.dir"));
			String webappDirLocation = "web/chat";
			Tomcat tomcat = new Tomcat();

			// The port that we should run on can be set into an environment
			// variable
			// Look for that variable and default to 8080 if it isn't there.
			String webPort = System.getenv("PORT");
			if (webPort == null || webPort.isEmpty()) {
				webPort = String.valueOf(porta);
			}

			tomcat.setPort(Integer.valueOf(webPort));
			
		

			Context ctx = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
			ctx.setSessionTimeout(timeout);
			
			System.out.println("configuring app with basedir: "
					+ new File("./" + webappDirLocation).getAbsolutePath());

			tomcat.start();
			tomcat.getServer().await();

		} catch (Exception e) {

		}
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public TomCatServer(){
		
	}

}
