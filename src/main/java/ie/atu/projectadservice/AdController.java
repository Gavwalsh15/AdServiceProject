package ie.atu.projectadservice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ad")
public class AdController {
    private final AdService adService;

    private final BankServiceClient bankServiceClient;


    @Autowired
    public AdController(AdService adService, BankServiceClient bankServiceClient) {
        this.adService = adService;
        this.bankServiceClient = bankServiceClient;
    }

    @PostMapping("/create")
    public ResponseEntity<String> signUp(@Valid @RequestBody CreateAd ad) {
        adService.createAd(ad);

        return new ResponseEntity<>("Ad successfully created", HttpStatus.CREATED);
    }
    @GetMapping("/getads")
    public List<CreateAd> getAllAds() {
        return adService.getAllAds();
    }

    @PostMapping("/buyproduct")
    public ResponseEntity<String> buyProduct(@RequestBody PurchaseRequest purchaseRequest) {
        bankServiceClient.buyProduct(purchaseRequest);
        adService.deleteAd(purchaseRequest.getProductTitle(), purchaseRequest.getAdCreateTime());

        return new ResponseEntity<>("Product successfully Purchased", HttpStatus.CREATED);
    }
}
