package com.sergstas.gymnasticshelper.feature.gymlist.data

import com.sergstas.gymnasticshelper.domain.entity.GymnasticsData

interface GymListDao {
    fun getList(): List<GymnasticsData>
}
