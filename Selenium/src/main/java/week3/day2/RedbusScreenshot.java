package week3.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RedbusScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.DISMISS);
		ChromeOptions option=new ChromeOptions();
		option.merge(cap);
		
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Thread.sleep(30000);
		driver.manage().window().maximize();
		driver.findElement(By.id("src")).sendKeys("Koyambedu, Chennai");
		Thread.sleep(3000);
		driver.findElement(By.id("src")).sendKeys(Keys.TAB);
		driver.findElement(By.id("dest")).sendKeys("Madurai (All Locations)");
		Thread.sleep(3000);
		driver.findElement(By.id("dest")).sendKeys(Keys.TAB);
		driver.findElement(By.id("onward_cal")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//table[contains(@class,'rb-monthTable')]//tr/td[@class='current day']/following::td)")).click();
		driver.findElement(By.id("search_btn")).click();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		WebElement busesInfo=driver.findElement(By.xpath("(//div[text()='Showing']/span[text()='buses'])[1]"));
		String noOfBuses=busesInfo.getText().replaceAll("[^0-9]"," ");
		System.out.println("Number of buses available: "+ noOfBuses);
		List<WebElement> travels=driver.findElements(By.className("travels"));
		List<String> travelsNames=new ArrayList<String>();
		for (WebElement webElement : travels) {
			travelsNames.add(webElement.getText());
		}
	
		Set<String> uniqueTravelsNames=new LinkedHashSet<String>(travelsNames);
		System.out.println("UNIQUE TRAVELS NAMES:");
		System.out.println("--------------------");
		for (String string : uniqueTravelsNames) {
			System.out.println(string);
		}
		System.out.println("number of travels in the list "+travelsNames.size());
		System.out.println("Number of travels in UniqueTravelsNames: "+uniqueTravelsNames.size());
		driver.findElement(By.xpath("(//i[contains(@class,'icon-close')])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[contains(@class,'icon-close')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='View Seats'])[1]")).click();
		Thread.sleep(3000);
		Date scrDate=new Date();
		String dateToAppend=scrDate.toString();
		String dateToAppend1=dateToAppend.replaceAll(":", "");
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./snaps/redbusseats"+dateToAppend1+".png");
		FileUtils.copyFile(source, target);
		System.out.println("The screenshot of the first bus's available seats is in snaps");
		}
		

}
