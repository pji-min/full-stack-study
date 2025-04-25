package kr.mooner510.dsmpractice

import kr.mooner510.dsmpractice.global.security.jwt.JwtProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(JwtProperties::class)
class DsmPracticeApplication

fun main(args: Array<String>) {
    runApplication<DsmPracticeApplication>(*args)
}
