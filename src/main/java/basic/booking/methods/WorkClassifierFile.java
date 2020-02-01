package basic.booking.methods;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface WorkClassifierFile {

    //читаем данные из файла
    public List<String> readClassifierFile(File file);

}
