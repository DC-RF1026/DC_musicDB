package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntMusic;

@Repository
public class MusicDao {

	private final JdbcTemplate db;

	@Autowired
	public MusicDao(JdbcTemplate db) {
		this.db = db;
	}

	public List<EntMusic> searchDb() {
		String sql = "SELECT * FROM music";

		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		List<EntMusic> resultDb2 = new ArrayList<EntMusic>();
		for (Map<String, Object> result1 : resultDb1) {
			EntMusic entmusicdb = new EntMusic();
			entmusicdb.setId((int) result1.get("id"));
			entmusicdb.setArtist((String) result1.get("artist"));
			entmusicdb.setSong((String) result1.get("song"));
			entmusicdb.setGenre((String) result1.get("genre"));

			//移し替えたデータを持ったentmusicdbを、resultDB2に入れる
			resultDb2.add(entmusicdb);
		}
		//Controllerに渡す
		return resultDb2;
	}

	//ここから検索画面についてのメソッド	
	public List<EntMusic> selectSong(String song) {

		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM music where song=?", song);

		List<EntMusic> resultDb2 = new ArrayList<EntMusic>();

		for (Map<String, Object> result1 : resultDb1) {
			EntMusic entmusicdb = new EntMusic();
			entmusicdb.setSong((String) result1.get("song"));

			resultDb2.add(entmusicdb);
		}
		return resultDb2;
	}

	public List<EntMusic> selectArtist(String artist) {

		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM music where artist=?", artist);

		List<EntMusic> resultDb2 = new ArrayList<EntMusic>();

		for (Map<String, Object> result1 : resultDb1) {
			EntMusic entmusicdb = new EntMusic();
			entmusicdb.setArtist((String) result1.get("artist"));

			resultDb2.add(entmusicdb);
		}
		return resultDb2;
	}

	public List<EntMusic> selectGenre(String genre) {

		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM music where genre=?", genre);

		List<EntMusic> resultDb2 = new ArrayList<EntMusic>();

		for (Map<String, Object> result1 : resultDb1) {
			EntMusic entmusicdb = new EntMusic();
			entmusicdb.setGenre((String) result1.get("genre"));

			resultDb2.add(entmusicdb);
		}
		return resultDb2;
	}
	//ここまで

	//削除文
	public void deleteDb(Long id) {

		//		データベースのデータを削除する処理
		db.update("delete from music where id=?", id);
	}
	


	// 昇順または降順でデータを取得する
	public List<EntMusic> searchDbSortedBySong(boolean ascending){
		String sql = "SELECT * FROM music ORDER BY song " + (ascending ? "ASC" : "DESC");

		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		List<EntMusic> resultDb2 = new ArrayList<>();

		for (Map<String, Object> result1 : resultDb1) {
			EntMusic entdailydb = new EntMusic();
			//				entdailydb.setId((int) result1.get("id"));
			//				entdailydb.setTitle((String) result1.get("title"));
			//				entdailydb.setContent((String) result1.get("content"));

			resultDb2.add(entdailydb);
		}

		return resultDb2;
	}
	
	
}
