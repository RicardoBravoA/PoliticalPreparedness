package com.udacity.political.preparedness.main.election

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.databinding.FragmentElectionsBinding

class ElectionsFragment : Fragment() {

    //TODO: Declare ViewModel

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

        //TODO: Add ViewModel values and create ViewModel

        //TODO: Add binding values

        //TODO: Link elections to voter info

        //TODO: Initiate recycler adapters

        //TODO: Populate recycler adapters

        val binding = FragmentElectionsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        viewModel.showData()

        return binding.root

    }

    //TODO: Refresh adapters when fragment loads

}