package section19.exercise1.services;

import java.util.Collections;
import java.util.List;

public final class CalculationService {
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        return Collections.max(list);
    }
}
