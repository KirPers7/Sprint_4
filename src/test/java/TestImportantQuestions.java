import io.github.bonigarcia.wdm.WebDriverManager;
import models.pageobjects.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TestImportantQuestions {

    private WebDriver driver;

    //Вопросы о важном: 1. "Сколько это стоит? И как оплатить?"
    private static final By CLICK_ON_FIRST_QUESTION = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    //Вопросы о важном: 2. "Хочу сразу несколько самокатов! Так можно?"
    private static final By CLICK_ON_SECOND_QUESTION = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    //Вопросы о важном: 3. "Как рассчитывается время аренды?"
    private static final By CLICK_ON_THIRD_QUESTION = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    //Вопросы о важном: 4. "Можно ли заказать самокат прямо на сегодня?"
    private static final By CLICK_ON_FOURTH_QUESTION = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    //Вопросы о важном: 5. "Можно ли продлить заказ или вернуть самокат раньше?"
    private static final By CLICK_ON_FIFTH_QUESTION = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    //Вопросы о важном: 6. "Вы привозите зарядку вместе с самокатом?"
    private static final By CLICK_ON_SIXTH_QUESTION = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    //Вопросы о важном: 7. "Можно ли отменить заказ?"
    private static final By CLICK_ON_SEVENTH_QUESTION = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    //Вопросы о важном: 8. "Я жизу за МКАДом, привезёте?"
    private static final By CLICK_ON_EIGHTH_QUESTION = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");
    //Ответ на вопрос 1
    private static final By ANSWER_ON_FIRST_QUESTION = By.id("accordion__panel-0");
    //Ответ на вопрос 2
    private static final By ANSWER_ON_SECOND_QUESTION = By.id("accordion__panel-1");
    //Ответ на вопрос 3
    private static final By ANSWER_ON_THIRD_QUESTION = By.id("accordion__panel-2");
    //Ответ на вопрос 4
    private static final By ANSWER_ON_FOURTH_QUESTION = By.id("accordion__panel-3");
    //Ответ на вопрос 5
    private static final By ANSWER_ON_FIFTH_QUESTION = By.id("accordion__panel-4");
    //Ответ на вопрос 6
    private static final By ANSWER_ON_SIXTH_QUESTION = By.id("accordion__panel-5");
    //Ответ на вопрос 7
    private static final By ANSWER_ON_SEVENTH_QUESTION = By.id("accordion__panel-6");
    //Ответ на вопрос 8
    private static final By ANSWER_ON_EIGHTH_QUESTION = By.id("accordion__panel-7");


    private final By click_question;
    private final String expected_answer;
    private final By actual_answer;

    public TestImportantQuestions(By click_question, String expected_answer, By actual_answer) {
        this.click_question = click_question;
        this.expected_answer = expected_answer;
        this.actual_answer = actual_answer;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {CLICK_ON_FIRST_QUESTION,
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        ANSWER_ON_FIRST_QUESTION},
                {CLICK_ON_SECOND_QUESTION,
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        ANSWER_ON_SECOND_QUESTION},
                {CLICK_ON_THIRD_QUESTION,
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        ANSWER_ON_THIRD_QUESTION},
                {CLICK_ON_FOURTH_QUESTION,
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        ANSWER_ON_FOURTH_QUESTION},
                {CLICK_ON_FIFTH_QUESTION,
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        ANSWER_ON_FIFTH_QUESTION},
                {CLICK_ON_SIXTH_QUESTION,
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        ANSWER_ON_SIXTH_QUESTION},
                {CLICK_ON_SEVENTH_QUESTION,
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        ANSWER_ON_SEVENTH_QUESTION},
                {CLICK_ON_EIGHTH_QUESTION,
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                        ANSWER_ON_EIGHTH_QUESTION}
        };
    }

    @Before
    public void setUp () {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void checkFindImportantQuestions() {
        MainPage mainPage = new MainPage(driver);
        mainPage.findImportantQuestion();
        driver.findElement(click_question).click();
        String actual = driver.findElement(actual_answer).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому", expected_answer, actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
