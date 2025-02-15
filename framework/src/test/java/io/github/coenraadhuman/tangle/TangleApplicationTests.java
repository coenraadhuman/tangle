package io.github.coenraadhuman.tangle;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.Compiler;
import com.google.testing.compile.JavaFileObjects;
import io.github.coenraadhuman.tangle.annotation.processor.AnnotationProcessor;
import org.junit.jupiter.api.Test;

import javax.tools.JavaFileObject;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TangleApplicationTests {

	@Test
	public void testAnnotationProcessorGeneratesClass() {
//		JavaFileObject sourceFile = JavaFileObjects.forSourceLines(
//			"com.example.MyTestClass",
//			"package com.example;",
//			"",
//			"@io.github.coenraadhuman.tangle.Service",
//			"public class MyTestClass {}"
//		);
//
//		Compilation compilation = Compiler.javac()
//			.withProcessors(new AnnotationProcessor())
//			.compile(sourceFile);
//
//		assertThat(compilation).succeeded();
//
//		// Verify the file is generated
//		String expectedFilePath = "build/generated/sources/annotationProcessor/java/main/com/example/GeneratedClass.java";
		//assertTrue(Files.exists(Paths.get(expectedFilePath)));
	}

}
