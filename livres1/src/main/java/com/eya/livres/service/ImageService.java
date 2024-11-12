package com.eya.livres.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.eya.livres.entities.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;

	Image getImageDetails(Long id) throws IOException;

	ResponseEntity<byte[]> getImage(Long id) throws IOException;

	void deleteImage(Long id);

	Image uplaodImageLiv(MultipartFile file, Long idLiv) throws IOException;

	List<Image> getImagesParLiv(Long livId);
}
