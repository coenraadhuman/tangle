package io.github.coenraadhuman.test.project.inject;

import io.github.coenraadhuman.test.project.singleton.NoDependenciesSingleton;
import jakarta.inject.Inject;

public class ConstructorInject {

    private final NoDependenciesSingleton noDependenciesSingleton;

    @Inject
    public ConstructorInject(NoDependenciesSingleton noDependenciesSingleton) {
        this.noDependenciesSingleton = noDependenciesSingleton;
    }

    public void execute() {
        noDependenciesSingleton.action();
    }

}
