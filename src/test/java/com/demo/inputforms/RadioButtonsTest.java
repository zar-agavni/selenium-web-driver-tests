package com.demo.inputforms;

import com.demo.ChromeTestCase;
import org.openqa.selenium.By;

public class RadioButtonsTest extends ChromeTestCase {

    public void testRadioButtonFemale() {
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        driver.findElement(By.cssSelector("input[value=\"Female\"]")).click();
        driver.findElement(By.id("buttoncheck")).click();
        String result = driver.findElement(By.className("radiobutton")).getText();
        assertEquals("Radio button 'Female' is checked", result);
    }

    public void testRadioButtonMale() {
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        driver.findElement(By.cssSelector("input[value=\"Male\"]")).click();
        driver.findElement(By.id("buttoncheck")).click();
        String result = driver.findElement(By.className("radiobutton")).getText();
        assertEquals("Radio button 'Male' is checked", result);
    }

    public void testRadioButtonNotSelected() {
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        driver.findElement(By.id("buttoncheck")).click();
        String result = driver.findElement(By.className("radiobutton")).getText();
        assertEquals("Radio button is Not checked", result);
    }

    public void testGroupRadioButtons() {
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        driver.findElement(By.cssSelector("input[value=\"Male\"][name=\"gender\"]")).click();
        driver.findElement(By.cssSelector("input[value=\"0 - 5\"][name=\"ageGroup\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).click();
        String result = driver.findElement(By.className("groupradiobutton")).getText();
        assertEquals("Sex : Male\n" + "Age group: 0 - 5", result);
    }
}
