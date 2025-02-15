package io.github.coenraadhuman.tangle;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import io.github.coenraadhuman.tangle.annotation.processor.file.writer.FileWriter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class CodeGenerator {

    private final FileWriter fileWriter;

    public void generateClass() {
        // Todo: this needs to be determined:
        String className = "GeneratedClass";
        String packageName = "com.example";
        var key = FileGenerationTracker.generateFileKey(packageName, className);

        try {

            if (FileGenerationTracker.hasNotBeenWritten(key)) {
                TypeSpec generatedClass = TypeSpec.classBuilder(className)
                    .addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL)
                    .addMethod(MethodSpec.methodBuilder("hello")
                        .addModifiers(javax.lang.model.element.Modifier.PUBLIC)
                        .returns(void.class)
                        .addStatement("$T.out.println($S)", System.class, "Hello from JavaPoet!")
                        .build())
                    .build();

                fileWriter.writeFile(packageName, generatedClass);

                FileGenerationTracker.addFileAsWritten(key);
                System.out.println("✅ Successfully generated: " + key);
            } else {
                System.out.println("🫣 Skipped, generated before: " + key);
            }


        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to generate class " + className, e);
        }
    }
}