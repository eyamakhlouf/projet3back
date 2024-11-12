package com.eya.livres;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;

import com.eya.livres.entities.Genre;
import com.eya.livres.entities.Livre;
import com.eya.livres.repos.LivreRepository;



@SpringBootTest
class LivresApplicationTests {
	@Autowired
	private LivreRepository livreRepository;

	@Test
	public void testCreateLivre() {
		Livre liv = new Livre("Les miserables", "victor Hugo", 2200.500, new Date());
		livreRepository.save(liv);
	}
	@Test
	public void testFindLivre() {
		Livre l = livreRepository.findById(2L).get();
		System.out.println(l);
	}

	@Test
	public void testUpdateLivre() {
		Livre l = livreRepository.findById(2L).get();
		l.setPrixLivre(1000.0);
		livreRepository.save(l);
	}

	@Test
	public void testDeleteLivre() {
		livreRepository.deleteById(2L);
	}

	@Test
	public void testListerTousLivres() {
		List<Livre> livs = livreRepository.findAll();
		for (Livre l : livs) {
			System.out.println(l);
		}
	}
	

	@Test
	public void testFindLivreByTitre() {
		List<Livre> livs = livreRepository.findByTitreLivre("Les miserables");
		for (Livre l : livs) {
			System.out.println(l);
		}
	}
	
	@Test
	public void testFindLivreByTitreContains() {
		List<Livre> livs = livreRepository.findByTitreLivreContains("Les");
		for (Livre l : livs) {
			System.out.println(l);
		}
	}
	
	@Test 
	public void testfindByTitrePrix() {
		List<Livre> livs = livreRepository.findByTitrePrix("Les miserables", 2000.0);
		for (Livre l : livs) {
			System.out.println(l);
		}
	}
	
	
	@Test 
	public void testfindByGenre() {
		Genre gen = new Genre();
		gen.setIdGen(1L);
		List<Livre> livs = livreRepository.findByGenre(gen);
		for (Livre l : livs) {
			System.out.println(l);
		}
	}
	
	@Test
	public void findByGenreIdGen() {
		List<Livre> livs = livreRepository.findByGenreIdGen(1L);
		for (Livre l : livs) {
			System.out.println(l);

		}
	}
	
	
	@Test
	public void testfindByOrderByTitreLivreAsc() {
		List<Livre> livs = livreRepository.findByOrderByTitreLivreAsc();
		for (Livre l : livs) {
			System.out.println(l);

		}}
		
		
		
		@Test 
		public void testTrierLivresTitresPrix() {
			List<Livre> livs = livreRepository.trierLivresTitresPrix();
			for (Livre l : livs) {
				System.out.println(l);

			}
		}
	}
	
	/*
	 * @Test public void testfindByTitrePrix() { List<Livre> livs =
	 * livreRepository.findByTitrePrix("PC Asus", 1000.0); for (Livre l : livs) {
	 * System.out.println(l); } }
	 * 
	 * 
	 * 
	 * 
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test public void testTrierLivresTitresPrix() { List<Livre> livs =
	 * livreRepository.trierLivresTitresPrix(); for (Livre l : livs) {
	 * System.out.println(l);
	 * 
	 * } }
	 */
	
