package fr.jachou.Bootarkana.commands;

import fr.jachou.Bootarkana.utils.Commands.Command;
import fr.jachou.Bootarkana.utils.Commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;

public class CommandHelp implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        EmbedBuilder builder = new EmbedBuilder()
                .setTitle("Menu help :")
                .setColor(Color.green)
                .addField("**.site**", "`Affiche le site du serveur`")
                .addField("**.ping**", "`Affiche le ping du bot`")
                .addField("**.say**", "`Permet de parler avec le bot`")
                .addField("**.userinfo <user>**", "`Pour avoir des informations sur un personne`");
        event.getChannel().sendMessage(builder);
    }
}
