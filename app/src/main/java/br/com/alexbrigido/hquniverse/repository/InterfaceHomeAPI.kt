package br.com.alexbrigido.hquniverse.repository

import br.com.alexbrigido.hquniverse.repository.dto.BookHomePage
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfaceHomeAPI {

    @GET("search/{query}/{page}")
    suspend fun search(@Path("query") query: String, @Path("page") page: Int) : BookHomePage

    @GET("new")
    suspend fun new() : BookHomePage
}