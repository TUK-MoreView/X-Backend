//package com.moreview.global.exception;
//
//import io.swagger.v3.oas.models.responses.ApiResponse;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class ApiExceptionHandler {
//
//    @ExceptionHandler({ApiException.class})
//    public ResponseEntity<ApiExceptionResponse> handleApiException(final ApiException e) {
//        ErrorStatus errorStatus = e.getErrorStatus();
//        ApiExceptionResponse response = new ApiExceptionResponse(
//                errorStatus.getStatus().value(),
//                errorStatus.getErrorCode(),
//                errorStatus.getMessage()
//        );
//        return ResponseEntity.status(errorStatus.getStatus()).body(response);
//    }
//}
