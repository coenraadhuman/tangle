package io.github.coenraadhuman.test.project.singleton;

import jakarta.inject.Singleton;

@Singleton
public class NoDependenciesSingleton {

    public void action() {
        System.out.println("No dependency singleton, have been executed.");
    }

}
