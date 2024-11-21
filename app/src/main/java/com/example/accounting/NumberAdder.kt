package com.example.accounting

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class NumberAdder(private val dispatcher: CoroutineDispatcher = Dispatchers.IO
                  ,private val delay:Int = MyConstantClass.DELAY ) {


    suspend fun add(a:Int,b:Int):Int{
        return withContext(dispatcher){
            delay(delay.toLong())
            a+b
        }
    }

}