package pages_helper;

import io.qameta.allure.Step;

public class Logger {

    @Step("Console Log Message: [{message}]")
    public static void logMessage(String message) {
        System.out.println(message);
    }

}
