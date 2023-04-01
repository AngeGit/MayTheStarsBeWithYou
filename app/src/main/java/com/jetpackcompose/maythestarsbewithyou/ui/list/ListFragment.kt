package com.jetpackcompose.maythestarsbewithyou.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jetpackcompose.maythestarsbewithyou.R
import com.jetpackcompose.maythestarsbewithyou.ui.compatibility.CompatibilityViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 *ListFragment
 */

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val vm by viewModels<ListViewModel> ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

}