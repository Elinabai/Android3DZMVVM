package com.geektech.android3dz1mvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.geektech.android3dz1mvvm.databinding.FragmentSecondBinding
import com.geektech.android3dz1mvvm.model.ModelBook
import com.geektech.android3dz1mvvm.ui.adapter.AdapterBook
import com.geektech.android3dz1mvvm.ui.viewmodel.SecondViewModel

class SecondFragment : Fragment() {

    private var viewModel: SecondViewModel? = null
    private val listBook = mutableListOf<ModelBook>()
    private lateinit var binding: FragmentSecondBinding
    private var adapterBook = AdapterBook(listBook,this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[SecondViewModel::class.java]

        setUpListeners()
        clear()
        initialization()
    }

    private fun setUpListeners() {

        binding.btnOpen.setOnClickListener{
            binding.btnOpen.isInvisible = true
            binding.rvBook.isInvisible = false
        }
    }

    private fun clear() {
        listBook.clear()
    }

    private fun initialization() {
        viewModel?.let { listBook.addAll(it.getListOfCatHTP())}
        binding.rvBook.adapter = adapterBook
    }
    private fun onItemClick(modelBook:ModelBook) {
        findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToDetailFragment(
            modelBook.image,
            modelBook.name)
        )
    }
}