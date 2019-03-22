package practice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class IMSController {

    @Resource
    private InventoryItemRepository itemRepo;

    @RequestMapping("/")
    public String getMainPage(Model model) {
      model.addAttribute("itemsModel", itemRepo.findAllByOrderByDateAsc());
        return "index";
    }

    @RequestMapping("/item/add")
    public String lastAddedItem(Model model) {
        model.addAttribute("itemsModel", itemRepo.findTop3ByOrderByIdDesc());
        return "add";
    }

    @RequestMapping("/item/{id}")
    public String editItems(@PathVariable long id, Model model) {
        model.addAttribute("editModel", itemRepo.findById(id).orElse(null));
        return "item";
    }

    @RequestMapping("/item/delete")
    public String getDeletePage(Model model) {
        model.addAttribute("itemsModel", itemRepo.findAllByOrderByDateAsc());
        return "delete";
    }

    @RequestMapping("/item/find")
    public String getFindPage() {
        return "find";
    }
}