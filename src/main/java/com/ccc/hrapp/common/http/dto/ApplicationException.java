package com.ccc.hrapp.common.http.dto;

import com.ccc.hrapp.common.http.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationException extends RuntimeException {
    protected StatusCode statusCode;
    protected String logMessage;

    protected String clientMessage;

    protected Object[] parameters;

    public ApplicationException(StatusCode statusCode, String logMessage, Object... param) {
        super(statusCode.getMessage(), null, true, false);
        this.statusCode = statusCode;
        this.logMessage = logMessage;
        this.clientMessage = statusCode.getMessage();
        this.parameters = param;
    }

    public ApplicationException(StatusCode statusCode, String clientMessage) {
        super(statusCode.getMessage(), null, true, false);
        this.statusCode = statusCode;
        this.logMessage = clientMessage;
        this.clientMessage = clientMessage;
    }

}
