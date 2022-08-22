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

public class Exercise_Xpath_Css {
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

	  }

	  @Test(enabled = false)
	  public void TC_Register_With_Empty_Data() {
		  //Navigating through a particular website
		  driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		  //Click "ĐĂNG KÍ" button
		  driver.findElement(By.xpath("//button[contains(@class,'fs16')]")).click();
		  
		  WebElement name_er = driver.findElement(By.id("txtFirstname-error"));
		  WebElement email_er = driver.findElement(By.id("txtEmail-error"));
		  WebElement email_1_er = driver.findElement(By.id("txtCEmail-error"));
		  WebElement password_er = driver.findElement(By.id("txtPassword-error"));
		  WebElement password_1_er = driver.findElement(By.id("txtCPassword-error"));
		  WebElement Phone_number_er = driver.findElement(By.id("txtPhone-error"));
		  
		  //Check the error messages are displayed in the register form or not
		  //Name
		  Assert.assertEquals(name_er.getText(),"Vui lòng nhập họ tên");
		  Assert.assertTrue(name_er.isDisplayed());
		  //Email
		  Assert.assertEquals(email_er.getText(),"Vui lòng nhập email");
		  Assert.assertTrue(email_er.isDisplayed());
		  //Confirm Email
		  Assert.assertEquals(email_1_er.getText(),"Vui lòng nhập lại địa chỉ email");
		  Assert.assertTrue(email_1_er.isDisplayed());
		  //Password
		  Assert.assertEquals(password_er.getText(),"Vui lòng nhập mật khẩu");
		  Assert.assertTrue(password_er.isDisplayed());
		  //Confirm Password again
		  Assert.assertEquals(password_1_er.getText(),"Vui lòng nhập lại mật khẩu");
		  Assert.assertTrue(password_1_er.isDisplayed());
		  //Phone number
		  Assert.assertEquals(Phone_number_er.getText(),"Vui lòng nhập số điện thoại.");
		  Assert.assertTrue(Phone_number_er.isDisplayed());
		  
		  SleepInSecond(5);
	  }
	  
	  @Test(enabled = false)
	  public void TC_Register_With_Invalid_Email()
	  {
		  //Navigating through a particular website
		  driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		  
		  WebElement name = driver.findElement(By.id("txtFirstname"));
		  WebElement email = driver.findElement(By.id("txtEmail"));
		  WebElement email_1 = driver.findElement(By.id("txtCEmail"));
		  WebElement password = driver.findElement(By.id("txtPassword"));
		  WebElement password_1 = driver.findElement(By.id("txtCPassword"));
		  WebElement Phone_number = driver.findElement(By.id("txtPhone"));
		  
		  //Fill in the correct values ​​for the fields except Email
		  name.sendKeys("Nguyen Trong Nhan");
		  email.sendKeys("s.gmail");
		  email_1.sendKeys("s.gmail");
		  password.sendKeys("123456");
		  password_1.sendKeys("123456");
		  Phone_number.sendKeys("0963429982");
		  
		  //Click "ĐĂNG KÍ" button
		  driver.findElement(By.xpath("//button[contains(@class,'fs16')]")).click();
		  
		  WebElement email_er = driver.findElement(By.id("txtEmail-error"));
		  WebElement email_1_er = driver.findElement(By.id("txtCEmail-error"));
		  //Check Error Message of Email
		  Assert.assertEquals(email_er.getText(),"Vui lòng nhập email hợp lệ");
		  Assert.assertTrue(email_er.isDisplayed());
		  //Check Error Message of Confirm Email
		  Assert.assertEquals(email_1_er.getText(),"Email nhập lại không đúng");
		  Assert.assertTrue(email_1_er.isDisplayed());
		  
		  SleepInSecond(5);
	  }
	  
	  @Test(enabled = false)
	  public void TC_Register_With_Incorrect_Confirm_Email()
	  {
		  //Navigating through a particular website
		  driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		  
		  WebElement name = driver.findElement(By.id("txtFirstname"));
		  WebElement email = driver.findElement(By.id("txtEmail"));
		  WebElement email_1 = driver.findElement(By.id("txtCEmail"));
		  WebElement password = driver.findElement(By.id("txtPassword"));
		  WebElement password_1 = driver.findElement(By.id("txtCPassword"));
		  WebElement Phone_number = driver.findElement(By.id("txtPhone"));
		  
		  //Fill in the correct values ​​for the fields
		  name.sendKeys("Nguyen Trong Nhan");
		  email.sendKeys("nhan@gmail.com");
		  email_1.sendKeys("nhan@gmail.net");
		  password.sendKeys("123456");
		  password_1.sendKeys("123456");
		  Phone_number.sendKeys("0963429982");
		  
		  //Click "ĐĂNG KÍ" button
		  driver.findElement(By.xpath("//button[contains(@class,'fs16')]")).click();
		  
		  WebElement email_1_er = driver.findElement(By.id("txtCEmail-error"));

		  //Check Error Message of Confirm Email
		  Assert.assertEquals(email_1_er.getText(),"Email nhập lại không đúng");
		  Assert.assertTrue(email_1_er.isDisplayed());
		  
		  SleepInSecond(5);
	  }	  
	  
	  @Test(enabled = false)
	  public void TC_Register_With_Password_Less_Than_6_Characters()
	  {
		  //Navigating through a particular website
		  driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		  
		  WebElement name = driver.findElement(By.id("txtFirstname"));
		  WebElement email = driver.findElement(By.id("txtEmail"));
		  WebElement email_1 = driver.findElement(By.id("txtCEmail"));
		  WebElement password = driver.findElement(By.id("txtPassword"));
		  WebElement password_1 = driver.findElement(By.id("txtCPassword"));
		  WebElement Phone_number = driver.findElement(By.id("txtPhone"));
		  
		  //Fill in the correct values ​​for the fields
		  name.sendKeys("Nguyen Trong Nhan");
		  email.sendKeys("nhan@gmail.com");
		  email_1.sendKeys("nhan@gmail.com");
		  password.sendKeys("12345");
		  password_1.sendKeys("12345");
		  Phone_number.sendKeys("0963429982");
		  
		  //Click "ĐĂNG KÍ" button
		  driver.findElement(By.xpath("//button[contains(@class,'fs16')]")).click();
		  
		  WebElement password_er = driver.findElement(By.id("txtPassword-error"));
		  WebElement password_1_er = driver.findElement(By.id("txtCPassword-error"));
		  
		  //Check Error Message of Password
		  Assert.assertEquals(password_er.getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		  Assert.assertTrue(password_er.isDisplayed());
		  //Check Error Message of Confirm Password
		  Assert.assertEquals(password_1_er.getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		  Assert.assertTrue(password_1_er.isDisplayed());
		  
		  SleepInSecond(5);
	  }
	  
	  @Test(enabled = false)
	  public void TC_Register_With_Incorrect_Confirm_Password()
	  {
		  //Navigating through a particular website
		  driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		  
		  WebElement name = driver.findElement(By.id("txtFirstname"));
		  WebElement email = driver.findElement(By.id("txtEmail"));
		  WebElement email_1 = driver.findElement(By.id("txtCEmail"));
		  WebElement password = driver.findElement(By.id("txtPassword"));
		  WebElement password_1 = driver.findElement(By.id("txtCPassword"));
		  WebElement Phone_number = driver.findElement(By.id("txtPhone"));
		  
		  //Fill in the correct values ​​for the fields
		  name.sendKeys("Nguyen Trong Nhan");
		  email.sendKeys("nhan@gmail.com");
		  email_1.sendKeys("nhan@gmail.com");
		  password.sendKeys("123456");
		  password_1.sendKeys("123457");
		  Phone_number.sendKeys("0963429982");
		  
		  //Click "ĐĂNG KÍ" button
		  driver.findElement(By.xpath("//button[contains(@class,'fs16')]")).click();
		  
		  WebElement password_1_er = driver.findElement(By.id("txtCPassword-error"));
		  
		  //Check Error Message of Confirm Password
		  Assert.assertEquals(password_1_er.getText(),"Mật khẩu bạn nhập không khớp");
		  Assert.assertTrue(password_1_er.isDisplayed());
		  
		  SleepInSecond(5);
	  }
	  
	  @Test(enabled = true)
	  public void TC_Register_With_Incorrect_Phone_number()
	  {
		  //Navigating through a particular website
		  driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		  
		  WebElement name = driver.findElement(By.id("txtFirstname"));
		  WebElement email = driver.findElement(By.id("txtEmail"));
		  WebElement email_1 = driver.findElement(By.id("txtCEmail"));
		  WebElement password = driver.findElement(By.id("txtPassword"));
		  WebElement password_1 = driver.findElement(By.id("txtCPassword"));
		  WebElement Phone_number = driver.findElement(By.id("txtPhone"));
		  
		  //Fill in the correct values ​​for the fields expect phone number
		  name.sendKeys("Nguyen Trong Nhan");
		  email.sendKeys("nhan@gmail.com");
		  email_1.sendKeys("nhan@gmail.com");
		  password.sendKeys("123456");
		  password_1.sendKeys("123457");
		  //Enter phone number less than or greater than 10 number
		  Phone_number.sendKeys("096342998");
		  
		  //Click "ĐĂNG KÍ" button
		  driver.findElement(By.xpath("//button[contains(@class,'fs16')]")).click();
		  
		  WebElement Phone_number_er = driver.findElement(By.id("txtPhone-error"));
		  
		  //Check Error Message of Phone number
		  Assert.assertEquals(Phone_number_er.getText(),"Số điện thoại phải từ 10-11 số.");
		  Assert.assertTrue(Phone_number_er.isDisplayed());
		  
		  SleepInSecond(10);
		  
		  //Clear values for the fields
		  name.clear();
		  email.clear();
		  email_1.clear();
		  password.clear();
		  password_1.clear();
		  Phone_number.clear();
		  
		  //Fill in the correct values ​​for the fields except phone number
		  name.sendKeys("Nguyen Trong Nhan");
		  email.sendKeys("nhan@gmail.com");
		  email_1.sendKeys("nhan@gmail.com");
		  password.sendKeys("123456");
		  password_1.sendKeys("123457");
		  //Enter phone number starting with WRONG carrier prefix
		  Phone_number.sendKeys("196342998");
		  
		  //Click "ĐĂNG KÍ" button
		  driver.findElement(By.xpath("//button[contains(@class,'fs16')]")).click();
		  
		  //Check Error Message of Phone number
		  Assert.assertEquals(Phone_number_er.getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
		  Assert.assertTrue(Phone_number_er.isDisplayed());
		  SleepInSecond(10);
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

