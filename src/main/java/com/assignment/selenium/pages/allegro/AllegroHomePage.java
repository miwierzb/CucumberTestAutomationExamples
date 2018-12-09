package com.assignment.selenium.pages.allegro;

import com.assignment.selenium.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class AllegroHomePage extends BasePage {

    private final static By selectorHeaderSearchBox = By.cssSelector("[data-box-name='allegro.metrumHeader.search']");
    private final static By selectorElektonikaButton = By.cssSelector("[href='/dzial/elektronika']");
    private final static By selectorKomputeryButton = By.cssSelector("[title='Komputery']");
    private final static By selectorNieZgadzamSieButton = By.cssSelector("[data-analytics-interaction-value='reject']");
    private final static String url = "https://allegro.pl/";

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Allegro 'Home' Page is loaded");
        if (getDriver().getCurrentUrl().equals(url)) {
            logger().info("'Home' Page LOADED");
            return true;
        }
        logger().info("'Home' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Allegro 'Home' Page...");
        getDriver().get(url);
        waitForPageToLoad();
    }

    public boolean isNieZgadzamSieButtonDisplayed(){
        logger().info("Checking if 'Nie zgadzam sie' button is displayed");
        waitForElementToAppearNoException(selectorNieZgadzamSieButton);
        return getDriver().findElement(selectorNieZgadzamSieButton).isDisplayed();
    }

    public void clickNieZgadzamSieButton(){
        logger().info("Clicking 'Nie zgadzam sie' button");
        waitForElementToBeClickable(selectorNieZgadzamSieButton);
        getDriver().findElement(selectorNieZgadzamSieButton).click();
        waitForElementToDisappear(selectorNieZgadzamSieButton);
    }

    public AllegroElektronikaPage clickElektronikaButton(){
        logger().info("Clicking 'Elektronika' button");
        waitForElementToBeClickable(selectorElektonikaButton);
        getDriver().findElement(selectorElektonikaButton).click();
        return new AllegroElektronikaPage();
    }

    public boolean isHeaderSearchBoxDisplayed(){
        logger().info("Checking if header Search Box is displayed");
        waitForElementToAppearNoException(selectorHeaderSearchBox);
        return getDriver().findElement(selectorHeaderSearchBox).isDisplayed();
    }

    public AllegroKomputeryPage hoverOverElektronikaAndClickKomputeryButton(){
        logger().info("Hovering over 'Elektronika' text and clicking 'Komputery' Button");
        waitForElementToAppear(selectorElektonikaButton);
        WebElement elektronikaButton = getDriver().findElement(selectorElektonikaButton);
        Actions builder = new Actions(getDriver());
        builder.moveToElement(elektronikaButton).perform();
        waitForElementToAppear(selectorKomputeryButton);
        WebElement komputeryButton = getDriver().findElement(selectorKomputeryButton);
        builder.moveToElement(komputeryButton).click().perform();
        return new AllegroKomputeryPage();
    }

}
