package com.example.jhserviceapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jhserviceapp.R
import com.example.jhserviceapp.databinding.StartFragmentBinding

class StartFragment : Fragment() {
    private var _binding: StartFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = StartFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//            ObjectAnimator.ofPropertyValuesHolder(binding.test,
//                PropertyValuesHolder.ofFloat(View.ROTATION, 180f, -180f),
//                PropertyValuesHolder.ofFloat(View.TRANSLATION_X, 1000f, -1000f)
//            ).apply {
//                duration = 2500
//                interpolator = AccelerateInterpolator()
//                start()
//            }
//
//            ObjectAnimator.ofPropertyValuesHolder(
//                binding.manImage,
//                PropertyValuesHolder.ofFloat(View.TRANSLATION_X, 1500f, -1000f)
//            ).apply {
//                duration = 3000
//                interpolator = AccelerateInterpolator()
//                start()
//            }
//            delay(2500)
        findNavController().navigate(R.id.fromStartPageToMainPage)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}