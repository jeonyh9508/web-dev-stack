package com.kh.practice3.controller;

import java.util.ArrayList;

import com.kh.practice3.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();
	private Music music = new Music();
	
	//1. 특정 곡 추가
	public void addList(String song,String artist) {
		boolean add = true;
		
		music = new Music();
		music.setSong(song);
		music.setArtist(artist);
		
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getArtist().equals(artist) && list.get(i).getSong().equals(song)) {
				System.out.println("추가 실패");
				add = false;
			}
		}
		if(add) {
			list.add(music);
			System.out.println("추가 성공");
		}
//		System.out.println(list);
	}
	
	//2. 전체 곡 목록 출력
	public void printAll() {
		for(int i = 0; i < list.size(); i++) {
		System.out.println((i+1) + ". 곡명 : " + list.get(i).getSong() + " - 가수명 : " + list.get(i).getArtist());
		}
	}
	
	//3. 특정 곡 검색
	public void searchMusic(String search) {
		boolean song = false;
		boolean artist = false;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(search)) {
				System.out.println("(" + list.get(i).getSong() + " - " + list.get(i).getArtist() +")을 검색했습니다.");
				song = true;
			} else if(list.get(i).getArtist().equals(search)) {
				System.out.println("(" + list.get(i).getSong() + " - " + list.get(i).getArtist() +")을 검색했습니다.");
				artist = true;
			}
		}if(!song && !artist) {
			System.out.println("검색할 곡을 찾지 못했습니다.");
		}
	}
	
	//4. 특정 곡 수정
	public void updateMusic(String search, String song, String artist) {
		boolean update = true;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(search)) {
				System.out.println("(" + list.get(i).getSong() + " - " + list.get(i).getArtist() +")의 값이 변경되었습니다.");
				list.get(i).setSong(song);
				list.get(i).setArtist(artist);
				update = false;
			} 
		}
		if(update) {
			System.out.println("곡을 수정하지 못했습니다.");
		}
	}
	
	//5. 특정 곡 삭제
	public void removeMusic(String search) {
		boolean remove = true;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(search)) {
				System.out.println("(" + list.get(i).getSong() + " - " + list.get(i).getArtist() +")의 삭제했습니다");
				list.remove(i);
				remove = false;
			} 
		}if(remove) {
			System.out.println("삭제할 곡이 없습니다.");
		}
	}
	
}