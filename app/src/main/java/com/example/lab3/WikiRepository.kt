package com.example.lab3

class WikiRepository {
    private val call = GlobalModel.service

    suspend fun hitCountCheck(name: String): String = call.getTotalHits(name).query.searchinfo.totalhits.toString()
}
