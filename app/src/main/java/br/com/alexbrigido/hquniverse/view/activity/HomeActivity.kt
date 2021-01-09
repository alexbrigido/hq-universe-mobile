package br.com.alexbrigido.hquniverse.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import br.com.alexbrigido.hquniverse.R
import br.com.alexbrigido.hquniverse.viewmodel.BookHomeViewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel : BookHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}