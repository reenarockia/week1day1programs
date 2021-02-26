package week2.day2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LGRadioButtonPageTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		
		//to click on yes radio button for "Are you enjoying the classes?"
		driver.findElement(By.id("yes")).click();
		
		//To find the default selected button- result - checked
		WebElement defaultCheck=driver.findElement(By.xpath("//label[@for='Checked']"));
		System.out.println("default selected radio button name is: "+ defaultCheck.getText());

		
		//To select the age group (only if the choice is not selected)
		List<WebElement> ageGroup=driver.findElements(By.name("age"));
		
		for ( WebElement webElement : ageGroup) {
			if(!webElement.isSelected()) {
				webElement.click();
				}
		}
		//to confirm whether the given radio button is checked or not
			List<WebElement> defSelectRadioButtons=driver.findElements(By.xpath("//label[contains(@for,'hecked')]"));
			System.out.println("Number of Radiobutton elements "+defSelectRadioButtons.size());
			
			for (WebElement webElement2 : defSelectRadioButtons) {
				//System.out.println(webElement2.isSelected());
				boolean checkStatus=webElement2.isSelected();
				if(checkStatus==true) {
					System.out.println(webElement2.getText()+" is selected by default");
				}else {
					System.out.println(webElement2.getText()+" is not selected by default");
				}
			}
		}
		
	}


