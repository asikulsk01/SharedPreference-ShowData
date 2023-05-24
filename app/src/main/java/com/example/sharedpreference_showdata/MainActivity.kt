package com.example.sharedpreference_showdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedpreference_showdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var studentList: ArrayList<Student>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        //Declare array and RecyclerView
        //val studentListArray = arrayListOf<S>()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        studentList = arrayListOf()

        //SharedPreferences
        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val  editor = sharedPref.edit()



        //Actions on buttons
        binding.apply {
            binding.btnSave.setOnClickListener {
                val studentName = etStudentName.text.toString()
                val studentRoll = etStudentRoll.text.toString()

                editor.apply(){
                    putString("stName",studentName)
                    putString("stRoll",studentRoll)
                    apply()
                }


                //Sore the data in arrayList
                //Storing the student obj in the arrayList
                    val student = Student(studentName, studentRoll)
                    studentList.add(student)

                //clear the EditText
                etStudentName.text.clear()
                etStudentRoll.text.clear()

            }
        }


        binding.apply {
            btnDisplay.setOnClickListener {
                val sName = sharedPref.getString("stName",null)
                val sRoll = sharedPref.getString("stRoll",null)

                tvDiplayStudentName.text = sName
                tvDiplayStudentRoll.text = sRoll

                //Display the RecyclerView
                var myAdapter = MyAdapter(studentList)
                binding.recyclerView.adapter = myAdapter
                recyclerView.adapter= myAdapter

                //myRecyclerView.adapter = myAdapter

            }
        }

    }


}