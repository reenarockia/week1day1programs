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
		
		//verify whether we landed in Home page
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println("Title: "+driver.getTitle());
		String homeURL=driver.getCurrentUrl();
		if(homeURL.contains("home.html")) {
			System.out.println("Landeded in Home Page");
		}else {
			System.out.println("Error:Not in Home Page");
		}
		driver.navigate().back();
		
		//verify the link without clicking it
		WebElement url=driver.findElement(By.partialLinkText("without clicking me?"));
		String linkWithoutClicking=url.getAttribute("href");
		System.out.println("Find where am supposed to go without clicking:\n "+ linkWithoutClicking);
		//Now click the link and go to the page to get the url so that we can check it with the previous output(linkWithoutClicking)
		url.click();
		String linkWithClicking = driver.getCurrentUrl();
		//compare the results
		if(linkWithoutClicking.equalsIgnoreCase(linkWithClicking)) {
			System.out.println("Find where am supposed to go without clicking: Test pass");
		}else {
			System.out.println("Find where am supposed to go without clicking: Test Fail");
		}
		driver.navigate().back();
		
		//verify whether the link is broken
		WebElement brokenURL=driver.findElement(By.linkText("Verify am I broken?"));
		brokenURL.click();
		if(driver.getTitle().contains("HTTP Status 404")){;
			System.out.println(driver.getTitle());
			System.out.println("The link is broken - Test pass");
		}else {
			System.out.println("The link is not broken - Test Fail");
		}
		driver.navigate().back();
		
		//interact with same link name
		WebElement sameLink=driver.findElement(By.xpath("//label[contains(text(),'same link name')]/preceding-sibling::a[@link='blue']"));
		sameLink.click();
		String currentURL=driver.getCurrentUrl();
		if(currentURL.equalsIgnoreCase(homeURL)) {
			System.out.println("Test Pass: same Links");
		}else {
			System.out.println("Test Fail: Different Links");
		}
		driver.navigate().back();
		
		//to find number of links present in this page
		List<WebElement> numberofLinks=driver.findElements(By.xpath("//a[@href]/parent::div"));
		System.out.println("Number of links present in this page: " + numberofLinks.size());
		driver.close();
}
}
		