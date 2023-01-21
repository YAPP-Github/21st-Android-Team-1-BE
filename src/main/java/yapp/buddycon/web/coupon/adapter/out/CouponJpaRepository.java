package yapp.buddycon.web.coupon.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.coupon.domain.Coupon;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {

}
