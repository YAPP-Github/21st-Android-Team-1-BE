package yapp.buddycon.web.coupon.adapter.out;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonsResponseDto;
import yapp.buddycon.web.coupon.domain.Coupon;
import yapp.buddycon.web.coupon.domain.CouponState;

import java.util.List;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {

}
