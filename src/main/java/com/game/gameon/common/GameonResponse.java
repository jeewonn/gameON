package com.game.gameon.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Builder
@ToString
public class GameonResponse<T> {
    private Header header;
    private T result;

    public static GameonResponse<Void> success(){
        return GameonResponse.<Void>builder()
                .header(Header.builder()
                                .isSuccessful(true)
                                .statusCode(HttpStatus.OK)
                                .resultMessage("")
                        .build())
                .build();
    }

    public static <E> GameonResponse<E> of(E result){
        return GameonResponse.<E>builder()
                .header(Header.builder()
                        .isSuccessful(true)
                        .statusCode(HttpStatus.OK)
                        .resultMessage("")
                        .build())
                .result(result)
                .build();
    }

    public static <L> GameonResponse<List<L>> of(List<L> result){
        return GameonResponse.<List<L>>builder()
                .header(Header.builder()
                        .isSuccessful(true)
                        .statusCode(HttpStatus.OK)
                        .resultMessage("")
                        .build())
                .result(result)
                .build();
    }

    public static <P> GameonResponse<PagingResult<P>> of(List<P> result, int pageNumber, long totalElement){
        PagingResult<P> pagingResult = PagingResult.<P>builder()
                .content(result)
                .pageNumber(pageNumber)
                .totalElements(totalElement)
                .build();

        return GameonResponse.<PagingResult<P>>builder()
                .header(Header.builder()
                        .isSuccessful(true)
                        .statusCode(HttpStatus.OK)
                        .resultMessage("")
                        .build())
                .result(pagingResult)
                .build();
    }

    public static GameonResponse<Void> ofCodeMessage(HttpStatus httpStatus, String message){
        return GameonResponse.<Void>builder()
                .header(Header.builder()
                        .isSuccessful(false)
                        .resultMessage(message)
                        .statusCode(httpStatus)
                        .build())
                .build();
    }

    public static GameonResponse<Void> ofCodeMessage(ErrorCode errorCode, String message){
        return GameonResponse.<Void>builder()
                .header(Header.builder()
                        .isSuccessful(false)
                        .resultMessage(message)
                        .statusCode(errorCode.getHttpStatus())
                        .build())
                .build();
    }


    @ToString
    @Builder
    public static class Header {
        private boolean isSuccessful;
        private HttpStatus statusCode;
        private String resultMessage;

        @JsonProperty(value = "isSuccessful")
        public boolean isSuccessful() {
            return isSuccessful;
        }

        public int getStatusCode() {
            return statusCode.value();
        }

        public String getResultMessage() {
            return resultMessage;
        }
    }

    @ToString
    @Getter
    @Builder
    public static class PagingResult<P> {
        private long totalElements;
        private int pageNumber;
        private List<P> content;
    }
}
