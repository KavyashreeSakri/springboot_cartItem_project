package spring_Cart_Item.annotation;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartDao {
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	Scanner scanner;
	
	@Autowired
	List<Item> listItem;

	public void saveCart(Cart cart) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(cart);
		entityTransaction.commit();
		System.out.println("Saved successfully");

	}

	public void updateCart(int id, Cart cart) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Cart cart1 = entityManager.find(Cart.class, id);
		if (cart1 != null) {
			cart.setId(id);
			entityTransaction.begin();
			entityManager.persist(cart);
			entityTransaction.commit();
		} else {
			System.out.println("Cart not found");
		}

	}

	public void deleteCart(int id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Cart cart = entityManager.find(Cart.class, id);
		if (cart != null) {
			entityTransaction.begin();
			entityManager.remove(cart);
			entityTransaction.commit();
		} else {
			System.out.println("Cart id not found");
		}

	}

	public void getCartById(int id) {
		Cart cart = entityManager.find(Cart.class, id);
		System.out.println(cart);

	}

	public void getAllCart() {
		Query query = entityManager.createQuery("SELECT c FROM Cart c");
		List<Cart> cart = query.getResultList();
		System.out.println(cart);

	}
	public void updateItem(int id, Item item) {
		Item receivedItem = entityManager.find(Item.class, id);
		if (receivedItem != null) {
			item.setId(id);

			entityManager.getTransaction().begin();
			entityManager.merge(item);
			entityManager.getTransaction().commit();

			System.out.println("Item Updated Successfully");
		} else {
			System.out.println("Item doesn't exists");
		}
	}

}
