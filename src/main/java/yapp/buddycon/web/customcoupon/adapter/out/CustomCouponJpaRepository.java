package yapp.buddycon.web.customcoupon.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.customcoupon.domain.CustomCoupon;

public interface CustomCouponJpaRepository extends JpaRepository<CustomCoupon, Long> {
}
