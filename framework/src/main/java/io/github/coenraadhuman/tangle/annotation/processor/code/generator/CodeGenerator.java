package io.github.coenraadhuman.tangle.annotation.processor.code.generator;

import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Element;

@FunctionalInterface
public interface CodeGenerator {

    TypeSpec generateClass(Element element, String generatedClassName);

}
