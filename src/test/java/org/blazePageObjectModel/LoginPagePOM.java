package org.blazePageObjectModel;

import org.blazeInterfaceElements.LoginPageElements;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reusabilityMethods.BaseClass;
import com.utility.FileReaderManager;

public class LoginPagePOM extends BaseClass implements LoginPageElements { // 1.@findBy 2.constructor 3.action method

	@FindBy(id = login_id)
	private WebElement login;
	@FindBy(id = username_id)
	private WebElement username;
	@FindBy(id = password_id)
	private WebElement password;
	@FindBy(xpath = loginBtn_xpath)
	private WebElement loginBtn;
	@FindBy(id = loginValidation_id)
	private WebElement loginValidation;

	public LoginPagePOM() {
		PageFactory.initElements(driver, this);
	}

	public void getLoginPagePOM() throws Throwable {

		elementClick(login);
		implicitWait(10);
		passValue(username, FileReaderManager.getProperty("username"));
		passValue(password, FileReaderManager.getProperty("password"));
		elementClick(loginBtn);
		staticWait(3000);
		String actual = loginValidation.getText();
		Assert.assertEquals(actual, "Welcome surendar@123");
		System.out.println("logged in succesfully");
	}

}
