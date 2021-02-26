package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGCheckboxTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		
		//To select the languages 
		WebElement elementToSelectJava=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		elementToSelectJava.click();
		WebElement elementToSelectC=driver.findElement(By.xpath("(//input[@type='checkbox'])[4]"));
		elementToSelectC.click();
		//System.out.println("Languages Selected : "+ elementToSelectJava.getText() + ','+elementToSelectC.getText());
		
		//confirm selenium is checked
		WebElement elementToCheckedSelenium=driver.findElement(By.xpath("(//input[@checked])[1]"));
		System.out.println(elementToCheckedSelenium.isSelected());
		if(elementToCheckedSelenium.isSelected()) {
			System.out.println("Selenium is checked");
		}else {
			System.out.println("Selenium is not checked");
			}
		
		//DeSelect only checked - here we have to deSelect "I am selected"
		WebElement optionToDeselect=driver.findElement(By.xpath("(//input[@checked])[2]"));
		if(optionToDeselect.isSelected()) {
			optionToDeselect.click();
			System.out.println("I am selcted checkbox is deselected");
		}
		
		//select all below checkboxes
		
		List<WebElement> options= driver.findElements(By.xpath("((//div[@class='example'])[4]//div/input)"));
		System.out.println("Number of options: "+options.size());
		for (WebElement webElement : options) {
				webElement.click();
			}
			
		//driver.close();
		
		
	}

}
