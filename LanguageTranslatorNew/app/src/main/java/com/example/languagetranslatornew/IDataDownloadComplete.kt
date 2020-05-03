package com.example.languagetranslatornew

/**
 * IDataDownloadComplete
 * @property IDataDownloadComplete
 * Taken from graysons code
 */
interface IDataDownloadComplete {
    fun onDownloadComplete(data: String, status: DownloadStatus)
}