package com.mynager.rest.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "tb_item")
@NamedQueries({
	@NamedQuery(name = "Item.findByType", query = "SELECT i FROM Item i WHERE i.type.id = ?1"),
	@NamedQuery(name = "Item.findBySituation", query = "SELECT i FROM Item i WHERE i.situation.id = ?1")
})

public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank
	private String name;

	@OneToOne
	private Type type;

	@Column(name = "current_season")
	private int currentSeason;

	@Column(name = "number_seasons")
	private int numberSeasons;

	@Column(name = "number_episodes")
	private int numberEpisodes;

	@Column(name = "current_episode")
	private int currentEpisode;

	@OneToOne
	private Situation situation;

	@Column(name = "date_update", nullable = false, updatable = true)
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date dateUpdate = new Date();

	// getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getCurrentSeason() {
		return currentSeason;
	}

	public void setSeason(int currentSeason) {
		this.currentSeason = currentSeason;
	}

	public int getNumberSeasons() {
		return numberSeasons;
	}

	public void setNumberSeasons(int numberSeasons) {
		this.numberSeasons = numberSeasons;
	}

	public int getNumberEpisodes() {
		return numberEpisodes;
	}

	public void setNumberEpisodes(int numberEpisodes) {
		this.numberEpisodes = numberEpisodes;
	}

	public int getCurrentEpisode() {
		return currentEpisode;
	}

	public void setCurrentEpisode(int currentEpisode) {
		this.currentEpisode = currentEpisode;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
}