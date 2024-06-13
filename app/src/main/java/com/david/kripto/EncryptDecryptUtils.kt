package com.david.kripto

object EncryptDecryptUtils {

    fun vigenereEncrypt(text: String, key: String): String {
        val result = StringBuilder()
        val upperText = text.toUpperCase()
        val upperKey = key.toUpperCase()

        var keyIndex = 0
        for (char in upperText) {
            if (char.isLetter()) {
                val shift = upperKey[keyIndex % upperKey.length] - 'A'
                val encryptedChar = ((char - 'A' + shift) % 26 + 'A'.toInt()).toChar()
                result.append(encryptedChar)
                keyIndex++
            } else {
                result.append(char)
            }
        }

        return result.toString()
    }

    fun vigenereDecrypt(text: String, key: String): String {
        val result = StringBuilder()
        val upperText = text.toUpperCase()
        val upperKey = key.toUpperCase()

        var keyIndex = 0
        for (char in upperText) {
            if (char.isLetter()) {
                val shift = upperKey[keyIndex % upperKey.length] - 'A'
                val decryptedChar = ((char - 'A' - shift + 26) % 26 + 'A'.toInt()).toChar()
                result.append(decryptedChar)
                keyIndex++
            } else {
                result.append(char)
            }
        }

        return result.toString()
    }

    fun rot13Encrypt(text: String): String {
        return text.map { char ->
            when {
                char in 'A'..'Z' -> {
                    (((char - 'A') + 13) % 26 + 'A'.toInt()).toChar()
                }
                char in 'a'..'z' -> {
                    (((char - 'a') + 13) % 26 + 'a'.toInt()).toChar()
                }
                else -> char
            }
        }.joinToString("")
    }

    fun rot13Decrypt(text: String): String {
        return rot13Encrypt(text) // ROT13 is its own inverse
    }
}
