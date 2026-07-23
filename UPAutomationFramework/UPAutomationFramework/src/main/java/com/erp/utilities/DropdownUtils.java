package com.erp.utilities;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {

	public static void selectOptionFromDropDown(WebDriver ldriver,WebElement ele, String value)
	{
		Select drp = new Select(ele);
		List<WebElement> alloptions = drp.getOptions();
		for(WebElement option : alloptions)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
	}
	
}
