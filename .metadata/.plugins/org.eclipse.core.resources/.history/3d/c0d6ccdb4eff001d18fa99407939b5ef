package com.kylemiles.mockdraftsjdbc.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kylemiles.mockdraftsjdbc.dto.MockDraftDTO;
import com.kylemiles.mockdraftsjdbc.dto.MockDraftDTOById;
import com.kylemiles.mockdraftsjdbc.entity.Draft;
import com.kylemiles.mockdraftsjdbc.entity.MockDraft;
import com.kylemiles.mockdraftsjdbc.entity.Pick;
import com.kylemiles.mockdraftsjdbc.entity.Player;
import com.kylemiles.mockdraftsjdbc.entity.Round;
import com.kylemiles.mockdraftsjdbc.entity.Team;
import com.kylemiles.mockdraftsjdbc.entity.TeamName;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/mock-draft")
@OpenAPIDefinition(info = @Info(title = "Mock-Draft Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })
public interface MockDraftController {
	
	@Operation(summary = "Return all Mock Drafts", description = "Returns a list of Mock Drafts", responses = {
			@ApiResponse(responseCode = "200", description = "A list of Mock Drafts is returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MockDraft.class))),
			@ApiResponse(responseCode = "400", description = "The request parameter is invalid", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "403", description = "The current user is forbidden from this operation", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No Mock Drafts were found with the input criteria", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = @Content(mediaType = "application/json")) })
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<MockDraft> getMockDrafts();
	
	@Operation(summary = "Create a Mock Draft", description = "Create Mock Draft", responses = {
			@ApiResponse(responseCode = "201", description = "A Mock Draft is created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MockDraft.class))),
			@ApiResponse(responseCode = "400", description = "The request parameter is invalid", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "403", description = "The current user is forbidden from this operation", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No Mock Drafts were found with the input criteria", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = @Content(mediaType = "application/json")) })
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	MockDraftDTOById createMockDraft(Long teamId, Long draftId, Long playerId);
	
	@Operation(summary = "Create a Mock Draft", description = "Create Mock Draft", responses = {
			@ApiResponse(responseCode = "201", description = "A Mock Draft is created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MockDraft.class))),
			@ApiResponse(responseCode = "400", description = "The request parameter is invalid", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "403", description = "The current user is forbidden from this operation", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No Mock Drafts were found with the input criteria", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = @Content(mediaType = "application/json")) })
	@PostMapping("/alt")
	@ResponseStatus(code = HttpStatus.CREATED)
	MockDraftDTO altCreateMockDraft(TeamName team, Round round, Pick pick, int rank);
	
	@Operation(summary = "Update a Mock Draft", description = "Update Mock Draft", responses = {
			@ApiResponse(responseCode = "200", description = "A Mock Draft is updated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MockDraft.class))),
			@ApiResponse(responseCode = "400", description = "The request parameter is invalid", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "403", description = "The current user is forbidden from this operation", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No Mock Drafts were found with the input criteria", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = @Content(mediaType = "application/json")) })
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	MockDraftDTO updateMockDraft(Long id, TeamName team, Round round, Pick pick, int rank);
	
	@Operation(summary = "Return a Mock Draft by Team Name", description = "Returns a list of Mock Drafts", responses = {
			@ApiResponse(responseCode = "200", description = "A list of Mock Drafts is returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MockDraft.class))),
			@ApiResponse(responseCode = "400", description = "The request parameter is invalid", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "403", description = "The current user is forbidden from this operation", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No Mock Drafts were found with the input criteria", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = @Content(mediaType = "application/json")) })
	@GetMapping("/team")
	@ResponseStatus(code = HttpStatus.OK)
	List<MockDraft> getMockDraftsByTeamName(TeamName team);


}
