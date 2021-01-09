package br.com.alexbrigido.hquniverse.repository

import br.com.alexbrigido.hquniverse.domain.home.BookHome
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeBookAPI {

    private val connector : Retrofit = Retrofit.Builder()
            .baseUrl("https://api.itbook.store/1.0/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    suspend fun searchBooks(query: String, page: Int) : List<BookHome> {
        val service = connector.create(InterfaceHomeAPI::class.java)
        val books = service.search(query, page).books
        return books.map { dto ->
            BookHome(dto.title, dto.subtitle, dto.isbn13, dto.price, dto.image, dto.url)
        }
    }

    suspend fun newBooks() : List<BookHome> {
        val service = connector.create(InterfaceHomeAPI::class.java)
        val books = service.new().books
        return books.map { dto ->
            BookHome(dto.title, dto.subtitle, dto.isbn13, dto.price, dto.image, dto.url)
        }
    }
}