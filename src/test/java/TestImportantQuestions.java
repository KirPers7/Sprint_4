import models.pageobjects.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static models.pageobjects.MainPage.*;

@RunWith(Parameterized.class)
public class TestImportantQuestions extends TestBase {

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

    @Test
    public void checkFindImportantQuestions() {
        MainPage mainPage = new MainPage(driver);
        mainPage.findImportantQuestion();
        driver.findElement(click_question).click();
        String actual = driver.findElement(actual_answer).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому", expected_answer, actual);
    }
}
