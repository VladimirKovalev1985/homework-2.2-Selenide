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
        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));

    }

    @Test
    public void shouldSendFormWithEmptyName() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id='name'] .input__control").setValue("");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldSendFormWithEmptyCity() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldSendFormWithEmptyPhone() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldSendFormWithoutAgreement() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+89998884455");
        $(".button__text").click();
        $("[data-test-id='agreement'].input_invalid .checkbox__text")
                .shouldHave(text("Я соглашаюсь с условиями обработки и использования моих персональных данных"));
    }

    @Test
    public void shouldSendFormWithOtherCity() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Сочи");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(text("Доставка в выбранный город недоступна"));
    }

    @Test
    public void shouldSendFormInEnglishNameCity() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Moscow");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(text("Доставка в выбранный город недоступна"));
    }

    @Test
    public void shouldSendFormYesterday() {
        open("http://localhost:9999/");
        String planningDate = generateDate(-1);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+89998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='date'].input_invalid .input__sub").shouldHave(text("Заказ на выбранную дату невозможен"));
    }

    @Test
    public void shouldSendFormToday() {
        open("http://localhost:9999/");
        String planningDate = generateDate(1);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+89998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='date'].input_invalid .input__sub").shouldHave(text("Заказ на выбранную дату невозможен"));
    }

    @Test
    public void shouldSendFormTomorrow() {
        open("http://localhost:9999/");
        String planningDate = generateDate(2);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+89998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='date'].input_invalid .input__sub").shouldHave(text("Заказ на выбранную дату невозможен"));
    }

    @Test
    public void shouldSendFormInEnglishName() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id='name'] .input__control").setValue("Vladimir Ivanov");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='name'].input_invalid .input__sub")
                .shouldHave(text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы"));
    }

    @Test
    public void shouldSendFormTelWithoutPlus() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id='name'] .input__control").setValue("Vladimir Ivanov");
        $("[data-test-id=\"phone\"] input").setValue("79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='phone'].input_invalid .input__sub")
                .shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldSendFormCityNameHaveNumber() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("123");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(text("Доставка в выбранный город недоступна"));
    }

    @Test
    public void shouldSendFormTelNumberWith10() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id='name'] .input__control").setValue("Vladimir Ivanov");
        $("[data-test-id=\"phone\"] input").setValue("7999888445");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='phone'].input_invalid .input__sub")
                .shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldSendFormTelNumberWith9() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id='name'] .input__control").setValue("Vladimir Ivanov");
        $("[data-test-id=\"phone\"] input").setValue("799988845");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='phone'].input_invalid .input__sub")
                .shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldSendFormTelNumberWithLetter() {
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id='name'] .input__control").setValue("Vladimir Ivanov");
        $("[data-test-id=\"phone\"] input").setValue("+799988844а");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='phone'].input_invalid .input__sub")
                .shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldSendFormTelWithMinus(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+7-999-888-44-55");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='phone'].input_invalid .input__sub")
                .shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
}








