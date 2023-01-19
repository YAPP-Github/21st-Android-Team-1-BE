package yapp.buddycon.web.sharecoupon.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import yapp.buddycon.web.sharecoupon.domain.SharedCoupon;

public interface SharedCouponJpaRepository extends JpaRepository<SharedCoupon, Long> {
}
