package fr.ul.miage.bibliotheque.dao;

import fr.ul.miage.bibliotheque.entite.TypeOeuvre;

public class TypeOeuvreDao extends Dao<TypeOeuvre> {

	private static TypeOeuvreDao typeOeuvreDao;

	public TypeOeuvreDao() {
		super(TypeOeuvre.class);
	}

	public static TypeOeuvreDao getInstance() {
		if (typeOeuvreDao == null) {
			typeOeuvreDao = new TypeOeuvreDao();
		}
		return typeOeuvreDao;
	}

}
