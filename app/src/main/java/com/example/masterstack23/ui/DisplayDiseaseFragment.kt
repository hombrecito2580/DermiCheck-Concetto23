package com.example.masterstack23.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.masterstack23.data.DiseaseData
import com.example.masterstack23.data.UploadTestResponse
import com.example.masterstack23.databinding.FragmentDisplayDiseaseBinding
import com.google.gson.Gson
import okhttp3.Response


class DisplayDiseaseFragment : Fragment() {

    private var _binding: FragmentDisplayDiseaseBinding? = null
    private val binding get() = _binding!!
    private lateinit var tvDisease: TextView
    private lateinit var tvSymptoms:TextView
    private lateinit var tvTreatment:TextView
    private lateinit var tvUrl:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentDisplayDiseaseBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        val bundle = arguments
        if (bundle != null) {
            val responseString = bundle.getString("Response")
            if (responseString != null) {
                val response = Gson().fromJson(responseString, UploadTestResponse::class.java)
                tvDisease.text = response.disease
                val symptoms = response.symptoms
                var str = ""
                for(symptom in symptoms) {
                    str += "\u2022 ${symptom}\n"
                }
                tvSymptoms.text = str
                tvTreatment.text = response.cure
                tvUrl.text = response.url
            }
        }
    }

    private fun init(){
        tvDisease = binding.tvDisease
        tvSymptoms = binding.tvSymptoms
        tvTreatment = binding.tvTreatment
        tvUrl = binding.tvURL
    }

}