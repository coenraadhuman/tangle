package io.github.coenraadhuman.tangle.annotation.processor;

import io.github.coenraadhuman.tangle.annotation.processor.code.generator.ClassNameGenerator;
import io.github.coenraadhuman.tangle.annotation.processor.code.generator.CodeGenerator;
import io.github.coenraadhuman.tangle.annotation.processor.code.generator.SingletonGenerator;
import io.github.coenraadhuman.tangle.annotation.processor.file.writer.FileWriter;
import io.github.coenraadhuman.tangle.annotation.processor.model.ProjectInformation;
import lombok.RequiredArgsConstructor;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.io.IOException;

@RequiredArgsConstructor
public class ProcessorLogic {

    private final FileWriter fileWriter;
    private final Elements elementUtils;

    public void processProjectInformation(final ProjectInformation projectInformation) {
        var singletonGenerator = new SingletonGenerator();
        projectInformation.singletons().forEach(singleton -> processAnnotation(singletonGenerator, singletonGenerator, singleton));
    }

    public void processAnnotation(CodeGenerator codeGenerator, ClassNameGenerator classNameGenerator, Element element) {
        if (element instanceof TypeElement typeElement) {

            var packageName = elementUtils.getPackageOf(typeElement).toString();
            var className = typeElement.getSimpleName().toString();

            var key = FileGenerationTracker.generateFileKey(packageName, className);

            try {
                if (FileGenerationTracker.hasNotBeenWritten(key)) {
                    var generatedClassName = classNameGenerator.generatedClassName(className);
                    var typeSpec = codeGenerator.generateClass(element, generatedClassName);
                    fileWriter.writeFile(packageName, typeSpec);
                    FileGenerationTracker.addFileAsWritten(key);
                } else {
                    System.out.println("🫣 Skipped, generated before: " + key);
                }
            } catch (IOException e) {
                throw new RuntimeException("❌ Failed to generate class " + className, e);
            }
        }
    }

}