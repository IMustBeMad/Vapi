package vapidsl.domain.string;

import lombok.experimental.UtilityClass;
import vapidsl.common.SingleCondition;

@UtilityClass
public class StringConditions {

    public static SingleCondition<String> matches(String pattern) {
        return new SingleCondition<>(it -> it.matches(pattern));
    }

    public static SingleCondition<String> isEqual(String otherString) {
        return new SingleCondition<>(it -> it.equals(otherString));
    }

    public static SingleCondition<String> isNotEqual(String otherString) {
        return new SingleCondition<>(it -> !it.equals(otherString));
    }

    public static SingleCondition<String> isEmpty() {
        return new SingleCondition<>(String::isEmpty);
    }

    public static SingleCondition<String> isNotEmpty() {
        return new SingleCondition<>(it -> !it.isEmpty());
    }

    public static SingleCondition<String> isBlank() {
        return new SingleCondition<>(it -> it == null || it.isEmpty());
    }

    public static SingleCondition<String> isNotBlank() {
        return new SingleCondition<>(it -> it != null && !it.isEmpty());
    }

    public static SingleCondition<String> startsWith(String prefix) {
        return new SingleCondition<>(it -> it.startsWith(prefix));
    }

    public static SingleCondition<String> hasLength(int length) {
        return new SingleCondition<>(it -> it.length() == length);
    }

    public static SingleCondition<String> contains(String text) {
        return new SingleCondition<>(it -> it.contains(text));
    }
}
