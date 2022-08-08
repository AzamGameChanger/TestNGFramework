package com.codewithazam.testbase;

import com.codewithazam.utils.CommonMethods;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Base.test = Base.report.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Base.test.pass("Test case passed " + result.getName());
        try {
            Base.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("passed/" + result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Base.test.fail("Test case failed " + result.getName());
        try {
            Base.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("failed/"+result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
