package QA;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/QA/Features"},glue= {"QA/Stepdefs"},
        tags = "@WIP",publish = true,
        plugin = { "pretty", "html:target/cucumber-reports.html" ,"pretty", "json:target/cucumber-report.json"},
        monochrome = true
)
public class cucumber_runner extends AbstractTestNGCucumberTests {
public static WebDriver driver= null;

@Test
public static void openBrowser(){

    String path = System.getProperty("user.dir");
    System.out.println("MY PATH IS metoo"+path);
    System.setProperty("webdriver.chrome.driver",path+"/src/main/resources/Drivers/chromedriver");
//    System.setProperty("webdriver.chrome.driver", "/Users/abraartishan/Desktop/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("window-size=1400,1500");
    options.addArguments("--disable-gpu");
    options.addArguments("--no-sandbox");
    options.addArguments("start-maximized");
    options.addArguments("enable-automation");
    options.addArguments("--disable-infobars");
    options.addArguments("--disable-dev-shm-usage");
    driver = new ChromeDriver(options);
    driver.get("https://www.facebook.com");
    System.out.println(driver.getTitle());


    }
}
