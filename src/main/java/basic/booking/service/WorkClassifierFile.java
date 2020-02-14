//"src/main/resources/classifiers/metrostations.txt"

package basic.booking.service;

import basic.booking.domain.MetroStation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
public class WorkClassifierFile {

    //читаем данные из файла
    public List<String> readFile(String path) {
        List<String> list = new ArrayList();

        StringBuilder sb = new StringBuilder();
        int i = 0;

        FileInputStream fi = null;
        try {
            fi = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fi));

        //Создаем временную переменную - строку
        String getLineFromFile;

        //В цикле читаем строки до тех пор, пока не дойдем до последней строки
        while (true) {
            try {
                if (!((getLineFromFile = br.readLine()) != null)) {
                    break;
                }
                list.add(getLineFromFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
