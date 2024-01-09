package ie.atu.projectadservice;


import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "bank-service", url = "http://localhost:8083")
@Component
public interface BankServiceClient{
    @PostMapping("/api/transaction/buynow")
    String buyProduct(PurchaseRequest purchaseRequest);
}
