package id.latihan.crud.crudrestfullapi.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDataDTO<T>{

    private boolean status;

    private List<String> message = new ArrayList<>();

    public ResponseDataDTO(boolean status, List<String> message, T payload) {
        this.status = status;
        this.message = message;
        this.payload = payload;
    }

    public ResponseDataDTO() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    private T payload;

}
