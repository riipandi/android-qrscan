package dev.altaris.qrscan.presentation.activities.history

import android.content.Context
import client.yalantis.com.githubclient.mvp.BaseMvpPresenter
import client.yalantis.com.githubclient.mvp.BaseMvpView
import dev.altaris.qrscan.domain.History

object HistoryActivityContract {

    interface View: BaseMvpView {
        fun showHistory(histories: MutableList<History>)
    }

    interface Presenter: BaseMvpPresenter<View> {
        fun loadHistory(context: Context)
    }
}
