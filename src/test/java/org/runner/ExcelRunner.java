package org.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.reusabilityMethods.BaseClass;
import com.utility.ExcelData;

public class ExcelRunner extends BaseClass {

	public static void main(String[] args) throws Throwable {
		implicitWait(20);
		browserLaunch("edge");
		urlLaunch("https://www.youtube.com/");
		WebElement searchBar = driver.findElement(By.xpath("//input[@name='search_query']"));
		passValue(searchBar, ExcelData.getSingleExcelData(0, 2));
		WebElement searchBtn = driver.findElement(By.xpath("//button[contains(@class,'ytSearchboxComponentSearchButtonDark')]"));
		elementClick(searchBtn);
		staticWait(3000);
		takeScreenshot("C:\\Users\\ajith\\eclipse-workspace\\MavenBlazeProject\\snaps\\dataDriven.png");
	}

}
