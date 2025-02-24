package io.github.coenraadhuman.tangle.annotation.processor;

import com.google.auto.service.AutoService;
import io.github.coenraadhuman.tangle.Logger;
import io.github.coenraadhuman.tangle.annotation.processor.file.writer.FileWriter;
import io.github.coenraadhuman.tangle.annotation.processor.file.writer.JavaPoetWriter;
import io.github.coenraadhuman.tangle.annotation.processor.information.reader.InformationReader;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.Set;

@AutoService(Processor.class)
public class AnnotationProcessor extends AbstractProcessor {

    private FileWriter fileWriter;
    private Logger log;
    private Elements elementUtils;
    private Types typeUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        fileWriter = new JavaPoetWriter(processingEnv.getFiler());
        log = new Logger(processingEnv.getMessager());
        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(
            Inject.class.getCanonicalName(),
            Singleton.class.getCanonicalName()
        );
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Processing annotations...");
        var projectInformation = new InformationReader(elementUtils).retrieve(roundEnv);
        new ProcessorLogic(fileWriter, elementUtils).processProjectInformation(projectInformation);
        return false;  // Return false to allow other processors to run
    }

}
