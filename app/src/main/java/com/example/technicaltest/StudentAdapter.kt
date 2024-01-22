package com.example.technicaltest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewStudentName: TextView = itemView.findViewById(R.id.textViewStudentName)
        private val imageViewStudent: ImageView = itemView.findViewById(R.id.imageViewStudent)
        private val textViewStudentAddress: TextView = itemView.findViewById(R.id.textViewStudentAddress)

        fun bind(student: Student) {
            textViewStudentName.text = student.name
            imageViewStudent.setImageResource(student.image)
            textViewStudentAddress.text = student.address
        }
    }
}
