package org.blazePageObjectModel;

import org.blazeInterfaceElements.CartPageElements;
import org.blazePageObjectManager.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reusabilityMethods.BaseClass;

public class CartPagePOM extends BaseClass implements CartPageElements {

	@FindBy(id = cart_id)
	private WebElement cart;

	@FindBy(xpath = placeOrder_xpath)
	private WebElement placeOrder;

	@FindBy(xpath = name_xpath)
	private WebElement name;

	@FindBy(xpath = country_xpath)
	private WebElement country;

	@FindBy(xpath = city_xpath)
	private WebElement city;

	@FindBy(xpath = creditCard_xpath)
	private WebElement creditCard;

	@FindBy(xpath = month_xpath)
	private WebElement month;

	@FindBy(xpath = year_xpath)
	private WebElement year;

	@FindBy(xpath = purchase_xpath)
	private WebElement purchase;

	@FindBy(xpath = confirmation_xpath)
	private WebElement confirmation;

	@FindBy(xpath = ok_xpath)
	private WebElement ok;
	
	@FindBy(id = logout_id)
	private WebElement logout;
	
	@FindBy(id = logoutValidation_id)
	private WebElement logoutValidation;

	public CartPagePOM() {
		PageFactory.initElements(driver, this);
	}

	public void getCartPagePOM() throws Throwable {

		elementClick(cart);
		staticWait(2000);
		takeScreenshot("C:\\Users\\ajith\\eclipse-workspace\\MavenBlazeProject\\snaps\\cartPic.png");
		elementClick(placeOrder);
		passValue(name, "surendar");
		passValue(country, "india");
		passValue(city, "chennai");
		passValue(creditCard, "1111 2222 3333 4444");
		passValue(month, "march");
		passValue(year, "2309");
		elementClick(purchase);
		staticWait(3000);
		takeScreenshot("C:\\Users\\ajith\\eclipse-workspace\\MavenBlazeProject\\snaps\\order.png");
		elementClick(ok);
		staticWait(3000);
		elementClick(logout);
		String actual = logoutValidation.getText();
		implicitWait(10);
		Assert.assertEquals(actual, "Sign up");
		System.out.println("logged out successfully");
		terminate();
	}

}
