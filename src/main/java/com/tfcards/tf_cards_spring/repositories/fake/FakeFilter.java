package com.tfcards.tf_cards_spring.repositories.fake;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FakeFilter<T> {

    private Set<Predicate<T>> filters;

    public FakeFilter() {
        this.filters = new HashSet<Predicate<T>>();
    }

    public Collection<T> filter(Collection<T> pListToFilter) {
        Set<T> filteredCollect = pListToFilter.stream().filter(this::validate).collect(Collectors.toSet());
        return filteredCollect;
    }

    public Predicate<T> getFilterPredicate(T pObj) {
        return this::validate;
    }

    protected boolean validate(T pObj) {
        short filterPassed = (short) this.filters.stream().filter(f -> f.test(pObj)).count();
        return (filterPassed == (getFilters().size() - 1));
    }

    public void addFilter(Predicate<T> pNewFilter) {
        this.filters.add(pNewFilter);
    }

    public Set<Predicate<T>> getFilters() {
        return filters;
    }
}
