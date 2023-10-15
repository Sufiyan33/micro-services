package com.sufiyan.crud.demo.actuator;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

//TO register this endPoint to actuator mark this class to @component
@Component
@Endpoint(id = "release-note")
public class CustomEndpoint {

	/*
	 * Here, I am creating custom endPoint will register with Actuator. Why? If you
	 * want to add some custom data or want to show some releases then you can do.
	 * 
	 * @ReadOperation will act as a @GetMapping to fetch record.
	 * 
	 * @Selector : will act as a @PathVariable to give id and fetch record
	 * 
	 * @WriteOperation : will act as a @PostMapping where you can give input and
	 * save data.
	 */
	Map<String, List<String>> releaseNote = new LinkedHashMap<>();

	@PostConstruct
	public void noteDetails() {
		releaseNote.put("version-1.0", Arrays.asList("Added new Http endPoints", "Added swaggerApi", "Added openApi"));
		releaseNote.put("version-2.0", Arrays.asList("Added new Http endPoints", "Added swaggerApi", "Added openApi"));
		releaseNote.put("version-3.0", Arrays.asList("Added new Http endPoints", "Added swaggerApi", "Added openApi"));
	}

	@ReadOperation
	public Map<String, List<String>> getReleaseUpdate() {
		return releaseNote;
	}

	@ReadOperation
	public List<String> getNotesByVersion(@Selector String version) {
		return releaseNote.get(version);
	}

	@WriteOperation
	public void addReleaseNote(@Selector String version, String releaseDocs) {
		releaseNote.put(version, Arrays.stream(releaseDocs.split(",")).collect(Collectors.toList()));
	}

	@DeleteOperation
	public void deleteNotes(@Selector String version) {
		releaseNote.remove(version);
	}
}
