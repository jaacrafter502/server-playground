package io.emja.server

import org.springframework.boot.actuate.info.Info
import org.springframework.boot.actuate.info.InfoContributor
import org.springframework.stereotype.Component

@Component
class CustomInfoContributor : InfoContributor {
    override fun contribute(builder: Info.Builder) {
        builder.withDetail("app", mapOf(
            "name" to "My Application",
            "description" to "This is a sample Spring Boot application.",
            "version" to "1.0.0"
        )).withDetail(
            "author", mapOf(
            "name" to "Emma Pasch",
            "email" to "info@emma.pasch.de"))
    }
}