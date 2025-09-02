package com.muzi.cola;

public interface Rule {

    boolean evaluate(Facts facts);

    void execute(Facts facts);

    void apply(Facts facts);
}
