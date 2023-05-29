package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.MusicDao;

@Controller
public class MusicController {

	//MusicDaoの用意
	private final MusicDao musicdao;

	@Autowired
	public MusicController(MusicDao musicdao) {
		this.musicdao = musicdao;
	}

	//ログイン画面
	@RequestMapping("/login")
	public String login(Model model) {

		return "form/login";
	}

	//index画面
	@RequestMapping("/")
	public String sample(Model model) {

		return "index";
	}

	//編集画面
	@RequestMapping("/edit")
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

	//削除(DELETE)
	@RequestMapping("/del/{id}")
	public String delete(@PathVariable Long id) {
		//		musicdao.deleteDb(id);
		return "redirect:/index";
	}

	//検索画面
	@RequestMapping("/search")
	public String search( Model model) {

		return "form/search";
	}

	//全件検索(SELECT)
	@RequestMapping("/search/検索ボタンのリンクに応じて変更")
	public String view(Music music, Model model) {
		//		List<EntMusic> list = musicdao.selectDate(music.get検索したい値());

		//		model.addAttribute("selectDbList", list);
		//検索したものでソートをかけ、その内容をindex.htmlに表示

		return "index";
	}

}
