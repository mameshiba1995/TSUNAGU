package com.example.yuki.tsunagu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_animal_regist.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class AnimalRegistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_regist)

        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("pet")


        tourokuBtn.setOnClickListener{

            //性別ラジオボタン
            val genderGroup: RadioGroup = findViewById(R.id.genderGroup)
            val genderId = genderGroup.checkedRadioButtonId
            val genderBtn = genderGroup.findViewById<RadioButton>(genderId)
            //種類ラジオボタン
            val typeGroup: RadioGroup = findViewById(R.id.typeGroup)
            val typeId = typeGroup.checkedRadioButtonId
            val typeBtn = typeGroup.findViewById<RadioButton>(typeId)

            //petインスタンス生成
            val pet = Animal()

            if(!nameEdit.text.isNullOrEmpty()){
                pet.name = nameEdit.text.toString()
                Log.v("name:",pet.name)
            }
            if(!ageEdit.text.isNullOrEmpty()){
                pet.age = ageEdit.text.toString()
                Log.v("age:",pet.age)
            }
            if(!areaEdit.text.isNullOrEmpty()){
                pet.area = areaEdit.text.toString()
                Log.v("area:",pet.area)
            }
            pet.gender = genderBtn.text.toString()
            Log.v("gender:",pet.gender)

            pet.type = typeBtn.text.toString()
            Log.v("type:",pet.type)

            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val formatted = current.format(formatter)
            pet.date = formatted

            ref.child(pet.name).setValue(pet)
            Toast.makeText(applicationContext, "登録しました", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
