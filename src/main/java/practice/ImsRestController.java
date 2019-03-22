package practice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ImsRestController {

    @Resource
    private InventoryItemRepository itemRepo;

    @RequestMapping(path = "/addTheItem/{barcode}/{quantity}/{expirationDateString}/{itemName}/{unit}/{location}/{price}/{description}", method = POST)
    public void userFormProcessing(@PathVariable String barcode, @PathVariable int quantity,
                                   @PathVariable String expirationDateString, @PathVariable String itemName, @PathVariable String unit,
                                   @PathVariable String location, @PathVariable double price, @PathVariable String description) {
        LocalDate localDate = LocalDate.parse(expirationDateString);
        InventoryItem item = new InventoryItem(barcode, quantity, localDate, itemName, unit, location, price,
                description);
        itemRepo.save(item);
    }

    @RequestMapping(path = "/deleteTheItem/{id}", method = DELETE)
    public void userFormDeleting(@PathVariable long id) {
        itemRepo.deleteById(id);
    }

    @RequestMapping(path = "/editTheItem/{id}/{barcode}/{quantity}/{expirationDateString}/{itemName}/{unit}/{location}/{price}/{description}", method = PUT)
    public void editFormProcessing(@PathVariable(value = "id") long id, @PathVariable String barcode,
                                   @PathVariable int quantity, @PathVariable String expirationDateString, @PathVariable String itemName,
                                   @PathVariable String unit, @PathVariable String location, @PathVariable double price,
                                   @PathVariable String description) {
        LocalDate localDate = LocalDate.parse(expirationDateString);
        InventoryItem editItem = itemRepo.findById(id).orElse(null);
        editItem.setBarcode(barcode);
        editItem.setDate(localDate);
        editItem.setDescription(description);
        editItem.setLocation(location);
        editItem.setName(itemName);
        editItem.setPrice(price);
        editItem.setQuantity(quantity);
        editItem.setUnit(unit);
        itemRepo.save(editItem);
    }

    @RequestMapping(path = "/searchBy/{barcode}", method = GET)
    public String searchAllByBarcode(@PathVariable String barcode, Model model) {
        model.addAttribute("foundItems", itemRepo.findAllByBarcode(barcode));
        return "find";
    }

}