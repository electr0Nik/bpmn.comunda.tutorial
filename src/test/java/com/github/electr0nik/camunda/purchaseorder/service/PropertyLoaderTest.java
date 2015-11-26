package com.github.electr0nik.camunda.purchaseorder.service;

import com.github.electr0nik.camunda.purchaseorder.delegate.model.Meal;
import com.github.electr0nik.camunda.purchaseorder.service.impl.HelperServiceImpl;
import com.github.electr0nik.camunda.purchaseorder.service.impl.PropertyLoaderImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 25.11.15.
 */
public class PropertyLoaderTest {

  private final static String DEFAULT_PROPERTY_PRICE_PREFIX = "default.price.";

  private PropertyLoader propertyLoader;
  private HelperService helperService;

  @Before
  public void setUp() {
    this.propertyLoader = new PropertyLoaderImpl();
    this.helperService = new HelperServiceImpl();
  }

  @Test
  public void testGetPopulatedProperties() throws Exception {
    final String DEFAULT_PROPERTY_SOURCE = "mock_ingredientsPrice.properties";
    final Properties props = this.propertyLoader.getPopulatedProperties(DEFAULT_PROPERTY_SOURCE);

    assertNotNull(props);
    assertNotNull(props.getProperty(DEFAULT_PROPERTY_PRICE_PREFIX + "Pommes"));
    assertThat(props.getProperty(DEFAULT_PROPERTY_PRICE_PREFIX + "Pommes"), is("279"));
  }

  @Test
  public void testGetPopulatedPropertiesSmoke() throws Exception {
    final String DEFAULT_PROPERTY_SOURCE = "db/smoke/mock_mealIngredient.properties";
    final Properties props = this.propertyLoader.getPopulatedProperties(DEFAULT_PROPERTY_SOURCE);
    assertNotNull(props);

    final Meal schniPo = new Meal();
    schniPo.setName("SchniPo");
    schniPo.setIngredientList(this.helperService.populateMealIngredients(props, schniPo.getName()));
    assertThat(schniPo.getIngredientList().size(), is(2));

    final Meal maultaschen = new Meal();
    maultaschen.setName("Maultaschen");
    maultaschen.setIngredientList(this.helperService.populateMealIngredients(props, maultaschen.getName()));
    assertThat(maultaschen.getIngredientList().size(), is(3));

    final Meal eisDessert = new Meal();
    eisDessert.setName("EisDessert");
    eisDessert.setIngredientList(this.helperService.populateMealIngredients(props, eisDessert.getName()));
    assertThat(eisDessert.getIngredientList().size(), is(3));

    final Meal paprikanudeln = new Meal();
    paprikanudeln.setName("Paprikanudeln");
    paprikanudeln.setIngredientList(this.helperService.populateMealIngredients(props, paprikanudeln.getName()));
    assertThat(paprikanudeln.getIngredientList().size(), is(4));
  }
}