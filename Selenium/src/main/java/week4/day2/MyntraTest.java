package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
//		disable notifications
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.DISMISS);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver();
//		1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(30000);
//		2) Mouse over on WOMEN 
//		3) Click Jackets & Coats
		Actions builder=new Actions(driver);
		WebElement womenLink=driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Women']"));
		builder.moveToElement(womenLink).perform();
		WebElement jacketsAndCoatsLink = driver.findElement(By.xpath("//div[@class='desktop-categoryContainer']//following::a[text()='Jackets & Coats']"));
		builder.click(jacketsAndCoatsLink).perform();
		System.out.println("MouseHovered on Women link and clicked Jackets & Coats");
		Thread.sleep(3000);
//		4) Find the total count of item 
		WebElement totalItemCount=driver.findElement(By.xpath("//div[@class='title-container']//span"));
		int countOfTotalItems=Integer.parseInt(totalItemCount.getText().replaceAll("\\D",""));
		System.out.println("Total count of Items listed under Jackets and Coats: "+countOfTotalItems);
		
//		5) Validate the sum of categories count matches
		
		List<WebElement> categories=driver.findElements(By.xpath("//ul[@class='categories-list']//li//input"));
		System.out.println("Count of categories under Categories title: "+categories.size());
		Thread.sleep(3000);
		int sumOfItems=0;
		for (int i=1;i<=categories.size();i++) {
			String categoryName=driver.findElement(By.xpath("(//ul[@class='categories-list']//li//input)["+i+"]")).getAttribute("value");
			System.out.println(categoryName);
			builder.click(driver.findElement(By.xpath("(//ul[@class='categories-list']//li//input)["+i+"]"))).perform();
			Thread.sleep(3000);
			WebElement seperateItemCount=driver.findElement(By.xpath("//div[@class='title-container']//span"));
			int countOfItemsSeperately=Integer.parseInt(seperateItemCount.getText().replaceAll("\\D",""));
			System.out.println("Total count of Items listed under "+ categoryName +" : " + countOfItemsSeperately);
			sumOfItems=sumOfItems+countOfItemsSeperately;
			builder.click(driver.findElement(By.xpath("(//ul[@class='categories-list']//li//input)["+i+"]"))).perform();
		}
		System.out.println("Sum of count of Items listed under Jackets & Coats: "+ sumOfItems);	

//		6) Check Coats
		builder.click(driver.findElement(By.xpath("(//ul[@class='categories-list']//li//input)[2]"))).perform();
		System.out.println("Checked Coats");
//		7) Click + More option under BRAND
		builder.click(driver.findElement(By.xpath("//div[@class='brand-more']"))).perform();
		System.out.println("clicked on +more brands");
//		8) Type MANGO and click checkbox
		builder.click(driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//input[@value='MANGO']"))).perform();
		System.out.println("Checked on MANGO");
//		9) Close the pop-up x
		driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close')]")).click();
		System.out.println("closed the pop up");
		Thread.sleep(3000);
//		10) Confirm all the Coats are of brand MANGO
		List<WebElement> brandMANGO=driver.findElements(By.xpath("//div[@class='product-productMetaInfo']//h3"));
		int countForMANGO=0;
		for(int j=1;j<=brandMANGO.size();j++) {
			String checkForMANGO=driver.findElement(By.xpath("(//div[@class='product-productMetaInfo']//h3)["+j+"]")).getText();
			if(checkForMANGO.contains("MANGO")) {
				countForMANGO=countForMANGO+1;
			}
		}
		if(countForMANGO==brandMANGO.size()) {
			System.out.println("All the coats are of brand MANGO");
		}else {
			System.out.println("All or some of the coats are not of the brand MANGO");
		}
//		11) Sort by Better Discount
		WebElement sortBy=driver.findElement(By.xpath("//div[@class='sort-sortBy']//span[contains(@class,'myntraweb-sprite')]"));
		WebElement betterDiscount=driver.findElement(By.xpath("//ul[@class='sort-list']//label[text()='Better Discount']"));
		builder.click(sortBy).click(betterDiscount).perform();		
//		12) Find the price of first displayed item
		WebElement firstItemPrice=driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
		int priceOfFirstItem=Integer.parseInt(firstItemPrice.getText().replaceAll("\\D", ""));
		System.out.println("The price of First displayed better dicounted item : "+priceOfFirstItem);
//		13) Mouse over on size of the first item
		builder.moveToElement(firstItemPrice).perform();
		WebElement sizeOfFirstItem=driver.findElement(By.xpath("(//h4[@class='product-sizes']//span[@class='product-sizeNoInventoryPresent'])[1]"));
		builder.moveToElement(sizeOfFirstItem).perform();
		System.out.println("Mouse overed to the size of the first item listed down");
//		14) Click on WishList Now
		WebElement wishlist=driver.findElement(By.xpath("(//span[contains(@class,'product-notWishlistedIcon')])[1]"));
		builder.click(wishlist).perform();
		System.out.println("clicked on WishList");
//		15) Close Browser
//		driver.close();
//		System.out.println("Browser is closed");
	}

}
