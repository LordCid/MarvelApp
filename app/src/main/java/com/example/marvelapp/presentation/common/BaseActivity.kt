package com.example.marvelapp.presentation.common

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelapp.R
import com.example.marvelapp.SPAIN_LOCALE
import com.example.marvelapp.SPAIN_LOCALE_MIN
import com.example.marvelapp.VIEW_DATE_FORMAT
import com.example.marvelapp.domain.common.ImagesLoader
import dagger.android.AndroidInjection
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: ProgressDialog

    private val localeSpain = Locale(SPAIN_LOCALE_MIN, SPAIN_LOCALE)
    protected lateinit var simpleDateFormat: SimpleDateFormat

    @Inject
    lateinit var imagesLoader: ImagesLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        progressDialog = ProgressDialog(this)
        simpleDateFormat = SimpleDateFormat(VIEW_DATE_FORMAT, localeSpain)
        showLoadingDialogFragment()
    }


    private fun showLoadingDialogFragment() {
        progressDialog.setMessage(getString(R.string.downloading_title_dialog))
        progressDialog.show()
    }

    protected fun hideLoadingDialogFragment() {
        progressDialog.dismiss()
    }

}