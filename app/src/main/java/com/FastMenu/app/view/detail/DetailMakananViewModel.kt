package com.FastMenu.app.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.FastMenu.app.data.repository.MakananRepository
import com.FastMenu.app.data.response.DetailMakananResponse
import kotlinx.coroutines.launch

class DetailMakananViewModel (private val repository: MakananRepository) : ViewModel() {

    private val _detailMakanan = MutableLiveData<DetailMakananResponse>()
    val detailMakanan: LiveData<DetailMakananResponse> =  MutableLiveData()

    fun getDetailTopeng (id: String){
        viewModelScope.launch {
            val detailStory = repository.getDetailMakanan(id)
            _detailMakanan.postValue(detailStory)
        }
    }
}