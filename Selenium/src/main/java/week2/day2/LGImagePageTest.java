package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGImagePageTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		
		//click on the image and check whether we landed in home page
		driver.findElement(By.xpath("//label[contains(text(),'go home')]/following-sibling::img[contains(@onclick,'home.html')]")).click();
		if(driver.getCurrentUrl().contains("home.html")) {
			System.out.println("Landed in Home Page");
		}else {
			System.out.println("Not working as Expected");
		}
		driver.navigate().back();
		
		//Am I broken image? check
		driver.findElement(By.xpath("//label[contains(text(),'Broken Image?')]/following-sibling::img")).click();
		if(driver.getCurrentUrl().contains("Image.html")) {
			System.out.println("The link is broken, No navigation occurred");
		}else {
			System.out.println("The link is not broken");
			driver.navigate().back();
		}
		
		//Click me using keyboard or mouse check
		
		WebElement clickByKeyboardMouse=driver.findElement(By.xpath("//img[contains(@onclick,'home.html') and contains(@src,'keyboard.png')]"));
		
//		clickByKeyboardMouse.sendKeys(Keys.ENTER); - throwing ElementNotInteractableException.
		System.out.println(clickByKeyboardMouse.getAttribute("onclick"));
		String s=clickByKeyboardMouse.getAttribute("onclick");
		String[] splitList=s.split("'");
		String s2="";
		for (String string : splitList) {
			System.out.println(string);
			if(string.contains("html")){
				s2=string;
			}

		}
		System.out.println("s2"+s2);
		clickByKeyboardMouse.sendKeys(Keys.ENTER.valueOf(s2));
		
//		System.out.println(clickByKeyboardMouse);
		driver.getKeyboard();
//		String linkToBeClicked=clickByKeyboardMouse.getAttribute("onclick");
//		System.out.println(linkToBeClicked);
//		clickByKeyboardMouse.sendKeys(Keys.ENTER);
//		
//		if(driver.getCurrentUrl().contains("home.html")) {
//			System.out.println("Clicked on the link through keyboard and landed in Home Page");
//		}else {
//			System.out.println("Not working as Expected");
//		}
//		//driver.close();
	}

}
