package com.example.courseapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerView.CourseHolder> {

    class CourseHolder(item: View): RecyclerView.ViewHolder(item) {
        fun bind(course: Course){

        }
    }
}