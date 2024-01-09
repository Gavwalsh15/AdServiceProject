package ie.atu.projectadservice;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdRepository extends JpaRepository<CreateAd, Long>{

    Optional<CreateAd> findByCreateDateAndSellerEmail(String adCreateTime, String sellerEmail);
}
