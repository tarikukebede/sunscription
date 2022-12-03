package com.tarikukebede.sunscription.Interfaces;

public interface ITemplateService <T,K> {
    T create(T obj);
    T get(K id);
    K delete(K id);
}
