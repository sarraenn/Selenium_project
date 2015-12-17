//package com.example.tests;
//
// ----------------------------------------

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AppSeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://sarraenn.atlassian.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAppSelenium() throws Exception {
    driver.get(baseUrl + "login?dest-url=%2Fsecure%2FMyJiraHome.jspa");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("sarra.ennaji@gmail.com");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("forgot")).click();
    driver.findElement(By.id("forgotten_forgotUserName")).click();
    driver.findElement(By.xpath("//form[@id='form-forgot-credentials']/div/fieldset/div/div[2]/label")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("sarra.ennaji@gmail.com");
    driver.findElement(By.id("email-me")).click();
    driver.findElement(By.cssSelector("button.aui-button.aui-button-link")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
