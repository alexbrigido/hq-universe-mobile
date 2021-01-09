package br.com.alexbrigido.hquniverse.repository.dto

class BookHomePage(
        var total: Int,
        var page: Int,
        var books: List<BookHomeDTO>
)