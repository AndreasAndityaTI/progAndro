package com.FastMenu.app.view.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.FastMenu.app.data.remote.ApiConfig
import com.FastMenu.app.data.repository.MakananRepository
import com.FastMenu.app.data.response.MakananItem
import com.FastMenu.app.view.SearchMakananViewModelFactory
import com.FastMenu.app.databinding.ActivitySearchTopengBinding

class SearchMakananActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchTopengBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchTopengBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService = ApiConfig.getApiService()
        val makananRepository = MakananRepository(apiService)

        val viewModelFactory = SearchMakananViewModelFactory(makananRepository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SearchMakananViewModel::class.java)

        val layoutManager = LinearLayoutManager(this)
        binding.rvMakanan.layoutManager = layoutManager

        binding.appBar.setNavigationOnClickListener{
            finish()
        }

        viewModel.listMakanan.observe(this) { listMakanan ->
            setTopengData(listMakanan)
        }

        viewModel.isLoading.observe(this) {
            showLoading(it)
        }
    }

    private fun setTopengData(data: List<MakananItem>) {
        val adapter = MakananAdapter()
        adapter.submitList(data)
        binding.rvMakanan.adapter = adapter
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}