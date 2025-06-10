package com.mera.inventarios.infrastructure.controller.response;


import lombok.Data;

@Data
public class JsonApiResponse {

    private DataWrapper data;

    public JsonApiResponse(DataWrapper data) {
        this.data = data;
    }

    public static JsonApiResponse of(String type, Object id, Object attributes) {
        return new JsonApiResponse(new DataWrapper(type, id, attributes));
    }

    @Data
    public static class DataWrapper {
        private String type;
        private Object id;
        private Object attributes;

        public DataWrapper(String type, Object id, Object attributes) {
            this.type = type;
            this.id = id;
            this.attributes = attributes;
        }
    }
}

