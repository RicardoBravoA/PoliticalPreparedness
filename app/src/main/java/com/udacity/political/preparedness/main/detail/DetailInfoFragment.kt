package com.udacity.political.preparedness.main.detail

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.udacity.political.preparedness.common.LocationFragment
import com.udacity.political.preparedness.databinding.FragmentVoterInfoBinding

class DetailInfoFragment : LocationFragment() {

    private lateinit var binding: FragmentVoterInfoBinding
    private val viewModel: DetailInfoViewModel by lazy {
        ViewModelProvider(this, DetailInfoViewModelFactory(requireActivity().application)).get(
            DetailInfoViewModel::class.java
        )
    }

    override fun layoutParent() = binding.constraintParent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentVoterInfoBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val args by navArgs<DetailInfoFragmentArgs>()

//        viewModel.showData(args.id)


        locationViewModel.address.observe(viewLifecycleOwner, {
            Log.i("z- address", it.toString())
        })

        binding.followButton.setOnClickListener {
            Log.i("z- myLocation", "abc: ${location?.latitude} - ${location?.longitude}")
        }


        return binding.root
    }

    /*override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //TODO: Add ViewModel values and create ViewModel

        //TODO: Add binding values

        //TODO: Populate voter info -- hide views without provided data.
        */
    /**
    Hint: You will need to ensure proper data is provided from previous fragment.
     *//*


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

        viewModel.showData(args.id)

        return binding.root

    }*/

    //TODO: Create method to load URL intents

}