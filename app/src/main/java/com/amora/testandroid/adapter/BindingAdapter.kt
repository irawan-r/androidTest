package com.amora.testandroid.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amora.testandroid.model.ResponseItem
import com.amora.testandroid.ui.HomeAdapter

@BindingAdapter("listAndroidTest")
fun listAndroidTestBindRecyclerView(recyclerView: RecyclerView, data: List<ResponseItem?>?) {
    val listAndroidAdapter = recyclerView.adapter as HomeAdapter
    listAndroidAdapter.submitList(data)
}