package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.basis.BasisTest;

public class SearchTest extends BasisTest {
//    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Поиск
//    В поле Поиск ввести текст: java
//    Проверить что отобразились блоки:
//            Профессии
//            Курсы
//            Вебинары
//            Блоги
//            Форум
//            Тесты
//            Проекты и компании

    @Test
    void name() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://geekbrains.ru/career");

        WebElement buttonSearch = driver.findElement(By.cssSelector("[id=\"top-menu\"] [class=\"show-search-form\"] svg"));
        buttonSearch.click();

        WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");


        WebElement textProfession = driver.findElement(By.xpath("//header/h2[text()='Профессии']"));
        String quantityProfession = driver.findElement(By.xpath("//div[@class=\"container\"]/ul/li/a[@data-tab=\"professions\"]/span[text()]")).getText();
        Assertions.assertTrue(Integer.parseInt(quantityProfession)>=2);

        WebElement textCourses = driver.findElement(By.xpath("//header/h2[text()='Курсы']"));
        String quantityCourses = driver.findElement(By.xpath("//div[@class=\"container\"]/ul/li/a[@data-tab=\"courses\"]/span")).getText();
        Assertions.assertTrue(Integer.parseInt(quantityCourses)>15);

        WebElement textWebinars = driver.findElement(By.xpath("//header/h2[text()='Вебинары']"));
        String quantityWebinars = driver.findElement(By.xpath("//div[@class=\"container\"]/ul/li/a[@data-tab=\"webinars\"]/span")).getText();
        Assertions.assertTrue(Integer.parseInt(quantityWebinars)>180&&Integer.parseInt(quantityWebinars)<300);

        WebElement textBlogs = driver.findElement(By.xpath("//header/h2[text()='Блоги']"));
        String quantityBlogs = driver.findElement(By.xpath("//div[@class=\"container\"]/ul/li/a[@data-tab=\"blogs\"]/span")).getText();
        Assertions.assertTrue(Integer.parseInt(quantityBlogs)>300);

        WebElement textForum = driver.findElement(By.xpath("//header/h2[text()='Форум']"));
        String quantityForum = driver.findElement(By.xpath("//div[@class=\"container\"]/ul/li/a[@data-tab=\"forums\"]/span")).getText();
        Assertions.assertTrue(Integer.parseInt(quantityForum)!=350);

        WebElement textTests = driver.findElement(By.xpath("//header/h2[text()='Тесты']"));
        String quantityTests = driver.findElement(By.xpath("//div[@class=\"container\"]/ul/li/a[@data-tab=\"tests\"]/span")).getText();
        Assertions.assertTrue(Integer.parseInt(quantityTests)!=0);

        WebElement textProjectsAndCompanies = driver.findElement(By.xpath("//header/h2[text()='Проекты и компании']"));
        WebElement textGeekProjectsAndCompanies = driver.findElement(By.xpath("//h3/a[@href=\"/career/682\"]"));

        WebDriverWait wait = new WebDriverWait(driver, 40);

        wait.until(ExpectedConditions.textToBePresentInElement(textProfession,"Профессии"));
        wait.until(ExpectedConditions.textToBePresentInElement(textCourses,"Курсы"));
        wait.until(ExpectedConditions.textToBePresentInElement(textWebinars,"Вебинары"));
        wait.until(ExpectedConditions.textToBePresentInElement(textBlogs,"Блоги"));
        wait.until(ExpectedConditions.textToBePresentInElement(textForum,"Форум"));
        wait.until(ExpectedConditions.textToBePresentInElement(textTests,"Тесты"));
        wait.until(ExpectedConditions.textToBePresentInElement(textProjectsAndCompanies,"Проекты и компании"));

    }
}