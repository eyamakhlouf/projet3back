package com.eya.livres.service;

import java.util.List;

import com.eya.livres.entities.Genre;
import com.eya.livres.entities.Livre;

public interface LivreService {
	Livre saveLivre(Livre l);

	Livre updateLivre(Livre l);

	void deleteLivre(Livre l);

	void deleteLivreById(Long id);

	Livre getLivre(Long id);

	List<Livre> getAllLivres();
	
	List<Livre> findByTitreLivre(String titre);
	List<Livre> findByTitreLivreContains(String titre);
	List<Livre> findByTitrePrix (String titre, Double prix);
	List<Livre> findByGenre(Genre genre);
	List<Livre> findByGenreIdGen(Long id);
	List<Livre> findByOrderByTitreLivreAsc();
	List<Livre> trierLivresTitresPrix();

	/*Page<Livre> getAllLivresParPage(int page, int size);
	
	*/
}
