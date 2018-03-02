package main;

import java.io.IOException;


/**
 * Game
 * 
 * @author mayoineko
 *
 */
class Game {
	/** ゲームのタイトル*/
	private String title;
	/** ゲームのイメージファイルパス*/
	private String imagePath;
	/** ゲーム説明用テキストファイルパス*/
	private String textPath;
	/**ゲーム製作者パス*/
	private String authorPath;
	/**ゲーム製作年パス*/
	private String yearPath;
	/** ゲームのジャンル分け用タグ*/
	private int genre;
	//private String genre;
	/** ゲームの実行ファイルパス*/
	private String exePath;
	/**
	 * Constructor
	 * 
	 * @param path
	 * @param title
	 */
	Game(String path,String title) {
		this.title = title;
		setGame(path, title);
		
	}
	private final void setGame(final String path,final String title) {
		String[] folderList = FileListLoader.getSystemFileList(path);
		String file = FileListLoader.searchFile(folderList, "png","jpg","PNG","gif");
		if(file == null) this.imagePath = file;
		else this.imagePath = path + file;
		file = FileListLoader.searchFile(folderList,"txt");
		if(file == null) this.textPath = file;
		else this.textPath = path + file;
		file = FileListLoader.searchFile(folderList,"a");
		if(file == null) this.authorPath = file;
		else this.authorPath = file;
		file = FileListLoader.searchFile(folderList,"ye");
		if(file == null) this.yearPath = file;
		else this.yearPath = file;
		
		file = FileListLoader.searchFile(folderList,"g");
		try {
			if(file == null) this.genre = Genre.その他.getLabel();
			else this.genre = Integer.parseInt(TextReader.read(path+file));
		} catch(IOException e) {
			this.genre = Genre.その他.getLabel();
			System.err.println(e);
		}
		try {
			folderList = FileListLoader.getFileList(path);
		}catch(IOException e) {
			e.printStackTrace();
		}
		file = FileListLoader.searchFile(folderList, "exe", "jar");
		if(file == null) this.exePath = file;
		else this.exePath = path + file;
	}
	private void setImagePath(String path,String[] folderList) {
		String file = FileListLoader.searchFile(folderList, "png","jpg","gif");
		if(file == null) this.textPath = file;
		else this.textPath = path + file;
		
	}
	private void setGenre(String path,String[] folderList) {
		String file = FileListLoader.searchFile(folderList, "txt");
		try {
			if(file == null) this.genre = Genre.その他.getLabel();
			else this.genre = Integer.parseInt(TextReader.read(path+file));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	private void setExePath(String path,String[] folderList) {
		
	}
	
	/** getter*/
	String getTitle() { return title; }
	String getImagePath() { return imagePath; }
	String getTextPath() { return textPath; }
	int getGenre() { return genre; }
	String getExePath() { return exePath; }
	String getAythorPath() { return authorPath; }
	String getYearPath() { return yearPath; }
}
