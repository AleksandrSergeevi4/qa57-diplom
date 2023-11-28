package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {
    private SelenideElement cardNumber = $("[placeholder=\"0000 0000 0000 0000\"]");
    private SelenideElement month = $("[placeholder=\"08\"]");
    private SelenideElement year = $("[placeholder=\"22\"]");
    private SelenideElement name = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private SelenideElement code = $("[placeholder=\"999\"]");
    private SelenideElement button = $$("button").find(exactText("Продолжить"));
    private SelenideElement successOperation = $(byText("Операция одобрена Банком."));
    private SelenideElement failedOperation = $(byText("Ошибка! Банк отказал в проведении операции."));
    private SelenideElement errorCardNumber = $(byText("Неверный формат"));
    private SelenideElement errorMonth = $(byText("Неверный формат"));
    private SelenideElement errorValidPeriodCard = $(byText("Неверно указан срок действия карты"));
    private SelenideElement errorYear = $(byText("Неверный формат"));
    private SelenideElement errorValidPeriodYear = $(byText("Истёк срок действия карты"));
    private SelenideElement errorNotExistYear = $(byText("Неверно указан срок действия карты"));
    private SelenideElement errorName = $(byText("Поле обязательно для заполнения"));
    private SelenideElement errorCode = $(byText("Неверный формат"));

    public void payment(String inputCardNumber, String inputMonth, String inputYear, String inputName, String inputCode) {
        cardNumber.setValue(inputCardNumber);
        month.setValue(inputMonth);
        year.setValue(inputYear);
        name.setValue(inputName);
        code.setValue(inputCode);
        button.click();
    }

    public void notificationSuccessOperation() {
        successOperation.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void notificationFailedOperation() {
        failedOperation.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void notificationErrorCardNumber() {
        errorCardNumber.shouldBe(visible);
    }

    public void notificationErrorMonthNumber() {
        errorMonth.shouldBe(visible);
    }

    public void notificationErrorValidPeriodCard() {
        errorValidPeriodCard.shouldBe(visible);
    }

    public void notificationErrorYear() {
        errorYear.shouldBe(visible);
    }

    public void notificationErrorValidPeriodYear() {
        errorValidPeriodYear.shouldBe(visible);
    }

    public void notificationErrorNotExistYear() {
        errorNotExistYear.shouldBe(visible);
    }

    public void notificationErrorName() {
        errorName.shouldBe(visible);
    }

    public void notificationErrorCode() {
        errorCode.shouldBe(visible);
    }
}