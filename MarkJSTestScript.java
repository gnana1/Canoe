
/*
1. Make the automation test (use an environment that you’re most familiar with. Such as Selenium, Cypress, etc.) that covers MarkJs configurator.
a. The test should:
i. Open the MarkJs configurator (​https://markjs.io/configurator.html​).
ii. Fill out the form to allow to search for word “lorem” (case insensitive).
iii. Assert that there is a correct number of marked matches.
b. Within the same test adjust form so that it will search for case sensitive matches only and check for results.
====================================================================================================================
Pre-Requisite to run the code in Eclipse:
1. Import Selenium jar files
2. Import TestNG jar files
3. Download Chromedriver.exe file

NOTE1: In order to run the below code, specify the local path to chromedriver file.
NOTE2: The explantion of the Testscript is written in the inline comments 
====================================================================================================================
*/
package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CanoeMarkJs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "//Users//Appu//Downloads//chromedriver 2"); 
		//Invoking the chrome Browser
		WebDriver driver=new ChromeDriver(); 
		// opening the marksJs home page
		driver.get("https://markjs.io/configurator.html"); 
		//clearing the default value in 'keyword' field
		driver.findElement(By.xpath("//input[@id='keyword']")).clear();
		//typing keyword 'lorem'
		driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys("lorem");
		//selecting exactly in 'accuracy' dropdown
		Select accu= new Select(driver.findElement(By.id("form-keyword-accuracy")));
		accu.selectByValue("exactly");
		//clearing the default value in 'Element' field
		driver.findElement(By.cssSelector("#form-keyword-element")).clear();
		
		//unchecking 'separate word search' checkbox 
		WebElement W1 = driver.findElement(By.name("separateWordSearch"));
		if (W1.isEnabled())
		{
			W1.click();
		}
		//unchecking 'diacritics' checkbox
		WebElement W2 = driver.findElement(By.name("diacritics"));
		if (W2.isEnabled())
		{
			W2.click();
		}
		//clicking on 'mark' submit button
		driver.findElement(By.xpath("//form[@name='form-keyword']/button")).click();
		
		//asserting if there are correct number of marked searches
		Assert.assertEquals(driver.findElements(By.tagName("mark")).size(),6);
		System.out.println("Correct no.of marked matches are displayed for case insensitive search");
		
		//checking 'CaseSensitive' checkbox
		driver.findElement(By.name("caseSensitive")).click();
		
		//submitting mark button for case sensitive search
		driver.findElement(By.xpath("//form[@name='form-keyword']/button")).click();
		//asserting if there are correct number of marked searches
		Assert.assertEquals(driver.findElements(By.tagName("mark")).size(),1);
		System.out.println("Correct no.of marked matches are displayed for case sensitive search");
		
		}
	

}
