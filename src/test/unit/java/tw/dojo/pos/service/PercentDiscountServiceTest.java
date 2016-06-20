package tw.dojo.pos.service;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import tw.dojo.pos.domain.Item;
import tw.dojo.pos.repository.PercentDiscountRepository;
import tw.dojo.pos.strategy.PercentDiscount;

public class PercentDiscountServiceTest {

    @InjectMocks
    private PercentDiscount promotionService;

    @Mock
    private PercentDiscountRepository promotionRepository;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_calculate_percent_discount_benefit() {
        String barcode = "123456";
        Item item = new Item(barcode, 3);
        item.setPrice(3.0);
        when(promotionRepository.findOne(barcode)).thenReturn(new tw.dojo.pos.domain.PercentDiscount(95));

        Double benefit = promotionService.calculateBenefit(item);

        assertThat(benefit, closeTo(0.45, 0.000001));
    }
}
