package com.codingshuttle.razorpay.payment.processor.dto;

//Sealed Class
public sealed interface PaymentProcessorResponse permits  PaymentProcessorResponse.Pending,PaymentProcessorResponse.Success,PaymentProcessorResponse.Failure{
    record Pending(String processRef) implements PaymentProcessorResponse{}

    record Success(String processReference,String bankReference) implements PaymentProcessorResponse{}

    record Failure(String errorCode, String errorDescription) implements PaymentProcessorResponse{}

}
