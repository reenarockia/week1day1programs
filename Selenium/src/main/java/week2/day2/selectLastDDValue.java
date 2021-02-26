package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectLastDDValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		//Select last but one option from the dropdown
		//Selecting the last value "Loadrunner" in the first dropdown.
		
		List<WebElement> dropdown1optionsElement =driver.findElements(By.xpath("(//select[@id='dropdown1']/option)"));
		int numberOfOptionDD1=dropdown1optionsElement.size();
		WebElement dropDown1Element=driver.findElement(By.id("dropdown1"));
		Select dropDown1=new Select(dropDown1Element);
		dropDown1.selectByIndex(numberOfOptionDD1-1);
		
		driver.close();
	}

}
