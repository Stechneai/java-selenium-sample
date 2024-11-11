package com.lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicAuthentication {
    public static String hubURL = "https://hub.lambdatest.com/wd/hub";
    private WebDriver driver;

    public void setup() throws MalformedURLException {

        ChromeOptions browserOptions = new ChromeOptions();
browserOptions.setPlatformName("Windows 10");
browserOptions.setBrowserVersion("130");
HashMap<String, Object> ltOptions = new HashMap<String, Object>();
ltOptions.put("username", "preeti.bokade");
ltOptions.put("accessKey", "ndLW8ygsIAWTRc9YCBxkEOoybKYst3zd8dnUnP6t0MNPMpqVw9");
ltOptions.put("visual", true);
ltOptions.put("video", true);
ltOptions.put("build", "GTest");
ltOptions.put("project", "SampleTest");
ltOptions.put("name", "SampleTest1");
ltOptions.put("selenium_version", "4.0.0");
ltOptions.put("w3c", true);
browserOptions.setCapability("LT:Options", ltOptions);
        driver = new RemoteWebDriver(new URL(hubURL), capabilities);
        System.out.println(driver);
    }

    public void authentication() {
        Augmenter augmenter = new Augmenter();
        driver = augmenter.augment(driver);

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        driver = augmenter.addDriverAugmentation("chrome", HasAuthentication.class,
                (caps, exec) -> (whenThisMatches, useTheseCredentials) -> devTools.getDomains().network()
                        .addAuthHandler(whenThisMatches, useTheseCredentials))
                .augment(driver);

        ((HasAuthentication) driver).register(UsernameAndPassword.of("foo", "bar"));

        driver.get("http://httpbin.org/basic-auth/foo/bar");

        String text = driver.findElement(By.tagName("body")).getText();
        System.out.println(text);
        if (text.contains("authenticated")) {
            markStatus("passed", "Authentication Successful", driver);
        } else {
            markStatus("failed", "Authentication Failure", driver);
        }

    }

    public void tearDown() {
        try {
            driver.quit();
        } catch (

        Exception e) {
            markStatus("failed", "Got exception!", driver);
            e.printStackTrace();
            driver.quit();
        }
    }

    public static void markStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jsExecute = (JavascriptExecutor) driver;
        jsExecute.executeScript("lambda-status=" + status);
        System.out.println(reason);
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        BasicAuthentication test = new BasicAuthentication();
        test.setup();
        test.authentication();
        test.tearDown();
    }
}
