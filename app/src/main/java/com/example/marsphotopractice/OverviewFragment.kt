package com.example.marsphotopractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marsphotopractice.adapter.MarsImageAdapter
import kotlinx.android.synthetic.main.fragment_overview.*


class OverviewFragment : Fragment(R.layout.fragment_overview) {

    lateinit var fragmentViewModel : MarsViewModel
    lateinit var imageAdapter: MarsImageAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentViewModel = (activity as MainActivity).viewModel
        setUpRecyclerView()

        fragmentViewModel.photos.observe(viewLifecycleOwner, Observer{ list ->
            imageAdapter.differ.submitList(list)
        }
        )

    }

    private fun setUpRecyclerView() {
        imageAdapter = MarsImageAdapter()
        photos_grid.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


}