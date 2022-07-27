package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoeStorePage 
{
	public ShoeStorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="brand")
	public WebElement drp_brand;

	@FindBy(id = "search_button")
	public WebElement btn_search;

	@FindBy(id = "shoe_list")
	public WebElement search_result;

	@FindBy(id="remind_email_input")
	public WebElement txt_email;
	
	@FindBy(id = "remind_email_submit")
	public WebElement btn_email_submit;
	
	@FindBy(id="promo_code_input")
	public WebElement txt_promocode;
	
	@FindBy(id = "promo_code_submit")
	public WebElement btn_promo_submit;
	
	@FindBy(xpath="//ul[@id='shoe_list']//li")
	public List<WebElement> result;
	
	@FindBy(xpath="//div[contains(@class,'flash')]")
	public WebElement alertMessage;
}
