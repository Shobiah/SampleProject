package org.proj1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		
		WebElement txtSearch = driver.findElement(By.name("q"));
		txtSearch.sendKeys("iphone");
		
		driver.findElement(By.className("L0Z3Pu")).click();
		
		List<WebElement> prodNames = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> prodPrice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		
		System.out.println("total no of value"+prodNames.size()+"\n");
		
		int size = prodNames.size();
		
		for(int i=0;i<size;i++)
		{
			System.out.println(prodNames.get(i).getText());
			System.out.println(prodPrice.get(i).getText());
	        System.out.println("<======================================>");	
		}


        
		driver.quit();
		
}

}
