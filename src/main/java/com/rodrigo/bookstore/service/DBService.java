package com.rodrigo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.bookstore.domain.Categoria;
import com.rodrigo.bookstore.domain.Livro;
import com.rodrigo.bookstore.repositories.CategoriaRepository;
import com.rodrigo.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public void instaciaBaseDados() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Ficção Cientifica");
		Categoria cat3 = new Categoria(null, "Biografia", "Livro de Biografia");

		Livro l1 = new Livro(null, "Clean Code ", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "Dirty Code ", "Roberto Bolanos", "Blablabla", cat1);
		Livro l3 = new Livro(null, "Ciencia Ok", "Einstein", "Ciencia", cat2);
		Livro l4 = new Livro(null, "Livro 2 ", "Autor", "Blablabla", cat2);
		Livro l5 = new Livro(null, "Blablabla ", "Blablabla", "Blablabla", cat3);
		Livro l6 = new Livro(null, "Blablabla Volume 3 ", "Blablabla da Silva", "Volume 2", cat3);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));
		cat3.getLivros().addAll(Arrays.asList(l5, l6));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
	}

}
