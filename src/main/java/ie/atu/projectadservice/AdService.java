package ie.atu.projectadservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdService {
    private final AdRepository adRepo;
    @Autowired
    public AdService(AdRepository adRepo) {this.adRepo = adRepo;}

    public void createAd(CreateAd ad) {adRepo.save(ad);}
}
