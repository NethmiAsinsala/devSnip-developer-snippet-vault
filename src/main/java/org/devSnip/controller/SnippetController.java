package org.devSnip.controller;

import lombok.RequiredArgsConstructor;
import org.devSnip.model.Snippet;
import org.devSnip.service.SnippetService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping ("api/snippets")
public class SnippetController {

    private final SnippetService snippetService;

    @PostMapping ("/add")
    public boolean addSnippet(@RequestBody Snippet snippet){
        return snippetService.addSnippet(snippet);
    }

    @GetMapping ("/get-all")
    public List<Snippet> viewAllSnippet(){
        return snippetService.viewAllSnippet();
    }

    @PatchMapping ("/update/{id}")
    public void updateSnippet(@PathVariable Integer id, @RequestBody Snippet snippet ){
        snippetService.updateSnippet(id,snippet);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteSnippet(@PathVariable Integer id){
        return snippetService.deleteSnippet(id);
    }

    @GetMapping ("/get-by-folder/{id}")
    public  List<Snippet> getByFolder(@PathVariable Integer id){
        return snippetService.getByFolder(id);
    }

    @PostMapping("/explain")
    public String explainSnippet(@RequestBody Map<String, String> request) {
        String code = request.get("code_content");
        if (code == null || code.isEmpty()) {
            return "No code provided.";
        }

        try {
            RestTemplate restTemplate = new RestTemplate();
            String ollamaUrl = "http://localhost:11434/api/generate";

            Map<String, Object> ollamaRequest = new HashMap<>();
            ollamaRequest.put("model", "qwen2.5:0.5b");
            ollamaRequest.put("prompt", "Explain this code concisely without generating new code unless necessary:\n\n" + code);
            ollamaRequest.put("stream", false);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(ollamaRequest, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(ollamaUrl, entity, Map.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return (String) response.getBody().get("response");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error connecting to local AI: " + e.getMessage();
        }

        return "Failed to get explanation.";
    }
}
