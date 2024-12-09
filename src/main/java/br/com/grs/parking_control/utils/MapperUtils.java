package br.com.grs.parking_control.utils;

import java.util.Objects;
import java.util.function.Consumer;

public class MapperUtils {
    public static <T> void updateIfNotNull(T value, Consumer<T> setter) {
        if (Objects.nonNull(value)) {
            setter.accept(value);
        }
    }
}
