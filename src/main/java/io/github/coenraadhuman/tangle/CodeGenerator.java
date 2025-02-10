package io.github.coenraadhuman.tangle;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Paths;

public class CodeGenerator {
    public static void example(String[] args) throws IOException {
        // Generate a HelloWorld class
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build())
            .build();

        // Write to file
        JavaFile javaFile = JavaFile.builder("com.example", helloWorld)
            .build();

        javaFile.writeTo(Paths.get("./src/main/java"));
    }
}
