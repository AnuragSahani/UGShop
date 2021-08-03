package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.model.request.LoginRequest;
import com.example.ugshop.network.ErrorResponse;

public class LoginResponse extends ResponseEntity {
    private ErrorResponse error;
    private boolean loginStatus;
    private LoginRequest loginModel;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return loginStatus;
    }

    public void setSuccess(boolean success) {
        this.loginStatus = success;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public LoginRequest getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginRequest loginModel) {
        this.loginModel = loginModel;
    }
}
