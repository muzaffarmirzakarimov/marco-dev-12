package com.example.examplewordpres.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
//
//
//    private static String UPLOADED_FOLDER="D://adb";
//
//    private final EmailService emailService;

//    @PostMapping(value = "/sendatechment")
//    public ResponseEntity sendMessageAttechment(@RequestParam("file") MultipartFile file){
//       try {
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path,bytes);
//
//            emailService.sendMessageAttechment(file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok().body("send message");
//    }


//
//    @GetMapping("/sendemail")
//    public ResponseEntity sendEmail(@RequestBody EmailDTO emailDTO){
//
//       emailService.sendMessage(emailDTO);
//       return ResponseEntity.ok("success");
//    }
}
