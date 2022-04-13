package com.example.marvelapp.presentation.common

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.marvelapp.R
import com.example.marvelapp.SPAIN_LOCALE
import com.example.marvelapp.SPAIN_LOCALE_MIN
import com.example.marvelapp.VIEW_DATE_FORMAT
import com.example.marvelapp.domain.common.ImagesLoader
import dagger.android.AndroidInjection
import dagger.android.support.DaggerFragment
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    private lateinit var progressDialog: ProgressDialog

    private val localeSpain = Locale(SPAIN_LOCALE_MIN, SPAIN_LOCALE)
    protected lateinit var simpleDateFormat: SimpleDateFormat

    @Inject
    lateinit var imagesLoader: ImagesLoader

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = ProgressDialog(context)
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