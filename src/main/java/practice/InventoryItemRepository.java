package practice;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryItemRepository extends CrudRepository<InventoryItem, Long> {

    List<InventoryItem> findAllByOrderByDateAsc();

    List<InventoryItem> findTop3ByOrderByIdDesc();

    List<InventoryItem> findAllByBarcode(String barcode);

}