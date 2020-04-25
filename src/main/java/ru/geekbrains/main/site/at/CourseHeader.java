package ru.geekbrains.main.site.at;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseHeader {

    public CourseHeader(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[id=\"prof-link\"]")
    private WebElement buttonProfessions;

    @FindBy(css = "[id=\"free-link\"]")
    private WebElement buttonFreeIntensive;

    @FindBy(css = "[id=\"cour-link\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[href*=\"https://forbusiness\"]")
    private WebElement buttonCompanies;


    private WebDriver driver;

    public CoursePage clickButton(String nameButton) {
        switch (nameButton) {
            case "Профессии": {
                buttonProfessions.click();
                break;
            }
            case "Бесплатные интенсивы": {
                buttonFreeIntensive.click();
                break;
            }
            case "Курсы": {
                buttonCourses.click();
                break;
            }
            case "Компаниям": {
                buttonCompanies.click();
                break;
            }
            default: {
                throw new NotFoundException("Кнопка с именем " + nameButton + " не найдена");
            }
        }

        return PageFactory.initElements(driver, CoursePage.class);
    }

}