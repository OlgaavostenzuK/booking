//"src/main/resources/classifiers/metrostations.txt"

package basic.booking.controller;

import basic.booking.domain.MetroStation;
import basic.booking.repos.MetroStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Map;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
public class MetroStationController {
    @Autowired
    private MetroStationRepo metroStationRepo;

//    @GetMapping("/start")
//    public String start(Map<String, Object> model){
//        return "start";
//    }
//
//    @PostMapping("/start")
//    public void updateMetroStations(@RequestParam MultipartFile fileMetroStations, Map<String, Object> model) {

//        //читаем данные из файла
//        FileInputStream fi = null;
//        try {
//            fi = new FileInputStream((File) fileMetroStations);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        BufferedReader br = new BufferedReader(new InputStreamReader(fi));
//
//        //Создаем временную переменную - строку
//        String getLineFromFile;
//
//        //В цикле читаем строки до тех пор, пока не дойдем до последней строки
//        while (true) {
//            try {
//                if (!((getLineFromFile = br.readLine()) != null)) {
//                    break;
//                }
//                MetroStation metroStation = new MetroStation(getLineFromFile);
//                metroStationRepo.save(metroStation);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
