package com.jetpackcompose.maythestarsbewithyou.ui.lucky_day

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jetpackcompose.maythestarsbewithyou.ui.lucky_day.model.LuckyOfTheDayUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LuckyOfTheDayViewModel @Inject constructor(val cardsProvider: RandomCardsProvider):ViewModel() {

    private var _cardSelected: MutableLiveData<LuckyOfTheDayUIModel> = MutableLiveData<LuckyOfTheDayUIModel>(cardsProvider.getLuckyCard())
    var cardSelected:LiveData<LuckyOfTheDayUIModel> =_cardSelected

    fun prepareCard(){
        _cardSelected.value = cardsProvider.getLuckyCard()
    }

}