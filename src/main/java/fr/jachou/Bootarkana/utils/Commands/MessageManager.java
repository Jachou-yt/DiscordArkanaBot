package fr.jachou.Bootarkana.utils.Commands;

import fr.jachou.Bootarkana.Main;
import fr.jachou.Bootarkana.commands.*;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Arrays;

public class MessageManager {

    private static CommandRegistry registry = new CommandRegistry();

    static {
        registry.addCommand(new Command(
              "ping",
              "pings the bot",
                new CommandPing(),
                "ping", "p?"
        ));
        registry.addCommand(new Command(
                "test-embed",
                "Une commande pour tester un embed",
                new CommandTest(),
                "test", "teste"

        ));
        registry.addCommand(new Command(
                "help",
                "Pour voir la liste de commande disponible",
                new CommandHelp(),
                "help", "hp"
        ));
        registry.addCommand(new Command(
                "site",
                "Pour voir le site",
                new CommandSite(),
                "site", "internet"
        ));
        registry.addCommand(new Command(
                "say",
                "Pour parler avec le bot",
                new CommandSay(),
                "say", "text"
        ));
        registry.addCommand(new Command(
                "userinfo",
                "Pour savoir des information sur un joueur",
                new CommandUserInfo(),
                "userinfo", "infouser"

        ));
    }

    private static final String PREFIX = Main.getConfigManager().getToml().getString("bot.prefix");

    public static void create(MessageCreateEvent event){

        if (event.getMessageContent().startsWith(PREFIX)){
            String[] args = event.getMessageContent().split(" ");
            String commandName = args[0].substring(PREFIX.length());
            args = args.length == 1 ? new String[0] : Arrays.copyOfRange(args, 1, args.length - 1);

            String[] finalArgs = args;
            registry.getByAlias(commandName).ifPresent((cmd) -> {
                cmd.getExecutor().run(event, cmd, finalArgs);
            });
        }
    }

}
