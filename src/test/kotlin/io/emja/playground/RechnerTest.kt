package io.emja.playground

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RechnerTest {

    @Test
    fun testMultiplikation() {
        val result = Rechner().calculator(listOf("1", "*", "2"))
        assertEquals(2, result)
    }

    @Test
    fun testDivision() {
        Rechner().calculator(listOf("1", "/", "2"))
    }
}