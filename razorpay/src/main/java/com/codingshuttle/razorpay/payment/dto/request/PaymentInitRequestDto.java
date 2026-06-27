package com.codingshuttle.razorpay.payment.dto.request;

import com.codingshuttle.razorpay.common.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;

import java.util.Map;
import java.util.UUID;

public record PaymentInitRequestDto(
        @NotNull(message = "Order id is required")
        UUID orderId,

        @NotNull(message = "payment method is required")
        PaymentMethod method,

        Map<String,Object> methodDetails
) {
}
