package basic.booking.controller;

import basic.booking.domain.Subject;
import basic.booking.domain.User;
import basic.booking.repos.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AddObjectController {
    @Autowired
    private SubjectRepo subjectRepo;

    @GetMapping("/add-new-object")
    public String addNewObject(){return "add-new-object";}

    @Value("${upload.path}")
    private String uploadPath;


    //    TODO: для проверки - убрать userToControl
    @PostMapping("/add-new-object")
    public void add(
            @RequestParam String chooseSubjectName,
            @RequestParam Integer choosePrice,
            @RequestParam String chooseRegion,
            @RequestParam String chooseAddress,
            @RequestParam Integer chooseArea,
            @RequestParam String chooseInfo,
            @RequestParam String chooseMedia,
            @RequestParam(name = "file", required = false) MultipartFile file) throws IOException {

        Subject subject=new Subject(chooseSubjectName,choosePrice,chooseRegion, chooseAddress, chooseArea, chooseInfo,chooseMedia);

        if (file!=null){
            File uploadDir=new File(uploadPath+"/static");

            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile=UUID.randomUUID().toString();
            String resultFilename="/static/"+uuidFile+"-"+file.getOriginalFilename();
            file.transferTo(new File(uploadPath+"/"+resultFilename));

            subject.setFilename(resultFilename);
        }

        subjectRepo.save(subject);
    }

}




