package com.jetpackcompose.maythestarsbewithyou.ui.compatibility

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jetpackcompose.maythestarsbewithyou.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment de la screen de Compatibilidad
 */

@AndroidEntryPoint
class CompatibilityFragment : Fragment() {

    private val vm by viewModels<CompatibilityViewModel> ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_compatibility, container, false)
    }
}