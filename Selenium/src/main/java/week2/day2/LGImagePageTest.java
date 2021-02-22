package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGImagePageTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[contains(text(),'go home')]/following-sibling::img[contains(@onclick,'home.html')]")).click();
		if(driver.getCurrentUrl().contains("home.html")) {
			System.out.println("Landed in Home Page");
		}else {
			System.out.println("Not working as Expected");
		}
		driver.navigate().back();
		driver.findElement(By.xpath("//label[contains(text(),'Broken Image?')]/following-sibling::img")).click();
		if(driver.getCurrentUrl().contains("Image.html")) {
			System.out.println("The link is broken, No navigation occured");
		}else {
			System.out.println("The link is not broken");
		}
		driver.findElement(By.xpath("//label[contains(text(),'Keyboard or Mouse')]/following-sibling::img[contains(@src,'keyboard')]")).click();
		if(driver.getCurrentUrl().contains("home.html")) {
			System.out.println("Clicked on the link and landed in Home Page");
		}else {
			System.out.println("Not working as Expected");
		}
		//driver.close();
	}

}
