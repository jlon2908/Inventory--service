//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.global;

import com.arka.inventory_service.domain.exception.customerOrder.CustomerOrderNotFoundException;
import com.arka.inventory_service.domain.exception.inventory.SkuNotFoundException;
import com.arka.inventory_service.domain.exception.warehouse.CatalogServiceUnavailableException;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseNotFoundByCodeException;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseNotFoundByIdException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({SkuNotFoundException.class})
    public Mono<ErrorResponse> handleSkuNotFoundException(SkuNotFoundException ex, ServerWebExchange exchange) {
        return Mono.just(ErrorResponse.builder().timestamp(LocalDateTime.now()).status(HttpStatus.NOT_FOUND.value()).error(HttpStatus.NOT_FOUND.getReasonPhrase()).message(ex.getMessage()).path(exchange.getRequest().getPath().value()).errorCode("INVENTORY-ERROR-404").validationErrors((List)null).build()).doOnNext((response) -> exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler({WarehouseNotFoundByCodeException.class})
    public Mono<ErrorResponse> handleWarehouseNotFoundByCodeException(WarehouseNotFoundByCodeException ex, ServerWebExchange exchange) {
        return Mono.just(ErrorResponse.builder().timestamp(LocalDateTime.now()).status(HttpStatus.NOT_FOUND.value()).error(HttpStatus.NOT_FOUND.getReasonPhrase()).message(ex.getMessage()).path(exchange.getRequest().getPath().value()).errorCode("INVENTORY-ERROR-404").validationErrors((List)null).build()).doOnNext((response) -> exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler({CustomerOrderNotFoundException.class})
    public Mono<ErrorResponse> handleCustomerOrderNotFoundException(CustomerOrderNotFoundException ex, ServerWebExchange exchange) {
        return Mono.just(ErrorResponse.builder().timestamp(LocalDateTime.now()).status(HttpStatus.NOT_FOUND.value()).error(HttpStatus.NOT_FOUND.getReasonPhrase()).message(ex.getMessage()).path(exchange.getRequest().getPath().value()).errorCode("INVENTORY-ORDER-404").validationErrors((List)null).build()).doOnNext((response) -> exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler({WarehouseNotFoundByIdException.class})
    public Mono<ErrorResponse> handleWarehouseNotFoundByIdException(WarehouseNotFoundByIdException ex, ServerWebExchange exchange) {
        return Mono.just(ErrorResponse.builder().timestamp(LocalDateTime.now()).status(HttpStatus.NOT_FOUND.value()).error(HttpStatus.NOT_FOUND.getReasonPhrase()).message(ex.getMessage()).path(exchange.getRequest().getPath().value()).errorCode("INVENTORY-ERROR-404").validationErrors((List)null).build()).doOnNext((response) -> exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler({CatalogServiceUnavailableException.class})
    public Mono<ErrorResponse> handleCatalogServiceUnavailableException(CatalogServiceUnavailableException ex, ServerWebExchange exchange) {
        return Mono.just(ErrorResponse.builder().timestamp(LocalDateTime.now()).status(HttpStatus.SERVICE_UNAVAILABLE.value()).error(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase()).message(ex.getMessage()).path(exchange.getRequest().getPath().value()).errorCode("INVENTORY-ERROR-503").validationErrors((List)null).build()).doOnNext((response) -> exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE));
    }

    @ExceptionHandler({ValidationException.class})
    public Mono<ErrorResponse> handleValidationException(ValidationException ex, ServerWebExchange exchange) {
        return Mono.fromRunnable(() -> exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST)).then(Mono.just(ErrorResponse.builder().timestamp(LocalDateTime.now()).status(HttpStatus.BAD_REQUEST.value()).error(HttpStatus.BAD_REQUEST.getReasonPhrase()).message("Validation failed").path(exchange.getRequest().getPath().value()).errorCode("INVENTORY-ERROR-400").validationErrors(ex.getErrors()).build()));
    }
}
