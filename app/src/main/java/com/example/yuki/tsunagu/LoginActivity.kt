package com.example.yuki.tsunagu


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    //Firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        LoginBtn.setOnClickListener {

            val mail = loginMailEdit.text.toString()
            val pass = loginPassEdit.text.toString()

            if(mail.equals("")){
                Toast.makeText(
                    baseContext, "メールアドレスを入力してください",
                    Toast.LENGTH_SHORT
                ).show()
            }else if(pass.equals("")) {
                Toast.makeText(
                    baseContext, "パスワードを入力してください",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                auth.signInWithEmailAndPassword(mail, pass)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                baseContext, "ログインしました。",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                baseContext, "メールアドレスまたはパスワードが違います。",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
            }
        }

        RegisterBtn.setOnClickListener {

            val mail = loginMailEdit.text.toString()
            val pass = loginPassEdit.text.toString()

            if(mail.equals("")){
                Toast.makeText(
                    baseContext, "メールアドレスを入力してください",
                    Toast.LENGTH_SHORT
                ).show()
            }else if(pass.equals("")) {
                Toast.makeText(
                    baseContext, "パスワードを入力してください",
                    Toast.LENGTH_SHORT
                ).show()
            }else if(pass.length <6) {
                Toast.makeText(
                    baseContext, "パスワードは6文字以上で入力してください",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                auth.createUserWithEmailAndPassword(mail, pass)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                baseContext, "登録しました。",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                baseContext, "登録できませんでした。",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }

    }
}
