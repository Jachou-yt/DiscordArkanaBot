package fr.jachou.Bootarkana.commands;

import fr.jachou.Bootarkana.utils.Commands.Command;
import fr.jachou.Bootarkana.utils.Commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandTest implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Test embed")
                .setDescription("Un embed de test")
                .setAuthor("Jachou")
                .addField("Field 1", "Ceci est un field de test", true);
        event.getChannel().sendMessage(embed);
    }

}
