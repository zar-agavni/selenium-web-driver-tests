package com.demo.inputforms;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxTest extends TestCase {

    private WebDriver driver;

    @Override
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zarag\\Downloads\\chromedriver_96\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Override
    public void tearDown() throws Exception {
        driver.quit();
    }

    public void testSingleCheckBox() {
        // Given
        driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
        driver.findElement(By.id("isAgeSelected")).click();

        // When
        final String text = driver.findElement(By.id("txtAge")).getText();

        // Then
        assertEquals("Success - Check box is checked", text);
    }

    public void testMultipleCheckbox() {
        // Given
        driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
        driver.findElement(By.id("check1")).click();

        // When
        final boolean isChecked = driver.findElement(By.className("cb1-element")).isSelected();
        final String btnName = driver.findElement(By.id("check1")).getAttribute("value");

        // Then
        assertTrue(isChecked);
        assertEquals("Uncheck All", btnName);
    }

    public void testMultipleCheckboxSimple() {
        // Given
        driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
        driver.findElement(By.id("check1")).click();

        // When
        final String isChecked = driver.findElement(By.id("isChkd")).getAttribute("value");
        final String btnName = driver.findElement(By.id("check1")).getAttribute("value");

        // Then
        //Get attribute value as a String and converted to Boolean.
        assertTrue(Boolean.parseBoolean(isChecked));
        assertEquals("Uncheck All", btnName);
    }

    public void testMultipleCheckboxUncheck() {
        // Given
        driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
        //Check All
        driver.findElement(By.id("check1")).click();
        //Uncheck All
        driver.findElement(By.id("check1")).click();

        // When
        boolean isChecked = driver.findElement(By.className("cb1-element")).isSelected();
        String btnName = driver.findElement(By.id("check1")).getAttribute("value");

        // Then
        assertFalse(isChecked);
        assertEquals("Check All", btnName);
    }
}