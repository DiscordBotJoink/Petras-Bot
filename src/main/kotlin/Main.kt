import Classes.getHashmap
import Events.onSlashCommand
import Events.onButtonPressEvent
import Events.onMessage

import dev.kord.common.annotation.KordPreview
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.interaction.ComponentInteraction
import dev.kord.core.event.interaction.InteractionCreateEvent
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import kotlinx.coroutines.flow.onEach

@OptIn(KordPreview::class)
suspend fun main() {
    val hashmap = getHashmap()
    val kord = Kord("ODI2MTAxNDUzMjMxNzUxMTk4.YGHk7g.mtGVuDmInHXTe6vIW9qBIPQ7qyM")


    kord.guilds.onEach {
        println("new guild :) 1")
        kord.slashCommands.createGuildApplicationCommand(it.id, "start", "start counter irgendwas")
    }

    kord.guilds.onEach {
        println("new guild :) 2")
        println(it.name)
    }

    println("no new guild :(")
    val command = kord.slashCommands.createGuildApplicationCommand(Snowflake(840622529193312266), "start", "start counter irgendwas")
    //val command = kord.slashCommands.createGuildApplicationCommand(Snowflake(814865736786903070), "start", "start counter irgendwas")

    kord.on<MessageCreateEvent> {
        onMessage(message)
    }

    kord.on<InteractionCreateEvent> {
        if (interaction is ComponentInteraction) onButtonPressEvent(interaction, hashmap)
        else onSlashCommand(interaction)

    }

    kord.getUser(Snowflake(2))
    kord.login()
}

