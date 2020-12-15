package com.udacity.political.preparedness.election

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.udacity.political.preparedness.databinding.FragmentElectionsBinding
import com.udacity.political.preparedness.databinding.FragmentVoterInfoBinding

class VoterInfoFragment : Fragment() {

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

        return binding.root

    }

    //TODO: Create method to load URL intents

}