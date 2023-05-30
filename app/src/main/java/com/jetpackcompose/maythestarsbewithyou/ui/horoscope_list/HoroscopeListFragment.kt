package com.jetpackcompose.maythestarsbewithyou.ui.horoscope_list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jetpackcompose.maythestarsbewithyou.databinding.FragmentListBinding
import com.jetpackcompose.maythestarsbewithyou.ui.horoscope_detail.HoroscopeDetailActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 *ListFragment
 */

@AndroidEntryPoint
class HoroscopeListFragment : Fragment() {

    private val vm by viewModels<HoroscopeListViewModel> ()

    private var _binding: FragmentListBinding? = null
    private val binding get() =_binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAries.setOnClickListener{
            openDetail()
        }
        binding.buttonTaurus.setOnClickListener{
            openDetail()
        }
        binding.buttonGemini.setOnClickListener{
            openDetail()
        }
    }
    private fun openDetail(){
        startActivity(HoroscopeDetailActivity.create(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentListBinding.inflate(inflater,container, false)
        return binding.root
    }

}