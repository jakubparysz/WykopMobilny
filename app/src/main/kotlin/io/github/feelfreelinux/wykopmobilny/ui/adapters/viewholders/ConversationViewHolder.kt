package io.github.feelfreelinux.wykopmobilny.ui.adapters.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.feelfreelinux.wykopmobilny.models.dataclass.Conversation
import io.github.feelfreelinux.wykopmobilny.ui.modules.pm.conversation.getConversationIntent
import kotlinx.android.synthetic.main.conversation_list_item.view.*

class ConversationViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bindView(conversation : Conversation) {
        view.authorHeaderView.setAuthorData(conversation.user, conversation.lastUpdate)
        view.setOnClickListener {
            view.context?.apply {
                startActivity(getConversationIntent(conversation.user.nick))
            }
        }
    }
}