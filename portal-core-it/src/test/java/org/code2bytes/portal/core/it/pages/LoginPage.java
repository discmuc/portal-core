package org.code2bytes.portal.core.it.pages;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	@Inject
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openLoginPage() {
		String url = System.getProperty("c2b.test.it.url.desktop");
		driver.get(url);
	}
}
