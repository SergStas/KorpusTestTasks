package com.sergstas.gymnasticshelper.feature.gymlist.presentation

import com.sergstas.gymnasticshelper.feature.gymlist.data.GymListDao
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope

class GymListPresenter(private val _dao: GymListDao): MvpPresenter<GymListView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateList()
    }

    private fun updateList() {
        presenterScope.launch {
            viewState.showLoading(true)
            val list = _dao.getList()
            viewState.setList(list)
            viewState.showLoading(false)
        }
    }
}
