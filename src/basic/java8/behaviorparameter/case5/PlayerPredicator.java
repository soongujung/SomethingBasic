package basic.java8.behaviorparameter.case5;

import basic.java8.behaviorparameter.Player;

@FunctionalInterface
public interface PlayerPredicator<T> {
    public boolean check(T obj, String opt);
}
