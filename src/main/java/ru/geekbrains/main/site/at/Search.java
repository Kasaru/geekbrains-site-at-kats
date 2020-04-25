package ru.geekbrains.main.site.at;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Search {

    @FindBy(xpath = "//div[@class=\"container\"]/ul/li/a[@data-tab=\"professions\"]/span[text()]")
    private WebElement quantityProfession;
    @FindBy(xpath = "//div[@class=\"container\"]/ul/li/a[@data-tab=\"courses\"]/span")
    private WebElement quantityCourses;
    @FindBy(xpath = "//div[@class=\"container\"]/ul/li/a[@data-tab=\"webinars\"]/span")
    private WebElement quantityWebinars;
    @FindBy(xpath = "//div[@class=\"container\"]/ul/li/a[@data-tab=\"blogs\"]/span")
    private WebElement quantityBlogs;
    @FindBy(xpath = "//div[@class=\"container\"]/ul/li/a[@data-tab=\"forums\"]/span")
    private WebElement quantityForums;
    @FindBy(xpath = "//div[@class=\"container\"]/ul/li/a[@data-tab=\"tests\"]/span")
    private WebElement quantityTests;

    @FindBy(css ="[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    private WebElement buttonSearch;
    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;

    public Search(WebDriver driver) {
        block = PageFactory.initElements(driver, Block.class);
    }
    private Block block;
    @Step(value = "Введение тестовых данных java")
    public Search inputSearch(String word){
        buttonSearch.click();
        inputSearch.sendKeys(word);
        return this;
    }
    @Step(value = "Проверка отображаемых в блоках значений")
    @Description(value =
            "Профессий не менее чем 2\n" +
            "Курсов более 15\n" +
            "Вебинаров больше чем 180, но меньше 300\n" +
            "Блогов более 300\n" +
            "Форумов не 350\n" +
            "Тестов не 0")
    public Search QuantityAssert() {
    assertThat(Integer.parseInt(quantityProfession.getText()), greaterThanOrEqualTo(2));
    assertThat(Integer.parseInt(quantityCourses.getText()), greaterThan(15));
    assertThat(Integer.parseInt(quantityWebinars.getText()), allOf(greaterThan(180), lessThan(300)));
    assertThat(Integer.parseInt(quantityBlogs.getText()), greaterThan(300));
    assertThat(Integer.parseInt(quantityForums.getText()), not(equalTo(350)));
    assertThat(Integer.parseInt(quantityTests.getText()), not(equalTo(0)));
        return this;
    }

    public Block getBlock() {
        return block;
    }
}

