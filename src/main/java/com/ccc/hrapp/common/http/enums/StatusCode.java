package com.ccc.hrapp.common.http.enums;

import lombok.Getter;

@Getter
public enum StatusCode {
    /*
     * Entry For Success Scenario
     */
    SUCCESS(1000, "Success"),

    /*
     * Entry For Application Error
     */
    INVALID_PARAMETERS(2000, "Validation Failure"),
    INVALID_METHOD_ARGUMENTS(2001, "Invalid Method Argument"),
    HTTP_METHOD_NOT_SUPPORTED(2002, "HTTP Method Not Supported"),
    RECORD_NOT_FOUND(2003, "Record Not Found"),
    NO_MENU_OPTION_FOUND(2004, "No Menu Option Found"),
    DUPLICATE_RECORD(2005, "Duplicate Record"),
    DUPLICATE_OPERATION_KEY(2006, "Duplicate Operation Key"),
    DUPLICATE_TITLE_OPTION(2007, "Duplicate Tile Option"),
    ILLEGAL_NAVIGATION(2008, "Connection problem or invalid MMI code"),
    VALIDATION_NAVIGATION_FAILURE(2009, "Connection problem or invalid MMI code"),
    /*
     * Entry For UN_HANDLED Exceptions
     */
    INTERNAL_SERVER_ERROR(5000, "Internal Server Error");

    private final int code;
    private final String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}