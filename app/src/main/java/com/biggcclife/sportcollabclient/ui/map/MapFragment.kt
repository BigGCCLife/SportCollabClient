package com.biggcclife.sportcollabclient.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.biggcclife.sportcollabclient.BuildConfig
import com.biggcclife.sportcollabclient.R
import com.biggcclife.sportcollabclient.databinding.FragmentMapBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.runtime.image.ImageProvider

class MapFragment : Fragment() {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Yandex MapKit
        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
        MapKitFactory.initialize(requireContext().applicationContext)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mapViewModel =
            ViewModelProvider(this)[MapViewModel::class.java]

        _binding = FragmentMapBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Move the camera to Moscow as an example
        binding.mapview.mapWindow.map.move(
            CameraPosition(Point(59.9342802, 30.3350986), 10.0f, 0.0f, 0.0f)
        )

        val ultImageProvider = ImageProvider.fromResource(requireContext(), R.drawable.pin_ult)
        val tenImageProvider = ImageProvider.fromResource(requireContext(), R.drawable.pin_ten)
        val fooImageProvider = ImageProvider.fromResource(requireContext(), R.drawable.pin_foo)
        val basImageProvider = ImageProvider.fromResource(requireContext(), R.drawable.pin_bas)
        val icoImageProvider = ImageProvider.fromResource(requireContext(), R.drawable.pin)

        binding.mapview.map.mapObjects.addPlacemark().apply {
            geometry = Point(59.928793, 30.425399)
            setIcon(ultImageProvider)
        }
        binding.mapview.map.mapObjects.addPlacemark().apply {
            geometry = Point(59.927224, 30.338271)
            setIcon(ultImageProvider)
        }
        binding.mapview.map.mapObjects.addPlacemark().apply {
            geometry = Point(59.925522, 30.290175)
            setIcon(ultImageProvider)
        }


        binding.mapview.map.mapObjects.addPlacemark().apply {
            geometry = Point(59.944666, 30.375973)
            setIcon(basImageProvider)
        }
        binding.mapview.map.mapObjects.addPlacemark().apply {
            geometry = Point(60.055927, 30.348953)
            setIcon(tenImageProvider)
        }
        binding.mapview.map.mapObjects.addPlacemark().apply {
            geometry = Point(59.860190, 30.383073)
            setIcon(fooImageProvider)
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}