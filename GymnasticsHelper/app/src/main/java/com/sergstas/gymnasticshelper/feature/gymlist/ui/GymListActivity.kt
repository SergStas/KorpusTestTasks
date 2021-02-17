package com.sergstas.gymnasticshelper.feature.gymlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.sergstas.gymnasticshelper.R
import com.sergstas.gymnasticshelper.domain.entity.GymnasticsData
import com.sergstas.gymnasticshelper.feature.gymlist.adapters.GymListAdapter
import com.sergstas.gymnasticshelper.feature.gymlist.data.GymListDao
import com.sergstas.gymnasticshelper.feature.gymlist.presentation.GymListPresenter
import com.sergstas.gymnasticshelper.feature.gymlist.presentation.GymListView
import kotlinx.android.synthetic.main.activity_gym_list.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class GymListActivity : MvpAppCompatActivity(), GymListView {
    private val _presenter: GymListPresenter by moxyPresenter {
        GymListPresenter(com.sergstas.gymnasticshelper.feature.gymlist.data.GymListDaoImpl())
    }

    private lateinit var _adapter: GymListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_list)

        with(gymList_rv) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = GymListAdapter().also { _adapter = it }
        }
    }

    override fun setList(list: List<GymnasticsData>) {
        _adapter.submitList(list)
    }

    override fun showLoading(b: Boolean) {
        gymList_pb.isVisible = b
    }
}