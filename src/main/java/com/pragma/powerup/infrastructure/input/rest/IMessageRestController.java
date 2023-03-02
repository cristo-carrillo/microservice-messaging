package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.MessagingRequestDto;
import com.pragma.powerup.application.handler.IMessagingHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messaging")
@RequiredArgsConstructor
public class IMessageRestController {

    private final IMessagingHandler messagingHandler;

    @Operation(summary = "Send a message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "message sent", content = @Content),
            @ApiResponse(responseCode = "400", description = "The phone number format is incorrect", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<Void> sendMessaging(@RequestBody MessagingRequestDto messagingRequestDto) {
        messagingHandler.sendMessaging(messagingRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/validate-code/{code}/{id}")
    public ResponseEntity<Void> validateCode(@PathVariable Integer code, @PathVariable Long id) {
        messagingHandler.validateCode(code, id);
        return ResponseEntity.ok().build();
    }
}
