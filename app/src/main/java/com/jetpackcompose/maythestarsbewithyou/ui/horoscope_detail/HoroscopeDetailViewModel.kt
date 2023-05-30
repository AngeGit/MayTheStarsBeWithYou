package com.jetpackcompose.maythestarsbewithyou.ui.horoscope_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpackcompose.maythestarsbewithyou.core.network.ResultType
import com.jetpackcompose.maythestarsbewithyou.domain.GetHoroscopeUseCase
import com.jetpackcompose.maythestarsbewithyou.domain.dto.HoroscopeDTO
import com.jetpackcompose.maythestarsbewithyou.domain.model.HoroscopeModel
import com.jetpackcompose.maythestarsbewithyou.ui.horoscope_detail.model.DetailUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(
    private val getHoroscopeUseCase: GetHoroscopeUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<DetailUIState> = MutableStateFlow(DetailUIState.Loading)
    val uiState: StateFlow<DetailUIState> = _uiState
    fun getHoroscope() {
        viewModelScope.launch() {
            getHoroscopeUseCase(HoroscopeDTO("aries"))
                .collect { result: ResultType<HoroscopeModel> ->
                    when (result) {
                        is ResultType.Error -> _uiState.value = DetailUIState.Error(result.errorMsg.toString())
                        is ResultType.Success -> _uiState.value = DetailUIState.Success(result.data!!)
                    }
                }
        }
    }
}