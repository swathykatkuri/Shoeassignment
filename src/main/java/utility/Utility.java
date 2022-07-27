package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	static WebDriverWait wait; 
    static Properties prop = new Properties();
    
    public static void loadPropertyFile() {
    	
    	try {
			prop.load(new FileInputStream("./config/configuration.properties"));
		} catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
	public static String getProperty(String key) {
		
		loadPropertyFile();
		return prop.getProperty(key);
		
	}
		
	
	public static void selectbyText(WebElement element,String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	
	public void PerformActionOnElement(WebElement element, String Action, String Text) throws Exception {
    	switch (Action.toLowerCase()) {
		case "click":
			element.click();
			break;
		case "type":
			element.sendKeys(Text);
			break;
		case "clear":
			element.clear();
			break;
		default:
			throw new IllegalArgumentException("Action \"" + Action + "\" isn't supported.");
		}
    }
	
	
}
