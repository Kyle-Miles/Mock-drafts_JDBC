package com.kylemiles.mockdraftsjdbc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kylemiles.mockdraftsjdbc.entity.Team;
import com.kylemiles.mockdraftsjdbc.entity.TeamNeeds;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/team")
@OpenAPIDefinition(info = @Info(title = "Team Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })
public interface TeamController {
	
	@Operation(summary = "Return all Team Needs", description = "Returns a list of Teams and Needs", responses = {
			@ApiResponse(responseCode = "200", description = "A list of teams is returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Team.class))),
			@ApiResponse(responseCode = "400", description = "The request parameter is invalid", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "403", description = "The current user is forbidden from this operation", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No teams were found with the input criteria", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = @Content(mediaType = "application/json")) })
	@GetMapping("/team_needs")
	@ResponseStatus(code = HttpStatus.OK)
	List<TeamNeeds> getTeamNeeds();
	
	@Operation(summary = "Return all Teams", description = "Returns a list of Teams", responses = {
			@ApiResponse(responseCode = "200", description = "A list of teams is returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Team.class))),
			@ApiResponse(responseCode = "400", description = "The request parameter is invalid", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "403", description = "The current user is forbidden from this operation", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No teams were found with the input criteria", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = @Content(mediaType = "application/json")) })
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Team> getAllTeams();

}
