package ru.milovtim.prototypebeans

import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PrototypeBeansApplication {

    static void main(String[] args) {
        new SpringApplication(PrototypeBeansApplication).with {
            bannerMode = Banner.Mode.OFF
            run(args)
        }
    }
}
