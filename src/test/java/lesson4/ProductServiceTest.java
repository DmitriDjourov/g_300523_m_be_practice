package lesson4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @Mock
    private MerchService merchService;

    @BeforeEach
    public void init() {
        productService = new ProductService();
        merchService = Mockito.mock(MerchService.class);
        productService.setMerchService(merchService);
        productService.save(new Product("Banana", 120, "Best bananas"));
        productService.save(new Product("Apple", 90, "Best apples"));
        productService.save(new Product("Orange", 200, "Best oranges"));
    }

    // После написания каждого теста, можно переписывать методы
    // сервиса так, чтобы тесты падали

    @Test
    public void checkIfSupplierInfoIsNull() {
        Mockito.when(merchService.withoutSupplierInfo()).thenReturn(true);
        List<Product> products = productService.getAll();
        for (Product product : products) {
            assertNull(product.getSupplier());
        }
    }

    @Test
    public void checkIfSupplierInfoIsNotNull() {
        Mockito.when(merchService.withoutSupplierInfo()).thenReturn(false);
        List<Product> products = productService.getAll();
        for (Product product : products) {
            assertNotNull(product.getSupplier());
        }
    }

    // Если будет время, предыдущие два теста написать с моком репозитория

    @Test
    public void checkCorrectMarkup() {
        Mockito.when(merchService.getMarkup()).thenReturn(30.0);
        Product product = productService.getById(1);
        assertEquals(156, product.getPrice());
    }

    @Test
    public void checkIfCorrectArticleWasSet() {
        Product product = new Product("Test name", 777, "Test supplier");
        String testArticle = "Test777";

        Mockito.doAnswer(x -> {
            Product product1 = x.getArgument(0);
            product1.setArticle(testArticle);
            return product1;
        }).when(merchService).setArticle(product);

        product = productService.save(product);
        product = productService.getById(product.getId());

        assertNotNull(product);
        assertEquals(testArticle, product.getArticle());
    }

    @Test
    public void checkFullDeletion() {
        Mockito.when(merchService.fullDeletion()).thenReturn(true);

        Product product = new Product("Test name", 777, "Test supplier");
        product.setActive(true);

        product = productService.save(product);

        productService.delete(product.getId());

        product = productService.getById(product.getId());

        assertNull(product);
    }

    @Test
    public void checkIfInactiveStatusWasSet() {
        Mockito.when(merchService.fullDeletion()).thenReturn(false);

        Product product = new Product("Test name", 777, "Test supplier");
        product.setActive(true);

        product = productService.save(product);

        productService.delete(product.getId());

        product = productService.getById(product.getId());

        assertNotNull(product);
        assertFalse(product.isActive());
    }

    @Test
    public void mockAndSpyDemo() {
        productService.save(new Product("Real name", 100, "Real supplier"));
        ProductService mock = Mockito.mock(ProductService.class);
        ProductService spy = Mockito.spy(productService);
        mock.save(new Product("Real name", 100, "Real supplier"));

        Product product1 = new Product("Test name 1", 777, "Test supplier 1");
        Product product2 = new Product("Test name 2", 888, "Test supplier 2");

        product1.setName("Test name");
        product2.setSupplier("Test supplier");

        List<Product> products = List.of(product1, product2);

        Mockito.when(mock.getAll()).thenReturn(products);
        Mockito.when(spy.getAll()).thenReturn(products);

        System.out.println();
        System.out.println("Behavior with Mockito.when():");

        System.out.println("Mock: " + mock.getAll());
        System.out.println("Spy:  " + spy.getAll());

        System.out.println();

        System.out.println("Behavior without Mockito");

        System.out.println("Mock: " + mock.getById(1));
        System.out.println("Spy:  " + spy.getById(1));

        System.out.println();
    }
}