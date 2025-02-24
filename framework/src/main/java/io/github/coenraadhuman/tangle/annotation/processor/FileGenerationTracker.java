package io.github.coenraadhuman.tangle.annotation.processor;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class FileGenerationTracker {

        private final static Set<String> generatedFiles = new HashSet<>();

        public static String generateFileKey(final String packageName, final String className) {
            return String.format("%s.%s", packageName, className);
        }

        public static boolean hasNotBeenWritten(final String fileKey) {
            return !generatedFiles.contains(fileKey);
        }

        public static void addFileAsWritten(final String fileKey) {
            generatedFiles.add(fileKey);
        }

}
