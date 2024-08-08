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
package io.emja.server

import org.springframework.stereotype.Component


/**
 * TODO Description of class...
 */
@Component
class CalculatorService {

    fun performCalculation(a: Float, b: Float, op: String): String {
        return when (op) {
            "+" -> (a + b).toString()
            "-" -> (a - b).toString()
            "*" -> (a * b).toString()
            "/", ":" -> (a / b).toString()
            else -> "Invalid operation"
        }
    }

    fun splitOperation(op: String): Array<String> {
        if (op.contains("+")) {
            return op.split("+").plus("+").toTypedArray()
        } else if (op.contains("-")) {
            return op.split("-").plus("-").toTypedArray()
        } else if (op.contains("*")) {
            return op.split("*").plus("*").toTypedArray()
        } else if (op.contains("/")) {
            return op.split("/").plus("/").toTypedArray()
        } else if (op.contains(":")) {
            return op.split(":").plus("/").toTypedArray()
        } else {
            return arrayOf("ERROR", "ERROR", "ERROR")
        }
    }
}