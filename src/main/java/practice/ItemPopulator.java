package practice;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemPopulator implements CommandLineRunner {

	private LocalDate date1 = LocalDate.of(2019, 3, 13);
	private LocalDate date2 = LocalDate.of(2019, 3, 12);
	private LocalDate date3 = LocalDate.of(2019, 3, 11);
	private LocalDate date4 = LocalDate.of(2019, 3, 10);
	private LocalDate date5 = LocalDate.of(2019, 3, 9);
	private LocalDate date6 = LocalDate.of(2019, 3, 13);
	private LocalDate date7 = LocalDate.of(2019, 3, 13);

	@Resource
	InventoryItemRepository itemRepo;

	@SuppressWarnings("unused")
	public void run(String... args) {
		InventoryItem testItem1 = itemRepo
				.save(new InventoryItem("1234A", 5, date1, "Apple", "EACH", "Aisle 10", .59, "Granny Smith"));
		InventoryItem testItem2 = itemRepo
				.save(new InventoryItem("1234B", 5, date2, "Banana", "EACH", "Aisle 10", .59, "Granny Smith"));
		InventoryItem testItem3 = itemRepo
				.save(new InventoryItem("1234C", 5, date3, "Orange", "EACH", "Aisle 10", .59, "Granny Smith"));
		InventoryItem testItem4 = itemRepo
				.save(new InventoryItem("1234D", 5, date4, "Grape", "EACH", "Aisle 10", .59, "Granny Smith"));
		InventoryItem testItem5 = itemRepo
				.save(new InventoryItem("1234F", 5, date5, "Plum", "EACH", "Aisle 10", .59, "Granny Smith"));
		InventoryItem testItem6 = itemRepo
				.save(new InventoryItem("1234G", 5, date6, "Plum", "EACH", "Aisle 10", .59, "Granny Smith"));
		InventoryItem testItem7 = itemRepo
				.save(new InventoryItem("1234H", 5, date7, "Plum", "EACH", "Aisle 10", .59, "Granny Smith"));

	}
}
