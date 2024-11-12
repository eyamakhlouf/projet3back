package com.eya.livres.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eya.livres.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}
