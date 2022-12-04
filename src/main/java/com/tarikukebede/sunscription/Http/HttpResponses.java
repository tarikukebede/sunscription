package com.tarikukebede.sunscription.Http;

import com.tarikukebede.sunscription.Utils.Reflection;

public class HttpResponses {
    public static final String NOT_FOUND = "Sorry! There is no entity matching the given Id of ${id}";
    public static final String NOT_RECORD_FOR_SEARCH_PARAM = "Sorry! Unable to find entity for search parameter of field";
    public static final String NO_RECORD_FOUND = "Sorry! No record found for the given request";
    public static final String BAD_REQUEST = "Bad request! error occurred while processing entity";
    public static final String DUPLICATION_NOT_ALLOWED = "Sorry! creating multiple entities with same field attribute is not allowed";
    public static final String INTERNAL_ERROR = "Ops! we encountered a problem while processing entity.";

    public static <T, K> String notFoundResponse(T obj, K k){
        return NOT_FOUND.replace("entity", Reflection.getClassName(obj)).replace("${id}", String.valueOf(k));
    }

    public static <T> String notFoundBySearchParamResponse(T obj, String searchParam) {
        return NOT_RECORD_FOR_SEARCH_PARAM.replace("entity", Reflection.getClassName(obj)).replace("field", searchParam);
    }

    public static <T> String duplicateResponse(T obj, String duplicate){
        return DUPLICATION_NOT_ALLOWED.replace("entities", Reflection.getClassName(obj)).replace("filed", duplicate);
    }

    public static <T> String errorWhileProcessing(T obj){
        return INTERNAL_ERROR.replace("entity", Reflection.getClassName(obj));
    }

    public static <T> String badRequest(T obj){
        return BAD_REQUEST.replace("entity", Reflection.getClassName(obj));
    }
}
