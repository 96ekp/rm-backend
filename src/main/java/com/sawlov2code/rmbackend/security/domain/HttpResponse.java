package com.sawlov2code.rmbackend.security.domain;

public class HttpResponse {

    private int httpStatusCode; // 200, 201, 400, 500
    private String httpStatusMessage; // OK, Created, Bad Request, Internal Server Error
    private String message;

    public HttpResponse() {
    }

    public HttpResponse(int httpStatusCode, String httpStatusMessage, String message) {
        this.httpStatusCode = httpStatusCode;
        this.httpStatusMessage = httpStatusMessage;
        this.message = message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getHttpStatusMessage() {
        return httpStatusMessage;
    }

    public void setHttpStatusMessage(String httpStatusMessage) {
        this.httpStatusMessage = httpStatusMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
