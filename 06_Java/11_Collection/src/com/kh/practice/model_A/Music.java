package com.kh.practice.model_A;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Music implements Comparable<Music> {

	private String artist;
	private String song;
	
	@Override
	public int compareTo(Music o) {
		return o.artist.compareTo(this.artist);
	}

}