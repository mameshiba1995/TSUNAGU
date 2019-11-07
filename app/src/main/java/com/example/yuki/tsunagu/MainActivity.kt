package com.example.yuki.tsunagu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginBtn.setOnClickListener{
            //ログインボタン押下
            val login =  Intent(this, LoginActivity::class.java)
            startActivity(login)
        }

        createAcountBtn.setOnClickListener{
            //新規作成ボタン押下
            val register =  Intent(this, RegisterActivity::class.java)
            startActivity(register)
        }
    }


}
