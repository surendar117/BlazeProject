package com.reusabilityMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class BaseClass {

	public static WebDriver driver;

	protected static void browserLaunch(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
		}
	}

	protected static void urlLaunch(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
		}
	}

	protected static void passValue(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
		}
	}

	protected static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
		}
	}

	protected static void terminate() {
		try {
			driver.quit();
		} catch (Exception e) {
		}
	}

	protected static void closeCurrentPage() {
		try {
			driver.close();
		} catch (Exception e) {
		}
	}

	protected static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
		}
	}

	protected static void navigate(String text) {
		try {
			if (text.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (text.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (text.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
		}
	}

	protected static void staticWait(int milliSeconds) throws Throwable {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
		}
	}

	protected static void implicitWait(short sec) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		} catch (Exception e) {
		}
	}

	protected static void implicitWait(int min) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(min));
		} catch (Exception e) {
		}
	}

	protected static void alertHandle(String action) {
		try {
			if (action.equalsIgnoreCase("ok")) {
				driver.switchTo().alert().accept();
			} else if (action.equalsIgnoreCase("cancel")) {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {
		}
	}

	protected static void alertHandle(String input, String action) {
		try {
			if (action.equalsIgnoreCase("ok")) {
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(input);
				alert.accept();
			} else if (action.equalsIgnoreCase("cancel")) {
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(input);
				alert.dismiss();
			} else if (input.equals("") && action.equalsIgnoreCase("ok")) {
				Alert alert = driver.switchTo().alert();
				// alert.sendKeys(input);
				alert.accept();
			} else if (input.equals("") && action.equalsIgnoreCase("cancel")) {
				Alert alert = driver.switchTo().alert();
				// alert.sendKeys(input);
				alert.dismiss();
			}
		} catch (Exception e) {
		}
	}

	protected static void getCurrentURL() { // returns attribute value;
		try {
			System.out.println(driver.getCurrentUrl());
		} catch (Exception e) {
		}
	}

	protected static void getTittle() {
		try {
			System.out.println(driver.getTitle());
		} catch (Exception e) {
		}
	}

	protected static void getAttribute(WebElement element, String attributeName) { // returns attribute value;
		try {
			String attributeValue = element.getAttribute(attributeName);
			System.out.println(attributeValue);
		} catch (Exception e) {
		}
	}

	protected static void getText(WebElement element) { // returns text in the element;
		try {
			String Text = element.getText();
			System.out.println(Text);
		} catch (Exception e) {
		}
	}

	protected static void takeScreenshot(String path) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(path);
			FileHandler.copy(source, destination);
		} catch (WebDriverException e) {
		} catch (IOException e) {
		}
	}

	protected static void outOfFrame() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
		}
	}

	protected static void frame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
		}
	}

	protected static void frame(String value) {
		try {
			driver.switchTo().frame(value);
		} catch (Exception e) {
		}
	}

	protected static void frame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
		}
	}

	protected static void isEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			System.out.println(enabled);
		} catch (Exception e) {
		}
	}

	protected static void isDisplayed(WebElement element) {
		try {
			boolean displayed = element.isDisplayed();
			System.out.println(displayed);
		} catch (Exception e) {
		}
	}

	protected static void isSelected(WebElement element) {
		try {
			boolean selected = element.isDisplayed();
			System.out.println(selected);
		} catch (Exception e) {
		}
	}

	protected static void mouseActions(WebElement element, String action) {
		Actions ac = new Actions(driver);
		try {
			if (action.equalsIgnoreCase("moveToElement")) {
				ac.moveToElement(element).perform();
			} else if (action.equalsIgnoreCase("doubleClick")) {
				ac.doubleClick(element).perform();
			} else if (action.equalsIgnoreCase("contextClick")) {
				ac.contextClick(element).perform();
			} else if (action.equalsIgnoreCase("click")) {
				ac.click(element).perform();
			}
		} catch (Exception e) {
		}
	}

	protected static void dragAndDropby(WebElement element, int x, int y) {
		Actions ac = new Actions(driver);
		try {
			ac.dragAndDropBy(element, x, y).perform();
		} catch (Exception e) {
		}
	}

	protected static void dragAndDrop(WebElement element1, WebElement element2) {
		Actions ac = new Actions(driver);
		try {
			ac.dragAndDrop(element1, element2).perform();
		} catch (Exception e) {
		}
	}

	protected static void clickHoldRelease(WebElement element1, WebElement element2) {
		Actions ac = new Actions(driver);
		try {
			ac.clickAndHold(element1);
			ac.release(element2).perform();
			;
		} catch (Exception e) {
		}
	}

}
