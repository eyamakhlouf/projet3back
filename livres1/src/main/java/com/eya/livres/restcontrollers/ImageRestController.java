package com.eya.livres.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.eya.livres.entities.Image;
import com.eya.livres.entities.Livre;
import com.eya.livres.service.ImageService;
import com.eya.livres.service.LivreService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;
	
	@Autowired
	LivreService livreService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uplaodImageLiv/{idLiv}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idLiv") Long idLiv)
			throws IOException {
		return imageService.uplaodImageLiv(file, idLiv);
	}

	@RequestMapping(value = "/getImagesLiv/{idLiv}", method = RequestMethod.GET)
	public List<Image> getImagesLiv(@PathVariable("idLiv") Long idLiv) throws IOException {
		return imageService.getImagesParLiv(idLiv);
	}

	@RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
	public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id)
			throws IOException {
		Livre l = livreService.getLivre(id);
		l.setImagePath(id + ".jpg");

		Files.write(Paths.get(System.getProperty("user.home") + "/images/" + l.getImagePath()), file.getBytes());
		livreService.saveLivre(l);

	}

	@RequestMapping(value = "/loadfromFS/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		Livre l = livreService.getLivre(id);
		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/images/" + l.getImagePath()));
	}

}
