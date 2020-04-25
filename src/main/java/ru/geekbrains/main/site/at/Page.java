package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public class Page {

    private CourseHeader courseHeader;

    public Page(WebDriver driver) {
        navigation = PageFactory.initElements(driver, Navigation.class);
    }

    private Navigation navigation;

    private WebDriver driver;

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement headerPage;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;

    @Step(value = "Закрытие всплывающего окна")
    public Page popUpClosed() {
        buttonPopUpClosed.click();
        return this;
    }
    @Step(value = "Проверка соответствия имени страницы")
    public Page checkNamePage(String exampleNamePage) {
        String headerPageText = headerPage.getText();
        assertThat(headerPageText, equalToCompressingWhiteSpace(exampleNamePage));
        return this;
    }

    public Navigation getNavigation() {
        return navigation;
    }

}
