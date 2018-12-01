package ru.milovtim.prototypebeans

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired

class WorkerImpl implements Worker, InitializingBean {

    private static int COUNTER = 0

    final String name
    private Classifier classifier

    WorkerImpl(String name) {
        this.name = "$name(${++COUNTER})"
    }

    @Autowired
    void setClassifier(Classifier classifier) {
        this.classifier = classifier
    }

    @Override
    String id() {
        "worker: '$name'"
    }

    @Override
    void afterPropertiesSet() throws Exception {
        println "Worker '$name ($classifier.specific)' initialized"
    }
}
