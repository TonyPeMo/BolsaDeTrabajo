package com.example.db.dto;

import java.util.List;

public record LoginResponse(String username, List<String> authorities, String token) {
}