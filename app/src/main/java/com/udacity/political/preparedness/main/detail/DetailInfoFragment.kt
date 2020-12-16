package com.udacity.political.preparedness.main.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.udacity.political.preparedness.databinding.FragmentVoterInfoBinding
import com.udacity.political.preparedness.main.election.ElectionsViewModel
import com.udacity.political.preparedness.main.election.ElectionsViewModelFactory

class DetailInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //TODO: Add ViewModel values and create ViewModel

        //TODO: Add binding values

        //TODO: Populate voter info -- hide views without provided data.
        /**
        Hint: You will need to ensure proper data is provided from previous fragment.
         */


        //TODO: Handle loading of URLs

        //TODO: Handle save button UI state
        //TODO: cont'd Handle save button clicks

        val binding = FragmentVoterInfoBinding.inflate(inflater)
        binding.lifecycleOwner = this


        val args by navArgs<DetailInfoFragmentArgs>()

        val viewModel: DetailInfoViewModel by lazy {
            ViewModelProvider(this, DetailInfoViewModelFactory(requireActivity().application)).get(
                DetailInfoViewModel::class.java
            )
        }

        return binding.root

    }

    //TODO: Create method to load URL intents

}