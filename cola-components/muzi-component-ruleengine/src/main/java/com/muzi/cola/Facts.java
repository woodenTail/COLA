package com.muzi.cola;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Facts  implements Iterable<Fact<?>> {

    Set<Fact<?>> facts;

    public Facts() {
        this.facts = new HashSet<>();
    }

    public void add(Fact<?> fact) {
        facts.add(fact);
    }

    public <T>T get(String factName) {

        for (Fact<?> fact : facts) {
            if (fact.name.equals(factName)) {
                return (T)fact.getValue();
            }
        }
        return null;
    }

    @Override
    public Iterator<Fact<?>> iterator() {
        return facts.iterator();
    }

    @Override
    public void forEach(Consumer<? super Fact<?>> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Fact<?>> spliterator() {
        return Iterable.super.spliterator();
    }
}
