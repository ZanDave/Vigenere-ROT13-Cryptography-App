package com.david.kripto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.david.kripto.databinding.FragmentVigenereBinding

class VigenereFragment : Fragment() {

    private lateinit var binding: FragmentVigenereBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVigenereBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnEncrypt.setOnClickListener {
            val plainText = binding.etPlainText.text.toString()
            val key = binding.etKey.text.toString()
            val encryptedText = EncryptDecryptUtils.vigenereEncrypt(plainText, key)
            binding.tvResult.text = "Encrypted Text: $encryptedText"
        }

        binding.btnDecrypt.setOnClickListener {
            val encryptedText = binding.etPlainText.text.toString()
            val key = binding.etKey.text.toString()
            val decryptedText = EncryptDecryptUtils.vigenereDecrypt(encryptedText, key)
            binding.tvResult.text = "Decrypted Text: $decryptedText"
        }

        return view
    }
}
