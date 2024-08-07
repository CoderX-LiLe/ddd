package com.freetime.ddd.orm.repository;

public enum Predicate {
    IS_EQUAL,
    NOT_EQUAL,
    IS_IN,
    IS_BETWEEN,
    NOT_BETWEEN,
    LIKE,
    LIKE_LEFT,
    LIKE_RIGHT,
    NOT_LIKE,
    IS_NOT_NULL,
    ORDER_ASC,
    ORDER_DESC,
    LAST;
}
