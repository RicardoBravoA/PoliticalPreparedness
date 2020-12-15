package com.udacity.political.preparedness.main.election

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.databinding.FragmentElectionsBinding
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.main.election.adapter.ElectionListAdapter

class ElectionsFragment : Fragment() {

    private val viewModel: ElectionsViewModel by lazy {
        ViewModelProvider(this, ElectionsViewModelFactory(requireActivity().application)).get(
            ElectionsViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //TODO: Add binding values

        //TODO: Link elections to voter info

        //TODO: Initiate recycler adapters

        //TODO: Populate recycler adapters

        val binding = FragmentElectionsBinding.inflate(inflater)
        binding.lifecycleOwner = this


        val electionAdapter = ElectionListAdapter(::electionClick)
        binding.upcomingElectionsRecyclerView.adapter = electionAdapter

        viewModel.electionList.observe(viewLifecycleOwner, {
            electionAdapter.submitList(it)
        })

        viewModel.showData()

        return binding.root

    }

    private fun electionClick(electionModel: ElectionModel) {

    }

    //TODO: Refresh adapters when fragment loads

}