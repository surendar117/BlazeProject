package org.blazePageObjectManager;

import org.blazePageObjectModel.CartPagePOM;
import org.blazePageObjectModel.LoginPagePOM;
import org.blazePageObjectModel.ProductPagePOM;

import com.utility.FileReaderManager;

public class PageObjectManager {

	private static PageObjectManager manager;
	private FileReaderManager reader;
	private LoginPagePOM login;
	private ProductPagePOM product;
	private CartPagePOM cart;

	private PageObjectManager() {

	}

	public static PageObjectManager getPageObjectManager() {
		if (manager == null) {
			manager = new PageObjectManager();
		}
		return manager;
	}

	public FileReaderManager getFileReaderManager() {
		if (reader == null) {
			reader = new FileReaderManager();
		}
		return reader;
	}

	public LoginPagePOM getLoginPage() {
		if (login == null) {
			login = new LoginPagePOM();
		}
		return login;
	}

	public ProductPagePOM getProductPage() {
		if (product == null) {
			product = new ProductPagePOM();
		}
		return product;
	}

	public CartPagePOM getCartPage() {
		if (cart == null) {
			cart = new CartPagePOM();
		}
		return cart;
	}

}
