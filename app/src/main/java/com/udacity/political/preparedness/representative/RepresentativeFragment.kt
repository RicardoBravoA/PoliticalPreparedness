package com.udacity.political.preparedness.representative

import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.common.LocationFragment
import com.udacity.political.preparedness.databinding.FragmentRepresentativeBinding
import com.udacity.political.preparedness.util.setEntries
import com.udacity.political.preparedness.util.visible
import java.util.*

class RepresentativeFragment : LocationFragment() {

    private lateinit var binding: FragmentRepresentativeBinding

    private val viewModel: RepresentativeViewModel by lazy {
        ViewModelProvider(this, RepresentativeViewModelFactory(requireActivity().application)).get(
            RepresentativeViewModel::class.java
        )
    }

    override fun layoutParent() = binding.constraintParent

    companion object {
        //TODO: Add Constant for Location request
    }

    //TODO: Declare ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //TODO: Establish bindings

        //TODO: Define and assign Representative adapter

        //TODO: Populate Representative adapter

        //TODO: Establish button listeners for field and location search

        binding = FragmentRepresentativeBinding.inflate(inflater)
        binding.lifecycleOwner = this

        viewModel.validateInternet()

        viewModel.loadSpinner()

        viewModel.stateList.observe(viewLifecycleOwner, {
            Log.i("z- stateList", it.toString())
            binding.stateSpinner.setEntries(it)
        })

        viewModel.showForm.observe(viewLifecycleOwner, {
            binding.constraintForm.visible(it)
            if (it) {
                validateGPS()
            }
        })

        viewModel.showErrorForm.observe(viewLifecycleOwner, {
            binding.constraintError.visible(it)
        })

        binding.locationButton.setOnClickListener {
            validateGPS()
        }

        locationViewModel.location.observe(viewLifecycleOwner, {
            Log.i("z- location", it.toString())
//            val address = geoCodeLocation(it)
            viewModel.showAddress(Geocoder(context, Locale.getDefault()), it)
        })

        viewModel.addressModel.observe(viewLifecycleOwner, {
            Log.i("z- address", it.toString())
            binding.addressLine1EditText.setText(it.line1)
            binding.addressLine2EditText.setText(it.line2)
            binding.cityEditText.setText(it.city)
            binding.zipEditText.setText(it.city)
        })

        return binding.root

    }


    /*private fun geoCodeLocation(location: Location): AddressModel {

        return geocoder.getFromLocation(location.latitude, location.longitude, 1)
            .map { address ->
                AddressModel(
                    address.thoroughfare,
                    address.subThoroughfare,
                    address.locality,
                    address.adminArea,
                    address.postalCode
                )
            }
            .first()
    }*/

}
