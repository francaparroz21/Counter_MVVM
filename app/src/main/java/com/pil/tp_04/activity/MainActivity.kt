package com.pil.tp_04.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.pil.tp_04.R
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_04.mvp.model.CountModel
import com.pil.tp_04.mvp.viewmodel.CounterViewModel
import com.pil.tp_04.mvp.viewmodel.factory.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}
