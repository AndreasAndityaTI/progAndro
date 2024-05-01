package com.FastMenu.app.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.FastMenu.app.data.repository.MakananRepository
import com.FastMenu.app.view.detail.DetailMakananViewModel
import com.FastMenu.app.view.search.SearchMakananViewModel


class SearchMakananViewModelFactory(private val repository: MakananRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SearchMakananViewModel::class.java) -> {
                SearchMakananViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailMakananViewModel::class.java) -> {
                DetailMakananViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}