package io.github.coenraadhuman.tangle;

import lombok.RequiredArgsConstructor;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;

@RequiredArgsConstructor
public class Logger {

    // Todo: class inclusion in logs?
    private final Messager messager;

    private void error(final String message, final Element element) {
        messager.printMessage(Diagnostic.Kind.ERROR, message, element);
    }

    private void error(final String message) {
        messager.printMessage(Diagnostic.Kind.ERROR, message);
    }

    private void note(final String message) {
        messager.printMessage(Diagnostic.Kind.NOTE, message);
    }

}
