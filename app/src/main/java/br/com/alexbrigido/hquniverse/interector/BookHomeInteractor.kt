package br.com.alexbrigido.hquniverse.interector

import br.com.alexbrigido.hquniverse.domain.home.BookHome
import br.com.alexbrigido.hquniverse.repository.HomeBookAPI

class BookHomeInteractor {

    private val repository = HomeBookAPI()

    suspend fun newBooks(): List<BookHome> {
        return repository.newBooks()
    }
}