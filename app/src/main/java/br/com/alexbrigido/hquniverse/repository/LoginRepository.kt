package br.com.alexbrigido.hquniverse.repository

import br.com.alexbrigido.hquniverse.domain.login.LoginData
import br.com.alexbrigido.hquniverse.domain.login.LoginResponse
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LoginRepository() {

    private val auth = Firebase.auth

    suspend fun doLogin(data: LoginData) : LoginResponse = suspendCoroutine { nextStep ->
        val operation = auth.signInWithEmailAndPassword(data.email, data.password)
        val response = LoginResponse()
        operation.addOnCompleteListener { result ->
            if (result.isSuccessful) {
                response.code = "SUCCESS"
            } else {
                response.code = "FAIL_LOGIN"
                response.message = "E-mail ou senha inválidos"
            }
            nextStep.resume(response)
        }
    }

}