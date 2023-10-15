package com.example.masterstack23.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.masterstack23.R
import com.example.masterstack23.databinding.FragmentProfileBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var ivPhoto:ImageView
    private lateinit var fabAddPhoto: FloatingActionButton
    private lateinit var imageUri: Uri
    private lateinit var rvBookMark: RecyclerView
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etUserName: EditText

    private val cameraContract = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        ivPhoto.setImageURI(imageUri)
    }

    private val galleryContract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        imageUri = it!!
        ivPhoto.setImageURI(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        fabAddPhoto.setOnClickListener{
            val bottomSheetDialog= BottomSheetDialog(requireContext())
            val bottomSheetView=LayoutInflater.from(context).inflate(R.layout.bottomsheet,view.findViewById(R.id.bottomsheet))

            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()

            bottomSheetView.findViewById<ImageView>(R.id.camera).setOnClickListener{
                cameraContract.launch(imageUri)
                bottomSheetDialog.dismiss()
            }
            bottomSheetView.findViewById<ImageView>(R.id.folder).setOnClickListener{
                galleryContract.launch("image/*")
                bottomSheetDialog.dismiss()
            }
        }

        binding.btnEdit.setOnClickListener{
            binding.btnSubmit.visibility = View.VISIBLE
            fabAddPhoto.isEnabled = true
            etName.isEnabled = true
            etEmail.isEnabled = true
            etUserName.isEnabled = true
            binding.btnEdit.visibility = View.GONE
        }

        binding.btnSubmit.setOnClickListener {

        }

    }


    private fun createImageUri(): Uri? {
        val image = File(activity?.applicationContext?.filesDir, "camera_photo.png")
        return activity?.applicationContext?.let {
            FileProvider.getUriForFile(it, "com.example.masterstack23.fileProvider", image)
        }
    }


    private fun init() {
        ivPhoto=binding.ivPhoto
        fabAddPhoto=binding.fabAddPhoto
        rvBookMark=binding.rvBookMark
        etName=binding.etName
        etEmail=binding.etEmail
        etUserName=binding.etUserName
        imageUri = createImageUri()!!

    }
}