package yapp.buddycon.web.coupon.adapter.in;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.auth.adapter.out.AuthMember;
import yapp.buddycon.web.coupon.adapter.in.request.*;
import yapp.buddycon.web.coupon.adapter.in.response.CouponsResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.CustomCouponInfoResponseDto;
import yapp.buddycon.web.coupon.adapter.in.response.GifticonInfoResponseDto;
import yapp.buddycon.web.coupon.application.port.in.CouponUseCase;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/coupon/")
public class CouponController {

  private final CouponUseCase couponUseCase;

  @GetMapping("gifticon")
  @Operation(summary = "기프티콘 정렬 조회")
  public List<CouponsResponseDto> getSortedGifticons(@RequestParam("usable") boolean usable, Pageable pageable, AuthMember authMember) {
    return null;
  }

  @GetMapping("custom-coupon")
  @Operation(summary = "제작티콘 정렬 조회")
  public List<CouponsResponseDto> getSortedCustomCoupons(@RequestParam("usable") boolean usable, Pageable pageable, AuthMember authMember) {
    return null;
  }

  @GetMapping("gifticon/{id}")
  @Operation(summary = "기프티콘 상세 조회")
  public GifticonInfoResponseDto getGifticonInfo(@PathVariable("id") long id) {
    return null;
  }

  @GetMapping("custom-coupon/{id}")
  @Operation(summary = "제작티콘 상세 조회")
  public CustomCouponInfoResponseDto getCustomCouponInfo(@PathVariable("id") long id) {
    return null;
  }

  @PatchMapping("{id}/state")
  @Operation(summary = "쿠폰 상태 변경", description = "상태 : USED, USABLE")
  public DefaultResponseDto changeCouponState(@PathVariable("id") long id, @RequestBody CouponStateRequestDto couponStateRequestDto) {
    return null;
  }

  @PostMapping("gifticon")
  @Operation(summary = "기프티콘 제작")
  public DefaultResponseDto makeGifticon(@RequestPart GifticonCreationRequestDto gifticonCreationRequestDto, @RequestPart MultipartFile image, AuthMember authMember) {
    return null;
  }

  @PostMapping("custom-coupon")
  @Operation(summary = "제작티콘 제작")
  public DefaultResponseDto makeCustomCoupon(@RequestPart CustomCouponCreationRequestDto customCouponCreationRequestDto, @RequestPart MultipartFile image, AuthMember authMember) {
    return null;
  }

  @GetMapping("custom-coupon/{barcode}")
  @Operation(summary = "바코드로 제작티콘 정보 불러오기")
  public CustomCouponInfoResponseDto getCustomCouponInfoByBarcode(@PathVariable("barcode") String barcode, AuthMember authMember) {
    return null;
  }

  @DeleteMapping("{id}")
  @Operation(summary = "쿠폰 삭제")
  public DefaultResponseDto deleteCoupon(@PathVariable("id") long id) {
    return null;
  }

  @PutMapping("gifticon/{id}")
  @Operation(summary = "기프티콘 정보 수정")
  public DefaultResponseDto editGifticonInfo(@PathVariable("id") long id, @RequestBody GifticonInfoRequestDto gifticonInfoRequestDto) {
    return null;
  }

  @PutMapping("custom-coupon/{id}")
  @Operation(summary = "제작티콘 정보 수정")
  public DefaultResponseDto editCustomCouponInfo(@PathVariable("id") long id, @RequestBody CustomCouponInfoRequestDto customCouponInfoRequestDto) {
    return null;
  }

}
