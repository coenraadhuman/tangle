package io.github.coenraadhuman.tangle;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class TangleApplication {

	public static void main(String[] args) {
		log.info("It is alive!");

        try {
            CodeGenerator.example(args);
        } catch (IOException e) {
			log.error("Can't generate file");
            throw new RuntimeException(e);
        }

    }

}
