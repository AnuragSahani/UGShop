package com.example.ugshop.model.response;

import com.example.ugshop.network.ErrorResponse;

public class RemoveUserResponse {
    private ErrorResponse error;
    private boolean isDeleted;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
