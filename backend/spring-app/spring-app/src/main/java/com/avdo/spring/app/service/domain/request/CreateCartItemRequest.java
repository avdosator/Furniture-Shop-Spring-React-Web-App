package com.avdo.spring.app.service.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateCartItemRequest {

    protected final Long productId;

    protected final int quantity;
}
