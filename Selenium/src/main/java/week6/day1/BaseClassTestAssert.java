package week6.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTestAssert {
	RemoteWebDriver driver;
	public String fileName;
	public String sheetNumber;
	public SoftAssert softAssert;
	@Parameters({"browser","url","userName","passWord"})
	@BeforeMethod
	public void precondition(String browser,String url,String userName,String passWord) {
		System.out.println("In BeforeMethod");
		softAssert=new SoftAssert();
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);		
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@AfterMethod
	public void postConditions() {
		System.out.println("In AfterTest");
		driver.close();
	}
	@DataProvider(name="Data")
	public String[][] sendData() throws IOException{
		System.out.println("In DataProvider");
		MethodDataProvider obj1=new MethodDataProvider();
		return obj1.extractData(fileName, sheetNumber);
	}
}
