package com.example.technicaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.student_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = fetchData()

        val adapter = StudentAdapter(items)
        recyclerView.adapter = adapter
    }
    // ini hanya buat random address
    fun generateRandomAddress(): String {
        val streets = listOf("Jl. Merdeka", "Jl. Pahlawan", "Jl. Proklamasi", "Jl. Gatot Subroto", "Jl. Sudirman")
        val cities = listOf("Jakarta", "Surabaya", "Bandung", "Medan", "Semarang")
        val provinces = listOf("DKI Jakarta", "East Java", "West Java", "North Sumatra", "Central Java")

        val randomStreet = streets.random()
        val randomCity = cities.random()
        val randomProvince = provinces.random()

        return "$randomStreet, $randomCity, $randomProvince"
    }
    //fetching data(image) dilakukan secara local, seluruh data akan tersimpan di array studentList
    // yang kemudian dipanggil oleh recyclerview
    fun fetchData() : ArrayList<Student>{
        val studentList = ArrayList<Student>()

        studentList.add(Student("Amara Johannes", R.drawable.student_1, generateRandomAddress()))
        studentList.add(Student("Andrea Putri Sukonco", R.drawable.student_2, generateRandomAddress()))
        studentList.add(Student("Kevin Sorensen", R.drawable.student_3, generateRandomAddress()))
        studentList.add(Student("Rivo Juicer Wowor", R.drawable.student_4, generateRandomAddress()))
        studentList.add(Student("Dennis Roger Siregar", R.drawable.student_5, generateRandomAddress()))
        studentList.add(Student("Victor Albert", R.drawable.student_6, generateRandomAddress()))
        studentList.add(Student("Jessica Marline", R.drawable.student_7, generateRandomAddress()))
        studentList.add(Student("Helen Queen Victoria", R.drawable.student_8, generateRandomAddress()))
        studentList.add(Student("John Doe", R.drawable.student_9, generateRandomAddress()))
        studentList.add(Student("Prince Almighty King", R.drawable.student_10, generateRandomAddress()))

        return studentList
    }
}