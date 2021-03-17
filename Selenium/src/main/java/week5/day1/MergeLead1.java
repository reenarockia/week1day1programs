package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MergeLead1 extends Baseclass1 {
	@BeforeTest
	public void setFileName(){
		fileName="datafile";
		sheetNumber="MergeLead";
	}
	@Test(dataProvider="Data")
	public void runMergeLead1(String leadId1,String leadId2) throws InterruptedException {

		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.linkText("Merge Leads")).click();

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();

		Set<String> allHandles=driver.getWindowHandles();
		List<String> allHandlesList=new ArrayList<String>(allHandles);
		driver.switchTo().window(allHandlesList.get(1));
		driver.manage().window().maximize();

		driver.findElement(By.name("id")).sendKeys(leadId1);

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr[1]/td[2]/following::a[@class='linktext'])[1]")).click();

		driver.switchTo().window(allHandlesList.get(0));
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Thread.sleep(3000);
		Set<String> allHandles2=driver.getWindowHandles();
		List<String> allHandlesList2=new ArrayList<String>(allHandles2);
		driver.switchTo().window(allHandlesList2.get(1));
		driver.manage().window().maximize();

		driver.switchTo().window(allHandlesList2.get(1));

		driver.findElement(By.name("id")).sendKeys(leadId2);

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr[1]/td[2]/following::a[@class='linktext'])[1]")).click();

		driver.switchTo().window(allHandlesList.get(0));

		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Thread.sleep(3000);

		driver.switchTo().alert().accept();

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.name("id")).sendKeys(leadId1);

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		WebElement check=driver.findElement(By.className("x-paging-info"));
		if(check.getText().equalsIgnoreCase("No records to display")) {
			System.out.println("No records to display - Lead info Merged successfully");
		}else {
			System.out.println("Lead info didn't merge successfully");
		}
		
	}

}
