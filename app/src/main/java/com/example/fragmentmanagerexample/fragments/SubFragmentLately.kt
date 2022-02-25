package com.example.fragmentmanagerexample.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentmanagerexample.R
import com.example.fragmentmanagerexample.databinding.FragmentSubBinding

class SubFragmentLately : Fragment() {

    private lateinit var viewModel: SubFragmentViewModel
    private lateinit var viewModelFactory: SubFragmentViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment프래그먼트", "Lately OnCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSubBinding>(
            inflater,
            R.layout.fragment_sub,
            container,
            false
        )

        viewModelFactory = SubFragmentViewModelFactory("여기는 최신순 정렬 프래그먼트 입니다.")
        viewModel = ViewModelProvider(
            requireParentFragment(),
            viewModelFactory
        )[SubFragmentViewModel::class.java]

        viewModel.headLine = "여기는 최신순 정렬 프래그먼트 입니다."

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment프래그먼트", "Lately OnDestroy()")
    }
}