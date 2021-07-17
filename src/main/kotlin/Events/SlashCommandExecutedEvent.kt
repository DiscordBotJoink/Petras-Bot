package Events

import Comands.Start
import dev.kord.core.entity.interaction.Interaction

suspend fun onSlashCommand(interaction: Interaction) {
    if(interaction.data.toString().contains("content=start")) Start(interaction, "thank you for starting the game")
}