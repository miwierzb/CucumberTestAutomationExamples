package com.assignment.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public abstract class BasePage implements IBasePage {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    private WebDriverWait wait;

    public BasePage() {
        wait = new WebDriverWait(getDriver(), TIMEOUT, POLLING);
    }

    protected void waitForElementToAppear(By locator) {
        logger().debug("Waiting for " + locator + " element to appear");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToAppearNoException(By locator) {
        logger().debug("Waiting for " + locator + " element to appear with no exception");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException
                | StaleElementReferenceException
                | TimeoutException ex){
            logger().error("Element not found!");
        }
    }

    protected void waitForElementToDisappearNoException(By locator) {
        logger().debug("Waiting for " + locator + " element to disappear with no exception");
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (NoSuchElementException
                | StaleElementReferenceException
                | TimeoutException ex){
            logger().error("Element not found or still visible!");
        }
    }

    protected void waitForElementToDisappear(By locator) {
        logger().debug("Waiting for " + locator + " element to disappear");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForElementToBeClickable(By locator) {
        logger().debug("Waiting for " + locator + " element to be clickable");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForPageToLoad() {
        logger().debug("Waiting for page to load");
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(pageLoadCondition);
    }

}
