package com.tarikukebede.sunscription.Controllers;

import com.tarikukebede.sunscription.Interfaces.ITemplateController;
import com.tarikukebede.sunscription.Services.ServiceTemplate;
import org.springframework.web.bind.annotation.*;

public class ControllerTemplate<T, K> implements ITemplateController<T, K> {

    private final ServiceTemplate<T,K> service;

    public ControllerTemplate(ServiceTemplate<T, K> service) {
        this.service = service;
    }

    @Override
    public T create(@RequestBody T obj) {
        return service.create(obj);
    }

    @Override
    public T get(@PathVariable K id) {
        return service.get(id);
    }

    @Override
    public K delete(@PathVariable K id) {
        return service.delete(id);
    }
}
