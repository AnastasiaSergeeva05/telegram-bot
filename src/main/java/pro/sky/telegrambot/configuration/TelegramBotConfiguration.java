package pro.sky.telegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramBotConfiguration {


    private final String BotToken;

    public TelegramBotConfiguration(

            @Value("${telegram.bot.token}")
            String botToken) {

        this.BotToken = botToken;
    }

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(BotToken);
        bot.execute(new DeleteMyCommands());
        return bot;
    }

}
