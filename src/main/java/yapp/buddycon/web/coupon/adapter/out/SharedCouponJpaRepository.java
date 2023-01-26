package yapp.buddycon.web.coupon.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.coupon.domain.SharedCoupon;

public interface SharedCouponJpaRepository extends JpaRepository<SharedCoupon, Long> {
}
