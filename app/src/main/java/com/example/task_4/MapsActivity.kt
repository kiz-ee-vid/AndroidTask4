package com.example.task_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.task_4.databinding.ActivityMapsBinding
import kotlinx.coroutines.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val homiel = LatLng(52.42416, 31.014281)
        CoroutineScope(Dispatchers.Default).launch {
            val items = BankApiImpl.getListOfBanks()
            runOnUiThread {
                if (items != null) {
                    for (i in 0 until items.count())
                        mMap.addMarker(
                            MarkerOptions().position(LatLng(items[i].gps_x, items[i].gps_y)).title("Банк")
                        )
                }
            }
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homiel, 13f))
    }
}