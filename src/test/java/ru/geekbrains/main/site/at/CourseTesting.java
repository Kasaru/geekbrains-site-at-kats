package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.basis.BasisTest;

public class CourseTesting extends BasisTest {
    @DisplayName("Вход с валидным логином и паролем")
    @Test
    void checkSingIn() {
        String login = "hao17583@bcaoo.com";
        String password = "hao17583";

        driver.get("https://geekbrains.ru/login");
        driver.manage().window().maximize();

        ((CoursePage)
                PageFactory.initElements(driver, AuthPage.class)
                        .authorization(login, password)
                        .checkNamePage("Главная")
                        .getNavigation()
                        .clickButton("Курсы")
        )
                .getCourseHeader().clickButton("Курсы")
                .configFilter("Бесплатные", "Тестирование")
                .checkingDisplayedCourses(
                        "Тестирование ПО. Уровень 1",
                        "Тестирование ПО. Уровень 2"
                )
        ;

    }
}
