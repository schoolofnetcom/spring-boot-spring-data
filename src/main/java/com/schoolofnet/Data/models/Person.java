package com.schoolofnet.Data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "people")
public class Person {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	@JsonBackReference
	private Event eventId;
	
	public Person() {
		
	}
	
	public Person(Long id, String name, Event event) {
		this.setId(id);
		this.setName(name);
		this.setEventId(event);
	}
	
	public Person(String name, Event event) {
		this.setName(name);
		this.setEventId(event);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Event getEventId() {
		return eventId;
	}

	public void setEventId(Event eventId) {
		this.eventId = eventId;
	}
}
