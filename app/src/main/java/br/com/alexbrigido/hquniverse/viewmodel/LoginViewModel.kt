package br.com.alexbrigido.hquniverse.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.alexbrigido.hquniverse.domain.login.LoginData
import br.com.alexbrigido.hquniverse.domain.login.LoginResponse
import br.com.alexbrigido.hquniverse.interector.LoginInterector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel(val app: Application) : AndroidViewModel(app), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main
    private val interactor = LoginInterector()
    val responseView = MutableLiveData<LoginResponse>()

    fun doLogin(data: LoginData) {
        launch {
            val response = interactor.doLogin(data)
            responseView.value = response
        }
    }

}