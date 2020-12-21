package com.udacity.political.preparedness.representative

import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.data.response.AddressResponse
import com.udacity.political.preparedness.databinding.FragmentRepresentativeBinding
import com.udacity.political.preparedness.util.setEntries
import java.util.*

class RepresentativeFragment : Fragment() {

    private val viewModel: RepresentativeViewModel by lazy {
        ViewModelProvider(this, RepresentativeViewModelFactory(requireActivity().application)).get(
            RepresentativeViewModel::class.java
        )
    }

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

        val binding = FragmentRepresentativeBinding.inflate(inflater)
        binding.lifecycleOwner = this

        viewModel.loadSpinner()

        viewModel.stateList.observe(viewLifecycleOwner, {
            Log.i("z- stateList", it.toString())
            binding.stateSpinner.setEntries(it)
        })

        return binding.root

    }


    private fun geoCodeLocation(location: Location): AddressResponse {
        val geocoder = Geocoder(context, Locale.getDefault())
        return geocoder.getFromLocation(location.latitude, location.longitude, 1)
            .map { address ->
                AddressResponse(
                    address.thoroughfare,
                    address.subThoroughfare,
                    address.locality,
                    address.adminArea,
                    address.postalCode
                )
            }
            .first()
    }

}
