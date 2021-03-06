package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealMensFashion {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		WebElement mensFashion=driver.findElement(By.xpath("(//span[contains(text(),'Men')])[2]"));
		WebElement loafers=driver.findElement(By.xpath("//span[text()='Loafers']"));
		Actions actionObj=new Actions(driver);
		actionObj.moveToElement(mensFashion).click(loafers).perform();
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		WebElement loafersOption1=driver.findElement(By.xpath("(//img[@class='product-image '])[1]"));
		WebElement loaferQuickView=driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
		actionObj.moveToElement(loafersOption1).click(loaferQuickView).perform();
		
		//driver.quit();
		
		
	}

}
