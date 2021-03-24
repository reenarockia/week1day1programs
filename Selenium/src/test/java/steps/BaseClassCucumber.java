package steps;

import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BaseClassCucumber {
	public static ChromeDriver driver;
	public static List<String> handlesList;
	SoftAssert softAssert=new SoftAssert();
	public static WebDriverWait wait;
	public static Actions actionsObj;
}
