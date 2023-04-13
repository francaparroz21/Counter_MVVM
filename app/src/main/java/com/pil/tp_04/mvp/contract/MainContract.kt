package com.pil.tp_04.mvp.contract

import androidx.lifecycle.LiveData
import com.pil.tp_04.mvp.viewmodel.CounterViewModel

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
        fun incValue()
        fun decValue()
    }
}
