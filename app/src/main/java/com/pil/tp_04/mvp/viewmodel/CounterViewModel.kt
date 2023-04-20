package com.pil.tp_04.mvp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pil.tp_04.mvp.contract.MainContract

class CounterViewModel(private val model: MainContract.Model) : ViewModel(),
    MainContract.ViewModel {
    private val mutableLiveData: MutableLiveData<CounterData> = MutableLiveData()
    override fun getValue(): LiveData<CounterData> {
        return mutableLiveData
    }

    override fun resetValue() {
        model.reset()
        mutableLiveData.value = CounterData(CounterState.INITIAL)
    }

    override fun incValue(inputValue: Int) {
        model.increment(inputValue)
        mutableLiveData.value = CounterData(CounterState.INC, model.counter)
    }

    override fun decValue(inputValue: Int) {
        model.decrement(inputValue)
        mutableLiveData.value = CounterData(CounterState.DEC, model.counter)
    }

    data class CounterData(
        val state: CounterState = CounterState.INITIAL,
        val value: Int = 0
    )

    enum class CounterState {
        INITIAL,
        INC,
        DEC,
    }
}