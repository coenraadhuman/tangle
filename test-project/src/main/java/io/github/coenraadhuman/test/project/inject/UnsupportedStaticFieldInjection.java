package io.github.coenraadhuman.test.project.inject;

import io.github.coenraadhuman.test.project.singleton.NoDependenciesSingleton;
import jakarta.inject.Inject;

public class UnsupportedStaticFieldInjection {

    @Inject
    private static NoDependenciesSingleton noDependenciesSingleton;

    public void execute() {
        noDependenciesSingleton.action();
    }

}
