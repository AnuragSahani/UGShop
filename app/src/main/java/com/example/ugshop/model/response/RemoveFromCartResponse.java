package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;

public class RemoveFromCartResponse extends ResponseEntity {
    private boolean appError;
    private boolean removed;

    @Override
    public String toString() {
        return "RemoveFromCartResponse{" +
                "appError=" + appError +
                ", removed=" + removed +
                '}';
    }

    public boolean isAppError() {
        return appError;
    }

    public void setAppError(boolean appError) {
        this.appError = appError;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}
