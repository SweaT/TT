package com.example.TT.dto.response;

import org.springframework.http.HttpStatus;

public record DefaultRs(HttpStatus statusCode, String message) {

    public static DefaultRs getSuccess() {
        return new DefaultRs(HttpStatus.OK, "Ok");
    }

    public static DefaultRs getClientFail() {
        return new DefaultRs(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    public static DefaultRs getServerFail() {
        return new DefaultRs(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

}
