package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		Select dropDown1=new Select(driver.findElement(By.id("dropdown1")));
		dropDown1.selectByIndex(1);
		Select dropDown2=new Select(driver.findElement(By.name("dropdown2")));
		dropDown2.selectByVisibleText("Appium");
		Select dropDown3=new Select(driver.findElement(By.id("dropdown3")));
		dropDown3.selectByValue("3");
		List<WebElement> dropdownlist=driver.findElements(By.xpath("//select"));
		System.out.println("Number of dropdowns present: "+dropdownlist.size());
		driver.findElement(By.xpath("//option[contains(text(),'sendKeys')]/parent::select")).sendKeys("Loadrunner");
		Select dropDown5=new Select(driver.findElement(By.xpath("//option[contains(text(),'programs')]/parent::select[@multiple]")));
		dropDown5.selectByVisibleText("Selenium");
		dropDown5.selectByVisibleText("UFT/QTP");
		//driver.close();
		
	}

}
