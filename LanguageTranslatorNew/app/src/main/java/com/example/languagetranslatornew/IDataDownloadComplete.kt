package com.example.languagetranslatornew

interface IDataDownloadComplete {
    fun onDownloadComplete(data: String, status: DownloadStatus)
}