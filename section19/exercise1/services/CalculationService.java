package section19.exercise1.services;

import utils.src.CollectionUtils;

import java.util.Collections;
import java.util.List;

public final class CalculationService {
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if(CollectionUtils.isNullOrEmpty(list)){
            throw new IllegalStateException("List can't be empty");
        }

        return Collections.max(list);
    }
}
