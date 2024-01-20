package com.example.finalterm

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addAppointment(appointment: Appointment): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        var row: Long = 0
        try
        {
            values.put("title", appointment.title)
            values.put("date", appointment.date)
            values.put("specialist", appointment.specialist)
            values.put("appointmentDate", appointment.appointmentDate)
            values.put("price", appointment.price)
            row = db.insert(TABLE_NAME, null, values)
        }
        catch (e: Exception)
        {
            Log.d("insert error", "$e")
        }
        finally {
            db.close()

        }
        return row
    }

    @SuppressLint("Range")
    fun selectAll(): MutableList<Appointment> {
        val appointments = mutableListOf<Appointment>()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val title = cursor.getString(cursor.getColumnIndex("title"))
                val date = cursor.getString(cursor.getColumnIndex("date"))
                val appointmentDate = cursor.getString(cursor.getColumnIndex("appointmentDate"))
                val specialist = cursor.getString(cursor.getColumnIndex("specialist"))
                val price = cursor.getDouble(cursor.getColumnIndex("price"))
                val appointment = Appointment(title, date, specialist, appointmentDate, price)
                appointments.add(appointment)

            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return appointments
    }
    companion object {
        private const val DATABASE_NAME = "salon.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "appointments"
        private const val CREATE_TABLE = "CREATE TABLE $TABLE_NAME " +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "date TEXT NOT NULL," +
                "specialist TEXT NOT NULL," +
                "appointmentDate TEXT NOT NULL," +
                "price REAL" +
                ");"
    }
}
