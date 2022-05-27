package com.amora.testandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.amora.testandroid.base.viewmodel.ViewModelFactory
import com.amora.testandroid.databinding.DetailBinding
import com.amora.testandroid.databinding.HomeBinding
import com.amora.testandroid.viewmodel.DetailViewModel
import com.amora.testandroid.viewmodel.HomeViewModel

class DetailFragment: Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: DetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = DetailFragmentArgs.fromBundle(requireArguments()).id
        val viewModelFactory =
            ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java].apply {
            getTestAndroid(id)

            detailAndroid.observe(viewLifecycleOwner) { android ->
                binding.androidDetail = android
            }
        }
        binding.lifecycleOwner = viewLifecycleOwner
    }
}