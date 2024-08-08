/*
 * This file is part of a Körber Pharma Software GmbH project.
 *
 * Copyright (c)
 *    Körber Pharma Software GmbH
 *    All rights reserved.
 *
 * This source file may be managed in different Java package structures,
 * depending on actual usage of the source file by the Copyright holders:
 *
 * for: io.pasx.* or any other Körber Pharma Software owned Internet domain
 *
 * Any use of this file as part of a software system by none Copyright holders
 * is subject to license terms.
 */
package io.emja.playground

class Rechner {

    fun calculator(args: List<String>): Any {
        try {
            println("What is the first number?")
            val a = args[0].toInt()
            println("What is the operation?")
            val op = args[1]
            println("What is the second number?")
            val b = args[2].toInt()
            print(a.toString() + op + b.toString() + " is: ")
            val result: Any = if (op == "+") {
                a + b
            } else if (op == "-") {
                a - b
            } else if (op == "/" || op == ":") {
                a / b
            } else if (op == "*") {
                a * b
            } else {
                "Invalid operation, choose one of +, -, *, /"
            }
            println(result)
            return result
        } catch (e: Exception) {
            println("Invalid input, please try again.")
            println("Error: ${e.message}")
            println("Error: ${e.javaClass.name.toString()}")
            throw e
        }
        return ""
    }
}
