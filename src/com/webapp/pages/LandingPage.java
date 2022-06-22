package com.webapp.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;

import com.webapp.utility.Utility;


public class LandingPage {

    String errorMessage = "User not found";

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickDestinationField() throws IOException {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(Utility.fetchLocator("destinationField_XPATH")))).click();

       // driver.findElement(By.xpath(Utility.fetchLocator("destinationField_XPATH"))).click();

    }

    public void enterDubaiDestination() throws IOException {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.id(Utility.fetchLocator("enterDestination_ID")))).sendKeys(Utility.fetchLocator("country_TEXT"));

        //driver.findElement(By.id(Utility.fetchLocator("enterDestination_ID"))).sendKeys(Utility.fetchLocator("country_TEXT"));

    }

    public void clickDubaiFromDropDown() throws IOException {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(Utility.fetchLocator("selectSecondDropDown_XPATH")))).click();

      //  driver.findElement(By.xpath(Utility.fetchLocator("selectSecondDropDown_XPATH"))).click();

    }


    public void clickSearchButton() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("searchButton_XPATH"))).click();
    }

    public void rewardsOnPage() throws IOException {

        isElementPresent(By.id("marquee-title"));

    }

    public void stayTab() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("stayNavBar_XPATH"))).click();

    }

    public void verifySearchedCity() throws IOException {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(Utility.fetchLocator("check_XPATH"))));

        assertEquals(driver.findElement(By.xpath(Utility.fetchLocator("check_XPATH"))).getText(), "Going to\n" +
                "Dubai, United Arab Emirates");
    }




    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void verifySearchResultIsPremierInn() throws IOException {
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("premierInn_XPATH")));

        try {
            assertEquals(
                    driver.findElement(By.linkText("More information about Premier Inn Dubai International Airport, opens in a new tab"))
                            .getText(),
                    "More information about Premier Inn Dubai International Airport, opens in a new tab");
        } catch (Error e) {
            System.out
                    .println(new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(
                                    By.linkText("More information about Premier Inn Dubai International Airport, opens in a new tab")))
                            .getText());
        }

    }

    public void checkFlightIsOnNavBar() throws IOException {
        try {
            assertEquals(
                    driver.findElement(By.xpath("flightNavBar_XPATH"))
                            .getText(),
                    "Flights");
        } catch (Error e) {
            System.out
                    .println(new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(
                                    (By.xpath("flightNavBar_XPATH"))))
                                            .getText());
        }

    }

    public void verifyBurjKhalifaInPopularFilter() throws IOException {
        try {
            assertEquals(
                    driver.findElement(By.xpath(Utility.fetchLocator("popularFilter_XPATH")))
                            .getText(),
                    "Burj Khalifa");
        } catch (Error e) {
            System.out
                    .println(new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(
                                            By.xpath(Utility.fetchLocator("popularFilter_XPATH"))))
                            .getText());
        }

    }

    }


