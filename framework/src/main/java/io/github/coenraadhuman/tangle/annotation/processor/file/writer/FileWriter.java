package io.github.coenraadhuman.tangle.annotation.processor.file.writer;

import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

public interface FileWriter {

    void writeFile(String packageName, TypeSpec typeSpec) throws IOException;

}
