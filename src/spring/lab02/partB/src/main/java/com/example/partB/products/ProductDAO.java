package com.example.partB.products;


import com.example.partB.integrations.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO implements IProductDAO{
	private ILogger logger;

	@Autowired
	public ProductDAO(ILogger logger){
		this.logger = logger;
	}
	
	public void save(Product product) {
		// simple sleep
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ProductDAO: saving product "+product.getName());
		logger.log("product is saved in the DB: "+ product.getName() );
	}

}
