package com.sergstas.gymnasticshelper.feature.gymlist.presentation

import com.sergstas.gymnasticshelper.domain.entity.GymnasticsData
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface GymListView: MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setList(list: List<GymnasticsData>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLoading(b: Boolean)
}
