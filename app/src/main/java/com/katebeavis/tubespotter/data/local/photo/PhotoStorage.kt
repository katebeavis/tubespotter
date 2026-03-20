package com.katebeavis.tubespotter.data.local.photo

import android.content.Context
import androidx.core.content.FileProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoStorage @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    fun createImageFile(): File {
        val picturesDir = File(context.getExternalFilesDir("Pictures"), "")
        if (!picturesDir.exists()) picturesDir.mkdirs()
        return File.createTempFile("station_", ".jpg", picturesDir)
    }

    fun getUriForFile(file: File) = FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        file,
    )

    fun deletePhoto(uri: String) {
        val file = File(uri)
        if (file.exists()) file.delete()
    }
}