package com.lukman.pahlawanislamskuy.ui.pahlawanlocal

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukman.pahlawanislamskuy.adapter.PahlawanAdapter
import com.lukman.pahlawanislamskuy.data.Pahlawan
import com.lukman.pahlawanislamskuy.databinding.ActivityJsonBinding
import org.json.JSONException
import org.json.JSONObject

class JsonActivity : AppCompatActivity() {

    private var arrayPahlawan = arrayListOf<Pahlawan>()

    private var _binding: ActivityJsonBinding? = null
    private val binding get() = _binding as ActivityJsonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getListPahlawan()
        Log.i("TAG", "onCreate: ")

        val mAdapter = PahlawanAdapter()
        binding.rvPahlawan.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@JsonActivity)
            mAdapter.setData(arrayPahlawan)
        }
    }

    private fun getListPahlawan() {
        val json = assets.readAssetFile("pahlawan_nasional.json")
        Log.i("JSON", "getListPahlawan: $json")
        val rootJSON = JSONObject(json)

        try {
            // get array daftar_pahlawan in json
            val pahlawanFromJSONArray = rootJSON.getJSONArray("daftar_pahlawan")
            for (i in 0 until pahlawanFromJSONArray.length()) {
                val data = pahlawanFromJSONArray.getJSONObject(i)
                val pahlawan = Pahlawan(
                    nama = data.getString("nama"),
                    panggilan = data.getString("nama2"),
                    kategori = data.getString("kategori"),
                    gambar = data.getString("img")
                )
                arrayPahlawan.add(pahlawan)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun AssetManager.readAssetFile(filename: String): String =
        open(filename).bufferedReader().use { it.readText() }
}