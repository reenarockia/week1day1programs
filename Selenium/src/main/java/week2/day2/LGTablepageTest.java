package week2.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGTablepageTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Long sleepTime=2000L;
		//Thread.sleep(sleepTime);
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
		
		//Get the count of number of columns
		List<WebElement> columns=driver.findElements(By.xpath("//table[@id='table_id']//th"));
		System.out.println("Number of columns in this webtable: "+columns.size());
		
		//Get the count of number of rows
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		System.out.println("Number of rows in this webtable: "+rows.size());
		
		//Get the progress value of 'learn to interact with elements'
		
		System.out.println("Progress value of 'learn to interact with elements' is: "+ driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText());
		
		//check the vital task for the least completed progress
		List<WebElement> progress=driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		int NoOfprogressValues=progress.size();
		
		List<Integer> progressTextArray=new ArrayList<Integer>(NoOfprogressValues);
		
		for (WebElement webElement : progress) {
			String num=webElement.getText().replaceAll("%","");
			int i=Integer.parseInt(num);
			progressTextArray.add(i);
		}
		System.out.println("LeastProgressValue: "+Collections.min(progressTextArray));
		driver.findElement(By.xpath("//td[contains(text(),'"+Collections.min(progressTextArray)+"')]/following::input[@name='vital']")).click();
//		driver.close();
	}

}
