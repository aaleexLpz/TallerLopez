package es.taller.alex.controller.dtos.errors;

import org.springframework.validation.FieldError;

public class FieldErrorDto {

    private String field;

    private String message;

    public FieldErrorDto(String field, String message){
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
