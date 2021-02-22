package week2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGHyperLinkPageTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println("Title: "+driver.getTitle());
		driver.navigate().back();
		WebElement url=driver.findElement(By.xpath("//a[@href='Button.html']"));
		System.out.println("Find where am supposed to go without clicking:\n"+url);
		driver.findElement(By.xpath("//a[@href='error.html']")).click();
		if(driver.getCurrentUrl().contains("error.html")) {
			System.out.println("Verify am I broken link is broken");
		}else {
			System.out.println("Verify am I broken link is not broken");
		}
		driver.navigate().back();
		driver.findElement(By.xpath("//label[contains(text(),'same link name')]/preceding-sibling::a[contains(text(),'Home Page')]")).click();
		if(driver.getCurrentUrl().contains("home.html")) {
			System.out.println("Interacted with the same link to go to Home Page");
		}else {
			System.out.println("not working as expected");
		}
		driver.navigate().back();
		List<WebElement> linkslist=driver.findElements(By.xpath("//a"));
		System.out.println("Number of links present in this page: "+linkslist.size());
		//driver.close();
	}

}
