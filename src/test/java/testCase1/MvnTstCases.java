package testCase1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import keywords.UiKeyword;

public class MvnTstCases {
	@Test

public static void chromeTst() {
		UiKeyword.openBrowser("crome");
		UiKeyword.launchUrl();
		UiKeyword.browserClose();
       
       }


}