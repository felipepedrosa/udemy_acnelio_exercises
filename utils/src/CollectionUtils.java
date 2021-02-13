package utils.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Utility class for {@link Collection};
 */
public final class CollectionUtils {

    /**
     * Checks if a collection is null or empty.
     *
     * @param collection
     *  Collection to be checked;
     *
     * @return
     *   {@code Boolean.TRUE} if collection is null or empty, otherwise {@code Boolean.FALSE}.
     */
    public static boolean isNullOrEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isNullOrEmpty(new ArrayList<>())); // true
        System.out.println(isNullOrEmpty(Collections.singletonList("Test"))); // false
    }
}
