package io.github.coenraadhuman.tangle.annotation.processor.code.generator;

@FunctionalInterface
public interface ClassNameGenerator {

    String generatedClassName(String enclosingClassName);

}
