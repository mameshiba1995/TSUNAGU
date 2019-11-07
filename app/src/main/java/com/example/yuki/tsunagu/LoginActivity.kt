package com.example.yuki.tsunagu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    //Realm
    private lateinit var  realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        realm = Realm.getDefaultInstance()


        LoginBtn.setOnClickListener{

            var mail: String = ""
            var pass: String = ""
            if(!loginMailEdit.text.isNullOrEmpty()){
                mail = loginMailEdit.text.toString()
            }
            if(!loginPassEdit.text.isNullOrEmpty()){
                pass = loginPassEdit.text.toString()
            }

            var user = realm.where(Account::class.java).equalTo("mail", mail).equalTo("pass",pass).findAll()

            if(user.size != 0){
                //画面遷移


            } else {
                Toast.makeText(applicationContext, "アドレスまたはパスワードが違います。", Toast.LENGTH_SHORT).show()
            }

        }

        ReturnBtn.setOnClickListener{
            //タイトルへ戻る
            finish()
        }
    }



}
