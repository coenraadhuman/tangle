package io.github.coenraadhuman.tangle.annotation.processor.file.writer;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import lombok.RequiredArgsConstructor;

import javax.annotation.processing.Filer;
import java.io.IOException;

@RequiredArgsConstructor
public class JavaPoetWriter implements FileWriter {

    private final Filer filer;

    @Override
    public void writeFile(String packageName, TypeSpec typeSpec) throws IOException {
        var file = JavaFile.builder(packageName, typeSpec).build();
        file.writeTo(filer);
    }

}
