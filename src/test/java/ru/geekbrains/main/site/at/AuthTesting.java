package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.basis.BasisTest;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка авторизации.")
public class AuthTesting extends BasisTest {
        @DisplayName("Вход с валидным логином и паролем")
        @Test
        @Link(value = "https://geekbrains.ru/login")
        @Description(value = "Проверка работоспособности модуля авторизации https://geekbrains.ru/login")
        void checkSignIn() {
            String login = "hao17583@bcaoo.com";
            String password = "hao17583";

            driver.get("https://geekbrains.ru/login");
            PageFactory.initElements(driver, AuthPage.class)
                    .authorization(login, password)
                    .checkNamePage("Главная");
        }
}

