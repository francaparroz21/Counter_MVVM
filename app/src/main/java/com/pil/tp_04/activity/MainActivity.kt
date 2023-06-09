package com.pil.tp_04.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pil.tp_04.R
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_04.mvvm.model.CounterModel
import com.pil.tp_04.mvvm.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var countViewModel: CounterViewModel = CounterViewModel(CounterModel())
    private fun getAcc(): Int = binding.inputCount.text.toString().toInt();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increment.setOnClickListener { countViewModel.incValue(getAcc()) }
        binding.decrement.setOnClickListener { countViewModel.decValue(getAcc()) }
        binding.reset.setOnClickListener { countViewModel.resetValue() }

        countViewModel.getValue().observe({lifecycle},::updateUI)
    }

    private fun updateUI(it:CounterViewModel.CounterData){
        when(it.state){
            CounterViewModel.CounterState.INC -> binding.counter.text = it.value.toString()
            CounterViewModel.CounterState.DEC -> binding.counter.text = it.value.toString()
            CounterViewModel.CounterState.INITIAL -> binding.counter.text = getString(R.string.startText)
        }
    }
}
