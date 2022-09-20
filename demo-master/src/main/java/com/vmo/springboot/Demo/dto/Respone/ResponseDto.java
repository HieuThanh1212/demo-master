package com.vmo.springboot.Demo.dto.Respone;

public class ResponseDto {
    private Integer status;
    private Object error;
    private Object data;

    public ResponseDto() {
    }

    public ResponseDto(Integer status, Object error, Object data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public ResponseDto(Object error, Object data) {
        this.error = error;
        this.data = data;
    }

    public ResponseDto(Integer status, Object error) {
        this.status = status;
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
