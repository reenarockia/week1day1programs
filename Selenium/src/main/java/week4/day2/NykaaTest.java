package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
//		disable notifications
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.DISMISS);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver();
//		1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(30000);

//		2) Mouseover on Brands and Mouseover on Popular
		Actions builder=new Actions(driver);
		WebElement brands=driver.findElement(By.xpath("//li[@class='menu-dropdown-icon']//a[text()='brands']"));
		builder.moveToElement(brands).perform();
		System.out.println("Mouse overed on Brands");
		WebElement popular=driver.findElement(By.xpath("//a[contains(text(),'Popular')]"));
		builder.moveToElement(popular).perform();
		System.out.println("Mouse overed on Popular");
//		3) Click L'Oreal Paris
		WebElement lorealParis=driver.findElement(By.xpath("//img[contains(@src,'lorealparis')]"));
		builder.click(lorealParis).perform();
		System.out.println("clicked on L'Oreal Paris");
		
		Set<String> allWindowHandles=driver.getWindowHandles();
		List<String> windowHandles=new ArrayList<String>(allWindowHandles);
//		4) Go to the newly opened window and check the title contains L'Oreal Paris
		driver.switchTo().window(windowHandles.get(1));
//		System.out.println("Title:" + driver.getTitle());
		if(driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("The newly opened window's title is L'Oreal Paris");
		}else {
			System.out.println("Not landed in L'Oreal Paris as expected");
		}
//		5) Click sort By and select customer top rated
		WebElement sortBy=driver.findElement(By.xpath("//span[@class='pull-right']"));
		sortBy.click();
		System.out.println("Clicked on Sort By");
		WebElement customerTopRated=driver.findElement(By.xpath("//div[@for='3']"));
		customerTopRated.click();
		System.out.println("Sorted by customer Top Rated");
		Thread.sleep(3000);
//		6) Click Category and click Shampoo
		WebElement category=driver.findElement(By.xpath("(//div[contains(@class,'pull-right')])[1]"));
		category.click();
		System.out.println("Clicked on Category");
		List<WebElement> allShampoo=driver.findElements(By.xpath("//label[@for='chk_Shampoo_undefined']//div"));
		for (WebElement webElement : allShampoo) {
			webElement.click();
		}
		System.out.println("clicked on all the "+allShampoo.size()+" shampoo options in Category");
//		7) check whether the Filter is applied with Shampoo
		List<WebElement> filtersApplied=driver.findElements(By.xpath("//ul[contains(@class,'applied-filter-lists')]/li"));
		
		int filtersAppliedCount=0;
		for (WebElement webElement : filtersApplied) {
			if(webElement.getText().contains("Shampoo")) {
				filtersAppliedCount=filtersAppliedCount+1;			
				}else {
					break;
				}
		}
		System.out.println(filtersAppliedCount);
			if(filtersAppliedCount==filtersApplied.size()) {
				System.out.println("All the "+filtersAppliedCount+" filters applied are of type -shampoo");
			}else {
				System.out.println("All or some of the filters are not shampoo");
			}
		
//		8) Click on L'Oreal Paris Colour Protect Shampoo
		WebElement colourProtect=driver.findElement(By.xpath("//div[@class='card-img']//img[contains(@alt,'Paris Colour Protect')]"));
		colourProtect.click();
		System.out.println("Clicked on L'Oreal Paris Colour Protect Shampoo");
		
		Set<String> allWindowHandles1=driver.getWindowHandles();
		List<String> windowHandleList1=new ArrayList<String>(allWindowHandles1);
		int NumberOfWindows=windowHandleList1.size();
//		System.out.println("Title 1: " +driver.switchTo().window(windowHandleList1.get(0)).getTitle());
//		System.out.println("Title 2: " +driver.switchTo().window(windowHandleList1.get(1)).getTitle());
//		System.out.println("Title 3: " +driver.switchTo().window(windowHandleList1.get(2)).getTitle());
//		System.out.println("NumberOfWindows: "+NumberOfWindows);
		
//		9) GO to the new window and select size as 175ml
		driver.switchTo().window(windowHandleList1.get(2));
		driver.findElement(By.xpath("//span[text()='175ml']")).click();
//		10) Print the MRP of the product
		WebElement MRP=driver.findElement(By.xpath("(//div[@class='price-info']//span[@class='post-card__content-price-offer'])[1]"));
		String MRPOfTheProduct=MRP.getText().replaceAll("\\D","");
		int MRPOfTheProductint=Integer.parseInt(MRPOfTheProduct);
		System.out.println("MRP Of the Product : "+MRPOfTheProductint);
		
//		11) Click on ADD to BAG
		driver.findElement(By.xpath("//div[@class='pull-left']//button[text()='ADD TO BAG']")).click();
		System.out.println("clicked on ADD TO BAG button");
//		12) Go to Shopping Bag 
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(300));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='View Bag']")));
		builder.click(driver.findElement(By.xpath("//div[text()='View Bag']"))).perform();
		Thread.sleep(5000);
		System.out.println("clicked on View Bag");
//		13) Print the Grand Total amount
		
		WebElement grandTotalAmount=driver.findElement(By.xpath("//div[@class='first-col']//div[@class='value']"));
		String grandTotalAmount1=grandTotalAmount.getText().replaceAll("\\D","");
		int grandTotalAmountInt=Integer.parseInt(grandTotalAmount1);
		System.out.println("The Grand Total amount : "+grandTotalAmountInt);		
//		14) Click Proceed
		WebElement proceed=driver.findElement(By.xpath("//div[@class='second-col']//button//span/following-sibling::i"));
		wait.until(ExpectedConditions.elementToBeClickable(proceed));
		builder.click(proceed).perform();
		System.out.println("Clicked on PROCEED button");
//		15) Click on Continue as Guest
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		System.out.println("Clicked on Continue as Guest button");

//		16) Check if this grand total is the same in step 13
		WebElement checkGrandTotal=driver.findElement(By.xpath("//div[contains(@class,'grand-total-cell')]//span"));
		String GrandTotal=checkGrandTotal.getText().replaceAll("\\D","");
		int GrandTotalInGuestPage=Integer.parseInt(GrandTotal);
		System.out.println("GrandTotal: "+GrandTotalInGuestPage);
		if(GrandTotalInGuestPage ==grandTotalAmountInt ) {
			System.out.println("Grand Total in Continue as Guest is same as that of in Shopping bag");
		} else {
			System.out.println("Grand Total in Continue as Guest is not same as that of in Shopping bag");
		}
//		17) Close all windows

//		driver.quit();
	}

}
