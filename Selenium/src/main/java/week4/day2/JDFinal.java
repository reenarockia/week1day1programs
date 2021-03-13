package week4.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JDFinal {

	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.DISMISS);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		driver.get("https://www.justdial.com/Chennai/Car-Repair-Services-Hyundai-Xcent-in-Porur/nct-11293522");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Thread.sleep(15000);
		driver.findElement(By.xpath("(//span[contains(@onclick,'closePopUp')])[4]")).click();
		//**** Java script to scroll down till the end of the page*******
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//**************************
		Thread.sleep(5000);
		List<String> serviceCentreNames1=new ArrayList<String>();
		List<Float> ratings1=new ArrayList<Float>();
		List<Long> votes1=new ArrayList<Long>();
		List<String> phoneNumbers1=new ArrayList<String>();
		
		float f=0.0f;
		Long v=0L;
		String p="";
		
		
		Map<String,String> reference=new HashMap<String,String>();
		reference.put("dc","+");
		reference.put("fe","(");
		reference.put("hg",")");
		reference.put("ba","-");
		reference.put("acb","0");
		reference.put("yz","1");
		reference.put("wx","2");
		reference.put("vu","3");
		reference.put("ts","4");
		reference.put("rq","5");
		reference.put("po","6");
		reference.put("nm","7");
		reference.put("lk","8");
		reference.put("ji","9");
		
		List<WebElement> listOfServiceCentres1=driver.findElements(By.xpath("//div[contains(@class,'store-details')]//h2[@class='store-name']//a"));
		
for(int i=1;i<=listOfServiceCentres1.size();i++) {
			
			//Adding each service center name to the list "serviceCentreNames1"
			WebElement serviceCentreNamesElement1=driver.findElement(By.xpath("(//div[contains(@class,'store-details')])["+i+"]//h2[@class='store-name']//a"));
			serviceCentreNames1.add(serviceCentreNamesElement1.getText());
			
//			//Adding each Rating to the list "ratings1"
//
//			List<WebElement> ratingElements1 = driver.findElements(By.xpath("(//div[contains(@class,'store-details')])["+i+"]//p[@class='newrtings ']//span[@class='green-box']"));
//			if(ratingElements1.size()!=0) {
//				ratings1.add(Float.parseFloat(ratingElements1.get(0).getText()));
//			} else {
//				ratings1.add(f);
//			}
			//Adding each Phone Number to the list "phoneNumbers"
			List<WebElement> phoneElement1=driver.findElements(By.xpath("(//p[contains(@onclick,'clntphn')])["+i+"]"));
			if(phoneElement1.size()!=0) {
				List<WebElement> phoneNumbericons1=driver.findElements(By.xpath("(//p[contains(@onclick,'clntphn')])["+i+"]//span[contains(@class,'mobilesv ')]"));
				List<String> seperateIcons1 = new ArrayList<String>();

				for(int j=0;j<phoneNumbericons1.size();j++) {
					seperateIcons1.add(phoneNumbericons1.get(j).getAttribute("class").substring(14));
				}
				String finalPhoneNumber="";
				for (String string : seperateIcons1) {
					for (Entry<String,String> string2 : reference.entrySet()) {
						if(string.equalsIgnoreCase(string2.getKey())) {
							string=string2.getValue();
						}
						
					}
					finalPhoneNumber=finalPhoneNumber+string;
				}
				phoneNumbers1.add(finalPhoneNumber);
				} else {
					phoneNumbers1.add(p);
				}


}
System.out.println("All Service Centres names");
for (String eachserviceCenterName : serviceCentreNames1) {
	System.out.println(eachserviceCenterName);

	}

System.out.println("All PhoneNumbers");
for (String eachPhoneNumber : phoneNumbers1) {
	System.out.println(eachPhoneNumber);

	}

//System.out.println("All Ratings");
//for (String eachRating : ratings1) {
//	System.out.println(eachRating);
//}
}
}