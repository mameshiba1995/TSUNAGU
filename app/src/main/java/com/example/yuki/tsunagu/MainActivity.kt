package com.example.yuki.tsunagu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_title.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dogBtn.setOnClickListener{
            //犬検索ボタン押下
            val search =  Intent(this, SearchResultActivity::class.java)
            startActivity(search)
        }

        catBtn.setOnClickListener{
            //猫検索ボタン押下
            val search =  Intent(this, SearchResultActivity::class.java)
            startActivity(search)
        }

        etcBtn.setOnClickListener{
            //その他検索ボタン押下
            val search =  Intent(this, SearchResultActivity::class.java)
            startActivity(search)
        }
    }





}
