package com.jetpackcompose.maythestarsbewithyou.ui.horoscope_detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jetpackcompose.maythestarsbewithyou.databinding.ActivityDetailBinding
import com.jetpackcompose.maythestarsbewithyou.ui.horoscope_detail.model.DetailUIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val vm by viewModels<HoroscopeDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        vm.getHoroscope()
    }

    private fun initUI() {
        lifecycleScope.launch() {
            repeatOnLifecycle(Lifecycle.State.STARTED) {//Desde que empiece el ciclo de vida
                vm.uiState.collect { uiState -> //Collecteamos  el uiState del VM
                    when (uiState) { //y dependiendo del tipo pintamos una pantalla u otra:
                        is DetailUIState.Error -> {
                            binding.loading.isVisible = false
                            Toast.makeText(
                                this@HoroscopeDetailActivity,
                                uiState.msg,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        DetailUIState.Loading ->
                            binding.loading.isVisible = true

                        is DetailUIState.Success -> {
                            binding.loading.isVisible = false
                            Toast.makeText(
                                this@HoroscopeDetailActivity,
                                uiState.horoscopeModel.horoscope,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }

    companion object {
        fun create(context: Context): Intent = Intent(context, HoroscopeDetailActivity::class.java)
    }
}