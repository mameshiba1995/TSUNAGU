package com.example.yuki.tsunagu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*

class RegisterActivity : AppCompatActivity() {

    //Realm
    private lateinit var  realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        realm = Realm.getDefaultInstance()

        registerBtn.setOnClickListener{
            var name: String = ""
            var mail: String = ""
            var pass: String = ""

            if(!nameEdit.text.isNullOrEmpty()){
                name = nameEdit.text.toString()
            }
            if(!mailEdit.text.isNullOrEmpty()){
                mail = mailEdit.text.toString()
            }
            if(!passwordEdit.text.isNullOrEmpty()){
                pass = passwordEdit.text.toString()
            }

            var mailUser = realm.where(Account::class.java).equalTo("mail", mail).findAll()

            if(mailUser.size == 0) {

                realm.executeTransaction {
                    val maxId = realm.where<Account>().max("id")
                    val nextId = (maxId?.toLong() ?: 0L) + 1L
                    val account = realm.createObject<Account>(nextId)
                    account.dateTime = Date()
                    account.name = name
                    account.mail = mail
                    account.pass = pass
                }
                Toast.makeText(applicationContext, "登録しました", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(applicationContext, "そのアドレスは既に使用中です。", Toast.LENGTH_SHORT).show()
            }
        }

        registBackBtn.setOnClickListener{
            //タイトルへ戻る
            finish()
        }
    }

}
