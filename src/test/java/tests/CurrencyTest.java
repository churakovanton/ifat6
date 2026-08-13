package tests;

import enums.Currency;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import validators.RateSteps;
import validators.RateValidator;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import io.qameta.allure.Owner;

@Listeners(AllureTestNg.class)
@Epic("Курсы валют")
@Feature("API проверки валюты RUB")
@Owner("Антон Чураков моя@почта.ру")
public class CurrencyTest {
    private final RateSteps steps = new RateSteps();
    private final RateValidator validator = new RateValidator();

    @DataProvider(name = "currencies")
    public Object[][] currencies() {
        return new Object[][]{
                {Currency.RUB}
        };
    }

    @Test(dataProvider = "currencies")
    public void checkRates(Currency currency) {
        String response = steps.getResponse(currency);
        validator.validateSchema(200);
        validator.validateHeaders(response);
        validator.validateKeys(response);
    }
}