package com.udacity.political.preparedness.main.detail

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.political.preparedness.R
import com.udacity.political.preparedness.common.LocationFragment
import com.udacity.political.preparedness.databinding.FragmentDetailInfoBinding
import com.udacity.political.preparedness.util.hyperlink
import com.udacity.political.preparedness.util.visible

class DetailInfoFragment : LocationFragment() {

    private lateinit var binding: FragmentDetailInfoBinding
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

        binding = FragmentDetailInfoBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val args by navArgs<DetailInfoFragmentArgs>()

        viewModel.fromSaved(args.fromSaved)

        if (!args.fromSaved) {
            binding.actionButton.text = getString(R.string.follow_election)
            viewModel.validateInternet()
        } else {
            binding.actionButton.text = getString(R.string.delete_election)
            viewModel.showOfflineData(args.id)
        }

        locationViewModel.address.observe(viewLifecycleOwner, {
            Log.i("z- address", it.toString())
            viewModel.showData(args.id, it.address)
        })

        binding.actionButton.setOnClickListener {
            if (!args.fromSaved) {
                viewModel.saveElection()
                findNavController().popBackStack()
            } else {
                viewModel.deleteElection()
                findNavController().popBackStack()
            }

        }

        viewModel.showForm.observe(viewLifecycleOwner, {
            binding.constraintForm.visible(it)
            if (it) {
                validateGPS()
            }
        })

        viewModel.showErrorForm.observe(viewLifecycleOwner, {
            binding.constraintError.visible(it)
        })

        binding.messageButton.setOnClickListener {
            viewModel.validateInternet()
        }

        viewModel.data.observe(viewLifecycleOwner, {
            binding.toolbarName.title = it.name
            binding.electionDateTextView.text = it.electionDay.toString()
            binding.stateHeaderTextView.visible(true)
            binding.addressHeaderTextView.visible(true)
            binding.actionButton.visible(true)

            it.votingLocationFinderUrl?.let { url ->
                binding.votingLocationTextView.hyperlink(
                    getString(R.string.voting_locations),
                    url
                )
                binding.votingLocationTextView.visible(true)
            }

            it.ballotInfoUrl?.let { url ->
                binding.ballotTextView.hyperlink(
                    getString(R.string.ballot_information),
                    url
                )
                binding.ballotTextView.visible(true)
            }

            it.address?.let { address ->
                binding.addressLineTextView.text = address
                binding.addressLineTextView.visible(true)
            }
        })

        return binding.root
    }

}