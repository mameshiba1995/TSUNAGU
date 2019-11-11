package com.example.yuki.tsunagu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_title.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance()
    val petList = database.getReference("Info")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        petList.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                Toast.makeText(baseContext, value,
                    Toast.LENGTH_LONG).show()
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(baseContext, "読み込み失敗",
                    Toast.LENGTH_LONG).show()
            }
        })

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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            R.id.root -> {


                val regist =  Intent(this, AnimalRegistActivity::class.java)
                startActivity(regist)
            }
        }
        return super.onOptionsItemSelected(item)
    }





}
