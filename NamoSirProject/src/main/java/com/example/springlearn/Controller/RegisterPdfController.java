package com.example.springlearn.Controller;

import com.example.springlearn.Service.RegisterFormService;
import com.example.springlearn.Service.RegisterPdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/register-forms")
public class RegisterPdfController {

    private final RegisterPdfService service;

    public RegisterPdfController(RegisterPdfService service) {
        this.service = (RegisterPdfService) service;
    }

    // Download ALL records
    @GetMapping("/download-pdf")
    public ResponseEntity<byte[]> downloadAllPdf() throws IOException {

        byte[] pdf = service.downloadAllAsPdf();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=register-forms.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

    // Download by sender name
//    @GetMapping("/download-pdf/{senderName}")
//    public ResponseEntity<byte[]> downloadBySender(
//            @PathVariable String senderName) throws IOException {
//
//        byte[] pdf = service.downloadBySenderNamePdf(senderName);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION,
//                        "attachment; filename=register-forms-" + senderName + ".pdf")
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(pdf);
//    }
}
