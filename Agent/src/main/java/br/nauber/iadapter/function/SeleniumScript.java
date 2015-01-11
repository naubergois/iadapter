package br.nauber.iadapter.function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumScript {

	SeleniumScript(int porta) {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:" + porta + "/login.jsp");
		driver.findElement(By.name("nickname")).clear();
		driver.findElement(By.name("nickname")).sendKeys("teste"+System.currentTimeMillis());
		driver.findElement(By.name("Submit")).click();

		driver.close();

	}

}
