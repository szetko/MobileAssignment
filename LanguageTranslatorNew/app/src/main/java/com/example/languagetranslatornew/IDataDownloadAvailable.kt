package com.example.languagetranslatornew

interface IDataDownloadAvailable {
    fun onDataAvailable(data: String)
    fun onError(e: Exception)
}