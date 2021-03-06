package com.ufpb.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ufpb.model.Ad;
import com.ufpb.model.People;
import com.ufpb.repository.AdRepository;
import com.ufpb.repository.PeopleRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufpb.storage.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Api(value = "Imagens", description = "Seta todas as operaçoes baseadas em imagens.", tags = {"Imagens"})
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    AdRepository adRepository;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/avatar")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return model.toString();
    }

    @GetMapping("/avatar/{filename:.+}")
    public ResponseEntity<Resource> serveFileAvatar(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
    @GetMapping("/image/{filename:.+}")
    public ResponseEntity<Resource> serveFileImage(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PutMapping("/avatar/{userId}")
    public void handleFileUpload(HttpServletRequest request,
                                @PathVariable Long userId,
                                @RequestParam("file") MultipartFile file) {

        storageService.store(file);
        People people = peopleRepository.findById(userId).orElse(null);
        people.setUrlImage("/api/avatar/" + file.getOriginalFilename());

        peopleRepository.save(people);
    }

    @PutMapping("/image/{AdId}")
    public void handleImageAdUpload(HttpServletRequest request,
                                    @PathVariable Long AdId,
                                    @RequestParam("file") MultipartFile file) {

        storageService.store(file);
        Ad ad = adRepository.findById(AdId).orElse(null);
        ad.setUrlImage("/api/image/" + file.getOriginalFilename());

        adRepository.save(ad);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
