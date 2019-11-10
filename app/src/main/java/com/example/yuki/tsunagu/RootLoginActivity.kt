package com.example.yuki.tsunagu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_root_login.*

class RootLoginActivity : AppCompatActivity() {

    private lateinit var  realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root_login)
        realm = Realm.getDefaultInstance()

        rootLoginBtn.setOnClickListener{
            
        }
    }


}
