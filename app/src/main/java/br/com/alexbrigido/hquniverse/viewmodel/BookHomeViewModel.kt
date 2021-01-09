package br.com.alexbrigido.hquniverse.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.alexbrigido.hquniverse.domain.home.BookHome
import br.com.alexbrigido.hquniverse.interector.BookHomeInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class BookHomeViewModel(val app: Application) : AndroidViewModel(app), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main
    private val interactor = BookHomeInteractor()
    val responseView = MutableLiveData<List<BookHome>>()

    fun newBooks() {
        launch {
            responseView.value = interactor.newBooks()
        }
    }
}