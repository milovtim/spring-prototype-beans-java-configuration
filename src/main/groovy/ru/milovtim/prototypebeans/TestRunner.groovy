package ru.milovtim.prototypebeans


import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

import java.util.function.Function

@Component
class TestRunner implements ApplicationRunner {

    final Function<String, Worker> workerFactory

    //@autowired does not required in constructor-based injection for sprint 4+
    TestRunner(Function<String, Worker> workerFactory) {
        this.workerFactory = workerFactory
    }

    @Override
    void run(ApplicationArguments args) throws Exception {
        def prototype1 = evaluateWorker('prototype')
        def prototype2 = evaluateWorker('prototype')
        println "prototype beans ARE THE SAME instances: ${prototype1.is(prototype2)}"

        def singleton1 = evaluateWorker('singleton')
        def singleton2 = evaluateWorker('singleton')
        println "singleton beans ARE THE SAME instances: ${singleton1.is(singleton2)}"
    }

    /**
     * obtain instance of bean from factory function and print its id
     */
    private Worker evaluateWorker(String type) {
        workerFactory.apply(type).with(true) {
            println "Use ${it.id()}"
        }
    }
}
