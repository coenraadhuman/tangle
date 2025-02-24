package io.github.coenraadhuman.tangle.annotation.processor.information.reader;

import io.github.coenraadhuman.tangle.annotation.processor.model.ProjectInformation;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import java.util.Set;

@RequiredArgsConstructor
public class InformationReader {

    private final Elements elements;

    public ProjectInformation retrieve(final RoundEnvironment roundEnvironment) {
        var singletons = getSingletons(roundEnvironment);
        var injects = getInjects(roundEnvironment);
        return new ProjectInformation(singletons, injects);
    }

    private Set<? extends Element> getSingletons(final RoundEnvironment roundEnvironment) {
        return roundEnvironment.getElementsAnnotatedWith(Singleton.class);
    }

    private Set<? extends Element> getInjects(final RoundEnvironment roundEnvironment) {
        return roundEnvironment.getElementsAnnotatedWith(Inject.class);
    }

}
