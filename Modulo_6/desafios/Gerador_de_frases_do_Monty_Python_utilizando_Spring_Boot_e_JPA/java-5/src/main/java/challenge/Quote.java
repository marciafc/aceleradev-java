package challenge;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scripts", indexes = { @Index(name = "ix_scripts_detail", columnList = "detail") })
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	private Integer episode;

	@JsonIgnore
	@Column(name = "episode_name")
	private String episodeName;

	@JsonIgnore
	private String segment;

	@JsonIgnore
	private String type;

	private String actor;

	@JsonIgnore
	private String character;

	@Column(name = "detail")
	private String quote;

	@JsonIgnore
	@Column(name = "record_date")
	private LocalDateTime recordDate;

	@JsonIgnore
	private String series;

	@JsonIgnore
	@Column(name = "transmission_date")
	private LocalDateTime transmissionDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public LocalDateTime getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(LocalDateTime recordDate) {
		this.recordDate = recordDate;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public LocalDateTime getTransmissionDate() {
		return transmissionDate;
	}

	public void setTransmissionDate(LocalDateTime transmissionDate) {
		this.transmissionDate = transmissionDate;
	}
}
