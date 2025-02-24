package io.github.coenraadhuman.test.project.inject;

import io.github.coenraadhuman.test.project.singleton.NoDependenciesSingleton;
import jakarta.inject.Inject;

public class FieldInject {

    @Inject
    private NoDependenciesSingleton noDependenciesSingleton;

    public void execute() {
        noDependenciesSingleton.action();
    }

}
