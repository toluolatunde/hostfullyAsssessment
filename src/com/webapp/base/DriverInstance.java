package com.webapp.base;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.webapp.utility.Utility;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DriverInstance {

    public static WebDriver driver;


    @BeforeTest
    public void setUp() throws IOException {

        if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
            driver = new ChromeDriver();

        }

        else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        }

        else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
            driver = new EdgeDriver();

        }

        driver.get(Utility.fetchProperty("applicationURL").toString());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

    }
    @AfterTest
    public void tearDown() {
        driver.close();

    }

    public static String fn_GetTimeStamp() {
        DateFormat DF = DateFormat.getDateTimeInstance();
        Date dte = new Date();
        //DateFormat DF = DateFormat.getDateTimeInstance();
        //Date dte = new Date();
        String DateValue = DF.format(dte);
        DateValue = DateValue.replaceAll(":", "_");
        DateValue = DateValue.replaceAll(",", "");
        return DateValue;
    }

    //Perform Action
//    public static Actions getAction() {
//        Actions action = new Actions(driver);
//        return action;
    public static String TakeSnapshot(String DestFilePath) throws IOException {
        String TS = fn_GetTimeStamp();
        TakesScreenshot tss = (TakesScreenshot) driver;
        File srcfileObj = tss.getScreenshotAs(OutputType.FILE);
        DestFilePath = DestFilePath + TS + ".png";
        File DestFileObj = new File(DestFilePath);

        FileUtils.copyFile(srcfileObj, DestFileObj);
        return DestFilePath;

    }


}
