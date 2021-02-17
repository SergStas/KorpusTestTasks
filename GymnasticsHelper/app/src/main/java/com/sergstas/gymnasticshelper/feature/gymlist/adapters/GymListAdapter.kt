package com.sergstas.gymnasticshelper.feature.gymlist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sergstas.gymnasticshelper.R
import com.sergstas.gymnasticshelper.domain.entity.GymnasticsData
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_gym_item.*

class GymListAdapter : ListAdapter<GymnasticsData, GymListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<GymnasticsData>() {
        override fun areItemsTheSame(oldItem: GymnasticsData, newItem: GymnasticsData): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: GymnasticsData, newItem: GymnasticsData): Boolean =
            oldItem == newItem
    }) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_gym_item, parent, false)
            )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val data = getItem(position)
            holder.gymItem_tvName.text = data.name
        }

        class ViewHolder(override val containerView: View):
            RecyclerView.ViewHolder(containerView), LayoutContainer
}
