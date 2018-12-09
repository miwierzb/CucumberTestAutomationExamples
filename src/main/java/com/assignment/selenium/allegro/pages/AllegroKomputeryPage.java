package com.assignment.selenium.allegro.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class AllegroKomputeryPage extends BasePage {

    private final static By selectorKomputeryText = By.xpath("//span[@class='listing-title__category' and text()='Komputery']");
    private final static By selectorKomputeryBreadcrumb = By.xpath("//div[@data-role='breadcrumb-item']//*[@itemprop='name' and text()='Komputery']");
    private final static By selectorDyskiIPamieciPrzenosneButton = By.cssSelector("[data-analytics-click-value='Dyski i pamięci przenośne']");
    private final static String url = "https://allegro.pl/kategoria/komputery";

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Allegro 'Komputery' Page is loaded");
        if (getDriver().getCurrentUrl().contains(url)) {
            logger().info("'Komputery' Page LOADED");
            return true;
        }
        logger().info("'Komputery' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Allegro 'Komputery' Page...");
        waitForPageToLoad();
    }

    public boolean isKomputeryTextDisplayed() {
        logger().info("Checking if 'Komputery' text is displayed");
        waitForElementToAppearNoException(selectorKomputeryText);
        return getDriver().findElement(selectorKomputeryText).isDisplayed();
    }

    public boolean isKomputeryBreadcrumbDisplayed() {
        logger().info("Checking if 'Komputery' breadcrumb is displayed");
        waitForElementToAppearNoException(selectorKomputeryBreadcrumb);
        return getDriver().findElement(selectorKomputeryBreadcrumb).isDisplayed();
    }

    public AllegroDyskiIPamieciPrzenosnePage clickDyskiIPamieciPrzenosneButton(){
        logger().info("Clicking 'Dyski i pamieci przenosne' button");
        waitForElementToBeClickable(selectorDyskiIPamieciPrzenosneButton);
        getDriver().findElement(selectorDyskiIPamieciPrzenosneButton).click();
        return new AllegroDyskiIPamieciPrzenosnePage();
    }

}