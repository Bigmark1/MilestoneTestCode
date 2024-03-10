package com.example.inventorysystem

import com.example.inventorysystem.data.memory.FakeMemory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class AddActivityTest {

    private lateinit var dh: FakeMemory
    private lateinit var data: Data

    @Before
    fun setUp(){

        dh = FakeMemory()


        val holderList = mutableListOf<Data>()
        (1..5).forEachIndexed { index, c ->
            holderList.add(
                Data(
                    index,
                    c,
                    "Product",
                    5.5,
                    10.5
                )
            )
        }
        runBlocking {
            holderList.forEach { dh.insertItem(it) }
        }

    }

    @Test
    fun test_If_Add_Function_Is_Functioning_As_Expected(){

        runBlocking {   inventoryItem(13, "New", 5.5, 10.5) }

        assertEquals(6, dh.databaseSize() )
    }

    @Test
    fun test_If_Function_Checking_For_Duplicates_Is_Functional(){

        assertEquals(false, addCheck(3))
    }

    @Test
    fun test_If_Function_Is_Passing_NoMatches(){

        assertEquals(true, addCheck(15))

    }

    @Ignore
    fun addCheck(number: Int) : Boolean {
        var b: Boolean = true
        val  expected: Boolean = false


        if(dh.searchList(number) != -1){
            b = false
        }

        return b
    }

    @Ignore
     fun inventoryItem(number: Int, product: String, cost: Double, price: Double)  {

        try {
            data = Data(0, number, product, cost, price)

            dh.insertItem(data)
        }
        catch (e: Exception){

            e.printStackTrace()
        }



    }



    }


