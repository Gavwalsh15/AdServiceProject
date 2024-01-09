package ie.atu.projectadservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdService {
    private final AdRepository adRepo;

    @Autowired
    public AdService(AdRepository adRepo) {
        this.adRepo = adRepo;
    }

    public void createAd(CreateAd ad) {
        adRepo.save(ad);
    }

    public List<CreateAd> getAllAds() {
        return adRepo.findAll();
    }

    public void deleteAd(String sellerEmail, String adCreateTime) {
        Optional<CreateAd> ad = adRepo.findByCreateDateAndSellerEmail(adCreateTime, sellerEmail);

        ad.ifPresent(createAd -> adRepo.deleteById(createAd.getId()));
    }
}
