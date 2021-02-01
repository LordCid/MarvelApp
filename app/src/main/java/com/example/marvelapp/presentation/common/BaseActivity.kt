package com.example.marvelapp.presentation.common

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelapp.R
import com.example.marvelapp.domain.common.ImagesLoader
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: ProgressDialog

    @Inject
    lateinit var imagesLoader: ImagesLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        progressDialog = ProgressDialog(this)
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