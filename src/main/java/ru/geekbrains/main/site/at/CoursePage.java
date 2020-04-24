package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {
    private WebDriver driver;
    public CoursePage(WebDriver driver) {this.courseHeader = PageFactory.initElements(driver, CourseHeader.class);}
    private CourseHeader courseHeader;

    @Step(value = "Проверка работоспособности фильтрации по чекбоксам {0}, {1}")
    public CoursePage configFilter(String... args) {
        for (String test : args) {
            driver.findElement(By.xpath("//form/ul//label[text()='" + test + "']"))
                    .click();
        }
        return this;
    }
    @Step(value = "Проверка отображения курсов{0}, {1}")
    public CoursePage checkDispCourse(String... args) {
        for (String test : args) {
            driver.findElement(By.xpath("//a/div/div/span[text()='" + test + "']"));
        }
        return this;
    }

    public CourseHeader getCourseHeader() {
        return courseHeader;
    }
}


