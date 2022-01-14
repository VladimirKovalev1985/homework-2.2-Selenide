import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryNegativeTests {
    String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    public void shouldSendEmptyForm() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $(".button__text").click();
        $("[data-test-id='city'].input_invalid.input__sub").shouldHave(text("Поле обязательно для заполнения"));

        }

    @Test
    public void shouldSendFormWithEmptyName(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id='name'] .input__control").setValue("");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='name'] .input_invalid.input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldSendFormWithEmptyCity(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='city'] .input_invalid.input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }



}
