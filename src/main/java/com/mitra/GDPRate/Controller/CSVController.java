package com.mitra.GDPRate.Controller;

import com.mitra.GDPRate.Service.CSVService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class CSVController {
    @Autowired
    private CSVService csvService;

    Logger logger = LoggerFactory.getLogger(CSVController.class);

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                     RedirectAttributes redirectAttributes, HttpServletRequest request) throws IOException {
        logger.info(file.getName());
        csvService.handleFile(file);
        return ResponseEntity.ok("CSV File Uploaded..");
    }
}
