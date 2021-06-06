package fr.jachou.Bootarkana;

import fr.jachou.Bootarkana.utils.Commands.MessageManager;
import fr.jachou.Bootarkana.utils.ConfigManager;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.File;

public class Main {

    private static DiscordApi api;
    private static ConfigManager configManager;

    public static void main(String[] args) {

        configManager = new ConfigManager(new File(System.getProperty("user.dir"), "config.toml"));

    api = new DiscordApiBuilder()
            .setToken(configManager.getToml().getString("bot.token"))
            .login().join();
    api.addMessageCreateListener(MessageManager::create);
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }
}
