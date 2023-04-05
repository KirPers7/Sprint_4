package models.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage {
    //Поле ввода "Имя"
    private static final By NAME = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода "Фамилия"
    private static final By SURNAME = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода "Адрес: куда привезти заказ"
    private static final By ADDRESS_GOAL = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле выбора из списка "Станция метро"
    private static final By SUBWAY_STATION = By.xpath(".//input[@placeholder='* Станция метро']");
    //Выбор станции метро - "Черкизовская"
    private static final By CHOOSE_SUBWAY_STATION = By.xpath(".//div[text()='Черкизовская']");
    //Поле ввода "Телефон: на него позвонит курьер"
    private static final By PHONE_NUMBER = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее" с переходом на следующую страницу оформления заказа
    private static final By BUTTON_NEXT = By.xpath(".//button[text()='Далее']");

    private final WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputCustomersFieldsInNewOrder(String name, String surname, String addressGoal, String phoneNumber) {
        WebElement inputName = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(NAME));
        inputName.sendKeys(name);
        driver.findElement(SURNAME).sendKeys(surname);
        driver.findElement(ADDRESS_GOAL).sendKeys(addressGoal);
        driver.findElement(SUBWAY_STATION).click();
        driver.findElement(CHOOSE_SUBWAY_STATION).click();
        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumber);
        driver.findElement(BUTTON_NEXT).click();
    }

}
