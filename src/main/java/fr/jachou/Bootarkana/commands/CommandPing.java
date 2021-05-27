package fr.jachou.Bootarkana.commands;

import fr.jachou.Bootarkana.utils.Commands.Command;
import fr.jachou.Bootarkana.utils.Commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;

public class CommandPing implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {

        EmbedBuilder builder = new EmbedBuilder()
                .setTitle("Pinging....")
                .setColor(Color.ORANGE);

        event.getChannel().sendMessage(builder).thenAccept((message) -> {
            long unixBot = message.getCreationTimestamp().toEpochMilli();
            long unixUser = event.getMessage().getCreationTimestamp().toEpochMilli();
            long ping = unixBot - unixUser;

            builder.setColor(Color.GREEN)
                    .setDescription("Ping : " + ping + "ms")
                    .setTitle("Pong !");
            message.edit(builder);
        });

    }
}
