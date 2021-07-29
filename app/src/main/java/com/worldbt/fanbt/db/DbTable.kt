package com.worldbt.fanbt.db

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.worldbt.fanbt.model.DreamModel
import java.lang.Exception

class DbTable {
    fun loadDream(db: SQLiteDatabase): ArrayList<DreamModel>{
        val cursor: Cursor = db.query("greek",
            null, null, null, null, null, null)

        val list: ArrayList<DreamModel> = ArrayList()

        cursor.moveToFirst()
        val id = cursor.getColumnIndex("id")
        val name = cursor.getColumnIndex("name")

        try {
            do {
                val model = DreamModel()
                model.id = cursor.getString(id)
                model.name = cursor.getString(name)
                model.image = "q" + model.id

                list.add(model)
            }while (cursor.moveToNext())
        }catch (e: Exception){
            Log.d("DB", e.message.toString())
        }
        cursor.close()

        return list
    }
}