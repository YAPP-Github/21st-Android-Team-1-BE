package yapp.buddycon.batch.job.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CouponForBatchVoRowMapper implements RowMapper<CouponForBatchVo> {

  @Override
  public CouponForBatchVo mapRow(ResultSet rs, int rowNum) throws SQLException {
    CouponForBatchVo vo = new CouponForBatchVo(
        rs.getLong("id"),
        rs.getString("name"),
        rs.getDate("expire_date"),
        rs.getLong("member_id")
    );
    return vo;
  }

}
