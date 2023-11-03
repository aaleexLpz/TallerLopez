package es.taller.alex.controller.dtos.errors;

import java.util.List;
public class ErrorsDto {

    private List<FieldErrorDto> fieldErrors;

    private String error;

    public ErrorsDto(String error){
        this.error = error;
    }

    public ErrorsDto(List<FieldErrorDto> fieldErrors){
        this.fieldErrors = fieldErrors;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<FieldErrorDto> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorDto> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
