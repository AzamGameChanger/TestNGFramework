package com.codewithazam.utils;

public class Constants {
    public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
    public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver";
    public static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/configs/config.properties";

    public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir") + "/screenshot/";
    public static final int IMPLICIT_WAIT_TIME =  10;
    public static final int EXPLICIT_WAIT_TIME =  20;

    public static final String REPORT_PATH = System.getProperty("user.dir") +"/target/html-report/HRMS.html";



}
