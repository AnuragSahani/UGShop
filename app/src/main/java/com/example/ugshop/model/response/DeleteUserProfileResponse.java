package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;

public class DeleteUserProfileResponse extends ResponseEntity {
    private boolean successfullyUserProfileDeleted;

    public boolean isSuccessfullyUserProfileDeleted() {
        return successfullyUserProfileDeleted;
    }

    public void setSuccessfullyUserProfileDeleted(boolean successfullyUserProfileDeleted) {
        this.successfullyUserProfileDeleted = successfullyUserProfileDeleted;
    }
}
