package com.example.ugshop.model.response;

public class DeleteUserProfileRequestResponse {
    private boolean successfullyUserProfileDeleted;

    public boolean isSuccessfullyUserProfileDeleted() {
        return successfullyUserProfileDeleted;
    }

    public void setSuccessfullyUserProfileDeleted(boolean successfullyUserProfileDeleted) {
        this.successfullyUserProfileDeleted = successfullyUserProfileDeleted;
    }
}
