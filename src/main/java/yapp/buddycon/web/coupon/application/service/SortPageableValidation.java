package yapp.buddycon.web.coupon.application.service;

import org.springframework.data.domain.Sort;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;

import java.util.Arrays;

public enum SortPageableValidation {
  COUPON_CREATED_AT_ASC_SORT("createdAt: ASC", Sort.by("createdAt").ascending(), false),
  COUPON_EXPIRE_DATE_ASC_SORT("expireDate: ASC", Sort.by("couponInfo.expireDate").ascending(), false),
  COUPON_NAME_ASC_SORT("name: ASC", Sort.by("couponInfo.name").ascending(), false),

  SHARED_COUPON_UNSHARED_ASC_SORT("createdAt: DESC", Sort.by("createdAt").descending(), true),
  SHARED_COUPON_CREATED_AT_ASC_SORT("createdAt: ASC", Sort.by("createdAt").ascending(), true),
  SHARED_COUPON_EXPIRE_DATE_ASC_SORT("expireDate: ASC", Sort.by("sharedCouponInfo.expireDate").ascending(), true),
  SHARED_COUPON_NAME_ASC_SORT("name: ASC", Sort.by("sharedCouponInfo.name").ascending(), true);

  private String inputSortProperty;
  private Sort sort;
  private boolean isSharedCoupon;

  SortPageableValidation(String inputSortProperty, Sort sort, boolean isSharedCoupon) {
    this.inputSortProperty = inputSortProperty;
    this.sort = sort;
    this.isSharedCoupon = isSharedCoupon;
  }

  public static Sort validateSortProperty(String input, boolean isSharedCoupon) {
    return Arrays.stream(SortPageableValidation.values())
      .filter(it -> it.inputSortProperty.equals(input) && it.isSharedCoupon == isSharedCoupon)
      .map(it -> it.sort)
      .findAny()
      .orElseThrow(() -> new CustomException(ErrorCode.INVALID_SORT_PROPERTY));
  }
}
