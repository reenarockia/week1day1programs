package week2.day1;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeafGroundButtonPageTest {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		System.out.println("Title: "+driver.getTitle());
		driver.findElement(By.id("home")).click();
		System.out.println("Back to button page");
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
		System.out.println("position of Get position button:"+driver.findElement(By.id("position")).getLocation());
		System.out.println("color of the button What color am I?: "+ driver.findElement(By.id("color")).
				getCssValue("background-color"));
		System.out.println("size of what is my size? button: "+driver.findElement(By.id("size")).getSize());
		//driver.close();
	}

}
