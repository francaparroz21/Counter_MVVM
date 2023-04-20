package com.pil.tp_04.mvvm.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pil.tp_04.mvvm.contract.MainContract
import com.pil.tp_04.mvvm.viewmodel.CounterViewModel

class ViewModelFactory(private val params: Array<Any>):ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when(modelClass){
            CounterViewModel::class.java -> CounterViewModel(params[0] as MainContract.Model)as T
            else -> throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
        }
    }
}