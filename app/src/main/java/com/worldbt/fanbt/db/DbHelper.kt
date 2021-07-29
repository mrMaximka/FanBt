package com.worldbt.fanbt.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper (private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object {
        const val ASSETS_PATH = "databases"
        const val DATABASE_NAME = "game"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE greek (\n" +
                "    id   INTEGER PRIMARY KEY\n" +
                "                 NOT NULL,\n" +
                "    name STRING  NOT NULL\n" +
                ");\n\n")

        db?.execSQL("INSERT INTO greek (\n" +
                "                      id,\n" +
                "                      name\n" +
                "                  )\n" +
                "                  VALUES (\n" +
                "                      '1',\n" +
                "                      'Альфредо Ди Стефано'\n" +
                "                  ),(\n" +
                "                      '2',\n" +
                "                      'Ференц Пушкаш'\n" +
                "                  ),(\n" +
                "                      '3',\n" +
                "                      'Пеле'\n" +
                "                  ),(\n" +
                "                      '4',\n" +
                "                      'Гарринча'\n" +
                "                  ),(\n" +
                "                      '5',\n" +
                "                      'Йохан Кройф'\n" +
                "                  ),(\n" +
                "                      '6',\n" +
                "                      'Диего Марадона'\n" +
                "                  ),(\n" +
                "                      '7',\n" +
                "                      'Лионель Месси'\n" +
                "                  ),(\n" +
                "                      '8',\n" +
                "                      'Роналдо'\n" +
                "                  ),(\n" +
                "                      '9',\n" +
                "                      'Роналдиньо'\n" +
                "                  ),(\n" +
                "                      '10',\n" +
                "                      'Криштиану Роналду'\n" +
                "                  ),(\n" +
                "                      '11',\n" +
                "                      'Сидни Кросби'\n" +
                "                  ),(\n" +
                "                      '12',\n" +
                "                      'Коннор Макдэвид'\n" +
                "                  ),(\n" +
                "                      '13',\n" +
                "                      'Евгений Малкин'\n" +
                "                  ),(\n" +
                "                      '14',\n" +
                "                      'Никлас Бэкстрем'\n" +
                "                  ),(\n" +
                "                      '15',\n" +
                "                      'Райан Гецлаф'\n" +
                "                  ),(\n" +
                "                      '16',\n" +
                "                      'Остон Мэттьюз'\n" +
                "                  ),(\n" +
                "                      '17',\n" +
                "                      'Леон Драйзайтль'\n" +
                "                  ),(\n" +
                "                      '18',\n" +
                "                      'Джон Таварес'\n" +
                "                  ),(\n" +
                "                      '19',\n" +
                "                      'Стивен Стэмкос'\n" +
                "                  ),(\n" +
                "                      '20',\n" +
                "                      'Марк Шайфли'\n" +
                "                  ),(\n" +
                "                      '21',\n" +
                "                      'Руди Гобер'\n" +
                "                  ),(\n" +
                "                      '22',\n" +
                "                      'Расселл Уэстбрук'\n" +
                "                  ),(\n" +
                "                      '23',\n" +
                "                      'Д''Анджело Расселл'\n" +
                "                  ),(\n" +
                "                      '24',\n" +
                "                      'Дамиан Лиллард'\n" +
                "                  ),(\n" +
                "                      '25',\n" +
                "                      'Пол Джордж'\n" +
                "                  ),(\n" +
                "                      '26',\n" +
                "                      'Никола Йокич'\n" +
                "                  ),(\n" +
                "                      '27',\n" +
                "                      'Кевин Дюрант'\n" +
                "                  ),(\n" +
                "                      '28',\n" +
                "                      'Джеймс Харден'\n" +
                "                  ),(\n" +
                "                      '29',\n" +
                "                      'Кавай Леонард'\n" +
                "                  ),(\n" +
                "                      '30',\n" +
                "                      'Яннис Адетокунбо'\n" +
                "                  );\n")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}