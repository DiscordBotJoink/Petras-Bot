package Comands

import dev.kord.common.annotation.KordPreview
import dev.kord.common.entity.ButtonStyle
import dev.kord.common.entity.optional.Optional
import dev.kord.core.behavior.interaction.followUp
import dev.kord.core.behavior.interaction.followUpEphemeral
import dev.kord.core.entity.interaction.Interaction
import dev.kord.rest.builder.interaction.actionRow
import dev.kord.rest.builder.interaction.embed

@OptIn(KordPreview::class)
suspend fun Start(interaction: Interaction, Ephemeral: String? = null) {
    interaction.acknowledgePublic().followUp {
        embed {
            title = "Leaderboard: "
            description = "Leaderboard for Counter"
        }
        actionRow {
            interactionButton(ButtonStyle.Primary, "CountUP") {
                label = "Count up"
            }
            interactionButton(ButtonStyle.Primary, "CountDOWN") {
                label = "Count down"
            }
            interactionButton(ButtonStyle.Danger, "CountRESET") {
                label = "RESET"
            }
        }
    }
}