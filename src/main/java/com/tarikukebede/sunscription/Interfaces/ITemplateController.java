package com.tarikukebede.sunscription.Interfaces;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface ITemplateController <T, K> {
    @PostMapping
    T create(T obj);
    @GetMapping("/{id}")
    T get(@PathVariable K id);
    @DeleteMapping
    K delete(@PathVariable K id);
}
