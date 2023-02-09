package yapp.buddycon.web.coupon.adapter.in;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yapp.buddycon.common.response.DefaultResponseDto;
import yapp.buddycon.web.auth.adapter.out.AuthMember;
import yapp.buddycon.web.coupon.adapter.in.request.*;
import yapp.buddycon.web.coupon.adapter.in.response.*;
import yapp.buddycon.web.coupon.application.port.in.CouponUseCase;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/coupon")
public class CouponController {

  private final CouponUseCase couponUseCase;

  @GetMapping("/gifticon")
  @Operation(summary = "기프티콘 정렬 조회")
  public List<CouponsResponseDto> getSortedGifticons(@RequestParam("usable") boolean usable, Pageable pageable, AuthMember authMember) {
    return couponUseCase.getSortedGifticons(usable, pageable, authMember);
  }

  @GetMapping("/custom-coupon")
  @Operation(summary = "제작티콘 정렬 조회")
  public List<CouponsResponseDto> getSortedCustomCoupons(@RequestParam("usable") boolean usable, Pageable pageable, AuthMember authMember) {
    return couponUseCase.getSortedCustomCoupons(usable, pageable, authMember);
  }

  @GetMapping("/gifticon/{id}")
  @Operation(summary = "기프티콘 상세 조회")
  public GifticonInfoResponseDto getGifticonInfo(@PathVariable("id") long id, AuthMember authMember) {
    return couponUseCase.getGifticonInfo(authMember.id(), id);
  }

  @GetMapping("/custom-coupon/{id}")
  @Operation(summary = "제작티콘 상세 조회")
  public CustomCouponInfoResponseDto getCustomCouponInfo(@PathVariable("id") long id, AuthMember authMember) {
    return couponUseCase.getCustomCouponInfo(authMember.id(), id);
  }

  @PatchMapping("/{id}/state")
  @Operation(summary = "쿠폰 상태 변경", description = "상태 : USED, USABLE")
  public DefaultResponseDto changeCouponState(@PathVariable("id") long id, @RequestBody CouponStateRequestDto couponStateRequestDto, AuthMember authMember) {
    return couponUseCase.changeCouponState(authMember.id(), id, couponStateRequestDto.state());
  }

  @PostMapping(value = "/gifticon", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "기프티콘 제작")
  public DefaultResponseDto makeGifticon(@RequestPart GifticonCreationRequestDto gifticonCreationRequestDto, @RequestPart MultipartFile image, AuthMember authMember) {
    return couponUseCase.makeGifticon(gifticonCreationRequestDto, image, authMember);
  }

  @PostMapping("/custom-coupon")
  @Operation(summary = "제작티콘 제작")
  public DefaultResponseDto makeCustomCoupon(@RequestPart CustomCouponCreationRequestDto customCouponCreationRequestDto, @RequestPart MultipartFile image, AuthMember authMember) {
    return null;
  }

  @GetMapping("/gifticon/info")
  @Operation(summary = "바코드로 기프티콘 정보 불러오기")
  public SharedGifticonInfoResponseDto getGifticonInfoByBarcode(@RequestParam("barcode") String barcode, AuthMember authMember) {
    return couponUseCase.getSharedGifticonInfoFromBarcode(barcode);
  }

  @GetMapping("/custom-coupon/info")
  @Operation(summary = "바코드로 제작티콘 정보 불러오기")
  public SharedCustomCouponResponseDto getCustomCouponInfoByBarcode(@RequestParam("barcode") String barcode, AuthMember authMember) {
    return couponUseCase.getSharedCustomCouponInfoFromBarcode(barcode);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "쿠폰 삭제")
  public DefaultResponseDto deleteCoupon(@PathVariable("id") long id, AuthMember authMember) {
    return couponUseCase.deleteCoupon(authMember.id(), id);
  }

  @PutMapping("/gifticon/{id}")
  @Operation(summary = "기프티콘 정보 수정")
  public DefaultResponseDto editGifticonInfo(@PathVariable("id") long id, @RequestBody GifticonInfoRequestDto gifticonInfoRequestDto, AuthMember authMember) {
    return null;
  }

  @PutMapping("/custom-coupon/{id}")
  @Operation(summary = "제작티콘 정보 수정")
  public DefaultResponseDto editCustomCouponInfo(@PathVariable("id") long id, @RequestBody CustomCouponInfoRequestDto customCouponInfoRequestDto, AuthMember authMember) {
    return null;
  }

}
