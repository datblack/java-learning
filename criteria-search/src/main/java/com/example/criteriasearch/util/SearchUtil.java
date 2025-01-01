package com.example.criteriasearch.util;

import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SearchUtil {
    public static <E> Specification<E> build(Specification<E> specification) {
        return specification;
    }

    private static <E> Specification<E> doSearch(List<SingularAttribute<E, String>> attributes, String value) {
        var attr = like(attributes.get(0), value);
        for (int i = 1; i < attributes.size(); i++) {
            attr = attr.or(like(attributes.get(i), value));
        }
        return attr;
    }

    public static <E> Specification<E> like(SingularAttribute<E, String> attribute, String value) {
        if (value == null) {
            return null;
        }
        return (root, query, builder) -> builder.like(root.get(attribute), "%" + value + "%");
    }

    public static <E, T> Specification<E> equal(SingularAttribute<E, T> attribute, T value) {
        if (value == null) {
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get(attribute), value);
    }

    public static <E, T> Specification<E> notEqual(SingularAttribute<E, T> attribute, T value) {
        if (value == null) {
            return null;
        }
        return (root, query, builder) -> builder.notEqual(root.get(attribute), value);
    }

    public static <E, T> Specification<E> isNotNull(String attribute) {
        return (root, query, builder) -> builder.isNotNull(root.get(attribute));
    }

    public static <E, T> Specification<E> in(SingularAttribute<E, T> attribute, List<T> values) {
        if (values == null) {
            return null;
        }
        return (root, query, builder) -> root.get(attribute).in(values);
    }

    public static <E, T extends Comparable<? super T>> Specification<E> greaterThan(SingularAttribute<E, T> attribute, T value) {
        if (value == null) {
            return null;
        }
        return (root, query, builder) -> builder.greaterThan(root.get(attribute), value);
    }

    public static <E, T extends Comparable<? super T>> Specification<E> greaterThanOrEqualTo(SingularAttribute<E, T> attribute, T value) {
        if (value == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(attribute), value);
    }


    public static <E, T extends Comparable<? super T>> Specification<E> lessThan(SingularAttribute<E, T> attribute, T value) {
        if (value == null) {
            return null;
        }
        return (root, query, builder) -> builder.lessThan(root.get(attribute), value);
    }

    public static <E, T extends Comparable<? super T>> Specification<E> lessThanOrEqualTo(SingularAttribute<E, T> attribute, T value) {
        if (value == null) {
            return null;
        }
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get(attribute), value);
    }

}
