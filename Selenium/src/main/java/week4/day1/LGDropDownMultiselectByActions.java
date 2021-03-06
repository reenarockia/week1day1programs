package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGDropDownMultiselectByActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		WebElement source=driver.findElement(By.xpath("(//select)[6]//following::option[text()='Appium']"));
		WebElement target=driver.findElement(By.xpath("(//select)[6]//following::option[text()='Loadrunner']"));
		Actions actionsObj=new Actions(driver);
		actionsObj.keyDown(Keys.CONTROL).click(source).click(target).keyUp(Keys.CONTROL).perform();
		System.out.println("successfully selected both Appium as well as Loadrunner");
		//driver.close();
		
	}

}
