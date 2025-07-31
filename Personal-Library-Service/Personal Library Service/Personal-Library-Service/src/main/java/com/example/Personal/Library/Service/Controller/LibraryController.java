package com.luv2cod.library.Personal.Library.Service.Controller;

import com.luv2cod.library.Personal.Library.Service.Config.LibraryConfig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

// java -jar personal-library-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=

@RestController
public class LibraryController {
    private final LibraryConfig libraryConfig;

    public LibraryController(LibraryConfig libraryConfig) {
        this.libraryConfig = libraryConfig;
    }

    @GetMapping("/library")
    public Map<String, String> getLibraryInfo(){
        Map<String, String> response = new LinkedHashMap<>();
        response.put("name", libraryConfig.getName());
        response.put("mode", libraryConfig.getMode());
        return response;
    }
}
