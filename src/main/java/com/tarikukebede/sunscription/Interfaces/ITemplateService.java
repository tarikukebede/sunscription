package com.tarikukebede.sunscription.Interfaces;

/**
 * @author Tariku Kebede
 * defaines basic operations
 * of a service
 **/
public interface ITemplateService <T,K> {
    T create(T obj);
    T get(K id);
    K delete(K id);
}
