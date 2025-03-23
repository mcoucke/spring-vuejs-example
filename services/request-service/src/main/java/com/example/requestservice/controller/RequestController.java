package com.example.requestservice.controller;

import com.example.requestservice.model.Request;
import com.example.requestservice.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping
    public List<Request> getAllRequests() {
        return StreamSupport.stream(requestRepository.findAll().spliterator(), false).toList();
    }

    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        return requestRepository.save(request);
    }
}