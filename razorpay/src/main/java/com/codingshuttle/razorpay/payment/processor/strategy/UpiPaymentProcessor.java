package com.codingshuttle.razorpay.payment.processor.strategy;

import com.codingshuttle.razorpay.common.util.RandomizerUtil;
import com.codingshuttle.razorpay.payment.processor.PaymentProcessor;
import com.codingshuttle.razorpay.payment.processor.dto.PaymentProcessorRequest;
import com.codingshuttle.razorpay.payment.processor.dto.PaymentProcessorResponse;

public class UpiPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {
        final  String VPA_CODE_FAIL = "fail@okaxis";

        String bankCode = request.methodDetails() != null ?
                request.methodDetails().get("vpa").toString() : null;
        if (VPA_CODE_FAIL.equals(bankCode)){
            return new PaymentProcessorResponse.Failure("UPI_REJECTED","Banked rejected the transaction registration");
        }
        String proceessorRef = "UPI_PROCESSOR_"+ RandomizerUtil.randomBase64(16);
        String bankRef = "BANK_REF"+RandomizerUtil.randomBase64(16);
        String redirectRef = "http://REDIRECT_BANK.com/"+proceessorRef;

        return new PaymentProcessorResponse.Success(proceessorRef,redirectRef);
    }
}
