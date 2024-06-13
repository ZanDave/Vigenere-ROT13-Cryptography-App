package com.david.kripto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.david.kripto.databinding.FragmentRot13Binding

class Rot13Fragment : Fragment() {

    private lateinit var binding: FragmentRot13Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRot13Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnEncryptRot13.setOnClickListener {
            val plainText = binding.etPlainTextRot13.text.toString()
            val encryptedText = EncryptDecryptUtils.rot13Encrypt(plainText)
            binding.tvResultRot13.text = "Encrypted Text: $encryptedText"
        }

        binding.btnDecryptRot13.setOnClickListener {
            val encryptedText = binding.etPlainTextRot13.text.toString()
            val decryptedText = EncryptDecryptUtils.rot13Decrypt(encryptedText)
            binding.tvResultRot13.text = "Decrypted Text: $decryptedText"
        }

        return view
    }
}
