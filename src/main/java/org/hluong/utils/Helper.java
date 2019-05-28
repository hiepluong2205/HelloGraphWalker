package org.hluong.utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

  private static WebDriver driver;
  private static WebDriverWait wait;
  private static Actions actions;
  public static Faker faker = new Faker();

  //  private static final Logger log = LoggerFactory.getLogger(TestModelParsingRuleManagement.class);
  private Helper() {
  }

  public static WebDriver getDriver() {

    //    switch (type) {
//      case "chrome":
//        return driver;
//      case "firefox":
//        return driverFF;
//      default: return driver;
//    }
    if (driver != null) {
      //do nothing
    } else {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
//      DesiredCapabilities capability = DesiredCapabilities.chrome();
//      capability.setBrowserName("chrome");
//      capability.setPlatform(Platform.WIN10);
//      driver = new RemoteWebDriver(new URL("http://172.30."),capability);
    }
    return driver;
  }

  public static Faker getFaker() {
    return faker;
  }

  public static WebDriverWait getWait() {
    return new WebDriverWait(getDriver(), 30);
  }

  public static Actions getActions() {
    return new Actions(getDriver());
  }


  public static void clickElementByXPATH(String elementXPATH) {
    getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(elementXPATH))).click();
//    driver.findElement(By.xpath(elementXPATH)).click();
  }

  public static WebElement waitForElementClickableByXPATH(String elementXPATH) {
    WebElement element = getWait().until(
        ExpectedConditions.elementToBeClickable(By.xpath(elementXPATH)));
    return element;
  }

  public static WebElement waitForElementPresentXPATH(String elementXPATH) {
    WebElement element = getWait()
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXPATH)));
    return element;
  }

  public static Boolean doesTextPresentInElementXPATH(String elementXPATH, String text) {
    Boolean element = getWait()
        .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(elementXPATH), text));
    return element;

  }

  public static WebElement findElementByID(String elementID) {
    WebElement element = getDriver().findElement(By.id(elementID));
    return element;
  }

  public static WebElement findElementByXPATH(String elementXPATH) {
    WebElement element = getDriver().findElement(By.xpath(elementXPATH));
    return element;
  }

  public int countElementsByXPATH(String elementsXPATH) {
    int count = getDriver().findElements(By.xpath(elementsXPATH)).size();
    return count;
  }

  public void scrollToElement(WebElement element) {
    ((JavascriptExecutor) getDriver())
        .executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public static void setUp() {
//    WebDriverManager.chromedriver().setup();
//    driver = getDriver();
//    getDriver().manage().window().maximize();
//    wait = new WebDriverWait(driver, 30);
//    actions = new Actions(driver);

  }

  public void tearDown() {
//    getDriver().close();
    getDriver().quit();
  }

}
