package io.github.coenraadhuman.tangle.annotation.processor.code.generator;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Element;

public class SingletonGenerator implements CodeGenerator, ClassNameGenerator {

    @Override
    public TypeSpec generateClass(Element element, String generatedClassName) {
        return TypeSpec.classBuilder(generatedClassName)
            .addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL)
            .addMethod(MethodSpec.methodBuilder("hello")
                .addModifiers(javax.lang.model.element.Modifier.PUBLIC)
                .returns(void.class)
                .addStatement("$T.out.println($S)", System.class, "Hello from JavaPoet!")
                .build())
            .build();
    }

    @Override
    public String generatedClassName(String enclosingClassName) {
        return "%sCreator".formatted(enclosingClassName);
    }

}
