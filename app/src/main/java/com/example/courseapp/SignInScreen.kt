package com.example.courseapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.courseapp.databinding.ActivityMainBinding

class SignInScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        emailFocuslistener()
        passwordFocuslistener()

        binding.bSignIn.setOnClickListener { validForm() }
        binding.bVk.setOnClickListener { vkButtonClick() }
        binding.bOk.setOnClickListener { okButtonClick() }
    }

    private fun validForm() {

        binding.edEmailContainer.helperText = validEmail()
        binding.edPasswordContainer.helperText = validPassword()

        val validEmail = binding.edEmailContainer.helperText == null
        val validPassword = binding.edPasswordContainer.helperText == null
        val intent = Intent(this@SignInScreen, MainScreen::class.java)

        if (validEmail && validPassword)
            startActivity(intent)
    }

    private fun emailFocuslistener() {
        binding.edEmail.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.edEmailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.edEmail.text.toString()
        if (emailText.isEmpty()){
            return "Укажите Email"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Неверный Email"
        }
        return null
    }

    private fun passwordFocuslistener() {
        binding.edPassword.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.edPasswordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.edPassword.text.toString()
        if (passwordText.isEmpty()){
            return "Укажите пароль"
        }
        return null
    }

    private fun vkButtonClick(){
        val url = Uri.parse("https://vk.com/")
        val intent = Intent(Intent.ACTION_VIEW, url)
        startActivity(intent)
    }

    private fun okButtonClick(){
        val url = Uri.parse("https://ok.ru/")
        val intent = Intent(Intent.ACTION_VIEW, url)
        startActivity(intent)
    }
}