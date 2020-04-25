package ru.geekbrains.main.site.at;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class CoursePage extends MainPage{

        public CoursePage(WebDriver driver) {
            super(driver);
            this.courseHeader = PageFactory.initElements(driver, CourseHeader.class);
        }

        private CourseHeader courseHeader;
        @Step(value = "Настройка фильтрации курсов")
        public CoursePage configFilter(String... args) {
            for (String test : args) {
                driver.findElement(By.xpath("//form/ul//label[text()='" + test + "']")).click();
            }
            return this;
        }
        @Step(value = "Проверка соответствия отображаемых курсов")
        public CoursePage checkingDisplayedCourses(String... args) {
            for (String test : args) {
                driver.findElement(By.xpath("//a/div/div/span[text()='" + test + "']"));
            }
            return this;
        }

        public CourseHeader getCourseHeader() {
            return courseHeader;
        }
}



