package Events

import Classes.sendEphemeral
import Classes.sortHashMap
import dev.kord.common.annotation.KordPreview
import dev.kord.core.behavior.edit
import dev.kord.core.entity.interaction.ComponentInteraction
import dev.kord.core.entity.interaction.Interaction
import java.util.*
import kotlin.collections.HashMap


@OptIn(KordPreview::class)
suspend fun onButtonPressEvent(interaction: Interaction, hashmap: HashMap<String?, Int>) {

    val customID = (interaction as ComponentInteraction).componentId.lowercase(Locale.getDefault())
    var username = interaction.user.asUserOrNull()?.username
    //username = interaction.message?.getGuild()?.let { interaction.user.asMember(it.id).nickname }

    if (customID == "countreset") {
        println("reset by $username")
        hashmap.put(username, 0)
        sendEphemeral(interaction, "You now have ${hashmap.get(username)} Points")
    }

    if (customID == "countup") {
        if (hashmap.containsKey(username)) {
            hashmap.put(username, hashmap.get(username)?.plus(1) ?: 1)
        }
        else {
            hashmap.put(username, 1)
            println("put user '$username' to 1")
        }
        sendEphemeral(interaction, "You now have ${hashmap.get(username)} Points")
    }

    if (customID == "countdown") {
        if (hashmap.containsKey(username)) {
            hashmap.put(username, hashmap.get(username)?.minus(1) ?: 1)
        }
        else {
            hashmap.put(username, -1)
        }
        sendEphemeral(interaction, "You now have ${hashmap.get(username)} Points")
    }

    if ("count" in customID) {
        interaction.message?.edit {
            embed {
                title = "Leaderboard: "
                description = "Leaderboard for Counter"

                var count = 0

                val map = sortHashMap(hashmap)

                map.forEach { (key, value) ->
                    count++
                    field("${count}. $key", false) { value.toString() }
                }

                println("hashmap: $hashmap \n map: $map")
            }
        }
    }
}
