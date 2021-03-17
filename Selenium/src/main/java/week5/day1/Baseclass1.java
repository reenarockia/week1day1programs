package week5.day1;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass1 {
	public ChromeDriver driver;
	public String fileName;
	public String sheetNumber; 
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preConditions(String url,String username,String password) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);		
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@AfterMethod
	public void postConditions() {
		driver.close();
	}
	 @DataProvider(name="Data")
	 public String[][] DataToPass() throws IOException {
		 LearnExcelOperations obj1=new LearnExcelOperations();
		 return obj1.ReadExcel(fileName,sheetNumber);
		 
	 }
	}
