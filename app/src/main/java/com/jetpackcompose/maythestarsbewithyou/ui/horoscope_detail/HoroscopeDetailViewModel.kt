package com.jetpackcompose.maythestarsbewithyou.ui.horoscope_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpackcompose.maythestarsbewithyou.domain.GetHoroscopeUseCase
import com.jetpackcompose.maythestarsbewithyou.ui.horoscope_detail.model.DetailUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(
  private val getHoroscopeUseCase: GetHoroscopeUseCase
): ViewModel() {
    private val _uiState: MutableStateFlow<DetailUIState> = MutableStateFlow(DetailUIState.Loading)
    val uiState: StateFlow<DetailUIState> = _uiState
  fun getHoroscope(){
      _uiState.value = DetailUIState.Loading
       viewModelScope.launch() {
         getHoroscopeUseCase()
             .catch { _uiState.value = DetailUIState.Error(it.message!!) }
             .collect{
             if(it!=null){
                _uiState.value = DetailUIState.Success(it)
             }else{
                 _uiState.value = DetailUIState.Error("Caso de uso da null")
             }
         }
       }
  }
}