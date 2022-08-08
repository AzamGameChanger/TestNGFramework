package com.codewithazam.testcases;

import com.codewithazam.pages.DashboardPageElements;
import com.codewithazam.pages.LoginPageElements;
import com.codewithazam.utils.CommonMethods;
import com.codewithazam.utils.ConfigsReader;
import com.codewithazam.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends CommonMethods {

    @Test(groups = {"smoke","regression"})
    public void validLogin(){
        LoginPageElements login = new LoginPageElements();
        DashboardPageElements dashboard = new DashboardPageElements();

        sendText(login.username, ConfigsReader.getProperty("username"));
        sendText(login.password, ConfigsReader.getProperty("password"));
        jsClick(login.loginBtn);

        boolean welcomeDisplayed =  dashboard.welcomeMessage.isDisplayed();
        Assert.assertTrue(welcomeDisplayed, "Welcome message isn't displayed");
        
    }

    @Test(groups = "regression")
    public void emptyPasswordLogin(){
        LoginPageElements login = new LoginPageElements();

        sendText(login.username, ConfigsReader.getProperty("username"));
        click(login.loginBtn);

        String expectedMsg ="Password cannot be empty";
        String actualMsg = login.errorMsg.getText();

        Assert.assertEquals(actualMsg,expectedMsg,"The error message doesn't match");
    }

    @Test(groups = "regression")
    public void invalidPasswordLogin(){
        LoginPageElements login = new LoginPageElements();

        sendText(login.username, ConfigsReader.getProperty("username"));
        sendText(login.password, "bla-bla-bla");
        click(login.loginBtn);

        String expectedMsg ="Invalid credentials";
        String actualMsg = login.errorMsg.getText();

        Assert.assertEquals(actualMsg,expectedMsg,"The error message doesn't match");

    }

}
