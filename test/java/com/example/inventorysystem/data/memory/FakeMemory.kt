package com.example.inventorysystem.data.memory

import com.example.inventorysystem.Data
import kotlinx.coroutines.runBlocking

class FakeMemory {

    private val items = mutableListOf<Data>()


    fun insertItem(item: Data) {
        items.add(item)

    }

    fun databaseSize(): Int {
        return this.items.size
    }

    fun searchList(testNumber: Int): Int {

        var answerIs: Int = -1

       var j: Int = 0

        runBlocking {
            for (i in 0 + 1..<items.size) {
                val inLine: Int = items[j].itemNumber

                if (testNumber == inLine) {
                    answerIs = items[j].itemNumber

                }
                j++
            }


        }
        return answerIs

    }

    fun getItemById(id: Int): Data? {
        return  this.getItemById(id)
    }

    fun deleteItem(item: Data) : Boolean{
       return this.items.remove(item)
    }
}



