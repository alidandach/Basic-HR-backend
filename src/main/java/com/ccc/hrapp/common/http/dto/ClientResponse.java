package com.ccc.hrapp.common.http.dto;

import java.util.ArrayList;
import java.util.List;

import com.ccc.hrapp.common.http.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponse<T extends ClientData> {
    private String status;
    private Integer code;
    private T data;
    private List<Violation> violations;

    public ClientResponse(StatusCode code) {
        this.code = code.getCode();
        this.status = code.getMessage();
    }

    public ClientResponse(StatusCode code, T data) {
        this.data = data;
        this.code = code.getCode();
        this.status = code.getMessage();
    }

    public void addViolation(Violation violation) {
        if (violations == null)
            violations = new ArrayList<>();
        violations.add(violation);
    }
}
