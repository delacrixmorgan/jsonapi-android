package com.delacrixmorgan.jsonapi.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delacrixmorgan.jsonapi.android.model.Course
import com.delacrixmorgan.jsonapi.android.model.Path
import kotlinx.serialization.json.Json
import org.json.JSONArray
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    private fun loadData() {
        val paths = processPath(R.raw.path)
        val courses = processCourse(R.raw.course)
    }

    private fun processPath(rawFile: Int): ArrayList<Path> {
        val inputStream = resources.openRawResource(rawFile)
        val responseObject = inputStream.bufferedReader().use(BufferedReader::readText)

        val jsonArray = JSONArray(responseObject)
        val paths = arrayListOf<Path>()

        for (index in 0 until jsonArray.length()) {
            val path = Json.parse(Path.serializer(), jsonArray[index].toString())
            paths.add(path)
        }

        return paths
    }

    private fun processCourse(rawFile: Int): ArrayList<Course> {
        val inputStream = resources.openRawResource(rawFile)
        val responseObject = inputStream.bufferedReader().use(BufferedReader::readText)

        val jsonArray = JSONArray(responseObject)
        val courses = arrayListOf<Course>()

        for (index in 0 until jsonArray.length()) {
            val path = Json.parse(Course.serializer(), jsonArray[index].toString())
            courses.add(path)
        }

        return courses
    }
}