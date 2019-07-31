package api.factorio;


import factorio.DataStore;
import factorio.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("factorio")
@Api(value = "Factorio Item")
public class ItemController {

    public DataStore dataStore = new DataStore();

//    http://localhost:8080/swagger-ui.html

    @GetMapping("/item")
    @ApiOperation(value = "getItem", response = Item.class)
    public Item getItem(@RequestParam(value="name") String id ){
        return dataStore.getItem(id);
    }

    @PutMapping("/addItem")
    @ApiOperation(value = "getItem", response = Item.class)
    public Item addItem(@RequestParam(value="name") Item item ){
        return dataStore.addItem(item);
    }

}


//    http://localhost:8080/swagger-ui.html#/greeting-controller

//    @GetMapping("/item")
//    @ApiOperation(value = "getItem", response = ETFObject.class)
//    public ETFObject item(@RequestParam(value="name") String id ){
//        RetrieveData retrieveData = new RetrieveData(id);
//        return retrieveData.getData();
//    }
//
//    @GetMapping("/item/details")
//    @ApiOperation(value = "getItem", response = Details.class)
//    public Details itemDetails(@RequestParam(value="name") String id ){
//        RetrieveData retrieveData = new RetrieveData(id);
//        return retrieveData.getData().getDetails();
//    }
//
//    @GetMapping("/item/slots")
//    @ApiOperation(value = "getItem", response = HashMap.class)
//    public HashMap<String, ArrayList> itemSlots(@RequestParam(value="name") String id ){
//        RetrieveData retrieveData = new RetrieveData(id);
//        return retrieveData.getData().getSlots();
//    }
//
//    @GetMapping("/item/all")
//    @ApiOperation(value = "getAll", response = ArrayList.class)
//    public ArrayList allItems(){
//        CacheFileName cacheFileName = new CacheFileName();
//
//        return cacheFileName.getFileNames();
//    }