package com.example.lab3

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repository : WikiRepository = WikiRepository()
    private val query = MutableLiveData<String>()

    fun queryName(name: String) {
        query.value = name
        println(name)
    }

    val hitCount: LiveData<String> = query.switchMap {
        liveData(Dispatchers.IO) { emit(repository.hitCountCheck(it)) }
    }
}