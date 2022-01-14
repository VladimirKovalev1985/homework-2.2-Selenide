import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class cardDeliveryTestsTest {
    String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    public void shouldSendNormForm() {

        //открыть страницу
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Москва"); //заполнить поле город
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);//очистить поле ввода
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        //сообщение об успешном бронировании после 15-ти секундного ожидания
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormWithCity(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendForm4Days(){
        open("http://localhost:9999/");
        String planningDate = generateDate(4);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendForm10Days(){
        open("http://localhost:9999/");
        String planningDate = generateDate(10);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormWithShortName(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Ян Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormWithShortSurname(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Ян");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormWithShortNameAndSurname(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Ян Ян");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormWithDoubleName(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир-Олег Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormWithDoubleSurname(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев-Петров");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormWithDoubleNameAndSurname(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир-Олег Сергеев-Петров");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormTel8(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("89998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormTel9(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("99998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormTelPlus0(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+09998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
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
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormWithNameAndSurnameOneLetter(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("В С");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

    @Test
    public void shouldSendFormWithEmptyDate(){
        open("http://localhost:9999/");
        String planningDate = generateDate(3);
        $("[data-test-id=\"city\"] .input__control").setValue("Санкт-Петербург");
       // $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        // $("[data-test-id=\"date\"] .input__control").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Владимир Сергеев");
        $("[data-test-id=\"phone\"] input").setValue("+79998884455");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно забронирована на " +planningDate));
    }

}