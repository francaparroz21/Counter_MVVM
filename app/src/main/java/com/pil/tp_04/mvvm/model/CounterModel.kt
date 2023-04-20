package com.pil.tp_04.mvvm.model

import com.pil.tp_04.mvvm.contract.MainContract

class CounterModel : MainContract.Model {
    override var counter: Int = ZERO

    override fun increment(inputValue: Int) {
        counter += inputValue
    }

    override fun decrement(inputValue: Int) {
        counter -= inputValue
    }

    override fun reset() {
        counter = ZERO
    }

    companion object {
        private const val ZERO = 0
    }
}
