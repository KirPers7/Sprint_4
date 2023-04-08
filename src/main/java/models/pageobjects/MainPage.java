package models.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    //Кнопка принятия cookie
    public static final By APP_COOKIE = By.className("App_CookieButton__3cvqF");
    //Кнопка "Заказать" на главной странице (наверху)
    public static final By CHECK_ORDER_BUTTON_TOP = By.xpath(".//button[(@class='Button_Button__ra12g') and (text()='Заказать')]");
    //Кнопка "Заказать" на главной странице (внизу)
    public static final By CHECK_ORDER_BUTTON_MID = By.cssSelector("button[class*='Button_Middle__1CSJM");
    //Вопросы о важном: 1. "Сколько это стоит? И как оплатить?"
    public static final By CLICK_ON_FIRST_QUESTION = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    //Вопросы о важном: 2. "Хочу сразу несколько самокатов! Так можно?"
    public static final By CLICK_ON_SECOND_QUESTION = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    //Вопросы о важном: 3. "Как рассчитывается время аренды?"
    public static final By CLICK_ON_THIRD_QUESTION = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    //Вопросы о важном: 4. "Можно ли заказать самокат прямо на сегодня?"
    public static final By CLICK_ON_FOURTH_QUESTION = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    //Вопросы о важном: 5. "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final By CLICK_ON_FIFTH_QUESTION = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    //Вопросы о важном: 6. "Вы привозите зарядку вместе с самокатом?"
    public static final By CLICK_ON_SIXTH_QUESTION = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    //Вопросы о важном: 7. "Можно ли отменить заказ?"
    public static final By CLICK_ON_SEVENTH_QUESTION = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    //Вопросы о важном: 8. "Я жизу за МКАДом, привезёте?"
    public static final By CLICK_ON_EIGHTH_QUESTION = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");
    //Ответ на вопрос 1
    public static final By ANSWER_ON_FIRST_QUESTION = By.id("accordion__panel-0");
    //Ответ на вопрос 2
    public static final By ANSWER_ON_SECOND_QUESTION = By.id("accordion__panel-1");
    //Ответ на вопрос 3
    public static final By ANSWER_ON_THIRD_QUESTION = By.id("accordion__panel-2");
    //Ответ на вопрос 4
    public static final By ANSWER_ON_FOURTH_QUESTION = By.id("accordion__panel-3");
    //Ответ на вопрос 5
    public static final By ANSWER_ON_FIFTH_QUESTION = By.id("accordion__panel-4");
    //Ответ на вопрос 6
    public static final By ANSWER_ON_SIXTH_QUESTION = By.id("accordion__panel-5");
    //Ответ на вопрос 7
    public static final By ANSWER_ON_SEVENTH_QUESTION = By.id("accordion__panel-6");
    //Ответ на вопрос 8
    public static final By ANSWER_ON_EIGHTH_QUESTION = By.id("accordion__panel-7");


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
    }

    public void clickCreateOrderButtonTop() {
        WebElement activeOrderButtonTop = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(CHECK_ORDER_BUTTON_TOP));
        driver.findElement(APP_COOKIE).click();
        activeOrderButtonTop.click();
    }

    public void clickCreateOrderButtonMid() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(CHECK_ORDER_BUTTON_TOP));
        driver.findElement(APP_COOKIE).click();
        WebElement element = driver.findElement(CHECK_ORDER_BUTTON_MID);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void findImportantQuestion() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(CHECK_ORDER_BUTTON_TOP));
        WebElement element = driver.findElement(CLICK_ON_FIRST_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}
