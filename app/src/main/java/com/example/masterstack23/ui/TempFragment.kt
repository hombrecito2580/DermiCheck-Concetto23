package com.example.masterstack23.ui

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.masterstack23.R
import com.example.masterstack23.databinding.FragmentTempBinding
import com.example.masterstack23.databinding.FragmentTestBinding
import com.example.masterstack23.repo.APIService
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.tensorflow.lite.Interpreter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

//class SkinDiseaseClassifier(private val assetManager: AssetManager) {

//    private val model: Interpreter = Interpreter(FileUtil.loadMappedFile(assetManager, "model.tflite"))
//    private val vggModel: Interpreter

//    fun predictSkinDisease(image: Bitmap): String {
//        // Preprocess the image
//        val preprocessedImage = preprocessImage(image)
//
//        // Perform inference with the VGG model
//        // ...
//
//        // Make predictions using the primary model
//        val result = runInference(preprocessedImage)
//
//        val disease_list = mutableListOf<String>("Acne and Rosacea Photos",
//            "Normal",
//            "vitiligo",
//            "Tinea Ringworm Candidiasis and other Fungal Infections",
//            "Melanoma Skin Cancer Nevi and Moles",
//            "Eczema Photos")
//        val predicted_class = result[0].bestLabel()
//        return disease_list[predicted_class]
//
//        // Get the predicted class label
//
//    }

//    private fun preprocessImage(image: Bitmap): TensorImage {
//        // Preprocess the image (resize, normalize, etc.)
//        // ...
//
//        return TensorImage.fromBitmap(preprocessedBitmap)
//    }

//    private fun runInference(inputImage: TensorImage): TensorLabel {
//        // Run inference using the primary model
//        // ...
//
//        return inferenceResult
//    }
//}

class TempFragment : Fragment() {

    private var _binding: FragmentTempBinding? = null
    private val binding get() = _binding!!
    private lateinit var dialog: Dialog

    private var requestImageCapture = 100

    private lateinit var image: ImageView
    private lateinit var imageUri: Uri
    private lateinit var initialImageURI: Uri

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTempBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        binding.image.setOnClickListener {
            val bottomSheetDialog= BottomSheetDialog(requireContext())
            val bottomSheetView=LayoutInflater.from(context).inflate(R.layout.bottomsheet,view.findViewById(R.id.bottomsheet))
            bottomSheetView.findViewById<ImageView>(R.id.camera).setOnClickListener{
                val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                try {
                    startActivityForResult(intent,requestImageCapture)
                }catch(_: ActivityNotFoundException) {

                }
                bottomSheetDialog.dismiss()
            }
            bottomSheetView.findViewById<ImageView>(R.id.folder).setOnClickListener{
                val intent= Intent(Intent.ACTION_GET_CONTENT)
                intent.type="image/*"
                resultLauncher.launch(intent)
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        binding.btnUpload.setOnClickListener {
            if(imageUri == initialImageURI) {
                Toast.makeText(context, "Please Select an image...", Toast.LENGTH_SHORT).show()
            }
            else {
//                upload()
                val assetManager = context?.assets
                val modelInputStream = assetManager?.open("model.tflite")
                val vggModelInputStream = assetManager?.open("vgg_model.tflite")
                val modelBuffer = modelInputStream?.let { it1 -> ByteArray(it1.available()) }
                val vggModelBuffer = vggModelInputStream?.let { it1 -> ByteArray(it1.available()) }
                modelInputStream?.read(modelBuffer)
                vggModelInputStream?.read(vggModelBuffer)
                modelInputStream?.close()
                vggModelInputStream?.close()

            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == requestImageCapture && resultCode== AppCompatActivity.RESULT_OK){
            val bitmap= data!!.extras!!.get("data") as Bitmap
            imageUri=getImageUriFromBitmap(requireContext(),bitmap)
            binding.image.setImageURI(imageUri)
        }
        else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun getImageUriFromBitmap(context: Context, bitmap: Bitmap): Uri {
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(context.contentResolver, bitmap, "Title", null)
        return Uri.parse(path.toString())
    }

    private val resultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result->
        if(result.resultCode== AppCompatActivity.RESULT_OK)
            result.data?.data.let {
                imageUri = it!!
                binding.image.setImageURI(it)
            }
    }

    private fun createImageUri(): Uri? {
        val image = File(activity?.applicationContext?.filesDir, "camera_photo.png")
        return activity?.applicationContext?.let {
            FileProvider.getUriForFile(it, "com.example.masterstack23.fileProvider", image)
        }
    }

    private fun init() {
        image = binding.image
        imageUri = createImageUri()!!
        initialImageURI = imageUri

        dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
    }

    private fun upload() {
        val filesDir = activity?.applicationContext?.filesDir
        val file = File(filesDir, "image.png")
        val inputStream = activity?.contentResolver?.openInputStream(imageUri)
        val outputStream = FileOutputStream(file)
        inputStream!!.copyTo(outputStream)
        inputStream.close()

        val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("profile", file.name, requestBody)

        val retrofit =
            Retrofit.Builder().baseUrl("https://hombrecito2580.pythonanywhere.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)

        val bundle = Bundle()
        lifecycleScope.launch {
            val response = async { retrofit.uploadImage(part) }
//            println(response.await())
//            println("\n\n\n\n\n\n\n\n\n\n")
            val temp = response.await().body()
            if(temp != null) {
                val responseJSON = Gson().toJson(response.await().body())
                bundle.putString("Response", responseJSON)
                findNavController().navigate(R.id.action_testFragment_to_displayDiseaseFragment, bundle)
            }
            else {
                Toast.makeText(context, "Invalid response from server...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}