package com.example.yuki.tsunagu

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Account : RealmObject(){
    @PrimaryKey
    var id: Long = 0
    var dateTime: Date = Date()
    var name: String = ""
    var mail: String = ""
    var pass: String = ""
}