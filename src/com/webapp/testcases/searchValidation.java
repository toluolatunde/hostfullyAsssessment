package com.webapp.testcases;

import com.webapp.base.DriverInstance;
import com.webapp.pages.LandingPage;
import com.webapp.utility.Utility;
import org.testng.annotations.Test;


import java.io.IOException;

public class searchValidation extends DriverInstance {
    @Test
    public void validateSearch() throws IOException, InterruptedException
    {
        LandingPage search = new LandingPage(driver);

        //check page elements are displayed
        search.rewardsOnPage();
        //search.checkFlightIsOnNavBar();

        //SearchQuery
        search.stayTab();
        search.clickDestinationField();
        search.enterDubaiDestination();
        Thread.sleep(1000);
        search.clickDubaiFromDropDown();
        Thread.sleep(1000);
        search.clickSearchButton();


        //Asserting new page
        Thread.sleep(2000);
        search.verifySearchedCity();
        search.verifySearchResultIsPremierInn();
        search.verifyBurjKhalifaInPopularFilter();

        //Take Screenshot
        Utility.captureScreenshot("dubaiAsSearched");



    }


}
