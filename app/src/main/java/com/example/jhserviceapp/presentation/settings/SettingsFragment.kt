package com.example.jhserviceapp.presentation.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jhserviceapp.App
import com.example.jhserviceapp.R
import com.example.jhserviceapp.databinding.SettingsFragmentBinding
import com.example.jhserviceapp.presentation.adapters.SettingsArticleAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SettingsFragment : Fragment() {
    private var _binding: SettingsFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sharedPref: SharedPreferences

    @Inject
    lateinit var settingsViewModel: SettingsViewModel

    private val settingsAdapter = SettingsArticleAdapter { defaultArticle ->
        settingsViewModel.removeDefaultArticle(defaultArticle)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SettingsFragmentBinding.inflate(layoutInflater)
        binding.articleListRecyclerView.adapter = settingsAdapter
        binding.articleListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            nameUser.setText(sharedPref.getString(App.USER_NAME, "").toString())
            userCode.setText(sharedPref.getString(App.USER_NUMBER, "").toString())
            saveUserButton.setOnClickListener {
                if (nameUser.text.isNotEmpty()) {
                    sharedPref.edit {
                        putString(App.USER_NAME, nameUser.text.toString())
                        putString(App.USER_NUMBER, userCode.text.toString())
                        apply()
                    }
                    Toast.makeText(
                        context,
                        getString(R.string.user_was_save_toast_text),
                        Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(R.id.fromSettingPageToMain_page)
                }
            }
            addDefArtButtonSettings.setOnClickListener {
                if (articleNumberSettings.text?.isNotEmpty() == true && articleNameSettings.text.isNotEmpty()) {
                    settingsViewModel.addDefaultArticle(
                        articleNumberSettings.text.toString(),
                        articleNameSettings.text.toString()
                    )
                    articleNumberSettings.text!!.clear()
                    articleNameSettings.text.clear()
                } else {
                    articleNumberSettings.error = getString(R.string.error_message_settings_page)
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(R.id.fromSettingPageToMain_page)
        }
        settingsViewModel.defaultList.onEach {
            settingsAdapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}