package com.zyl.jpa.batch.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CcsCarMapper implements RowMapper<CcsCar> {

	public CcsCar mapRow(ResultSet rs, int rowNum) throws SQLException {
		CcsCar c = new CcsCar();
		c.setOrg(rs.getString("ORG"));
		c.setAcctNbr(rs.getLong("ACCT_NBR"));
		c.setCardId(rs.getLong("CARD_ID"));
		return c;
	}
}