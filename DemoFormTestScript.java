/*Test-2
Make another test that covers the form at​ ​https://teroauralinna.github.io/vue-demo-form/ 
for positive and negative testing scenarios.

====================================================================================================================
Pre-Requisite to run the code in Eclipse:
1. Import Selenium jar files
2. Download Chromedriver.exe file

NOTE1: In order to run the below code, specify the local path to chromedriver file.
NOTE2: The explantion of the Testscript is written in the inline comments 
====================================================================================================================
*/
package introduction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CanoeDemoForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver", "//Users//Appu//Downloads//chromedriver 2");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get("https://teroauralinna.github.io/vue-demo-form/"); 
		
		// Defining Positive and Negative input Values for all input fields in the form
		String[][] str = {
		{"Gnana","Bheemineni","abc@gmail.com","free","free text","true"},
		{"Gnana","Bheemineni","abc@gmail.com","starter","free text ","true"},
		{"Gnana","Bheemineni","abc@gmail.com","enterprise","free text","true"},
		{"Gnana","Bheemineni","abc@gmail.com","free","","true"},
		//missing value in firstname-negative scenario
		{"","Bheemineni","abc@gmail.com","free","free text","true"},
		//missing value in lastname-negative scenario
		{"Gnana","","abc@gmail.com","starter","","true"},
		//invalid value in email-negative scenario
		{"Gnana","Bheemineni","abc@gmailom","enterprise","","true"},
		//missing value in email-negative scenario
		{"Gnana","Bheemineni","","free","","true"},
		//not accepting terms-negative scenario
		{"Gnana","Bheemineni","abc@gmail.com","starter","","false"},
		//missing values in all mandatory fields-negative scenario
		{"","","","free","",""},
		};
		
		//passing set of string values in all input fields
		for (int i=0;i<(str.length);i++)
		{
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(str[i][0]);
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(str[i][1]);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(str[i][2]);
		Select sub= new Select(driver.findElement(By.id("type")));
		sub.selectByValue(str[i][3]);
		driver.findElement(By.xpath("//textarea[@id='additionalInfo']")).clear();
		driver.findElement(By.id("additionalInfo")).sendKeys(str[i][4]);
		if (str[i][5].equals("true"))
		{
		driver.findElement(By.id("terms")).click();
		}
		//submitting the form with input values
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//checking if valid values are provided(check for positive or negative scenario)
		if(driver.findElements(By.xpath("//div[contains(@class,'alert')]")).size()==1)
		{
			System.out.println("Testcase no =" + (i+1) + ": Unable to submit. please enter valid value");
			
		}
		else
		{
			System.out.println("Testcase no =" + (i+1) + ":form submitted successfully");
			//returing to form page to run the script with the set of next input values
			driver.findElement(By.linkText("Return to the form")).click();
		
		}
		}
	}

}
