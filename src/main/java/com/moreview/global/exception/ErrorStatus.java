package com.moreview.global.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@ToString
public enum ErrorStatus {

    /**
     * Error Message Convention
     *
     * name : _(head) + Error Name status : HttpStatus
     *
     * errorCode : 400번 오류인 상황이 여러개 올텐데, 4001, 4002, 4003.. 이런식으로 설정 (해당 오류들은 MEMBER 와 관련된 400 오류들)
     * ex) Member Error, Http Status Code: 400 -> MEMBER_4000
     *
     * message : 사람이 알아볼 수 있도록 작성
     * ex) "인증이 필요합니다."
     */

    // ---------------------- S3 ----------------------
    EXCEEDING_FILE_COUNT(BAD_REQUEST, "S4001", "사진 개수가 너무 많습니다."),

    ;

    private final HttpStatus status;

    private final String errorCode;
    private final String message;
    ErrorStatus(final HttpStatus status, final String errorCode, final String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

}
