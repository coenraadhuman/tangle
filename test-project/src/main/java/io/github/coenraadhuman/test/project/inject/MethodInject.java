package io.github.coenraadhuman.test.project.inject;

import io.github.coenraadhuman.test.project.singleton.NoDependenciesSingleton;
import jakarta.inject.Inject;

public class MethodInject {

    private NoDependenciesSingleton noDependenciesSingleton;

    @Inject
    public void setServiceB(NoDependenciesSingleton serviceB) {
        this.noDependenciesSingleton = noDependenciesSingleton;
    }

    public void execute() {
        noDependenciesSingleton.action();
    }

}
