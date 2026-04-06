package org.runner;

import org.blazePageObjectManager.PageObjectManager;

import com.reusabilityMethods.BaseClass;

public class BlazeRunner extends BaseClass{
	
	public static void main(String[] args) throws Throwable {
		
		browserLaunch(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("browser"));
		urlLaunch(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("blazeUrl"));
		PageObjectManager.getPageObjectManager().getLoginPage().getLoginPagePOM();
		PageObjectManager.getPageObjectManager().getProductPage().getProductPagePOM();
		PageObjectManager.getPageObjectManager().getCartPage().getCartPagePOM();
		
	}

}
