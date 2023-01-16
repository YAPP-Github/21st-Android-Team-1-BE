package yapp.buddycon.web.gifticon.adapter.out;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yapp.buddycon.web.gifticon.adapter.in.response.GifticonsResponseDto;
import yapp.buddycon.web.gifticon.domain.Gifticon;
import yapp.buddycon.web.gifticon.domain.GifticonState;

import java.util.List;

public interface GifticonJpaRepository extends JpaRepository<Gifticon, Long> {

  @Query(value = """
    select new yapp.buddycon.web.gifticon.adapter.in.response.GifticonsResponseDto(g.id, a.path, g.gifticonInfo.name, g.gifticonInfo.expireDate)
    from Gifticon g inner join g.attachment a
    where g.gifticonState = :gifticonState
  """)
  List<GifticonsResponseDto> findSortedGifticonsAccordingToState(@Param("gifticonState") GifticonState gifticonState,
                                                         Pageable pageable);

  @Query(value = """
    select new yapp.buddycon.web.gifticon.adapter.in.response.GifticonsResponseDto(g.id, a.path, g.gifticonInfo.name, g.gifticonInfo.expireDate)
    from Gifticon g inner join g.attachment a
    where g.gifticonState = :gifticonState
  """)
  List<GifticonsResponseDto> findUsedGifticonsSortedBy(@Param("gifticonState") GifticonState gifticonState,
                                                         Pageable pageable);
}
