package br.com.alexbrigido.hquniverse.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.alexbrigido.hquniverse.R
import br.com.alexbrigido.hquniverse.databinding.FragmentLoginBinding
import br.com.alexbrigido.hquniverse.domain.login.LoginData
import br.com.alexbrigido.hquniverse.view.activity.HomeActivity
import br.com.alexbrigido.hquniverse.viewmodel.BookHomeViewModel
import br.com.alexbrigido.hquniverse.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel : LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this

        viewModel.responseView.observe(viewLifecycleOwner) {response ->
            when(response.code) {
                "SUCCESS" -> {
                    findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
                }
                else -> Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    fun doLogin() {
        val email = etEmail.text.toString()
        val pass = etPassword.text.toString()
        val data = LoginData(email, pass)
        viewModel.doLogin(data)
    }
}