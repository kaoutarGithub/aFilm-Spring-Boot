package com.nttdata.aflamiSpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.aflamiSpringBoot.entity.Media;
import com.nttdata.aflamiSpringBoot.repository.MediaRepository;

@Service
public class MediaService {
	
	MediaRepository mediaRepository;
	
	public MediaService(MediaRepository mediaRepository) {
		// TODO Auto-generated constructor stub
		this.mediaRepository = mediaRepository;
	}
	
	public List<Media> getList(){
		return mediaRepository.findAll();
	}
	
	public Media save(Media media) {
		return mediaRepository.save(media);
	}
	
	public Media getById(Long id) {
		return mediaRepository.findById(id).orElse(new Media());
	}
	
	public void delete(Long id) {
		mediaRepository.deleteById(id);
	}

}