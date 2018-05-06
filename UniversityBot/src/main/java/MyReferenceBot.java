import Models.University;
import Parser.UniversityJsonParser;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

/**
 * Created by Shoh Jahon on 02.05.2018.
 */
public class MyReferenceBot extends TelegramLongPollingBot {
    private UniversityJsonParser universityJsonParser;
    private String[] regions = {"Toshkent","Farg'ona","Andijon","Namangan","Jizzax","Sirdaryo",
    "Samarqand","Navoi","Qashqadaryo","Surhondaryo","Buxoro","Xorazm","Qoraqalpog'iston"};

    public void onUpdateReceived(Update update) {

        UniversityJsonParser universityJsonParser = new UniversityJsonParser();
        if (update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if (messageText.equals("/help")){
                SendMessage sendMessage = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Dastlab, sizdan quyidagi /help yoki /ask komandalaridan " +
                                " birini tanlash talab qilinadi. Agar /help komandasini tanlasangiz " +
                                " siz ushbu qo'llanma havola etiladi, aks holda /ask komandasini tanlasangiz " +
                                " sizdan tahsil olmoqchi bo'lgan universitet joylashgan viloyatni kiritish " +
                                " so'raladi, So'ngra universitet nomini kiritish talab qilinadi va nihoyat sizga " +
                                " ushbu universitet haqida ma'lumot havola etiladi!");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (messageText.equals("/ask")){
                SendMessage sendMessage = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Iltimos,Tahsil olmoqchi bo'lgan universitet joylashgan viloyat\n" +
                                "nomini kiriting? Masalan: Farg'ona");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (containsInRegions(messageText)){
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Universitet nomini kiriting! (Masalan:TATU)");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (universityJsonParser.universityExists(messageText)){
                University university = universityJsonParser.findUniversity(messageText);
                SendMessage sendMessage = new SendMessage()
                        .setChatId(chat_id)
                        .setText(
                        "Universitet nomi: "+university.getG4()+"\n"+
                        "Universitet manzili: "+university.getG7()+"\n"+
                        "Web sayti: "+university.getG11()+"\n"+
                        "Universitet rahbari: "+university.getG12());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public boolean containsInRegions(String region){
        for (String reg:regions) {
            if (reg.equals(region)){
                return true;
            }
        }
        return false;
    }

    public String getBotUsername() {
        return "MyReferenceBot";
    }

    public String getBotToken() {
        return "548234210:AAFePLaGKHRJmJZMfQESaQI84JyPR4cgiyU";
    }
}
