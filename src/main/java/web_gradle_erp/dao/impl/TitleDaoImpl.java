package web_gradle_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_gradle_erp.dao.TitleDao;
import web_gradle_erp.dto.Title;

public class TitleDaoImpl implements TitleDao {
	private static final TitleDaoImpl instance = new TitleDaoImpl();
	private Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}

	public static TitleDaoImpl getInstance() {
		return instance;
	}

	private TitleDaoImpl() {
	}

	@Override
	public List<Title> selectTitleByAll() {
		String sql = "select titleNo, titleName from title";

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Title> list = new ArrayList<Title>();
				do {
					list.add(getTitle(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int tNo = rs.getInt("tNo");
		String tName = rs.getString("tName");
		return new Title(tNo, tName);
	}

	@Override
	public Title selectTitleByNo(Title title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

}
