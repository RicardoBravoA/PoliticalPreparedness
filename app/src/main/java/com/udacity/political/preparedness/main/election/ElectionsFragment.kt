package com.udacity.political.preparedness.main.election

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

        val savedElectionAdapter = ElectionListAdapter(::savedElectionClick)
        binding.savedElectionsRecyclerView.adapter = savedElectionAdapter

        viewModel.electionList.observe(viewLifecycleOwner, {
            electionAdapter.submitList(it)
        })

        viewModel.savedElectionList.observe(viewLifecycleOwner, {
            Log.i("z- savedElectionList", it.toString())
            savedElectionAdapter.submitList(it)
        })

        viewModel.showData()
        viewModel.showSavedElections()

        return binding.root

    }

    private fun electionClick(electionModel: ElectionModel) {
        findNavController().navigate(
            ElectionsFragmentDirections.actionElectionsFragmentToVoterInfoFragment(
                electionModel.id,
                false
            )
        )
    }

    private fun savedElectionClick(electionModel: ElectionModel) {
        findNavController().navigate(
            ElectionsFragmentDirections.actionElectionsFragmentToVoterInfoFragment(
                electionModel.id,
                true
            )
        )
    }

    //TODO: Refresh adapters when fragment loads

}