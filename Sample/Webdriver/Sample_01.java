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

public class Sample_01 {
	WebDriver  driver;
	

	  @BeforeClass
	  public void beforeClass() {
		  //Configuring the system properties of firefox driver
		  System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
// OR	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		  //Initializing the browser driver
		  driver = new FirefoxDriver();
		  //Waiting time to start web driver
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		  //Display Format	
		  driver.manage().window().maximize();
		  //Navigating through a particular website
		  driver.get("https://demo.guru99.com/v4/");
	  }
	  @Test
	  public void TC_01() {
		  //Testcase for current URL
		  String login = driver.getCurrentUrl();
		  Assert.assertEquals(login, "https://demo.guru99.com/v4/");
	  }
	  @Test
	  public void TC_02() {
		  //Testcase for title web
		  String title = driver.getTitle();
		  Assert.assertEquals(title, "Guru99 Bank Home Page");
	  }
	  @Test
	  public void TC_03() {
		  //Testcase for display frmlogin
		  Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
	  }
	  @Test
	  public void TC_04() {
		  //Testcase for display button btnLogin
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@name='btnLogin']")).isDisplayed());
	  }
	  @Test
	  public void TC_05() {
		  //Testcase for display textbox uid
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@name='uid']")).isEnabled());
	  }
	  @Test
	  public void TC_06() throws Exception {
		  //Testcase for invalid textbox uid, password
		  WebElement txtuser = driver.findElement(By.name("uid"));
		  txtuser.sendKeys("");
		  WebElement txtpassword = driver.findElement(By.name("password"));
		  txtpassword.sendKeys("");
		  WebElement title = driver.findElement(By.xpath("//h2[@class='barone']"));
		  title.click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  Assert.assertEquals(driver.findElement(By.id("message23")).getText(), "User-ID must not be blank");
		  Assert.assertTrue(driver.findElement(By.id("message23")).isDisplayed());

		  Assert.assertEquals(driver.findElement(By.id("message18")).getText(), "Password must not be blank");
		  Assert.assertTrue(driver.findElement(By.id("message18")).isDisplayed());
	  }
	  @AfterClass
	  public void afterClass() {
		  //Exist web driver
		  driver.quit();
	  }
}

