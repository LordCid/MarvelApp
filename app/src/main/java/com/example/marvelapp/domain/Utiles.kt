package com.example.marvelapp.domain

import com.example.marvelapp.PUBLIC_KEY
import com.example.marvelapp.PRIVATE_KEY
import java.math.BigInteger
import java.security.MessageDigest

class Utiles {

    fun getHash(): String {
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
//        try {
//            // Create MD5 Hash
//            val digest: MessageDigest = MessageDigest.getInstance("MD5")
//            digest.update(s.toByteArray())
//            val messageDigest: ByteArray = digest.digest()
//
//            // Create Hex String
//            val hexString = StringBuffer()
//            for (i in messageDigest.indices) hexString.append(
//                Integer.toHexString(
//                    0xFF and messageDigest[i]
//                        .toInt()
//                )
//            )
//            return hexString.toString()
//        } catch (e: NoSuchAlgorithmException) {
//            e.printStackTrace()
//            return ""
//        }
    }

    fun getTimeStamp() = System.currentTimeMillis()
}