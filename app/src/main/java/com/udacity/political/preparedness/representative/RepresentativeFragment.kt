package com.udacity.political.preparedness.representative

import android.location.Geocoder
import android.os.Bundle
import android.view.*
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.udacity.political.preparedness.R
import com.udacity.political.preparedness.common.LocationFragment
import com.udacity.political.preparedness.databinding.FragmentRepresentativeBinding
import com.udacity.political.preparedness.domain.model.representative.RepresentativeModel
import com.udacity.political.preparedness.representative.adapter.RepresentativeAdapter
import com.udacity.political.preparedness.util.openWebView
import com.udacity.political.preparedness.util.selectValue
import com.udacity.political.preparedness.util.setEntries
import com.udacity.political.preparedness.util.visible
import java.util.*

class RepresentativeFragment : LocationFragment() {

    private lateinit var binding: FragmentRepresentativeBinding
    private var snackbar: Snackbar? = null

    private val viewModel: RepresentativeViewModel by lazy {
        ViewModelProvider(this, RepresentativeViewModelFactory(requireActivity().application)).get(
            RepresentativeViewModel::class.java
        )
    }

    override fun layoutParent() = binding.constraintParent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRepresentativeBinding.inflate(inflater)
        binding.lifecycleOwner = this

        viewModel.validateInternet()

        viewModel.loadSpinner()

        viewModel.stateList.observe(viewLifecycleOwner, {
            binding.stateSpinner.setEntries(it)
        })

        viewModel.showForm.observe(viewLifecycleOwner, {
            binding.constraintForm.visible(it)
        })

        viewModel.showErrorForm.observe(viewLifecycleOwner, {
            binding.constraintError.visible(it)
        })

        binding.locationButton.setOnClickListener {
            validateGPS()
        }

        binding.messageButton.setOnClickListener {
            viewModel.validateInternet()
        }

        binding.findButton.setOnClickListener {
            viewModel.find(
                binding.addressLine1EditText.text.toString(),
                binding.addressLine2EditText.text.toString(),
                binding.cityEditText.text.toString(),
                binding.stateSpinner.selectedItem.toString(),
                binding.zipEditText.text.toString()
            )
        }

        locationViewModel.location.observe(viewLifecycleOwner, {
            viewModel.showAddress(Geocoder(context, Locale.getDefault()), it)
        })

        viewModel.addressModel.observe(viewLifecycleOwner, {
            binding.addressLine1EditText.setText(it.line1)
            binding.addressLine2EditText.setText(it.line2)
            binding.cityEditText.setText(it.city)
            binding.zipEditText.setText(it.zip)
            binding.stateSpinner.selectValue(it.state)
        })

        val representativeAdapter = RepresentativeAdapter(::iconClick)
        binding.representativeRecyclerView.adapter = representativeAdapter

        viewModel.data.observe(viewLifecycleOwner, {
            representativeAdapter.submitList(it)
        })

        viewModel.error.observe(viewLifecycleOwner, {
            it?.let {
                showSnackbar(it)
            }
        })

        return binding.root

    }

    private fun showSnackbar(value: String) {
        if (snackbar == null) {
            snackbar = Snackbar.make(
                layoutParent(),
                value,
                Snackbar.LENGTH_INDEFINITE
            ).setAction(
                getString(R.string.ok)
            ) {
                dismissSnackbar()
                binding.findButton.performClick()
            }
        }
        snackbar?.show()
    }

    private fun dismissSnackbar() {
        snackbar?.dismiss()
    }

    private fun iconClick(url: String) {
        requireContext().openWebView(url)
    }

    override fun onDestroyView() {
        dismissSnackbar()
        super.onDestroyView()
    }

}
