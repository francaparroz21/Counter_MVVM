package com.pil.tp_04.mvvm.contract

import androidx.lifecycle.LiveData
import com.pil.tp_04.mvvm.viewmodel.CounterViewModel

interface MainContract {
    interface Model {
        var counter: Int
        fun increment(inputValue: Int)
        fun decrement(inputValue: Int)
        fun reset()
    }

    interface ViewModel {
        fun getValue(): LiveData<CounterViewModel.CounterData>
        fun resetValue()
        fun incValue(inputValue: Int)
        fun decValue(inputValue: Int)
    }
}
