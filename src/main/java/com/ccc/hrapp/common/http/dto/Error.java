package com.ccc.hrapp.common.http.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Error extends ClientData {
    private String details;
}
