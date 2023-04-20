package com.pil.tp_04.mvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pil.tp_04.mvvm.contract.MainContract
import com.pil.tp_04.mvvm.model.CounterModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CounterViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var counterViewModel: MainContract.ViewModel

    @Before
    fun setup(){
        counterViewModel = CounterViewModel(CounterModel())
    }

    @Test
    fun `test to increment button`(){
        counterViewModel.incValue(TEN)
        assert(counterViewModel.getValue().value?.value == TEN)
        assertEquals(CounterViewModel.CounterState.INC,counterViewModel.getValue().value?.state)
    }

    @Test
    fun `test to decrement button`(){
        counterViewModel.decValue(TEN)
        assert(counterViewModel.getValue().value?.value == -TEN)
        assertEquals(CounterViewModel.CounterState.DEC,counterViewModel.getValue().value?.state)
    }

    @Test
    fun `test to reset button`(){
        counterViewModel.decValue(ONE)
        counterViewModel.resetValue()
        assert( counterViewModel.getValue().value?.value == ZERO)
        assertEquals(CounterViewModel.CounterState.INITIAL,counterViewModel.getValue().value?.state)
    }

    companion object{
        private const val TEN = 10
        private const val ONE = 1
        private const val ZERO = 0
    }
}