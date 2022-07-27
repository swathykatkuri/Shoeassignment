package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.core.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static WebDriver driver=null;

	public static WebDriver get_driver_instance() {

        String browser = Utility.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
            	WebDriverManager.chromedriver().setup();
            	//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
            	   //session = ((ChromeDriver)driver).getSessionId();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
            	//WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                 //session = ((FirefoxDriver)driver).getSessionId();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
        return driver;
    }

    
    public void closeDriver(Scenario scenario){
        if(scenario.isFailed()){
           saveScreenshotsForScenario(scenario);
        }
        driver.close();
    }

    private void saveScreenshotsForScenario(final Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
    
}
