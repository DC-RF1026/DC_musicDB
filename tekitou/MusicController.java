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

	//index画面
	@RequestMapping("/{id}/home")
	public String sample(Model model, User user) {
		

		return "index";
	}

	//お気に入り画面　　お気に入り付けた曲を一覧で表示(01で識別？)
	@RequestMapping("/{id}/favorite")
	public String favorite(Model model, User user) {

		return "form/favorite";
	}
	

	//編集画面
	@RequestMapping("/{id}/edit")
	public String edit(Model model, User user) {

		return "form/edit";
	}

	//更新処理(UPDATE)
	@RequestMapping("/{id}/edit/{id}/exe")
	public String editExe(@PathVariable Long id, Model model, Music music, User user) {
		//フォームの値をエンティティに入れ直し
		//		EntMusic entmusic = new EntMusic();
		//		entmusic.setName(music.getName());
		//更新の実行
		//		musicdao.updateDb(id, entmusic);
		//一覧画面へリダイレクト
		return "redirect:/index";
	}

	//削除(DELETE)
	@RequestMapping("/{id}/del/{id}")
	public String delete(@PathVariable Long id, User user) {
		//		musicdao.deleteDb(id);
		return "redirect:/index";
	}

	//検索画面
	@RequestMapping("/{id}/search")
	public String search(Model model, User user) {

		return "form/search";
	}


//ここから検索画面についての処理
	//曲名検索(SELECT)
	@RequestMapping("/search/{song}/")
	public String searchsong(Music music, Model model, User user) {
		
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
