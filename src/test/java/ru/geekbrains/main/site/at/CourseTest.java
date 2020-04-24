package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.basis.BasisTest;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка страницы Курсы")
@Feature(value = "Проверка страниц")
@Story(value = "Проверка страницы Курсы")
public class CourseTest extends BasisTest{

        @DisplayName("Вход с валидный логин/пароль")
        @Test
        void checkSingIn() {
            String login = "hao17583@bcaoo.com";
            String password = "hao17583";

            driver.get("https://geekbrains.ru/login");
            driver.manage().window().maximize();
            PageFactory.initElements(driver, AuthPage.class)
                .authorization(login, password)
                .checkNamePage("Главная")
                .getNavigation()
                .clickButton("Курсы")
                .getCourseHeader().clickButton("Курсы")
                .configFilter("Бесплатные", "Тестирование")
                .checkDispCourse("Тестирование ПО. Уровень 1", "Тестирование ПО. Уровень 2");

        }
}

