package Classes

import dev.kord.common.Color
import dev.kord.common.annotation.KordPreview
import dev.kord.core.behavior.interaction.followUpEphemeral
import dev.kord.core.entity.interaction.Interaction
import dev.kord.rest.builder.interaction.embed

@OptIn(KordPreview::class)
suspend fun sendEphemeral(interaction: Interaction, text: String, useEmbed: Boolean = false, embedTitle: String? = null, embedText: String? = null) {
    interaction.acknowledgeEphemeral().followUpEphemeral {
        content = text
        if (useEmbed && embedTitle != null && embedText != null) {
            embed {
                title = embedTitle
                description = embedText
                color = Color(rand(1, 255), rand(1, 255), rand(1, 255))
            }
        }
    }
}

fun getHashmap():HashMap<String?, Int> {
    return hashMapOf<String?, Int>()
}

fun rand(start: Int, end: Int): Int {
    require(start <= end) {
        "Illegal Argument"
    }
    return (start..end).random()
}

fun sortHashMap(hashmap: HashMap<String?, Int>): Map<String?, Int> {
    return hashmap.entries.sortedBy { it.value.minus(it.value * 2) }.associate { it.toPair() }       // {val1=10, val2=9, val3=8, ...}
    //return hashmap.entries.sortedBy { it.value }.associate { it.toPair() }                              // {val13=1, val2=2, val3=3, ...}
}

