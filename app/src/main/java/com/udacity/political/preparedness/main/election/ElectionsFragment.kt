package com.udacity.political.preparedness.main.election

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.political.preparedness.databinding.FragmentElectionsBinding
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.main.election.adapter.ElectionListAdapter
import com.udacity.political.preparedness.main.election.adapter.SavedElectionListAdapter

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

        val binding = FragmentElectionsBinding.inflate(inflater)
        binding.lifecycleOwner = this


        val electionAdapter = ElectionListAdapter(::electionClick)
        binding.upcomingElectionsRecyclerView.adapter = electionAdapter

        val savedElectionAdapter = SavedElectionListAdapter(::savedElectionClick)
        binding.savedElectionsRecyclerView.adapter = savedElectionAdapter

        viewModel.electionList.observe(viewLifecycleOwner, {
            electionAdapter.submitList(it)
        })

        viewModel.savedElectionList.observe(viewLifecycleOwner, {
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

    private fun savedElectionClick(electionDetailModel: ElectionDetailModel) {
        findNavController().navigate(
            ElectionsFragmentDirections.actionElectionsFragmentToVoterInfoFragment(
                electionDetailModel.id,
                true
            )
        )
    }

}