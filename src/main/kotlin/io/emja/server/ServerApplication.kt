package io.emja.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerApplication

/**
 * The main function is the entry point of the Spring Boot application.
 * @param args the command line arguments
 */
fun main(args: Array<String>) {
	runApplication<ServerApplication>(*args)
}
