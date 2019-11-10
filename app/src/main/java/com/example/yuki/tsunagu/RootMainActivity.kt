package com.example.yuki.tsunagu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_root_main.*
import java.util.*

class RootMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root_main)


//        val database = FirebaseDatabase.getInstance()
//        val ref = database.getReference("petList")
//
//        petCreateBtn.setOnClickListener {
//            var name: String = ""
//            var age: String = ""
//            var gender: String = ""
//            var area : String = ""
//
//
//            if(!petNameText.text.isNullOrEmpty()){
//                name = nameEdit.text.toString()
//            }
//            if(!mailEdit.text.isNullOrEmpty()){
//                mail = mailEdit.text.toString()
//            }
//            if(!passwordEdit.text.isNullOrEmpty()){
//                pass = passwordEdit.text.toString()
//            }
//
//            var mailUser = realm.where(Account::class.java).equalTo("mail", mail).findAll()
//
//            if(mailUser.size == 0) {
//
//                realm.executeTransaction {
//                    val maxId = realm.where<Account>().max("id")
//                    val nextId = (maxId?.toLong() ?: 0L) + 1L
//                    val account = realm.createObject<Account>(nextId)
//                    account.dateTime = Date()
//                    //account.name = name
//                    account.mail = mail
//                    account.pass = pass
//                }
//                Toast.makeText(applicationContext, "登録しました", Toast.LENGTH_SHORT).show()
//                finish()
//            } else {
//                Toast.makeText(applicationContext, "そのアドレスは既に使用中です。", Toast.LENGTH_SHORT).show()
//            }
//        }
    }



}
