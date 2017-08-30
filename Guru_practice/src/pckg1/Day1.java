package pckg1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Day1 {
	
	static WebDriver driver;
	static String baseUrl;
	
	public static void setUp(){
		
		/* Path to Binary file of Firefox*/
		
		File pathToBinary = new File(Util.FIREFOX_PATH);
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		
		/*FirefoxProfile creation*/
		
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		
		driver = new FirefoxDriver(ffBinary,firefoxProfile);
		baseUrl = Util.BASE_URL;
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	public static void main(String args[]){
		
		String actualTitle;
		
		setUp();
		
		try{
			
			driver.findElement(By.name("uid")).clear();
			driver.findElement(By.name("uid")).sendKeys(Util.USER_NAME);
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(Util.PASS_WORD);
			driver.findElement(By.name("btnLogin")).click();
		}
		catch(Exception e){
			System.out.println("Unsuccessful Login");
		}
		
		actualTitle = driver.getTitle();
		if(actualTitle.contains(Util.EXPECTED_TITLE))
			System.out.println("Test case passed");
		else
			System.out.println("Test case Failed");
		
		//driver.close();
	}
}
