package io.github.coenraadhuman.tangle.annotation.processor;

import com.google.auto.service.AutoService;
import io.github.coenraadhuman.tangle.CodeGenerator;
import io.github.coenraadhuman.tangle.Logger;
import io.github.coenraadhuman.tangle.Service;
import io.github.coenraadhuman.tangle.annotation.processor.file.writer.FileWriter;
import io.github.coenraadhuman.tangle.annotation.processor.file.writer.JavaPoetWriter;

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
    private Elements elements;
    private Types types;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        fileWriter = new JavaPoetWriter(processingEnv.getFiler());
        log = new Logger(processingEnv.getMessager());
        types = processingEnv.getTypeUtils();
        elements = processingEnv.getElementUtils();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Service.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Processing annotations...");
        new CodeGenerator(fileWriter).generateClass();
        return false;  // Return false to allow other processors to run
    }

}
