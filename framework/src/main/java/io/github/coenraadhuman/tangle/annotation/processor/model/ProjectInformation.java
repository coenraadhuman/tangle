package io.github.coenraadhuman.tangle.annotation.processor.model;

import javax.lang.model.element.Element;
import java.util.Set;

public record ProjectInformation(
    Set<? extends Element> singletons,
    Set<? extends Element> injects
) {
}
