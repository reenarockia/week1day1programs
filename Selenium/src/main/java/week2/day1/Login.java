package week2.day1;

import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.close();
		
		/*
		 WebDriverManager.chromedriver().setup();
		ChromeDriver driver1=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		String title1=driver.getTitle();
		System.out.println(title1);
		driver.close();
		*/
	}

}
