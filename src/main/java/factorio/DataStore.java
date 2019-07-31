package factorio;

import api.Application;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class DataStore {
    HashMap<String, Item> itemList = new HashMap<>();


    public Item getItem(String id) {
        String[] items = (new File(getClass().getClassLoader().getResource("Items").getFile())).list();

        for(String fileName : items){
            File file = new File(getClass().getClassLoader().getResource("Items/".concat(fileName)).getFile());
            try {
                List<String> AllFile = Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.US_ASCII);
                String className = "";
                for(String tmp : AllFile){
                    className = className + tmp;
                }
                ObjectMapper mapper = new ObjectMapper();
                Item tmp = mapper.readValue(className, Item.class);
                tmp.toString();
                itemList.put( tmp.id, tmp );
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Item tmp = itemList.get(id);
        if(tmp == null){
            return new Item();
        }
        return tmp;
    }

    public Item addItem(Item item) {
        return itemList.put(item.id, item);
    }
}
