package yapp.buddycon.web.gifticon.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yapp.buddycon.web.gifticon.adapter.in.response.GifticonsResponseDto;
import yapp.buddycon.web.gifticon.application.port.in.GifticonUseCase;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/coupon/gifticon")
public class GifticonController {

  private final GifticonUseCase gifticonUseCase;

}
