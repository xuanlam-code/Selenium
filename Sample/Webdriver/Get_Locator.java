package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Get_Locator {
	WebDriver  driver;
	

	  @BeforeClass
	  public void beforeClass() {
		  //Configuring the system properties of firefox driver
		  System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		  //Initializing the browser driver
		  driver = new FirefoxDriver();
		  //Waiting time to start web driver
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  //Display Format	
		  driver.manage().window().maximize();
		  //Navigating through a particular website
		  driver.get("https://hardmode.vn/account/register");
	  }
	  @Test
	  public void TC_01() {
		  //Get locator by ID
		  driver.findElement(By.xpath("//input[@id = 'last_name']")).sendKeys("Lam");
		  SleepInSecond(5);
	  }

	  @Test
	  public void TC_02() {
		  //Get locator by name
		  driver.findElement(By.name("customer[first_name]")).sendKeys("Xuan");
		  SleepInSecond(5);
	  }
	  
	  @Test
	  public void TC_03() {
		  //Get locator by Class
		  driver.findElement(By.className("password")).sendKeys("1234");
		  SleepInSecond(5);
	  }
	  @Test
	  public void TC_04() {
		  //Get locator by linkText
		  driver.findElement(By.linkText("Tìm kiếm")).click();
		  SleepInSecond(3);
	  }
	  @Test
	  public void TC_05() {
		  //Get locator by partialLinkText
		  //Navigating through a particular website
		  driver.get("https://hardmode.vn/account/register");
		  driver.findElement(By.partialLinkText("CARDI")).click();
		  SleepInSecond(3);
	  }
	  @Test
	  public void TC_06() {
		  //count how many text
		  driver.get("https://hardmode.vn/account/register");
		  System.out.println("so luong text la " + driver.findElements(By.tagName("input")).size());
	  }
	  @Test
	  public void TC_07() {
		  //use Xpath
		  //ID
		  driver.findElement(By.xpath("//input[@id = 'last_name']")).sendKeys("Lam");
		  //name
		  driver.findElement(By.xpath("//input[@name = 'customer[first_name]']")).sendKeys("Xuan");
		  //classname
		  driver.findElement(By.xpath("//input[@class = 'password text']")).sendKeys("1234");
		  //linkText
		  //tuyet doi //Tagname[(text()='value')]
		  driver.findElement(By.xpath("//ul[@class ='link-widget']//a[(text()='Tìm kiếm')]")).click();
		  //PartialLinkText
		  //tuong doi //Tagname[contains(text(),'value')] or //Tagname[contains(@attribute,'value')]
		  driver.get("https://hardmode.vn/account/register");
		  driver.findElement(By.xpath("//ul[@class = 'link-widget']//a[contains(text(),'CARDI')]")).click();
		  //Tagname
		  driver.get("https://hardmode.vn/account/register");
		  System.out.println("so luong text la " + driver.findElements(By.xpath("//input")).size());

		  SleepInSecond(5);
	  }
	  @Test
	  public void TC_08() {
		  //use Css
		  //ID input#last_name
		  driver.findElement(By.cssSelector("input[id = 'last_name']")).sendKeys("Lam");
		  //name 
		  driver.findElement(By.cssSelector("input[name = 'customer[first_name]']")).sendKeys("Xuan");
		  //classname input.password.text
		  driver.findElement(By.cssSelector("input[class = 'password text']")).sendKeys("1234");
		  //linkText
		  driver.findElement(By.cssSelector("ul.link-widget a[href='/search']")).click();
		  //PartialLinkText
		  //tuong doi Tagname[attribute*='value']
		  driver.get("https://hardmode.vn/account/register");
		  driver.findElement(By.cssSelector("ul.link-widget a[href*='/croptop']")).click();
		  //Tagname
		  driver.get("https://hardmode.vn/account/register");
		  System.out.println("so luong text la " + driver.findElements(By.cssSelector("input")).size());

		  SleepInSecond(5);
	  }
	  @AfterClass
	  public void afterClass() {
		  //Exist web driver
		  driver.quit();
	  }
	  
	  public void SleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

