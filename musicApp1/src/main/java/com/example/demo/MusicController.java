package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.MusicDao;
import com.example.demo.entity.EntMusic;

@Controller
public class MusicController {

	//MusicDaoの用意
	private final MusicDao musicdao;

	@Autowired
	public MusicController(MusicDao musicdao) {
		this.musicdao = musicdao;
	}

	//ログイン画面
	@RequestMapping("/")
	public String login(Model model) {

		return "form/login";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {

		return "form/login";
	}

	//index画面 ソート機能を実装した場合
	@RequestMapping("/home")
	public String sample(Model model, Music music, @RequestParam(value = "sort", required = false) String sort) {
		List<EntMusic> list;

		if (sort != null && sort.equals("low")) {
			// 低い順にソートして取得,dailydaoのsearchDbSortedByDateメソッドの引数にtrueを渡す。
			list = musicdao.searchDbSortedBySong(true);
		} else if (sort != null && sort.equals("high")) {
			// 高い順にソートして取得
			list = musicdao.searchDbSortedBySong(false);
		} else {
			// 通常の取得、ソートボタン押してない時に表示させるもの
			list = musicdao.searchDb();
		}

		model.addAttribute("dbList", list);

		return "index";
	}

	//お気に入り画面　　お気に入り付けた曲を一覧で表示(01で識別？)
	@RequestMapping("/favorite")
	public String favorite(Model model) {

		return "form/favorite";
	}

	//編集画面
	@RequestMapping("edit")
	public String edit(Model model, Music music) {

		List<EntMusic> list;
		list = musicdao.searchDb();

		model.addAttribute("dbList", list);

		return "form/edit";
	}

	//更新処理(UPDATE)
	//update
	@RequestMapping("/update")
	public String update(Model model, Music music) {
		EntMusic entmusic = new EntMusic();

		entmusic.setId(music.getId());
		entmusic.setArtist(music.getArtist());
		entmusic.setSong(music.getSong());

		musicdao.updateDb(entmusic);

		List<EntMusic> list = musicdao.searchDb();
		model.addAttribute("dbList", list);

		return "redirect:edit";

	}

	//insert
	@RequestMapping("/insert")
	public String insert(Music music) {
		EntMusic entmusic = new EntMusic();

		entmusic.setArtist(music.getArtist());
		entmusic.setSong(music.getSong());
		entmusic.setGenre(music.getGenre());
		entmusic.setUrl(music.getUrl());

		musicdao.insertDb(entmusic);

		return "redirect:edit";
	}

	//物理削除(DELETE)　　＊論理削除じゃない＊
	@RequestMapping("/del/{id}")
	public String delete(@PathVariable Long id) {
		musicdao.deleteDb(id);
		return "redirect:/index";
	}

	//検索画面
	@RequestMapping("/search")
	public String search(Model model) {

		return "form/search";
	}

	//ここから検索画面についての処理
	//曲名検索(SELECT)
	@RequestMapping("/search/song")
	public String searchSong(@RequestParam("song") String song, Model model) {

		List<EntMusic> list = musicdao.selectSong(song);

		model.addAttribute("dbList", list);
		return "form/search";
	}

	//アーティスト検索(SELECT)
	@RequestMapping("/search/artist")
	public String searchartist(@RequestParam("artist") String artist, Model model) {

		List<EntMusic> list = musicdao.selectArtist(artist);

		model.addAttribute("dbList", list);
		return "form/search";
	}

	//ここまで

}
