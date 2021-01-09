package br.com.alexbrigido.hquniverse.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.alexbrigido.hquniverse.databinding.FragmentHomeBinding
import br.com.alexbrigido.hquniverse.domain.home.BookHome
import br.com.alexbrigido.hquniverse.view.adapter.HomeBookAdapter
import br.com.alexbrigido.hquniverse.viewmodel.BookHomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.internal.wait

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel : BookHomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel.run { newBooks() }
        viewModel.responseView.observe(viewLifecycleOwner) { response ->
            if(response.isNotEmpty()) {
                showNewBooks(response)
            }
        }
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        return binding.root
    }

    private fun showNewBooks(books: List<BookHome>){
        rvHome.adapter = HomeBookAdapter(books)
        rvHome.layoutManager = LinearLayoutManager(this.context)
        rvHome.setHasFixedSize(true)
    }

}