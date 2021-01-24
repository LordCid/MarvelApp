package com.example.marvelapp.domain

import com.example.marvelapp.PUBLIC_KEY
import com.example.marvelapp.PRIVATE_KEY
import java.math.BigInteger
import java.security.MessageDigest

class UtilitiesImpl: Utilities {

    override fun getHash(): String {
        return run {
            val stringToHash = "${getTimeStamp()}$PRIVATE_KEY$PUBLIC_KEY"
            val messageDigest = MessageDigest.getInstance("MD5")
            val bytes = messageDigest.digest(stringToHash.toByteArray())
            val bigInteger = BigInteger(1, bytes)
            var md5 = bigInteger.toString(16)
            while (md5.length < 32) {
                md5 = "0$md5"
            }
            md5
        }
    }

    override fun getTimeStamp() = System.currentTimeMillis()
}