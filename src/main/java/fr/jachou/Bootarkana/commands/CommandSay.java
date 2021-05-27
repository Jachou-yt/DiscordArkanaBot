package fr.jachou.Bootarkana.commands;

import fr.jachou.Bootarkana.utils.Commands.Command;
import fr.jachou.Bootarkana.utils.Commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;

public class CommandSay implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        EmbedBuilder EncoursDedev = new EmbedBuilder()
                .setTitle("En cours de creation")
                .setDescription("Ce systeme est actuellement en cours de developpement ! Reessayer la commande ulterierement")
                .setColor(Color.green);
        event.getChannel().sendMessage(EncoursDedev);
    }
}
