package org.blazeRunner;

import org.blazePageObjectManager.PageObjectManager;

import com.reusabilityMethods.BaseClass;
import com.utility.FileReaderManager;

public class Runner extends BaseClass {
	
	public static void main(String[] args) throws Throwable {
		
		browserLaunch(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("browser"));
	    urlLaunch(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("blazeUrl"));
	    PageObjectManager.getPageObjectManager().getLoginPage().getLoginPagePOM();
	    PageObjectManager.getPageObjectManager().getProductPage().getProductPagePOM();
	    PageObjectManager.getPageObjectManager().getCartPage().getCartPagePOM();
	    
	}

}
