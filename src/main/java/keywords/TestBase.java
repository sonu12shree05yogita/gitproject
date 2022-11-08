package keywords;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	//@Optional this used to when we dont want to send parameters from testng
	// we send by Textng or send by method
	@Parameters("Browser_Name")
	@BeforeMethod
	public static void steup(@Optional String browserName) throws Exception{
		if(browserName==null)
			browserName ="Crome";
		if (browserName.isEmpty()) {
			browserName ="Crome";
			System.out.println("Setting Default Browser as Crome");
		}
		UiKeyword.openBrowser(browserName);
	}
    @AfterMethod
	public static void tearDown() {
		UiKeyword.browserClose();
	}
}
