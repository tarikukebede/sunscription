package com.tarikukebede.sunscription.Services;

import com.tarikukebede.sunscription.Http.HttpResponses;
import com.tarikukebede.sunscription.Interfaces.ITemplateService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

/**
 * @author Tariku kebede
 * defines the basic api operations
 **/
public class ServiceTemplate<T, K> implements ITemplateService<T, K> {


    protected  T t;
    private final JpaRepository<T, K> repository;

    public ServiceTemplate(JpaRepository<T, K> repository, T t){
        this.repository = repository;
        this.t = t;
    }

    public T create(T obj){
        try {
            return repository.save(obj);
        }catch (Exception e){
            e.printStackTrace();
            throw errorWhileProcessing();
        }
    }

    public T get(K id){
        Optional<T> result;
        try {
            result =  repository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw  errorWhileProcessing();
        }

        if(result.isEmpty()){
            throw notFound(id);
        }else{
            return result.get();
        }
    }

    public K delete(K id){
        if(existsById(id)){
            try{
                repository.deleteById(id);
                return id;
            }catch (Exception e){
                throw errorWhileProcessing();
            }
        }else {
            throw badRequest();
        }
    }

    public boolean existsById(K id){
        try {
            return repository.existsById(id);
        }catch (Exception e){
            throw errorWhileProcessing();
        }
    }

    public ResponseStatusException notFound(K id){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                HttpResponses.notFoundResponse(t, id));
    }

    public ResponseStatusException errorWhileProcessing(){
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                HttpResponses.errorWhileProcessing(t));
    }

    public ResponseStatusException badRequest(){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                HttpResponses.badRequest(t));
    }
}
