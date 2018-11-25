package ru.milovtim.prototypebeans

import org.springframework.beans.factory.InitializingBean

class WorkerImpl implements Worker, InitializingBean {

    private static int COUNTER = 0

    final String name

    WorkerImpl(String name) {
        this.name = "$name(${++COUNTER})"
    }

    @Override
    String id() {
        "worker: '$name'"
    }

    @Override
    void afterPropertiesSet() throws Exception {
        println "Worker '$name' initialized"
    }
}
