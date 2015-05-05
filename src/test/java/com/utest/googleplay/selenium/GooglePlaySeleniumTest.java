package com.utest.googleplay.selenium;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import com.utest.googleplay.utils.DataExtractor;


@RunWith(Parameterized.class)
public class GooglePlaySeleniumTest {
	
	@Parameters
	public static Collection<Object[] > data(){
	  System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
      Object[][] data = new Object[][] { { new ChromeDriver() }, { new FirefoxDriver() }};
      return Arrays.asList(data);
    }
	
	private WebDriver browser;
	 
    public GooglePlaySeleniumTest(WebDriver browser){
    	this.browser = browser;
    }
 
	WebDriver driver;	 
 	@Before
    public void setUp(){
        driver = browser;
    }
  
    @After
    public void tearDown(){
    	driver.close();
        driver.quit();
    }
	 

	@Test
	public void starAndReviewTest() {
		driver.get("http://www.google.com");
		driver.findElement(By.xpath(".//*[@id='gbwa']/div[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='gb78']/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/ul/li[2]/a/span/span[2]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id("gbqfq")).click();
		driver.findElement(By.id("gbqfq")).sendKeys("Testing");
		driver.findElement(By.xpath(".//*[@id='gbqfb']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement testingApp =driver.findElement(By.cssSelector("a[href*='your.anmatesting.namespace']")); 
				//driver.findElement(By.linkText("Software Testing Concepts"));
		Actions actions = new Actions(driver);

		actions.moveToElement(testingApp).click().perform();
		
		//testingApp.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement stars =driver.findElement(By.xpath("//div[contains(@class, 'tiny-star') and contains(@class, 'star-rating-non-editable-container')]"));
		String starsText = stars.getAttribute("aria-label"); //Stars rating
		System.out.println("stars " + DataExtractor.getStarsFromText(starsText));
		
		WebElement starsCount =driver.findElement(By.className("stars-count")); //review count
		System.out.println("reviews " + DataExtractor.getStarCountFromText(starsCount.getText()) );
		
	}
}

	
	
	

