package io.github.coenraadhuman.test.project.singleton;

public class NoDependencySingletonCreator {

    private NoDependenciesSingleton singleton;

    public NoDependenciesSingleton getSingleton() {
        if (singleton == null) {
            singleton = new NoDependenciesSingleton();
        }
        return singleton;
    }

}
