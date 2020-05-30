package dev.altaris.qrscan.presentation.activities.history

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import client.yalantis.com.githubclient.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_history.*
import dev.altaris.qrscan.R
import dev.altaris.qrscan.domain.History
import dev.altaris.qrscan.presentation.adapters.HistoryAdapter
import dev.altaris.qrscan.utils.ActionEnums
import dev.altaris.qrscan.utils.Constants
import dev.altaris.qrscan.utils.Constants.preUrl

class HistoryActivity : BaseMvpActivity<HistoryActivityContract.View, HistoryActivityContract.Presenter>(),
        HistoryActivityContract.View {

    private var mAdapter: HistoryAdapter? = null
    override var mPresenter: HistoryActivityContract.Presenter = HistoryActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        setUpRecyclerView()
        mPresenter.loadHistory(this)
    }

    override fun showHistory(histories: MutableList<History>) {
        mAdapter?.addHistories(histories)
        mAdapter?.notifyDataSetChanged()
    }

    private fun setUpRecyclerView() {
        mAdapter = HistoryAdapter(ArrayList<History>()) {
            history, action ->
            when(action) {
                ActionEnums().ACTION_SEARCH -> {
                    searchInWWW(preUrl + history.context)
                }
                ActionEnums().ACTION_SHARE -> {
                    shareResultViewSharingIntent(history.context)
                }
                ActionEnums().ACTION_COPY -> {
                    copyToClipboard(history.context)
                }
            }
        }
        rvHistory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvHistory.adapter = mAdapter
    }

}
