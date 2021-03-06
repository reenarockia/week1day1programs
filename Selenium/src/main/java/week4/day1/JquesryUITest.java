package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquesryUITest {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		
		WebElement item1=driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item4=driver.findElement(By.xpath("//li[text()='Item 4']"));
       
        int targetLocationX=item4.getLocation().getX();
		int targetLocationY=item4.getLocation().getY();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", item1);
		
		Actions actionsObj=new Actions(driver);
		actionsObj.dragAndDropBy(item1, targetLocationX,targetLocationY).perform();
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./snaps/JqueryItem1Relocate.png");
		FileUtils.copyFile(source, target);
		System.out.println("The screenshot is in snaps");
		
		System.out.println("Item 1 is relocated to Item 4");
		driver.switchTo().defaultContent();
		driver.close();

		
	}

}
