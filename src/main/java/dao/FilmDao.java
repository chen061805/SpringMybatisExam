package dao;

import entity.Film;

public interface FilmDao {
	public void addFilm(Film film);
	public int checkLan(int language_id);
}