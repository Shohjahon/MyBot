import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

/**
 * Created by Shoh Jahon on 02.05.2018.
 */
public class Main {

    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi api = new TelegramBotsApi();

        try {
            api.registerBot(new MyReferenceBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
