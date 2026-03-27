package org.blazePageObjectModel;

import org.blazeInterfaceElements.ProductPageElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reusabilityMethods.BaseClass;

public class ProductPagePOM extends BaseClass implements ProductPageElements {

	@FindBy(linkText=phones_linkText)
	private WebElement phones;
	
	@FindBy(xpath=galaxyS7_xpath)
	private WebElement galaxyS7;
	
	@FindBy(xpath=cartBtn_xpath)
	private WebElement cartBtn;
	
	
	public ProductPagePOM() {
		PageFactory.initElements(driver, this);
	}
	
	public void getProductPagePOM() {
		elementClick(phones);
		elementClick(galaxyS7);
		elementClick(cartBtn);
		alertHandle("ok");
	}
	
}
