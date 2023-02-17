package spring_Cart_Item.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ApplicationContext context = new AnnotationConfigApplicationContext(CartItemConfig.class);
		Cart cart = context.getBean("cart", Cart.class);
		CartDao dao = context.getBean("cartDao", CartDao.class);
		List<Item> items = new ArrayList<Item>();
		boolean condition = true;
		do {
			System.out.println(
					"Enter the choice \n 1.Save Cart \n 2.Update Cart \n 3.Delete Cart based on Id \n 4.Get Cart based on Id \n 5.Get All Cart \n 6.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				boolean key = true;
				do {
					System.out.println("Enter the choice \n 1.Save Item \n 2.Save Cart \n 3.Go Back to Main Menu");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						Item item = context.getBean("item", Item.class);
						System.out.println("Enter the Item Name");
						item.setName(scanner.next());
						System.out.println("Enter the Item Cost");
						item.setCost(scanner.nextInt());
						System.out.println("Enter the Item Manufacturer");
						item.setManufacturer(scanner.next());
						System.out.println("Enter the Item Review");
						item.setReview(scanner.next());

						items.add(item);
					}
						break;
					case 2: {
						System.out.println("Enter the Cart Email");
						cart.setEmail(scanner.next());
						System.out.println("Enter the Cart Password");
						cart.setPassword(scanner.next());

						cart.setItem(items);
						dao.saveCart(cart);

					}
						break;
					default:
						key = false;
					}
				} while (key);
			}
				break;
			case 2: {
				boolean key = true;
				do {
					System.out.println("Enter the choice \n 1.Update Item \n 2.Update Cart \n 3.Go Back to Main Menu");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						Item item = context.getBean("item", Item.class);
						System.out.println("Enter the Item id");
						int id = scanner.nextInt();
						System.out.println("Enter the Item Name");
						item.setName(scanner.next());
						System.out.println("Enter the Item Cost");
						item.setCost(scanner.nextInt());
						System.out.println("Enter the Item Manufacturer");
						item.setManufacturer(scanner.next());
						System.out.println("Enter the Item Review");
						item.setReview(scanner.next());

						dao.updateItem(id, item);
					}
						break;
					case 2: {
						System.out.println("Enter the Cart id");
						int id = scanner.nextInt();
						System.out.println("Enter the Cart Email");
						cart.setEmail(scanner.next());
						System.out.println("Enter the Cart Password");
						cart.setPassword(scanner.next());

						dao.updateCart(id, cart);

					}
						break;
					default:
						key = false;
					}
				} while (key);
			}
				break;
			case 3: {
				System.out.println("Enter the Cart id");
				int id = scanner.nextInt();

				dao.deleteCart(id);
			}
				break;
			case 4: {
				System.out.println("Enter the Cart id");
				int id = scanner.nextInt();

				dao.getCartById(id);
			}
				break;
			case 5: {
				dao.getAllCart();
			}
				break;
			default:
				condition = false;
			}
		} while (condition);
	}

}
