import java.io.IOException;

/**
 * Самый главный класс.
 */
public class Main {

    private static CredentialProperties credentials;

    /**
     * Точка входа в программу.
     */
    public static void main(String[] args) {
        setup();
        System.out.println("Александр торжественно клянется, что замышляет только шалость!");
        var bot = new Instalike(
                credentials.getLogin(),
                credentials.getPassword(),
                " "// здесь должен быть профиль для примера https://www.instagram.com/sevostyanov_alexx часть которая идет после .сom/
        );
        bot.start();
    }

    /**
     * Настройка программы перед работой.
     */
    private static void setup() {
        // Настройка лога.
        System.setProperty(
                "java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT [%4$s]: %5$s%6$s%n"
        );
        // Чтение параметров из файла.
        try {
            credentials = new CredentialProperties();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        // Указываем путь к Chromedriver.
        System.setProperty(
                "webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe"
        );
    }
}