package com.example.graphcharts

import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var lineList : ArrayList<Entry>
    lateinit var lineDataSet : LineDataSet
    lateinit var lineData : LineData


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lineList= ArrayList()
        lineList.add(Entry(10f,100f))
        lineList.add(Entry(20f,400f))
        lineList.add(Entry(30f,700f))
        lineList.add(Entry(40f,200f))
        lineList.add(Entry(50f,500f))
        lineList.add(Entry(60f,300f))
        lineList.add(Entry(70f,600f))

        lineDataSet = LineDataSet(lineList,"Count")
        lineData = LineData(lineDataSet)
        line_chart.data= lineData
        lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet!!.valueTextColor= Color.BLUE
        lineDataSet.valueTextSize = 20f

        var timeStamp = 1655996400

        var tDate = timeStampDate(timeStamp)
        var tTime = timeStampTime(timeStamp)

        println("TIME AND DATE HERE - $tTime - $tDate")

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun timeStampDate(timestamp : Int): String? {

        var milliSeconds =timestamp.toLong()

        val simpleTimeFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

        val date = simpleTimeFormat.format(milliSeconds*1000)

        println("DATE HERE $date")

        return date
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun timeStampTime(timestamp : Int): String? {

        var milliSeconds =timestamp.toLong()

        val simpleDateFormat = SimpleDateFormat("hh:mm:ss", Locale.getDefault())

        val time = simpleDateFormat.format(milliSeconds)

        println("TIME HERE $time")

        return time
    }
}