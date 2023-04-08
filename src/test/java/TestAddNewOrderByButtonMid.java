import models.pageobjects.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestAddNewOrderByButtonMid extends TestBase {

    private final String nameCustomer;
    private final String surnameCustomer;
    private final String address;
    private final String phone;

    public TestAddNewOrderByButtonMid(String nameCustomer, String surnameCustomer, String address, String phone) {
        this.nameCustomer = nameCustomer;
        this.surnameCustomer = surnameCustomer;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Иван", "Матроскин", "Москва", "89041445566"},
                {"Макар", "Фартуков", "Москва", "89170054896"}
        };
    }

    @Test
    public void createNewOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCreateOrderButtonMid();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.inputCustomersFieldsInNewOrder(nameCustomer, surnameCustomer, address, phone);
        RentConditionsPage rentConditionsPage = new RentConditionsPage(driver);
        rentConditionsPage.inputRentFieldsInNewOrder();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.clickYesOnConfirmationForm();
        Created created = new Created(driver);
        created.checkOrderCreated();
    }
}
