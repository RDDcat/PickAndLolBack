package com.pickandlol.pickandlol.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@Tag(name = "Main", description = "Health Check API")
public class MainController {

    @Operation(summary = "서버 상태 확인", description = "서버 상태를 확인하기 위한 API")
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        String message = "server on health check";
        return ResponseEntity.ok(message);
    }
}
