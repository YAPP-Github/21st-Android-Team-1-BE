package yapp.buddycon.web.sharedCoupon.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.sharedCoupon.domain.SharedCoupon;

public interface SharedCouponJpaRepository extends JpaRepository<SharedCoupon, Long> {
}
