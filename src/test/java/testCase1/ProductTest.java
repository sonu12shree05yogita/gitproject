package testCase1;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import keywords.TestBase;
import keywords.UiKeyword;
//TestBase is extend because we want to execute @BeforeMethod and  @AfterMethod
public class ProductTest extends TestBase{
	@Test
	
public void verifySearchResultForPoloMen() {
	//UiKeyword.openBrowser("crome");
	UiKeyword.launchUrl();
	UiKeyword.enterText(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]"),"polo men");
	UiKeyword.clickOnButton(KeyEvent.VK_ENTER);
	List<String> productTitles = UiKeyword.getTests(By.xpath("//h3[@class=\"product-brand\"]"));
for (String productTitle : productTitles) {
	Assert.assertTrue(productTitle.contains("polo"),"ProductTitle Doesnt Contains: "+productTitle);
}
	
	}
}
