package com.schoolofnet.Data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.schoolofnet.Data.models.Event;
import com.schoolofnet.Data.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventRepository eventRepository;
	
	public EventController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@GetMapping
	@ResponseBody
	public Page<Event> findAll(Pageable pageable) {
		Page<Event> events = this.eventRepository.findAll(pageable);
		
		return events;
	}
	
	@GetMapping("/sort")
	@ResponseBody
	public List<Event> findAllSorting() {
		List<Event> events = (List<Event>) this.eventRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
		
		return events;
	}	
	
	@PostMapping
	@ResponseBody
	public Event create(@RequestBody Event event) {
		this.eventRepository.save(event);
		
		return event;
	}
}
