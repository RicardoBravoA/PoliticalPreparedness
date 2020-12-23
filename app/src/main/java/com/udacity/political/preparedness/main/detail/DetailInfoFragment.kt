package com.udacity.political.preparedness.main.detail

import android.os.Bundle
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

        geocode()
        viewModel.init(args.id, args.fromSaved)

        viewModel.buttonText.observe(viewLifecycleOwner, {
            binding.actionButton.text = it
        })

        locationViewModel.address.observe(viewLifecycleOwner, {
            viewModel.showData(args.id, it.address)
        })

        binding.actionButton.setOnClickListener {
            viewModel.actionButton()
        }

        viewModel.showForm.observe(viewLifecycleOwner, {
            binding.constraintForm.visible(it)
            if (it) {
                validateGPS()
            }
        })

        viewModel.showLoading.observe(viewLifecycleOwner, {
            binding.progressBar.visible(it)
            binding.constraintForm.visible(!it)
        })

        viewModel.showErrorForm.observe(viewLifecycleOwner, {
            binding.constraintError.visible(it)
            binding.constraintForm.visible(!it)
            binding.progressBar.visible(!it)
        })

        binding.messageButton.setOnClickListener {
            viewModel.validateInternet()
        }

        viewModel.navigate.observe(viewLifecycleOwner, {
            if (it) {
                findNavController().popBackStack()
            }
        })

        viewModel.data.observe(viewLifecycleOwner, {
            binding.toolbarName.visible(true)
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
            viewModel.hideLoading()
        })

        return binding.root
    }

}