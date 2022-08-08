package com.codewithazam.pages;

import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageElements extends CommonMethods {

    public DashboardPageElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    public WebElement PIM;
}
