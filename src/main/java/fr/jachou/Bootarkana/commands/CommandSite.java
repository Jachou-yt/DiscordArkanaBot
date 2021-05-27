package fr.jachou.Bootarkana.commands;

import fr.jachou.Bootarkana.utils.Commands.Command;
import fr.jachou.Bootarkana.utils.Commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;

public class CommandSite implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        EmbedBuilder builder = new EmbedBuilder()
                .setTitle("Site Arkana ")
                .setColor(Color.GREEN)
                .setDescription("**https://jachou.alwaysdata.net/**");
        event.getChannel().sendMessage(builder);

    }
}
