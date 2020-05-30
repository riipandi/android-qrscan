package dev.altaris.qrscan.presentation.activities.main

import client.yalantis.com.githubclient.mvp.BaseMvpPresenter
import client.yalantis.com.githubclient.mvp.BaseMvpView
import dev.altaris.qrscan.domain.History

object MainActivityContract {

    interface View: BaseMvpView {
        fun showSuccessScanningDialog(result: String)
        fun continueScanning()
    }

    interface Presenter: BaseMvpPresenter<View> {
        fun qrCodeScanned(history: History)
        fun searchByResultBtnPressed(result:String)
        fun copyResultBtnPressed(result: String)
        fun shareResultBtnPressed(result: String)
    }
}
