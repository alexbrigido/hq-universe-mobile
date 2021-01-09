package br.com.alexbrigido.hquniverse.interector

import android.util.Patterns
import br.com.alexbrigido.hquniverse.domain.login.LoginData
import br.com.alexbrigido.hquniverse.domain.login.LoginResponse
import br.com.alexbrigido.hquniverse.repository.LoginRepository

class LoginInterector() {

    private val repository = LoginRepository()

    suspend fun doLogin(data: LoginData) : LoginResponse {
        val result = validate(data)
        if(result.code != null) {
            return result
        }
        return repository.doLogin(data)
    }

    private fun validate(data: LoginData) : LoginResponse {
        val response = LoginResponse()
        if (data.email.isNullOrBlank()) {
            response.code = "ERRO_EMAIL_VAZIO"
            response.message = "E-mail é obrigatório"
            return response
        }
        if (data.password.isNullOrBlank()) {
            response.code = "ERRO_SENHA_VAZIA"
            response.message = "Senha é obrigatória"
            return response
        }
        if (data.password.length < 6){
            response.code = "ERRO_SENHA_MENOR_6"
            response.message = "Senha deve ser maior que 5 caracteres"
            return response
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(data.email).matches()){
            response.code = "ERRO_EMAIL_INVALIDO"
            response.message = "E-mail é inválido"
            return response
        }
        return response
    }

}