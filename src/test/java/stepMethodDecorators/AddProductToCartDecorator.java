package stepMethodDecorators;

import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductListPage;

public class AddProductToCartDecorator {

    public static void userOnHomePage(){
        HomePage.userOnHomePage();
    }

    public static void selectCategoryFromHomePage(String categoryName) {
        HomePage.selectCategoryFromHomePage(categoryName);
    }

    public static void selectProductForDetails(String productName){
        ProductListPage.selectProductForDetails(productName);
    }

    public static void selectProductSize(String productSize){
        ProductDetailPage.selectProductSize(productSize);
    }

    public static void selectProductQuantityBy(String size){
        ProductDetailPage.selectProductQuantityBy(size);
    }

    public static void pressAddToCartButton(){
        ProductDetailPage.pressAddToCartButton();
    }
}
