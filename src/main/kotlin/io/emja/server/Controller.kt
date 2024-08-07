package io.emja.server

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Controller class information purposes.
 */
@RestController
@RequestMapping("/info")
class Controller {

    @GetMapping("/hello")
    fun sayHello(): String {
        return """
            <html>
                <head>
                    <title>Hello, World!</title>
                </head>
                <body>
                    <h1>Hello, World!</h1>
                    We are on the world wide web!
                </body>
            </html>
        """.trimIndent()
    }

    @GetMapping("/goodbye")
    fun sayGoodbye(): String {
        return """
            <html>
                <head>
                    <title>Goodbye, World!</title>
                </head>
                <body>
                    <h1>Goodbye, World!</h1>
                    We are leaving the world wide web!
                </body>
            </html>
        """.trimIndent()
    }
}