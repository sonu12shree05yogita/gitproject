package keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//import testCase1.List;
//TestBase is extend because we want to execute @BeforeMethod and  @AfterMethod
public class UiKeyword  {
	public static RemoteWebDriver driver;
	 public static void openBrowser(String browserName) {
		 if(browserName.equalsIgnoreCase("Crome")) 
		 {
			 WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
		 }
		 if(browserName.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
		 }
		 
	}

	public static void browserClose() {
	driver.close();
	}
	
	
	public static void launchUrl() {
		ResourceBundle rb =ResourceBundle.getBundle("resourceFile");
			String	urlget = rb.getString("url");
		driver.get(urlget);
	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
		
	}
	
	public static void clickOnButton(int keycode)  {
		Robot buttonClick=null;
		try {
			buttonClick = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buttonClick.keyPress(keycode);
		buttonClick.keyRelease(keycode);

	}

	public static List<String> getTests(By element) {
		List<WebElement> elements =driver.findElements(element);
		List<String> Producttexts= new ArrayList();
		for (WebElement ele : elements) {
			Producttexts.add(ele.getText());
		}
		return Producttexts;
	}

	
}
