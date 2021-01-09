package br.com.alexbrigido.hquniverse.domain.home

data class BookHome(
        var title: String? = null,
        var subtitle: String? = null,
        var isbn13: String? = null,
        var price: String? = null,
        var image: String? = null,
        var url: String? = null
)