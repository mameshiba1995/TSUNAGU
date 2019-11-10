package com.example.yuki.tsunagu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_title.*

class TitleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)

        loginBtn.setOnClickListener{
            //ログインボタン押下
            val login =  Intent(this, LoginActivity::class.java)
            startActivity(login)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            R.id.root -> {

               // val rootlogin =  Intent(this, RootLoginActivity::class.java)
               // startActivity(rootlogin)

                 val rootmain =  Intent(this, RootMainActivity::class.java)
                 startActivity(rootmain)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
