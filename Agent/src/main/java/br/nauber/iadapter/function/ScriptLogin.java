package br.nauber.iadapter.function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScriptLogin implements IScriptSelenium {

	@Override
	public void run() {

		
		
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/login.jsp");
		driver.findElement(By.name("nickname")).clear();
		driver.findElement(By.name("nickname")).sendKeys(
				"teste" + System.currentTimeMillis());
		driver.findElement(By.name("Submit")).click();

		driver.close();	
	}

}
