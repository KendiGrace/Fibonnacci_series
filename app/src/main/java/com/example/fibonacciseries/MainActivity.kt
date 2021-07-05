package com.example.fibonacciseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.math.BigInteger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rvNumbers=findViewById<RecyclerView>(R.id.rvNumbers)
        rvNumbers.layoutManager=LinearLayoutManager(baseContext)
        var numAdapter=recyclerviewAdapter(sequence(100))
        rvNumbers.adapter=numAdapter

    }
    fun sequence(num:Int):List<BigInteger>{
        var numsList= MutableList<BigInteger>(num,{BigInteger.ZERO })
        var num1=BigInteger.ZERO
        var num2=BigInteger.ONE
        numsList[0]=num1
        numsList[1]=num2

        for (i in 1..num){
            var sum=num1+num2
            num1=num2
            num2=sum
            numsList[i-1]=num1
        }
        return numsList
    }



}