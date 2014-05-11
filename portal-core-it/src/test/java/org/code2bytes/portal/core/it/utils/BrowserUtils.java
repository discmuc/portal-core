package org.code2bytes.portal.core.it.utils;

import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.inject.Produces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.runtime.CucumberException;

public class BrowserUtils {

	private static WebDriver driver;

	@Produces
	public synchronized WebDriver getDriver() {

		if (driver == null) {
			try {
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("intl.accept_languages", "en");
				profile.setEnableNativeEvents(true);
				DesiredCapabilities dc = DesiredCapabilities.firefox();
				dc.setCapability(FirefoxDriver.PROFILE, profile);

				String seleniumUrl = System
						.getProperty("c2b.test.it.selenium.url");

				if (seleniumUrl == null || seleniumUrl.isEmpty()) {
					throw new MalformedURLException(
							"No selenium server URL available.");
				}

				driver = new RemoteWebDriver(new URL(seleniumUrl), dc);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} finally {
				Runtime.getRuntime().addShutdownHook(
						new Thread(new BrowserCleanup()));
			}
		}

		if (driver == null)
			throw new CucumberException("Couldn't create WebDriver instance.");

		return driver;
	}

	private static class BrowserCleanup implements Runnable {

		@Override
		public void run() {
			if (driver != null)
				driver.close();
		}
	}
}
