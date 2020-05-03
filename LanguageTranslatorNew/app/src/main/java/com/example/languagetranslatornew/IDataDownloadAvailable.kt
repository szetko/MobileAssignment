package com.example.languagetranslatornew
/**
 * IDataDownloadAvailable
 * @property IDataDownloadAvailable
 * Taken from graysons code
 */
interface IDataDownloadAvailable {
    fun onDataAvailable(data: String)
    fun onError(e: Exception)
}