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
			entmusicdb.setUrl((String) result1.get("url"));

			

			//移し替えたデータを持ったentmusicdbを、resultDB2に入れる
			resultDb2.add(entmusicdb);
		}
		//Controllerに渡す
		return resultDb2;
	}

	//ここから検索画面についてのメソッド	
	public List<EntMusic> selectSong(String song) {

		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM music where song=?", song);
		System.out.println(resultDb1);
		List<EntMusic> resultDb2 = new ArrayList<EntMusic>();

		for (Map<String, Object> result1 : resultDb1) {
			EntMusic entmusicdb = new EntMusic();
			entmusicdb.setSong((String) result1.get("song"));
			entmusicdb.setArtist((String) result1.get("artist"));
			entmusicdb.setUrl((String) result1.get("url"));

			resultDb2.add(entmusicdb);
		}
		return resultDb2;
	}

	public List<EntMusic> selectArtist(String artist) {

		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM music where artist=?", artist);

		List<EntMusic> resultDb2 = new ArrayList<EntMusic>();

		for (Map<String, Object> result1 : resultDb1) {
			EntMusic entmusicdb = new EntMusic();
			entmusicdb.setSong((String) result1.get("song"));
			entmusicdb.setArtist((String) result1.get("artist"));
			entmusicdb.setUrl((String) result1.get("url"));

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

	//更新の実行(UPDATE)
	public void updateDb(EntMusic entmusic) {
        db.update("update music set song = ?, artist = ? where id = ?", entmusic.getSong(), entmusic.getArtist(), entmusic.getId());
    }
	
	//新規データ挿入(INSERT)
	public void insertDb(EntMusic entmusic) {
	    db.update("INSERT INTO music (song, artist, genre, url) VALUES (?, ?, ?, ?)",
	              entmusic.getSong(), entmusic.getArtist(), entmusic.getGenre(), entmusic.getUrl());
	}


	// 昇順または降順でデータを取得する
	public List<EntMusic> searchDbSortedBySong(boolean ascending) {
		String sql = "SELECT * FROM music ORDER BY song " + (ascending ? "ASC" : "DESC");

		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		List<EntMusic> resultDb2 = new ArrayList<>();

		for (Map<String, Object> result1 : resultDb1) {
			EntMusic entmusicdb = new EntMusic();
			entmusicdb.setId((int) result1.get("id"));
			entmusicdb.setArtist((String) result1.get("artist"));
			entmusicdb.setSong((String) result1.get("song"));
			entmusicdb.setUrl((String) result1.get("url"));
			resultDb2.add(entmusicdb);
		}

		return resultDb2;
	}

}
