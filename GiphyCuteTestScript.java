/*
Test-3
Make another test that visits https://giphy.com and searches for “fintech” gifs 
and then asserts that there is a gif with a hashtag “#cute”.
====================================================================================================================
Pre-Requisite to run the code in Eclipse:
1. Import Selenium jar files
2. Download Chromedriver.exe file

NOTE1: In order to run the below code, specify the local path to chromedriver file.
NOTE2: The explantion of the Testscript is written in the inline comments 
====================================================================================================================
*/
package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CanoeGiphy {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "//Users//Appu//Downloads//chromedriver 2");
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://giphy.com"); 
		//type 'fintech' keyword in search box
		driver.findElement(By.id("search-box")).sendKeys("fintech");
		//click on 'search' button
		driver.findElement(By.xpath("//a[@class='_3LNjsTExcGj7xdqSxGseQI']/div/div[2]")).click();
		//searching for the hashtag cute. 
		//hashtag is a alternative name to a image file.hence searching for alternative name cute in below code
		int i=driver.findElements(By.xpath("//img[contains(@alt,'cute')]")).size();
		//asserting if there are any #cute gifs displayed in the output
		Assert.assertTrue(i>0);
		System.out.println("Gif with #Cute exists in fintech search");
	}

}
