package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

//index画面 ソート機能を実装した場合
//	@RequestMapping("/home")
//	public String sample(Model model, Music music, @RequestParam(value = "sort", required = false) String sort) {
//		List<EntMusic> list;
//
//		if (sort != null && sort.equals("low")) {
//			// 低い順にソートして取得,dailydaoのsearchDbSortedByDateメソッドの引数にtrueを渡す。
//			list = musicdao.searchDbSortedBySong(true);
//		} else if (sort != null && sort.equals("high")) {
//			// 高い順にソートして取得
//			list = musicdao.searchDbSortedBySong(false);
//		} else {
//			// 通常の取得、ソートボタン押してない時に表示させるもの
//			list = musicdao.searchDb();
//		}
//
//		return "index";
//	}

	//index画面
	@RequestMapping("/home")
	public String sample(Model model) {

		return "index";
	}

	//お気に入り画面　　お気に入り付けた曲を一覧で表示(01で識別？)
	@RequestMapping("/favorite")
	public String favorite(Model model) {

		return "form/favorite";
	}

	//編集画面
	@RequestMapping("edit")
	public String edit(Model model) {

		return "form/edit";
	}

	//更新処理(UPDATE)
	@RequestMapping("/edit/{id}/exe")
	public String editExe(@PathVariable Long id, Model model, Music music) {
		//フォームの値をエンティティに入れ直し
		//		EntMusic entmusic = new EntMusic();
		//		entmusic.setName(music.getName());
		//更新の実行
		//		musicdao.updateDb(id, entmusic);
		//一覧画面へリダイレクト
		return "redirect:/index";
	}

	//物理削除(DELETE)　　＊論理削除じゃない＊
	@RequestMapping("/del/{id}")
	public String delete(@PathVariable Long id) {
		//		musicdao.deleteDb(id);
		return "redirect:/index";
	}
	
	//検索画面
	@RequestMapping("/search")
	public String search(Model model) {

		return "form/search";
	}

	//ここから検索画面についての処理
	//曲名検索(SELECT)
	@RequestMapping("/search/{song}/")
	public String searchsong(Music music, Model model) {

		List<EntMusic> list = musicdao.selectSong(music.getSong());
		model.addAttribute("songlist", list);
		//検索したものでソートをかけ、その内容をindex.htmlに表示

		return "index";
	}

	//アーティスト検索(SELECT)
	@RequestMapping("/search/{artist}/")
	public String searchartist(Music music, Model model, User user) {

		List<EntMusic> list = musicdao.selectArtist(music.getArtist());

		model.addAttribute("artistlist", list);
		return "index";
	}

	//ジャンル検索(SELECT)
	@RequestMapping("/search/{genre}/")
	public String searchgenre(Music music, Model model, User user) {

		List<EntMusic> list = musicdao.selectGenre(music.getGenre());

		model.addAttribute("genrelist", list);
		return "index";
	}
	//ここまで

}
