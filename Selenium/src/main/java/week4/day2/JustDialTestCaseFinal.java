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

public class JustDialTestCaseFinal {

	public static void main(String[] args) throws InterruptedException {
//		disable notifications
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.DISMISS);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		driver.get("https://www.justdial.com/Chennai/Car-Repair-Services-Hyundai-Xcent-in-Porur/nct-11293522");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("(//span[contains(@onclick,'closePopUp')])[4]")).click();
		//**** Java script to scroll down till the end of the page*******
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
				//**************************
		Thread.sleep(6000);
		
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
		
		List<WebElement> ratingsElements=driver.findElements(By.xpath("//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0']//p[@class='contact-info ']/preceding-sibling::p[@class='newrtings ']//span[@class='green-box']"));
		System.out.println("Number of Ratings: "+ratingsElements.size());
		
//		List<WebElement> serviceCentresElements=driver.findElements(By.xpath("//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0']//p[@class='contact-info ']/preceding-sibling::p[@class='newrtings ']//span[@class='green-box']/ancestor::p/preceding-sibling::h2//span[@class='lng_cont_name']"));
		List<WebElement> serviceCentresElements=driver.findElements(By.xpath("//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0']//p[@class='contact-info ']/preceding-sibling::p[@class='newrtings ']//span[@class='green-box']/ancestor::p/preceding-sibling::h2//a"));
		System.out.println("Number of Service Centres: "+serviceCentresElements.size());
		
		List<WebElement> votesElements=driver.findElements(By.xpath("//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0']//p[@class='contact-info ']/preceding-sibling::p[@class='newrtings ']//span[@class='green-box']//following-sibling::span[@class='rt_count lng_vote']"));
		System.out.println("Number of votes elements: "+votesElements.size());
		
		Map<String,Float> serviceCenterRating=new HashMap<String,Float>();
		for(int i=0;i<serviceCentresElements.size();i++) {
			if(Float.parseFloat(ratingsElements.get(i).getText())>=4.5) {
			serviceCenterRating.put(serviceCentresElements.get(i).getAttribute("title"), Float.parseFloat((ratingsElements.get(i).getText())));
			
			}
		}
		
		List<String> serviceCentresOfHighRating=new ArrayList<String>();
		for (Entry<String,Float> eachServiceCenterRating : serviceCenterRating.entrySet()) {
			serviceCentresOfHighRating.add(eachServiceCenterRating.getKey());
		}
		Map<String,Integer> serviceCenterVotes=new HashMap<String, Integer>();
		for(int i=0;i<serviceCentresElements.size();i++) {
			if(Integer.parseInt(votesElements.get(i).getText().replaceAll("\\D", ""))>=50) {
				serviceCenterVotes.put(serviceCentresElements.get(i).getAttribute("title"), Integer.parseInt(votesElements.get(i).getText().replaceAll("\\D", "")));
			}
		}
		List<String> serviceCentresOfHighVotes=new ArrayList<String>();
		for (Entry<String,Integer> eachserviceCenterVotes : serviceCenterVotes.entrySet()) {
			serviceCentresOfHighVotes.add(eachserviceCenterVotes.getKey());

		}
		List<String> HighRatedVotedServiceCentres=new ArrayList<String>();
		for(int i=0;i<serviceCentresOfHighVotes.size();i++) {
			for(int j=0;j<serviceCentresOfHighRating.size();j++) {
				if(serviceCentresOfHighVotes.get(i).equalsIgnoreCase(serviceCentresOfHighRating.get(j))) {
					HighRatedVotedServiceCentres.add(serviceCentresOfHighVotes.get(i));
				}
			}
		}
		
		System.out.println("Phone Numbers of Service Centres having rating >=4.5 and votes >=50");
		System.out.println("*******************************************************************");
		
		for (String string : HighRatedVotedServiceCentres) {
			//System.out.println(string);
			//List<WebElement> phoneNumberIconsElements=driver.findElements(By.xpath("//span[text()='"+string+"']/ancestor::h2/following-sibling::p[@class='contact-info ']//span[contains(@class,'mobilesv')]"));
			List<WebElement> phoneNumberIconsElements=driver.findElements(By.xpath("//a[@title='"+string+"']/ancestor::h2/following-sibling::p[@class='contact-info ']//span[contains(@class,'mobilesv')]"));
			String finalPhoneNumber="";
			for(int i=0;i<phoneNumberIconsElements.size();i++) {
				String toBeDecoded=phoneNumberIconsElements.get(i).getAttribute("class").substring(14);
				for (Entry<String,String> string2 : reference.entrySet()) {
					if(toBeDecoded.equalsIgnoreCase(string2.getKey())) {
						finalPhoneNumber=finalPhoneNumber.concat(string2.getValue());
					}
					
				}
				
			}
			
		System.out.println(string+" =====> "+finalPhoneNumber);	
		}
			
		}
		
	}


