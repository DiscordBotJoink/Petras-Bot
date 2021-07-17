package Events

import dev.kord.common.annotation.KordPreview
import dev.kord.common.entity.ButtonStyle
import dev.kord.core.behavior.reply
import dev.kord.core.entity.Message

@OptIn(KordPreview::class)
suspend fun onMessage(message: Message) {
    val prefix = "-"
    when (message.content) {
        "test" -> message.reply {
            content = "test du "
        }

    }
}