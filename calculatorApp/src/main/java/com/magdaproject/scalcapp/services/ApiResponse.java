package com.magdaproject.scalcapp.services;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ApiResponse<T> {

    @NonNull private final Status status;
    @Nullable private final T data;
    @Nullable private final String message;

    private ApiResponse(@NonNull Status status, @Nullable T data,
                        @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(@NonNull T data) {
        return new ApiResponse<>(Status.SUCCESS, data, null);
    }

    public static <T> ApiResponse<T> error(String msg, @Nullable T data) {
        return new ApiResponse<>(Status.ERROR, data, msg);
    }


    public enum Status {SUCCESS, ERROR}

    @NonNull
    public Status getStatus() {
        return status;
    }

    @Nullable
    public T getData() {
        return data;
    }

    @Nullable
    public String getMessage() {
        return message;
    }

}
