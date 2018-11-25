package ru.milovtim.prototypebeans


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

import java.util.function.Function

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE

@Configuration
class Prots {
    @Bean
    Function<String, Worker> workerFactory() {
        { type ->
            switch (type) {
                case 'prototype':
                    stdoutWorker()
                    break
                case 'singleton':
                    stdoutSingletonWorker()
                    break
                default:
                    throw new IllegalStateException("Unknown type of worker: '$type'")
            }
        }
    }

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    Worker stdoutWorker() {
        new WorkerImpl('Prototype')
    }

    @Bean
    Worker stdoutSingletonWorker() {
        new WorkerImpl('Singleton')
    }
}
