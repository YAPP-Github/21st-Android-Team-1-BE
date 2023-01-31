package yapp.buddycon.web.coupon.application.service;

import org.springframework.data.domain.Sort;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;

import java.util.Arrays;

public enum SortPageableValidation {
  CREATED_AT_ASC_SORT("createdAt: ASC", Sort.by("createdAt").ascending()),
  EXPIRE_DATE_ASC_SORT("expireDate: ASC", Sort.by("couponInfo.expireDate").ascending()),
  NAME_ASC_SORT("name: ASC", Sort.by("couponInfo.name").ascending());

  private String inputSortProperty;
  private Sort sort;

  SortPageableValidation(String inputSortProperty, Sort sort) {
    this.inputSortProperty = inputSortProperty;
    this.sort = sort;
  }

  public static Sort validateSortProperty(String input) {
    return Arrays.stream(SortPageableValidation.values())
      .filter(it -> it.inputSortProperty.equals(input))
      .map(it -> it.sort)
      .findAny()
      .orElseThrow(() -> new CustomException(ErrorCode.INVALID_SORT_PROPERTY));
  }
}
