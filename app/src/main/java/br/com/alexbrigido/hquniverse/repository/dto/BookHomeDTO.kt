package br.com.alexbrigido.hquniverse.repository.dto

data class BookHomeDTO(
        var title: String,
        var subtitle: String,
        var isbn13: String,
        var price: String,
        var image: String,
        var url: String
)