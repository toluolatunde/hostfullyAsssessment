package com.webapp.utility;

import com.webapp.base.DriverInstance;
import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Utility extends DriverInstance{

    public static Object fetchProperty(String key) throws IOException
    {
        FileInputStream file = new FileInputStream("./Config/config.properties");
        Properties property = new Properties();
        property.load(file);
        //property.get(key);
        property.get(key);
        return property.get(key);
    }

    public static String fetchLocator(String key ) throws IOException {

        FileInputStream file = new FileInputStream("./Config/Locators.properties");
        Properties property = new Properties();
        property.load(file);
        return 	property.get(key).toString();
    }


    public static void captureScreenshot(String screenshotName) {

        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;

            File source=ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));

            System.out.println("Screenshot taken");
        }
        catch (Exception e)
        {

            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }


}
